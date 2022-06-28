package com.fafr.dao.player;

import static com.fafr.common.ApplicationLogger.logERROR;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fafr.common.ApplicationConstants.PLAYER_ATTRIBUTES;
import com.fafr.common.testData.PlayerTestData;
import com.fafr.dao.DataAccessObject;
import com.fafr.model.player.Player;

@Repository("PlayerDAO")
public class PlayerDAO implements DataAccessObject<Player> {

	private static PlayerDAO instance;
	private List<Player> data;

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
		final Integer temp = formatToInteger(value);
		Optional<Player> opt = data.stream().filter(e -> (e.getId().equals(temp))).findFirst();
		return opt.isPresent() ? opt.get() : null;
	}

	public List<Player> getBy(String c, String v) {
		List<Player> data = new ArrayList<>();
		switch (PLAYER_ATTRIBUTES.valueOf(c.toUpperCase())) {
		case ID:
			Player p = getById(v);
			if (p != null) {
				data.add(p);
			}
			return data;
		case FIRSTNAME:
			return data.stream().filter(e -> (e.getFirstName().equals(v))).collect(Collectors.toList());
		case LASTNAME:
			return data.stream().filter(e -> (e.getLastName().equals(v))).collect(Collectors.toList());
		case WEIGHT:
			final Integer temp = formatToInteger(v);
			return data.stream().filter(e -> (e.getWeight().equals(temp))).collect(Collectors.toList());
		case COLLEGE:
			return data.stream().filter(e -> (e.getCollege().equals(v))).collect(Collectors.toList());
		case BIRTHDATE:
			// TODO: Figure out format from parameter v, thenformat into MM-dd-yyyy date
			return data.stream().filter(e -> (e.getBirthDate().equals(v))).collect(Collectors.toList());
		case HEIGHT:
			final Integer t = formatToInteger(v);
			return data.stream().filter(e -> (e.getHeight().equals(t))).collect(Collectors.toList());
		case POSITION:
			return data.stream().filter(e -> (e.getPosition().equals(v))).collect(Collectors.toList());
		default:
			return null;
		}
	}

	@Override
	public boolean create(Player object) {
		if (object == null) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Player object) {
		// TODO Auto-generated method stub
		return false;
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
