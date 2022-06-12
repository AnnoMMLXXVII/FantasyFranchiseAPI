package com.fantasy.franchise.responseMessage;

import org.springframework.http.HttpStatus;

public class StatusResponse {
	private String reason;
	private Integer code;

	/**
	 * @param status
	 */
	public StatusResponse(HttpStatus status) {
		this.code = status.value();
		this.reason = status.getReasonPhrase();
	}

	/**
	 * @return the status
	 */
	public Integer getStatusCode() {
		return code;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
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
		StatusResponse other = (StatusResponse) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		return true;
	}

}
