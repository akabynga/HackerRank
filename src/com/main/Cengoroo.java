package com.main;

public class Cengoroo {
	public static void main(String... args) {

	}

	static String kangaroo(int x1, int v1, int x2, int v2) {
		long position1 = x1;
		long position2 = x2;
		long distance = Math.abs(x1 - x2);
		while (true) {
			if (position1 == position2) {
				return "YES";
			}
			position1 = position1 + v1;
			position2 = position2 + v2;

			if (distance <= Math.abs(position1 - position2)) {
				return "NO";
			}
		}
	}
}
