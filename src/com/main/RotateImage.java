package com.main;

public class RotateImage {

	/**
	 * Имеется изображение, представленное матрицей NxN; каждый пиксел представлен 4
	 * байтами. Напишите метод для поворота изображения на 90 градусов. Удастся ли
	 * вам выполнить эту операцию «на месте»?
	 * 
	 * @param args
	 */
	// [1][2][3] -> [7][4][1]
	// [4][5][6] -> [8][5][2]
	// [7][8][9] -> [9][6][3]
	public static void main(String... args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Start:");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("[" + arr[i][j] + "]");
			}
			System.out.println();
		}

		int temp;
		int length = arr.length - 1;
		for (int i = 0; i <= length / 2; i++) {
			for (int j = i; j < length - i; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[length - j][i];
				arr[length - j][i] = arr[length - i][length - j];
				arr[length - i][length - j] = arr[j][length - i];
				arr[j][length - i] = temp;
			}
		}
		System.out.println();
		System.out.println("Reverted:");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("[" + arr[i][j] + "]");
			}
			System.out.println();
		}

	}
}

//temp = arr[i][j];
//arr[i][j] = arr[length - j][i];
//arr[length - j][i] = arr[length - i][length - j];
//arr[length - i][length - j] = arr[j][length - i];
//arr[j][length - i] = temp;
