package com.algorithms.search;

import java.util.Arrays;

public class Pairs {
	public static void main(String... args) {

		int k = 2;
		int[] arr = { 1, 3, 5, 8, 6, 4, 2 };

		System.out.println(pairs(k, arr));
	}

	static int pairs(int k, int[] arr) {

		int pairsCount = 0;
		Arrays.sort(arr);
		int i = 0, j = 0;

		while (i < arr.length) {
			while (j < arr.length && arr[j] - arr[i] <= k) {
				if (arr[j] - arr[i] == k) {
					pairsCount++;
				}
				j++;
			}
			i++;
		}
		return pairsCount;
	}
}
