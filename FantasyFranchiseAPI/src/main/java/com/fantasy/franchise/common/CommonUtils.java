package com.fantasy.franchise.common;

import java.util.Random;

/**
 * Class that will comprise of methods that may be useful through out the entire
 * project
 * 
 * @author Haku Wei
 *
 */
public class CommonUtils {

	private static Random r;

	public static synchronized String generateRandomString(long seed) {
		r = new Random(seed);
//		if (n < 0 || n == 0) {
//			n = 10 + r.nextInt(21);
//		}
		int leftLimit = 65; // letter 'A'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		String s = r.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return s;
	}

	public static synchronized Character generateRandomCharacter(long seed) {
		r = new Random(seed);
//		if (n < 0 || n == 0) {
//			n = 10 + r.nextInt(21);
//		}
		int leftLimit = 65; // letter 'A'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 1;
		Character c = r.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).charAt(0);
		return c;
	}

	public static int generateRandomID() {
		r = new Random(System.currentTimeMillis());
		return 1 + r.nextInt(90001);
	}
	
}
