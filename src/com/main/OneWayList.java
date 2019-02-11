package com.main;

/*
 * Reverse one way list
 */
public class OneWayList {

	public static void main(String args[]) {

		CustomList<Integer> list = new CustomList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.print();
		System.out.println("--- Reverse ---");
		list.reverse();
		list.print();
	}

	public static class CustomList<T> {

		private Node<T> head;
		private Node<T> current;

		public CustomList() {
		}

		public void add(T val) {
			Node<T> element = new Node<>(val, null);
			if (head == null) {
				head = element;
				current = element;
			} else {
				current.next = element;
				current = element;
			}
		}

		public void reverse() {
			Node<T> prev = head;
			Node<T> cur = head.next;
			Node<T> fwd;
			
			prev.next = null;
			
			while (cur != null) {
				fwd = cur.next;
				cur.next = prev;
				prev = cur;
				cur = fwd;
			}
			head = prev;
		}

		public void print() {
			Node<T> pc = head;
			boolean stop = false;
			while (!stop) {
				System.out.println(pc.toString());
				pc = pc.next;
				if (pc == null) {
					stop = true;
				}
			}
		}

		static class Node<T> {
			private Node<T> next;
			private T value;

			public Node(T value, Node<T> next) {
				this.value = value;
				this.next = next;
			}

			public String toString() {
				return value.toString();
			}
		}
	}
}
