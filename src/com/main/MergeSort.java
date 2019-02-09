package com.main;

public class MergeSort {
	public static void main(String... args) {
		int[] arr = { 2, 1, 3, 1, 2 };
		int numSwaps = mergeSort(arr, new int[arr.length], 0, arr.length - 1);
		System.out.println(numSwaps);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//
//		}
	}

	private static int mergeSort(int[] arr, int[] temp, int left, int right) {
		if (left >= right) {
			return 0;
		}
		int mid = (left + right) / 2;

		int numSwaps = mergeSort(arr, temp, left, mid);
		numSwaps += mergeSort(arr, temp, mid + 1, right);

		numSwaps += mergeHalves(arr, temp, left, mid + 1, right);

		return numSwaps;
	}

	private static int mergeHalves(int[] arr, int[] temp, int leftStart, int mid, int rightEnd) {

		int numSwaps = 0;

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;

		int index = leftStart;
		int left = leftStart;
		int right = rightStart;

		int size = rightEnd - leftStart + 1;
		while (left <= mid - 1 && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index++] = arr[left++];
			} else {
				temp[index++] = arr[right++];
				numSwaps = numSwaps + (mid - left);
			}
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		return numSwaps;
	}

	static int merge(int arr[], int temp[], int leftStart, int mid, int rightEnd) {
		int left, right, index;
		int inv_count = 0;

		left = leftStart;
		right = mid;
		index = leftStart;
		while (left <= mid - 1 && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index++] = arr[left++];
			} else {
				temp[index++] = arr[right++];
				inv_count = inv_count + (mid - left);
			}
		}
		while (left <= mid - 1)
			temp[index++] = arr[left++];

		while (right <= rightEnd)
			temp[index++] = arr[right++];
		for (left = leftStart; left <= rightEnd; left++)
			arr[left] = temp[left];

		return inv_count;
	}
}
