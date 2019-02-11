package com.main;

public class Pairs {

	public static void main(String[] args) {

		int k = 2;
		int[] arr = { 1, 5, 3, 4, 2 };
		System.out.println("Init: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(pairs(k, arr));
//		System.out.println("Sort: ");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}

	}

	static void sort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int[] temp, int start, int end) {

		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, temp, start, mid);
		mergeSort(arr, temp, mid + 1, end);

		mergeHalves(arr, temp, start, end);

	}

	static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {

			if (arr[left] <= arr[right]) {
				temp[index++] = arr[left++];
			} else {
				temp[index++] = arr[right++];
			}
		}

		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);

	}

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {

		int countPairs = 0;
		sort(arr);
		int i = 0, j = 0;

		while (i < arr.length) {
			while (j < arr.length && arr[j] - arr[i] <= k) {
				if (arr[j] - arr[i] == k)
					countPairs++;
				j++;
			}
			i++;
		}
		return countPairs;
	}
}
