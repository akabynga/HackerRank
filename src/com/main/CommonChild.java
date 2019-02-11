package com.main;

import java.io.IOException;

public class CommonChild {

	public static int LCS(int[][] mem, String s1, String s2, int n, int m) {

		if (mem[n][m] != -1) {
			return mem[n][m];
		} else {
			int result = 0;
			if (n == 0 || m == 0) {
				result = 0;
			} else if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
				result = 1 + LCS(mem, s1, s2, n - 1, m - 1);
			} else if (s1.charAt(n - 1) != s2.charAt(m - 1)) {
				int temp1 = LCS(mem, s1, s2, n - 1, m);
				int temp2 = LCS(mem, s1, s2, n, m - 1);
				result = Math.max(temp1, temp2);
			}
			mem[n][m] = result;
			return result;
		}
	}

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				mem[i][j] = -1;
			}
		}
		return LCS(mem, s1, s2, s1.length(), s2.length());
	}

	public static void main(String[] args) throws IOException {
		System.out.println(commonChild("123", "as1d"));
	}
}