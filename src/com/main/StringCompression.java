package com.main;

public class StringCompression {
	/**
	 * Реализуйте метод для выполнения простейшего сжатия строк с использованием
	 * счетчика повторяющихся символов. Например, строка ааЬсссссааа превращается в
	 * а2b1с5а3. Если •сжатая� строка не становится короче исходной, то метод
	 * возвращает исходную строку. Предполагается, что строка состоит только из букв
	 * верхнего и нижнего регистра (a-z).
	 */

	public static void main(String... args) {
		System.out.println(compress("ааЬсссссааа"));
	}

	private static String compress(String str) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (index < str.length()) {
			int charCounter = 1;
			char anchor = str.charAt(index);
			sb.append(anchor);
			index++;

			while (index < str.length() && anchor == str.charAt(index)) {
				charCounter++;
				index++;
			}
			
			sb.append(charCounter);
		}
		String result = sb.toString();
		return result.length() >= str.length() ? str : result;
	}

}
