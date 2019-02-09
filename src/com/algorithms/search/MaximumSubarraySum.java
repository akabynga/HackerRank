package com.algorithms.search;

import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * 
 * @author Dzmitry Shchepin
 *
 */

public class MaximumSubarraySum {

	public static void main(String[] args) {
		long[] array = { 3, 3, 9, 9, 5 };
		long m = 7;
		System.out.println(maximumSum(array, m));
	}

	static long maximumSum(long[] a, long m) {

		long[] mods = new long[a.length];
		TreeSet<Long> ts = new TreeSet<>();
		long total = 0;
		long maxM = 0;

		for (int i = 0; i < a.length; i++) {
			total = ((total + a[i]) % m);
			mods[i] = total;
			if (total > maxM) {
				maxM = total;
			}
		}

		for (int i = 0; i < mods.length; i++) {
			ts.add(mods[i]);
			Long least = ts.higher(mods[i]);

			if (least != null && m - (least - mods[i]) > maxM) {
				maxM = m - (least - mods[i]);
			}
		}
		return maxM;
	}
}
