package com.algorithms.search;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem
 * 
 * @author Dzmitry Shchepin
 *
 */
public class IceCreamParlor {

	public static void main(String[] args) {
		int m = 4; // money have to spend
		int[] arr = { 1, 4, 5, 3, 2 }; // prices
		int[] result = icecreamParlor(m, arr);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	private static int[] icecreamParlor(int m, int[] arr) {
		int[] result = new int[2];

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == m) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return null;
	}
}
