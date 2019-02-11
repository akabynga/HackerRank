package com.main;

public class CheckPalindromPermutation {

	/**
	 * Напишите функцию, которая проверяет, является ли заданная строка
	 * перестановкой палиндрома. (Палиндром - слово или фраза, одинаково читающиеся
	 * в прямом и обратном направлении; перестановка - строка, содержащая те же
	 * символы в другом порядке.) Палиндром не ограничивается словами из словаря.
	 * --------------------------------------------------------------------------
	 * Пример: Ввод: Tact Соа
	 * --------------------------------------------------------------------------
	 * Вывод: True ( перестановки : "taco cat ", "atco cta ", и т . д .)
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println(isPolindromPermutation("Tact Coa"));
	}

	private static boolean isPolindromPermutation(String s) {
		s = s.toLowerCase();
		int[] freq = new int[127];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			freq[s.charAt(i)]++;
		}

		boolean findOdd = false;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] % 2 == 1) {
				if (findOdd) {
					return false;
				}
				findOdd = true;
			}

		}
		return true;
	}
}
