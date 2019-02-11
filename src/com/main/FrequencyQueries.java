package com.main;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(int[][] queries) {
		Map<Integer, Integer> valueFreq = new HashMap<Integer, Integer>();
		Map<Integer, Integer> freqNum = new HashMap<Integer, Integer>();
		List<Integer> result = new LinkedList<Integer>();

		int operation;
		int value;
		int oldFreq;
		int oldFNum;

		for (int i = 0; i < queries.length; i++) {

			int[] arr = queries[i];
			operation = arr[0];
			value = arr[1];
			switch (operation) {
			case 1:
				oldFreq = valueFreq.getOrDefault(value, 0);
				oldFNum = freqNum.getOrDefault(oldFreq, 0);

				freqNum.put(oldFreq + 1, freqNum.getOrDefault(oldFreq + 1, 0) + 1);
				freqNum.put(oldFreq, freqNum.getOrDefault(oldFreq, 1) - 1);

				valueFreq.put(value, oldFreq + 1);
				break;
			case 2:
				oldFreq = valueFreq.getOrDefault(value, 0);

				if (oldFreq > 0) {
					oldFNum = freqNum.getOrDefault(oldFreq, 0);
					if (oldFNum > 0) {
						freqNum.put(oldFreq, oldFNum - 1);
					}
					freqNum.put(oldFreq - 1, freqNum.getOrDefault(oldFreq - 1, 0) + 1);

					valueFreq.put(value, oldFreq - 1);
				}
				break;
			case 3:
				if (freqNum.getOrDefault(value, 0) == 0) {
					result.add(0);
				} else {
					result.add(1);
				}
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

			int q = Integer.parseInt(bufferedReader.readLine().trim());
			int[][] queries = new int[q][2];

			for (int i = 0; i < q; i++) {
				String[] query = bufferedReader.readLine().split(" ");
				queries[i][0] = Integer.parseInt(query[0]);
				queries[i][1] = Integer.parseInt(query[1]);
			}

			List<Integer> ans = freqQuery(queries);

			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

				bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");
			}
		}
	}
}