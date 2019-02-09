package sorting;

public class MergeSort {

	public static void sort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;

		mergeSort(arr, temp, left, mid);
		mergeSort(arr, temp, mid + 1, right);
		mergeHalves(arr, temp, left, mid + 1, right);
	}

	private static void mergeHalves(int[] arr, int[] temp, int leftStart, int mid, int rightEnd) {
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
			}
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}
}
