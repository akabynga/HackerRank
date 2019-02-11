package com.main;

//Напишите код для удаления дубликатов из несортированного связного списка.

public class RemoveDublicates1 {

	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String... args) {

		int[] hash = new int[10];
		Node head = new Node(5, new Node(6, new Node(5, new Node(6, new Node(6,
				new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, null))))))))))));
		Node current = head;

		while (current != null) {
			hash[current.data]++;
			current = current.next;
		}
		current = head;

		System.out.println("Before: ");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		current = head;

		while (current.next != null) {
			if (hash[current.next.data] > 1) {
				hash[current.next.data]--;
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		current = head;
		System.out.println("After: ");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}
