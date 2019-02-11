package com.main;

public class SymbolOccurence {
	/**
	 * Реализуйте алгоритм, определяющий, все ли символы в строке встречаются только
	 * один раз. А если при этом запрещено использование дополнительных структур
	 * данных?
	 */

	public static void main(String... args) {
		System.out.println(isEachNumberSinlgeOccurance_1("asda"));
		System.out.println(isEachNumberSinlgeOccurance_2("asda"));

	}

	public static boolean isEachNumberSinlgeOccurance_1(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) != s.lastIndexOf(s.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public static boolean isEachNumberSinlgeOccurance_2(String s) {

		int[] arr = new int[127];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
			if (arr[s.charAt(i)] > 1) {
				return false;
			}
		}

		return true;
	}
}
