package com.fafr.facade;

import com.fafr.responseMessage.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Facade Interface that is for the Basic CRUD Operations. MUST be implemented
 * for the future Facade classes. If a method does not have any implementation,
 * appropriately make the return calls and acceptable amends
 * 
 * @author Haku Wei
 *
 * @param <T>
 */
public interface FacadeInterface<T> {

	static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Simple Get ALL call which will return a list of Objects
	 * 
	 * @return
	 */
	abstract ResponseMessage getAll();

	/**
	 * Generic Method where <b>e</b> will represent the criteria for the getBy and
	 * the <b>s</b> will represent the value for that particular criteria.
	 * Overriding this method, at minimum <b>s</b> must be supplied while <b> e</b>
	 * does not have to be supplied as the assumption is the DAO layer will be
	 * called to specify the criteria to value <b>s</b>.
	 * 
	 * @param e
	 * @param s
	 * @return
	 */
	abstract T getBy(String e, String s);

	/**
	 * JSON String message that will be converted to an Object when reached to the
	 * DAO Layer.
	 * 
	 * @param json
	 * @return
	 */
	abstract T create(String json);

	abstract T delete(String json);
	
	abstract T update(String json);
	
	abstract T update(String key, String json);

	static boolean isGetByValueNotNull(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Unable to perform getBy(e,v) method - v must be supplied!");
		}
		return true;
	}

}
