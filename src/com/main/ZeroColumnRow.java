package com.main;

import java.util.LinkedList;
import java.util.List;

public class ZeroColumnRow {

//	Напишите алгоритм, реализующий следующее условие: если элемент матрицы
//	MxN равен О, то весь столбец и вся строка обнуляются. 

	public static void main(String... args) {

		int m = 4;
		int n = 4;
		List<Integer> rows = new LinkedList<>();
		List<Integer> columns = new LinkedList<>();

		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}
		System.out.println("Before: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("After: ");
		for (Integer i : rows) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = 0;
			}
		}

		for (Integer j : columns) {
			for (int i = 0; i < n; i++) {
				matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
