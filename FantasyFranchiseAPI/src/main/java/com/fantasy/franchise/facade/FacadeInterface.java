package com.fantasy.franchise.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fantasy.franchise.responseMessage.ResponseMessage;

public interface FacadeInterface<T> {

	static final Logger logger = LogManager.getLogger();

	abstract ResponseMessage getAll();

	abstract T get();
	
	abstract T getBy(String e, String s);

	abstract T create(String json);

	abstract T delete(String json);

	abstract T remove(String json);

}
