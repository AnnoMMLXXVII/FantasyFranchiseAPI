package com.fantasy.franchise.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

import com.fantasy.franchise.common.CommonUtils;
import com.fantasy.franchise.model.test.Test;

public class TestData {
	private static List<Test> dataSet = new ArrayList<>();

	public static void initializeTestData() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 800; i++) {
			try {
				for (int j = 0; j < 8; j++) {
					Thread.sleep(1);
					if (j == 1 || j == 7 || j == 6) {
						if (j == 1) {
							sb.append(CommonUtils.generateRandomString(System.nanoTime()) + ",");
						} else if (j == 6) {
							sb.append(CommonUtils.generateRandomCharacter(System.nanoTime()) + ",");
						} else {
							sb.append(((CommonUtils.generateRandomID() % 2 == 0) ? true : false) + ",");
						}
					} else {
						long data = (System.nanoTime()) * (j + 1);
						if (j == 5) {
							data = (data % 1000000) / 1000000;
						}
						if (j == 2) {
							data = (data / 100000);
						}
						if (j == 4) {
							data = (data % 1000000) / 100000;
						}
						sb.append(data + ",");
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addToDataSet(sb.toString());
			sb.delete(0, sb.length());
		}
	}

	private static void addToDataSet(String data) {
		String[] temp = data.split(",");
		Test test = new Test();
		test.setTestLong(Long.parseLong(temp[0]));
		test.setTestString(temp[1]);
		test.setTestInteger(Integer.parseInt(temp[2]));
		test.setTestDouble(Double.parseDouble(temp[3]));
		test.setTestByte(Byte.parseByte(temp[4]));
		test.setTestShort(Short.parseShort(temp[5]));
		test.setTestCharacter(temp[6].charAt(0));
		test.setTestBoolean(Boolean.parseBoolean(temp[7]));
		dataSet.add(test);
	}

	public static List<Test> getTestDataSet() {
		return dataSet;
	}

	public static void main(String[] args) {
		initializeTestData();
		dataSet = getTestDataSet();
		for (Test t : dataSet) {
			System.out.println(t.toString());
		}
	}

}
