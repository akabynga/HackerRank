package com.main;

public class StringPermutation {
	/**
	 * Для двух строк напишите метод, определяющий, явля�тся ли одна строка
	 * перестановкой другой.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(isPermutation("12243", "32241"));
	}

	private static boolean isPermutation(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		int[] freq = new int[127];
		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			freq[s2.charAt(i)]--;
			if (freq[s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}

}
