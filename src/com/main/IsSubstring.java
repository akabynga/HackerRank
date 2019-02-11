package com.main;

public class IsSubstring {

//	Допустим, что существует метод isSubstring, проверяющий, является ли
//	одно слово подстрокой другого. Для двух строк sl и s2 напишите код, 
//	который проверяет, получена ли строка s2 циклическим сдвигом s1, используя
//	только один вызов метода isSubstring (пример: слово waterbottle получено
//	циклическим сдвигом erbottlewat). 

	public static void main(String... args) {

		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		System.out.println(isSubstring(s1, s2));
	}

	public static boolean isSubstring(String s1, String s2) {

		int index = 0;
		for (int j = 0; j < s1.length(); j++) {
			if (s1.charAt(0) == s2.charAt(j)) {
				index = j;
				break;
			}
		}

		return s1.equals(s2.substring(index, s1.length()) + s2.substring(0, index));
	}
}
