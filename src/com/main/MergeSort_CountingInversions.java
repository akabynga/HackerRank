package com.main;

public class MergeSort_CountingInversions {

	public static void main(String[] args) {

//		int[] arr = { 2, 1, 3, 1, 2 };
		int[] arr = { 1, 1, 1, 2, 2 };
		int numSwaps = mergeSort(arr, 0, arr.length - 1);

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//
//		}
		System.out.println(numSwaps);
	}

	public static int mergeSort(int[] arr, int startPosition, int endPosition) {
		if (startPosition < endPosition) {
			int middle = (startPosition + endPosition) / 2;
			int numSwaps = mergeSort(arr, startPosition, middle) + mergeSort(arr, middle + 1, endPosition);
			numSwaps += mergeHalves(arr, startPosition, middle, endPosition);
			return numSwaps;
		}
		return 0;
	}

	public static int mergeHalves(int[] arr, int l, int m, int r) {

		int nSwaps = 0;
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				nSwaps++;
				i++;
			} else {
				arr[k] = R[j];
				j++;
				nSwaps += n1 - i;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

		return nSwaps;
	}

}
