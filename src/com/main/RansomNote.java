package com.main;

public class RansomNote {

	private static class Entry<String, Integer> {
		final int hash;
		final String key;
		int value;
		Entry<?, ?> next;

		Entry(int hash, String key, int value) {
			this.hash = hash;
			this.key = key;
			this.value = value;
		}
	}

	public static Entry<?, ?> findEntry(Entry<?, ?>[] table, String item) {
		int hash = Math.abs(item.hashCode());
		int index = hash % (table.length - 1);
		if (table[index] != null) {
			Entry<?, ?> eItem = table[index];
			while (eItem != null) {
				if (eItem.key.equals(item) && hash == eItem.hash) {
					return eItem;
				}
				eItem = eItem.next;
			}
		}
		return null;
	}

	public static void add(Entry<?, ?>[] table, String item, int value) {
		int hash = Math.abs(item.hashCode());
		int index = hash % (table.length - 1);

		Entry<?, ?> eItem = new Entry<String, Integer>(hash, item, value);

		if (table[index] != null) {
			Entry<?, ?> temp = table[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = eItem;
		} else {
			table[index] = eItem;
		}
	}

	public static void main(String[] args) {

		String[] magazineItems = "give me one grand today night".split(" ");
		String[] noteItems = "give one grand today".split(" ");

		Entry<?, ?>[] table = new Entry<?, ?>[magazineItems.length];

		for (int i = 0; i < magazineItems.length; i++) {
			Entry<?, ?> eItem = findEntry(table, magazineItems[i]);
			if (eItem != null) {
				eItem.value++;
			} else {
				add(table, magazineItems[i], 1);
			}
		}

		boolean can = true;
		for (int i = 0; i < noteItems.length; i++) {
			Entry<?, ?> eItem = findEntry(table, noteItems[i]);
			if (eItem != null && eItem.value != 0) {
				eItem.value--;
			} else {
				can = false;
				break;
			}

		}
		if (can) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
