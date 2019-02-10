package com.algorithms.search;

import java.util.Arrays;
import java.util.HashMap;

public class HashTablesIceCreamParlor {

	public static void main(String[] args) {
		int m = 4; // money have to spend
//		int[] arr = { 1, 4, 5, 3, 2 }; // prices
		int[] arr = { 2, 2, 4, 3 }; // prices

		int[] indecies = whatFlavors_1(arr, m);
		System.out.println(indecies[0] + " " + indecies[1]);
	}

	// Best solution
	static int[] whatFlavors_1(int[] arr, int money) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int target = money - arr[i];
			if (arr[i] < money) {
				if (map.containsKey(target)) {
					int i1 = map.get(target);
					int i2 = i + 1;
					int[] indecies = { Math.min(i1, i2), Math.max(i1, i2) };
					return indecies;
				} else {
					map.put(arr[i], i + 1);
				}
			}
		}
		return null;
	}

	// binary search solution
	static int[] whatFlavors(int[] menu, int money) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);

		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - menu[i];
			int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
			if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
				int[] indecies = getIndeciesFromValue(menu, sortedMenu[i], complement);
				return indecies;
			}
		}
		return null;
	}

	private static int[] getIndeciesFromValue(int[] menu, int value1, int value2) {
		int index1 = indexOf(menu, value1, 0);
		int index2 = indexOf(menu, value2, index1 + 1);
		int[] indecies = { Math.min(index1, index2), Math.max(index1, index2) };
		return indecies;
	}

	private static int indexOf(int[] menu, int value, int startIndex) {
		for (int i = startIndex; i < menu.length; i++) {
			if (menu[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
