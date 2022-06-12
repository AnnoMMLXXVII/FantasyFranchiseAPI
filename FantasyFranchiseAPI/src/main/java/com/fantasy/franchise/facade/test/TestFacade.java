package com.fantasy.franchise.facade.test;

import static com.fantasy.franchise.common.ApplicationLogger.logERROR;
import static com.fantasy.franchise.common.ApplicationLogger.logINFO;
import static com.fantasy.franchise.common.ApplicationLogger.logWARN;
import static com.fantasy.franchise.common.LogMessagesFAFR.FAFR_E_000;
import static com.fantasy.franchise.common.LogMessagesFAFR.FAFR_E_001;
import static com.fantasy.franchise.common.LogMessagesFAFR.FAFR_W_001;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fantasy.franchise.dao.DataAccessObject;
import com.fantasy.franchise.dao.test.TestDAO;
import com.fantasy.franchise.facade.FacadeInterface;
import com.fantasy.franchise.model.test.Test;
import com.fantasy.franchise.responseMessage.PayloadMessage;
import com.fantasy.franchise.responseMessage.ResponseMessage;

@Service
public class TestFacade implements FacadeInterface<ResponseMessage> {

	@Autowired
	private DataAccessObject<Test> dao;

	private static TestFacade instance;
	private PayloadMessage<?> payload;
	private HttpStatus status;

	public static FacadeInterface<ResponseMessage> getInstance() {
		if (instance == null) {
			synchronized (DataAccessObject.class) {
				if (instance == null) {
					return new TestFacade();
				}
			}
		}
		return instance;
	}

	@Override
	public ResponseMessage getAll() {
		List<Test> data = dao.getAll();
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
		payload = new PayloadMessage<List<Test>>(data);
		logINFO("Returning all Test Data");
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage getBy(String criteria, String value) {
		if (value.isEmpty() || value == null) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(
					String.format("Bad Request. No Value supplied for the criteria %s", criteria));
			logWARN(FAFR_E_001);
			return new ResponseMessage(status, payload);
		}
		List<Test> datas = null;
		if ("char".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByChar(value);
		} else if ("int".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByInteger(value);
		} else if ("boolean".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByBoolean(value);
		} else if ("short".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByShort(value);
		} else if ("byte".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByByte(value);
		} else if ("double".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByDouble(value);
		} else if ("long".equalsIgnoreCase(criteria)) {
			datas = ((TestDAO) dao).getByLong(value);
		} else {
			datas = ((TestDAO) dao).getByStringUsingContains(value);
		}
		if (datas == null) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(
					String.format("Unable to find by %s with the value %s", criteria, value));
			logWARN(FAFR_E_000);
			return new ResponseMessage(status, payload);
		}
		if (datas.isEmpty()) {
			status = HttpStatus.BAD_REQUEST;
			payload = new PayloadMessage<String>(status.getReasonPhrase());
			logWARN(FAFR_W_001);
			return new ResponseMessage(status, payload);
		}
		status = HttpStatus.OK;
		payload = new PayloadMessage<List<Test>>(datas);
		logINFO(String.format("Returning Test Data with %s=%s", criteria, value));
		return new ResponseMessage(status, payload);
	}

	@Override
	public ResponseMessage get() {
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
