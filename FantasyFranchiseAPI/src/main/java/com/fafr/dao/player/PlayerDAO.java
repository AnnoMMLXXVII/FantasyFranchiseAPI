package com.fafr.dao.player;

import static com.fafr.common.ApplicationLogger.logERROR;
import static com.fafr.common.ApplicationLogger.logWARN;
import static com.fafr.common.LogMessagesFAFR.FAFR_E_001;
import static com.fafr.common.LogMessagesFAFR.FAFR_W_002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fafr.common.ApplicationConstants.PLAYER_ATTRIBUTES;
import com.fafr.common.CommonUtils;
import com.fafr.common.testData.PlayerTestData;
import com.fafr.dao.DataAccessObject;
import com.fafr.model.player.Player;

@Repository("PlayerDAO")
public class PlayerDAO implements DataAccessObject<Player> {

	private static PlayerDAO instance;
	private static List<Player> data;

	public DataAccessObject<Player> getInstance() {
		if (instance == null) {
			synchronized (DataAccessObject.class) {
				if (instance == null) {
					return new PlayerDAO();
				}
			}
		}
		return instance;
	}

	private PlayerDAO() {
		data = PlayerTestData.getPlayerTestData();
	}

	@Override
	public List<Player> getAll() {
		return data;
	}

	@Override
	public Player getById(String value) {
		Optional<Player> opt = data.stream().filter(e -> (e.getId().equals(formatToInteger(value)))).findFirst();
		return opt.isPresent() ? opt.get() : null;
	}

	public List<Player> getBy(String c, String v) {
		switch (PLAYER_ATTRIBUTES.valueOf(c.toUpperCase())) {
		case ID:
			List<Player> tmp = new ArrayList<>();
			Player p = getById(v.trim());
			if (p != null) {
				tmp.add(p);
			}
			return tmp;
		case FIRSTNAME:
			return data.stream().filter(e -> (e.getFirstName().equals(v))).collect(Collectors.toList());
		case LASTNAME:
			return data.stream().filter(e -> (e.getLastName().equals(v))).collect(Collectors.toList());
		case WEIGHT:
			return data.stream().filter(e -> (e.getWeight().equals(formatToInteger(v)))).collect(Collectors.toList());
//		case COLLEGE:
//			return data.stream().filter(e -> (e.getCollege().equals(v))).collect(Collectors.toList());
//		case BIRTHDATE:
//			// TODO: Figure out format from parameter v, thenformat into MM-dd-yyyy date
//			return data.stream().filter(e -> (e.getBirthDate().equals(v))).collect(Collectors.toList());
		case HEIGHT:
			return data.stream().filter(e -> (e.getHeight().equals(formatToInteger(v)))).collect(Collectors.toList());
		case POSITION:
			return data.stream().filter(e -> (e.getPosition().equals(v))).collect(Collectors.toList());
		default:
			return null;
		}
	}

	@Override
	public boolean create(Player object) {
		if (object == null) {
			logWARN(FAFR_E_001);
			return false;
		}

		// Sort by Player Id in Ascending Order
		// Then retrieve highest Index, and if the parameter's Id
		// if the last element's id is <= the paremeter's id, return false
		Collections.sort(data, new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.getId() - o2.getId();
			}
		});

		int lastId = data.get(data.size() - 1).getId();
		if (object.getId() <= lastId) {
			logERROR("Unique Constraint Error: Player's Id must be unique");
			return false;
		}
		int temp = data.size();
		data.add(object);
		// TODO: Future Enhancement -- Write to CSV
		int size = data.size();
		return size > temp ? true : false;
	}

	@Override
	public boolean update(Player object) {
		if (object == null) {
			logERROR(FAFR_E_001);
			return false;
		}
		int idx = CommonUtils.searchPlayer(data, object.getId());
		if (idx < 0) {
			logWARN(FAFR_W_002);
			return false;
		} else {
			// TODO: Enhancement for deserializing and marshalling an object -- Validations
			// to make sure incoming field are valid
			data.set(idx, object);
		}
		return true;
	}

	@Override
	public boolean removeById(String id) {
		if (id == null) {
			logWARN(FAFR_E_001);
			return false;
		}
		int idx = CommonUtils.searchPlayer(data, Integer.parseInt(id));
		if (idx < 0) {
			return false;
		} else {
			data.remove(idx);
		}
		return true;
	}

	@Override
	public boolean remove(Player object) {
		if (object == null) {
			logWARN(FAFR_E_001);
			return false;
		}
		Collections.sort(data, new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.getId() - o2.getId();
			}
		});
		return removeById((object.getId() + "").trim());
	}

	private final Integer formatToInteger(String v) throws NumberFormatException {
		Integer t = null;
		try {
			t = Integer.parseInt(v);
		} catch (NumberFormatException ex) {
			logERROR("Unable to Parse Value: " + v);
			throw new NumberFormatException(ex.getMessage());
		}
		return t;
	}

}
