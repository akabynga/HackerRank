package com.main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class FraudulentActivityNotifications {

	private final static double EPSILON = 0.00001;

	public static boolean lessThan(double a, double b) {
		return lessThan(a, b, EPSILON);
	}

	public static boolean lessThan(double a, double b, double epsilon) {
		return b - a > epsilon;
	}

	public static boolean equals(double a, double b) {
		return a == b ? true : Math.abs(a - b) < EPSILON;
	}

	static int activityNotifications(int[] expenditure, int d) {

		int count = 0;
		// create freq array as exp <= 200 always
		// maintain a queue to find ontgoing and incoming exp
		// get median from freq array

		int[] freq = new int[201];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < expenditure.length; i++) {
			while (i < d) {
				q.add(expenditure[i]);
				freq[expenditure[i]]++;
				i++;
			}

			float median = getMedian(freq, d);

			if (expenditure[i] >= 2 * median) {
				count++;
			}

			// removing outing going element freq
			int elem = q.remove();
			freq[elem]--;

			// adding incoming element to freq
			q.add(expenditure[i]);
			freq[expenditure[i]]++;
		}

		return count;
	}

	private static float getMedian(int[] freq, int d) {
		if (d % 2 == 1) {
			int center = 0;
			for (int i = 0; i < freq.length; i++) {
				center = center + freq[i];

				if (center > d / 2) {
					return i;
				}
			}
		} else {
			int count = 0;
			int first = -1;
			int second = -1;
			for (int i = 0; i < freq.length; i++) {
				count = count + freq[i];

				if (count == d / 2) {
					first = i;
				} else if (count > d / 2) {
					if (first < 0)
						first = i;
					second = i;

					return ((float) first + (float) second) / 2;
				}
			}
		}
		return 0f;
	}

	public static void main(String[] args) throws IOException {

		int[] arr = { 10, 20, 30, 40, 50 };
		int result = activityNotifications(arr, 3);
		System.out.println(result);
	}
}
