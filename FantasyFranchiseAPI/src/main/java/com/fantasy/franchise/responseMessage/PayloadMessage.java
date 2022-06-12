package com.fantasy.franchise.responseMessage;

public class PayloadMessage<T> {

	private T payload;

	/**
	 * @param payload
	 */
	public PayloadMessage(T payload) {
		super();
		this.payload = payload;
	}

	/**
	 * @return the payload
	 */
	public String toString() {
		return payload.toString();
	}
	
	public T getPayload() {
		return payload;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
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
		PayloadMessage<?> other = (PayloadMessage<?>) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		return true;
	}

}
