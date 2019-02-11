package com.main;

public class SplitList {

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

		splitList(head, 5);
	}

	private static void splitList(Node head, int val) {
		Node current = head;

		Node tail = head.data == val ? head : null;
		Node h = head.data == val ? head : null;

		while (current.next != null) {
			if (current.next.data == val) {
				if (h == null) {
					h = current.next;
					tail = current.next;
				} else {
					tail.next = current.next;
				}
				current = current.next.next;
			} else {
				current = current.next;
			}
		}

		current = head;

		if (tail == null) {
			tail = head;
		}
		if (h == null) {
			h = head;
		}
		
		while (current.next != null) {
			Node temp = current.next.next;
			if (current.next.data < val) {
				current.next = h;
				h = current.next;
				current = temp;
			} else {
				tail = current.next;
				current = current.next;
				current = temp;
			}
		}
		// TODO Auto-generated method stub

	}
}
