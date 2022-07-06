package com.fafr.controller.player;

import static com.fafr.common.ApplicationConstants.PLAYER_ATTRIBUTES.ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fafr.facade.FacadeInterface;
import com.fafr.responseMessage.ResponseMessage;

@RestController
@RequestMapping(value = "players")
public class PlayerController {

	@Autowired
	@Qualifier("PlayerFacade")
	private FacadeInterface<ResponseMessage> facade;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPlayers() {
		ResponseMessage message = facade.getAll();
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPlayerById(@PathVariable(value = "id", required = true) String id) {
		if (id == null || id.isEmpty()) {
			// TODO: Update to provide better response message regarding invalid Id
			return ResponseEntity.badRequest().body("");
		}
		ResponseMessage message = facade.getBy(ID.name(), id);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getPlayersBy(@RequestParam(value = "criteria", required = true) String criteria,
			@RequestParam(value = "value", required = true) String value) {
		if (value == null || value.isEmpty()) {
			// TODO: Update to provide better response message regarding invalid value
			return ResponseEntity.badRequest().body("");
		}
		ResponseMessage message = facade.getBy(criteria.toUpperCase(), value);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> createPlayer(@RequestBody(required = true) String json) {
		if (json == null || json.isEmpty()) {
			// TODO: Update to provide better response message regarding invalid value
			return ResponseEntity.badRequest().body("");
		}
		ResponseMessage message = facade.create(json);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> updatePlayer(@PathVariable(required = true, value = "id") String id,
			@RequestBody(required = true) String json) {
		if (json == null || json.isEmpty()) {
			// TODO: Update to provide better response message regarding invalid value
			return ResponseEntity.badRequest().body("");
		}
		ResponseMessage message = facade.update(json);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}

	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePlayer(@PathVariable(required = true, value = "id") String json) {
		if (json == null || json.isEmpty()) {
			// TODO: Update to provide better response message regarding invalid value
			return ResponseEntity.badRequest().body("");
		}
		ResponseMessage message = facade.delete(json);
		if (message.getStatusCode().equals(200)) {
			return ResponseEntity.ok(message.getResponseMessage());
		}
		return ResponseEntity.badRequest().body(message.getResponseMessage());
	}
}
