package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDublicates {

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "UTF-8"), 32768);
		int quantity = Integer.parseInt(r.readLine());
		int number = 0;
		int i = 0;
		int last = Integer.MIN_VALUE;

		for (i = 0; i < quantity; i++) {
			number = Integer.parseInt(r.readLine());
			if (i == 1) {
				System.out.println(number);
			}

			if (last != number) {
				System.out.println(number);
			}

			last = number;
		}

	}
}
