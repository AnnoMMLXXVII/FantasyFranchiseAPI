package com.fantasy.franchise.model.test;

import org.springframework.stereotype.Component;

/**
 * @author Haku Wei
 *
 */
@Component
public class Test {
	private Long testLong;
	private String testString;
	private Integer testInteger;
	private Double testDouble;
	private Byte testByte;
	private Short testShort;
	private Character testCharacter;
	private Boolean testBoolean;

	public Test() {
		super();
	}

	/**
	 * @param testLong
	 * @param testString
	 * @param testInteger
	 * @param testDouble
	 * @param testByte
	 * @param testShort
	 * @param testCharacter
	 * @param testBoolean
	 */
	public Test(Long testLong, String testString, Integer testInteger, Double testDouble, Byte testByte,
			Short testShort, Character testCharacter, Boolean testBoolean) {
		super();
		this.testLong = testLong;
		this.testString = testString;
		this.testInteger = testInteger;
		this.testDouble = testDouble;
		this.testByte = testByte;
		this.testShort = testShort;
		this.testCharacter = testCharacter;
		this.testBoolean = testBoolean;
	}

	/**
	 * @return the testLong
	 */
	public Long getTestLong() {
		return testLong;
	}

	/**
	 * @param testLong the testLong to set
	 */
	public void setTestLong(Long testLong) {
		this.testLong = testLong;
	}

	/**
	 * @return the testString
	 */
	public String getTestString() {
		return testString;
	}

	/**
	 * @param testString the testString to set
	 */
	public void setTestString(String testString) {
		this.testString = testString;
	}

	/**
	 * @return the testInteger
	 */
	public Integer getTestInteger() {
		return testInteger;
	}

	/**
	 * @param testInteger the testInteger to set
	 */
	public void setTestInteger(Integer testInteger) {
		this.testInteger = testInteger;
	}

	/**
	 * @return the testDouble
	 */
	public Double getTestDouble() {
		return testDouble;
	}

	/**
	 * @param testDouble the testDouble to set
	 */
	public void setTestDouble(Double testDouble) {
		this.testDouble = testDouble;
	}

	/**
	 * @return the testByte
	 */
	public Byte getTestByte() {
		return testByte;
	}

	/**
	 * @param testByte the testByte to set
	 */
	public void setTestByte(Byte testByte) {
		this.testByte = testByte;
	}

	/**
	 * @return the testShort
	 */
	public Short getTestShort() {
		return testShort;
	}

	/**
	 * @param testShort the testShort to set
	 */
	public void setTestShort(Short testShort) {
		this.testShort = testShort;
	}

	/**
	 * @return the testCharacter
	 */
	public Character getTestCharacter() {
		return testCharacter;
	}

	/**
	 * @param testCharacter the testCharacter to set
	 */
	public void setTestCharacter(Character testCharacter) {
		this.testCharacter = testCharacter;
	}

	/**
	 * @return the testBoolean
	 */
	public Boolean getTestBoolean() {
		return testBoolean;
	}

	/**
	 * @param testBoolean the testBoolean to set
	 */
	public void setTestBoolean(Boolean testBoolean) {
		this.testBoolean = testBoolean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testBoolean == null) ? 0 : testBoolean.hashCode());
		result = prime * result + ((testByte == null) ? 0 : testByte.hashCode());
		result = prime * result + ((testCharacter == null) ? 0 : testCharacter.hashCode());
		result = prime * result + ((testDouble == null) ? 0 : testDouble.hashCode());
		result = prime * result + ((testInteger == null) ? 0 : testInteger.hashCode());
		result = prime * result + ((testLong == null) ? 0 : testLong.hashCode());
		result = prime * result + ((testShort == null) ? 0 : testShort.hashCode());
		result = prime * result + ((testString == null) ? 0 : testString.hashCode());
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
		Test other = (Test) obj;
		if (testBoolean == null) {
			if (other.testBoolean != null)
				return false;
		} else if (!testBoolean.equals(other.testBoolean))
			return false;
		if (testByte == null) {
			if (other.testByte != null)
				return false;
		} else if (!testByte.equals(other.testByte))
			return false;
		if (testCharacter == null) {
			if (other.testCharacter != null)
				return false;
		} else if (!testCharacter.equals(other.testCharacter))
			return false;
		if (testDouble == null) {
			if (other.testDouble != null)
				return false;
		} else if (!testDouble.equals(other.testDouble))
			return false;
		if (testInteger == null) {
			if (other.testInteger != null)
				return false;
		} else if (!testInteger.equals(other.testInteger))
			return false;
		if (testLong == null) {
			if (other.testLong != null)
				return false;
		} else if (!testLong.equals(other.testLong))
			return false;
		if (testShort == null) {
			if (other.testShort != null)
				return false;
		} else if (!testShort.equals(other.testShort))
			return false;
		if (testString == null) {
			if (other.testString != null)
				return false;
		} else if (!testString.equals(other.testString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Test [testLong=" + testLong + ", testString=" + testString + ", testInteger=" + testInteger
				+ ", testDouble=" + testDouble + ", testByte=" + testByte + ", testShort=" + testShort
				+ ", testCharacter=" + testCharacter + ", testBoolean=" + testBoolean + "]";
	}

}
