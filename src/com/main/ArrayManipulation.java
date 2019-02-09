package com.main;

import java.io.IOException;
import java.util.Scanner;

/**
 * @task https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @solution https://www.hackerrank.com/challenges/crush/forum/comments/255515
 */
public class ArrayManipulation {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		long[] arr = new long[n + 1];

		while (m-- > 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int k = scanner.nextInt();
			arr[a - 1] += k;
			arr[b] -= k;
		}

		long result = 0;
		long sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			result = Math.max(sum, result);
		}
		scanner.close();
		System.out.println(result);
	}
}
