package com.fafr.facade.player;

import static com.fafr.common.ApplicationLogger.logERROR;
import static com.fafr.common.ApplicationLogger.logINFO;
import static com.fafr.common.ApplicationLogger.logWARN;
import static com.fafr.common.LogMessagesFAFR.FAFR_E_000;
import static com.fafr.common.LogMessagesFAFR.FAFR_W_001;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fafr.dao.DataAccessObject;
import com.fafr.facade.FacadeInterface;
import com.fafr.model.player.Player;
import com.fafr.responseMessage.PayloadMessage;
import com.fafr.responseMessage.ResponseMessage;

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
	public ResponseMessage get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage getBy(String e, String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage create(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage delete(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage remove(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
