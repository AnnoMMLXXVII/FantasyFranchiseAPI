package com.fantasy.franchise.responseMessage;

import static com.fantasy.franchise.common.ApplicationLogger.logWARN;
import static com.fantasy.franchise.common.LogMessagesFAFR.FAFR_W_000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import io.cucumber.messages.JSON;

public class ResponseMessage {

	private List<Object> response = new ArrayList<>();
	private StatusResponse statusMessage;
//	private PayloadMessage<?> payload;
	private Object object;

	public ResponseMessage(HttpStatus status, Object object) {
		statusMessage = new StatusResponse(status);
//		payload = new PayloadMessage<Object>(object);
		this.object = object;
		serializeObjects();
	}

	private void serializeObjects() {
		try {
			response.add(JSON.writeValueAsString(statusMessage));
			response.add(JSON.writeValueAsString(object));
		} catch (IOException e) {
			logWARN(FAFR_W_000);
			response.clear();
			response.add(statusMessage.toString());
			response.add(object.toString());
		}
	}

	/**
	 * @return the status
	 */
	public Integer getStatusCode() {
		return statusMessage.getStatusCode();
	}

	/**
	 * @return the message
	 */
	public Object getMessage() {
		return object;
	}

	/**
	 * @return the ResponseMessage
	 */
	public String getResponseMessage() {
		return String.format("%s", response.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((statusMessage == null) ? 0 : statusMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseMessage other = (ResponseMessage) obj;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (statusMessage == null) {
			if (other.statusMessage != null)
				return false;
		} else if (!statusMessage.equals(other.statusMessage))
			return false;
		return true;
	}

}