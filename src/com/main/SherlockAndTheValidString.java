package com.main;

public class SherlockAndTheValidString {

	// Complete the isValid function below.
	static String isValid(String s) {

		int[] lettercounts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			lettercounts[s.charAt(i) - 'a']++;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int maxCounter = 0;
		int minCounter = 0;

		for (int i : lettercounts) {
			if (i < min && i != 0) {
				min = i;
				minCounter = 0;
			}

			if (i > max && i != 0) {
				max = i;
				maxCounter = 0;
			}
			if (i == min) {
				minCounter++;
			}

			if (i == max) {
				maxCounter++;
			}
		}
		if (max - min > 1) {
			return "NO";
		}
		System.out.println(minCounter);
		System.out.println(maxCounter);
		if (maxCounter - 1 != 0) {
			return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) {
		System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
	}
}