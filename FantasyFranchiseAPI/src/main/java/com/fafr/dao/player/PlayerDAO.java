package com.fafr.dao.player;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

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
		Optional<Player> opt = data.stream().filter(e -> e.getId().equals(value)).findFirst();
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public boolean create(Player object) {
		// TODO Auto-generated method stub
		return false;
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

}
