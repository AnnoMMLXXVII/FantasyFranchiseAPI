package com.fafr.facade;

import com.fafr.responseMessage.ResponseMessage;

public interface FacadeInterface<T> {

	abstract ResponseMessage getAll();

	abstract T get();

	abstract T getBy(String e, String s);

	abstract T create(String json);

	abstract T delete(String json);

	abstract T remove(String json);

}
