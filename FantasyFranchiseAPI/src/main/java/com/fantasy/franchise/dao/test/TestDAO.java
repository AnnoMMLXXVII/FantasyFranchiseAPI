package com.fantasy.franchise.dao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fantasy.franchise.dao.DataAccessObject;
import com.fantasy.franchise.model.test.Test;

@Repository
public class TestDAO implements DataAccessObject<Test> {

	private List<Test> data;

	private static TestDAO instance;

	public static DataAccessObject<Test> getInstance() {
		if (instance == null) {
			synchronized (DataAccessObject.class) {
				if (instance == null) {
					return new TestDAO();
				}
			}
		}
		return instance;
	}

	@Override
	public List<Test> getAll() {
		data = TestData.getTestDataSet();
		assert data != null : "Null data set";
		return data;
	}

	@Override
	public Test getById(String v) {
		data = TestData.getTestDataSet();
		Optional<Test> t = data.stream().filter(e -> e.getTestLong().equals(Long.parseLong(v))).findFirst();
		return t.isPresent() ? t.get() : null;
	}

	public List<Test> getByLong(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestLong().equals(Long.parseLong(v))).collect(Collectors.toList());
		} catch (Exception e2) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByBoolean(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestBoolean().equals(Boolean.parseBoolean(v)))
					.collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByStringUsingContains(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestString().contains(v)).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByStringUsingEquals(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestString().equalsIgnoreCase(v)).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByInteger(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestInteger().equals(Integer.parseInt(v))).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByByte(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestByte().equals(Byte.parseByte(v))).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByShort(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestShort().equals(Short.parseShort(v))).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByChar(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestCharacter().equals(v.charAt(0))).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	public List<Test> getByDouble(String v) {
		data = TestData.getTestDataSet();
		List<Test> t = null;
		try {
			t = data.stream().filter(e -> e.getTestDouble().equals(Double.parseDouble(v))).collect(Collectors.toList());
		} catch (Exception ex) {
			return null;
		}
		return t.isEmpty() ? new ArrayList<>() : t;
	}

	@Override
	public boolean create(Test object) {

		return false;
	}

	@Override
	public boolean update(Test object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Test object) {
		// TODO Auto-generated method stub
		return false;
	}

}
