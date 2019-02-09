package com.main;

import java.io.IOException;

public class TimeConversion {

	public static void main(String[] args) throws IOException {
		long test = (long) "sdfsd".length();
	}

	static long repeatedString(String s, long n) {

		long count = 0;
		long sSize = (long) s.length();
		char[] a = s.toCharArray();
		for (int i = 0; i < sSize; i++) {
			if (a[i] == 'a') {
				count++;
			}
		}
		long remDev = n % sSize;
		long numStrings = n / sSize;

		count = numStrings * count;

		for (long i = 0; i < remDev; i++) {
			if (a[(int) i] == 'a') {
				count++;
			}
		}
		return count;
	}
}
