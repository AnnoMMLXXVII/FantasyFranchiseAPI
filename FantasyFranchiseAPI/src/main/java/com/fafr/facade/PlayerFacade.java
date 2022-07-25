package com.fafr.facade;

import static com.fafr.common.ApplicationConstants.DIGITS_ONLY_REGEX;
import static com.fafr.common.ApplicationLogger.getLogLevel;
import static com.fafr.common.ApplicationLogger.getLogMessage;
import static com.fafr.common.ApplicationLogger.logERROR;
import static com.fafr.common.ApplicationLogger.logINFO;
import static com.fafr.common.ApplicationLogger.logWARN;
import static com.fafr.common.LogMessagesFAFR.FAFR_E_000;
import static com.fafr.common.LogMessagesFAFR.FAFR_E_002;
import static com.fafr.common.LogMessagesFAFR.FAFR_I_000;
import static com.fafr.common.LogMessagesFAFR.FAFR_I_001;
import static com.fafr.common.LogMessagesFAFR.FAFR_I_002;
import static com.fafr.common.LogMessagesFAFR.FAFR_W_001;
import static com.fafr.facade.FacadeInterface.isGetByValueNotNull;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fafr.dao.DataAccessObject;
import com.fafr.dao.PlayerDAO;
import com.fafr.model.Player;
import com.fafr.responseMessage.PayloadMessage;
import com.fafr.responseMessage.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("PlayerFacade")
public class PlayerFacade implements FacadeInterface<ResponseMessage> {

	@Autowired
	@Qualifier("PlayerDAO")
	private DataAccessObject<Player> dao;

	private static PlayerFacade instance;
	private PayloadMessage<?> payload;
	private HttpStatus status;

	public static FacadeInterface<ResponseMessage> getInstance() {
		if (instance == null) {
			synchronized (DataAccessObject.class) {
				if (instance == null) {
					return new PlayerFacade();
				}
			}
		}
		return instance;
	}

	@Override
	public ResponseMessage getAll() {
		List<Player> data = dao.getAll();
		if (data == null) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			payload = new PayloadMessage<String>(status.getReasonPhrase());
			logERROR(FAFR_E_000);
			return new ResponseMessage(status, payload);
		}
		if (data.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
			payload = new PayloadMessage<String>(status.getReasonPhrase());
			logWARN(FAFR_W_001);
			return new ResponseMessage(status, payload);
		}
		status = HttpStatus.OK;
		payload = new PayloadMessage<List<Player>>(data);
		logINFO("Returning all Player Data");
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage getBy(String e, String s) {
		List<Player> data = null;
		if (isGetByValueNotNull(s)) {
			data = ((PlayerDAO) dao).getBy(e, s);
		}
		if (data == null) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format("Unable to find by player with the %s %s", e, s));
			logWARN(FAFR_E_000);
			return new ResponseMessage(status, payload);
		} else if (data.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
			payload = new PayloadMessage<String>(
					String.format("No Results Retrieved for players with the %s %s", e, s));
			logWARN(FAFR_W_001);
			return new ResponseMessage(status, payload);
		}
		status = HttpStatus.OK;
		payload = new PayloadMessage<List<Player>>(data);
		logINFO(String.format("Returning Player's %s with the value : %s", e, s));
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage create(String json) {
		Player p = null;
		boolean isCreated = true;
		try {
			p = mapper.readValue(json, Player.class);
		} catch (JsonProcessingException ex) {
			logERROR("Unable to parse player json : " + ex.getMessage());
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format("Unable to parse player json: %s", ex.getMessage()));
			logWARN(FAFR_E_002);
			return new ResponseMessage(status, payload);
		} finally {
			isCreated = ((PlayerDAO) dao).create(p);
		}
		if (!isCreated && getLogLevel().equals(Level.WARN)) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format(getLogMessage()));
			return new ResponseMessage(status, payload);
		} else if (!isCreated && getLogLevel().equals(Level.ERROR)) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format(getLogMessage()));
			return new ResponseMessage(status, payload);
		}
		logINFO(p.toString());
		status = HttpStatus.OK;
		payload = new PayloadMessage<String>(FAFR_I_000.replace("Object", "Player"));
		logINFO(FAFR_I_000);
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage delete(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Player p = null;
		boolean isRemoved = true;
		try {
			if (json.matches(DIGITS_ONLY_REGEX)) {
				isRemoved = ((PlayerDAO) dao).removeById(json);
			} else {
				p = mapper.readValue(json, Player.class);
				isRemoved = ((PlayerDAO) dao).remove(p);
			}
		} catch (JsonProcessingException ex) {
			logERROR(ex.getMessage());
			if (!isRemoved && getLogLevel().equals(Level.WARN)) {
				status = HttpStatus.BAD_REQUEST;
				payload = new PayloadMessage<String>(String.format(getLogMessage()));
				return new ResponseMessage(status, payload);
			} else if (!isRemoved && getLogLevel().equals(Level.ERROR)) {
				status = HttpStatus.BAD_REQUEST;
				payload = new PayloadMessage<String>(String.format(getLogMessage()));
				return new ResponseMessage(status, payload);
			}
		}
		status = HttpStatus.OK;
		payload = new PayloadMessage<String>(FAFR_I_001.replace("Object", "Player"));
		logINFO(FAFR_I_001);
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage update(String json) {
		Player p = null;
		boolean isUpdated = true;
		try {
			p = mapper.readValue(json, Player.class);
		} catch (JsonProcessingException ex) {
			logERROR(ex.getMessage());
		} finally {
			isUpdated = ((PlayerDAO) dao).update(p);
		}
		if (!isUpdated && getLogLevel().equals(Level.WARN)) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format(getLogMessage()));
			return new ResponseMessage(status, payload);
		} else if (!isUpdated && getLogLevel().equals(Level.ERROR)) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(String.format(getLogMessage()));
			return new ResponseMessage(status, payload);
		}
		status = HttpStatus.OK;
		payload = new PayloadMessage<String>(FAFR_I_002.replace("Object", "Player"));
		logINFO(FAFR_I_002);
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage update(String key, String json) {
		Player p = null;
		try {
			p = mapper.readValue(json, Player.class);
		} catch (JsonProcessingException ex) {
			logERROR(ex.getMessage());
		} finally {
			if (!p.getId().equals(Integer.parseInt(key))) {
				logERROR("Path Variable {id} does not match Request Body's {id}");
				status = HttpStatus.BAD_REQUEST;
				payload = new PayloadMessage<String>(String.format(getLogMessage()));
				return new ResponseMessage(status, payload);
			}
		}
		return update(json);
	}

}
