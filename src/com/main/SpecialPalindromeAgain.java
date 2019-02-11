package com.main;

public class SpecialPalindromeAgain {

	public static void main(String[] args) {
		System.out.println(substrCount("aaaa"));
	}

	static long substrCount(String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			int innerCounter = 1;

			int counterDown = 0;
			int counterUp = 1;
			while (i - innerCounter >= 0 && i + innerCounter < s.length()
					&& s.charAt(i - innerCounter) == s.charAt(i - 1) && s.charAt(i + innerCounter) == s.charAt(i - 1)) {
				count++;
				innerCounter++;
			}

			while (i - counterDown >= 0 && i + counterUp < s.length() && s.charAt(i - counterDown) == s.charAt(i)
					&& s.charAt(i + counterUp) == s.charAt(i)) {
				count++;
				counterDown++;
				counterUp++;
			}
		}

		return count + s.length();
	}

	static long substrCount1(String s) {
		long count = 0;

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				if (isPalindrom(s.substring(j, j + i))) {
					System.out.println(s.substring(j, j + i));
					count++;
				}
			}
		}

		return count;
	}

	public static boolean isPalindrom(String str) {
		char flag = str.charAt(0);
		for (int i = 0; i < str.length() / 2; i++) {
			if (flag != str.charAt(str.length() - i - 1) || str.charAt(i) != flag) {
				return false;
			}
		}
		return true;
	}

}
