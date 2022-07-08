package com.fafr.common;

import java.util.List;
import java.util.Random;

import com.fafr.model.player.Player;

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

	public static int searchPlayer(List<Player> list, Player key) {
		PlayerSearch<Player> searchObject = new PlayerSearch<>();
		return searchObject.search(list, key);
	}
	
	public static int searchPlayer(List<Player> list, Integer key) {
		PlayerSearch<Player> searchObject = new PlayerSearch<>();
		return searchObject.search(list, key);
	}

}

class PlayerSearch<T extends Comparable<T>> {

	public int search(List<T> list, T object) {
		int idx = binarySearch(list, object);
		return idx;
	}

	public int search(List<T> list, Integer object) {
		int idx = binarySearch(list, object);
		return idx;
	}

	private int binarySearch(List<T> list, T keyObj) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (keyObj.compareTo(list.get(mid)) == 0) {
				return mid;
			}
			if (keyObj.compareTo(list.get(mid)) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private int binarySearch(List<T> list, Integer keyObj) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (keyObj.compareTo(((Player) list.get(mid)).getId()) == 0) {
				return mid;
			}
			if (keyObj.compareTo(((Player) list.get(mid)).getId()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
