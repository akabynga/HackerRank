package com.algorithms.implementation;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * 
 * @author Dzmitry Shchepin
 *
 */
public class BreakingTheRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 20, 20, 4, 5, 2, 25, 1 };
		int[] result = breakingRecords(arr);
		System.out.println(result[0] + " " + result[1]);
	}

	static int[] breakingRecords(int[] scores) {

		int min = scores[0];
		int max = scores[0];

		int[] counter = { 0, 0 };

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				counter[0]++;
				max = scores[i];
			}
			if (scores[i] < min) {
				counter[1]++;
				min = scores[i];
			}
		}
		return counter;
	}
}
