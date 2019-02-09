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
//		long[] array = { 1, 5, 9 };
//		long m = 5;

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

	/*
	 * Not mine but this solution better =)
	 */
	static long maximumSum_(long[] a, long m) {
		long current;
		long previous = 0;
		long result = 0;
		TreeSet<Long> sums = new TreeSet<>();
		for (int i = 0; i < a.length; i++) {
			current = (previous + a[i] % m) % m;
			result = Math.max(result, current);
			if (sums.ceiling(current) != null) {
				result = Math.max(result, (current - sums.ceiling(current) + m) % m);
			}
			sums.add(current);
			previous = current;
		}
		return result;
	}
}
