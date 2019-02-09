package com.main;

public class InsertionSort {
	public static void main(String... args) {
		int[] arr = { 2, 1, 3, 1, 2 };
		long swaps = sort(arr);
		System.out.println("Swaps num: " + swaps);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}
	}

	public static long sort(int arr[]) {
		int n = arr.length;
		long counter = 0;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
				counter++;
			}
			arr[j + 1] = key;
		}
		return counter;
	}
}
