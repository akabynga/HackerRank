package com.main;

/**
 * Реализуйте алгоритм для нахождения в односвязном списке k-го элемента с
 * конца.
 */
public class ReturnKthToLast {
	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String... args) {

		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,
				new Node(6, new Node(7, new Node(8, new Node(9, new Node(10, new Node(11, new Node(12, null))))))))))));

		Node current = head;
		int size = 1;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		current = head;
		int k = 7;
		int index = 0;
		Node f = null;
		while (current.next != null) {
			if (index == size - k) {
				f = current;
				break;
			}
			index++;
			current = current.next;
		}
		if (f != null) {
			System.out.println(f.data);
		}
	}
}
