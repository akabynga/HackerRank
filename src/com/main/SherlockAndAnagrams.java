package com.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock And Anagrams
 * 
 * @author Dzmitry Shchepin
 * @see https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagrams {

	public static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	static int sherlockAndAnagrams(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int result = 0;

		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j + i > s.length()) {
					break;
				}
				String sub = sortString(s.substring(j, j + i));
				if (!map.containsKey(sub)) {
					map.put(sub, 1);
				} else {
					int c = map.get(sub);
					c++;
					map.put(sub, c);
				}
			}
		}
		for (Integer c : map.values()) {
			result = result + c * (c - 1) / 2;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("abba"));
//		System.out.println(sherlockAndAnagrams("abcd"));
	}

}
