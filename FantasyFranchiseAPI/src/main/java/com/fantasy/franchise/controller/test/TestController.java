package com.fantasy.franchise.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.franchise.facade.FacadeInterface;
import com.fantasy.franchise.responseMessage.ResponseMessage;

@RestController
@RequestMapping(value = "data/test")
public class TestController {

	@Autowired
	private FacadeInterface<ResponseMessage> facade;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecords() {
		ResponseMessage message = facade.getAll();
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/char", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByCharacter(
			@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("char", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/long", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByLong(@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("long", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/boolean", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByBoolean(
			@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("boolean", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/short", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByShort(@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("short", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/byte", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByByte(@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("byte", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByString(
			@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("string", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/int", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByInteger(
			@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("int", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/double", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTestRecordByDouble(
			@RequestParam(required = true, value = "contains") String s) {
		ResponseMessage message = facade.getBy("double", s);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

}
