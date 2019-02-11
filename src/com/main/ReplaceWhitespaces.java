package com.main;

public class ReplaceWhitespaces {

	/**
	 * Напишите метод, заменяющий все пробелы в строке символами '%20'. Можете
	 * считать, что длина строки позволяет сохранить дополнительные символы, а
	 * фактическая длина строки известна заранее. (Примечание: при реализации метода
	 * на java для выполнения операции •на месте• используйте символьный массив.)
	 * Пример:
	 * 
	 * Ввод: "Mr John Smith ", Вывод: "Mr%20John%20Smith"
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		String s = "Mr John Smith   ";
		s = s.trim();
		int wsCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (' ' == s.charAt(i)) {
				wsCount++;
			}
		}
		char[] newString = new char[s.length() + wsCount * 3];

		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				newString[index++] = '%';
				newString[index++] = '2';
				newString[index++] = '0';
			} else {
				newString[index++] = s.charAt(i);
			}
		}
		// My implementsation
		System.out.println(new String(newString));
		// Default string implementation
		System.out.println(s.replace(" ", "%20"));

	}

}
