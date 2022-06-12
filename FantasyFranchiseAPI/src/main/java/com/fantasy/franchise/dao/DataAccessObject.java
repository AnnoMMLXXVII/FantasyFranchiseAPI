package com.fantasy.franchise.dao;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Generic Interface for the DAO objects
 * methods that can be resused or overridden based on desired specifications. 
 * CRUD operations at the minimum along with specific methods via *Id 
 * @author Haku Wei
 *
 * @param <T>
 */
public interface DataAccessObject<T> {

	abstract List<T> getAll();

	abstract T getById(String value);

	abstract boolean create(T object);

	abstract boolean update(T object);

	abstract boolean removeById(String id);

	abstract boolean remove(T object);

	default T getIdFrom(String name) {
		Optional<T> opt = getAll().stream().filter(e -> e.toString().equalsIgnoreCase(name)).findFirst();
		if (opt == null) {
//	            getApplicationLogger().logERROR(String.format("NULL POINTER EXCEPTION: Unable to find %s from the Database", name));
			throw new NullPointerException("Unable to extract the Key or Id from the matching instance field: " + name);
		}
		return opt.isPresent() ? opt.get() : null;
	}

}
