package com.main;

//Напишите код для удаления дубликатов из несортированного связного списка.
//Дополнительно
//Как вы будете решать задачу, если использовать временный буфер запрещено? 
public class RemoveDublicates2 {

	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String... args) {

		Node head = new Node(5, new Node(6, new Node(5, new Node(6, new Node(6,
				new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, new Node(6, null))))))))))));
		Node current = head;

		System.out.println("Before: ");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		current = head;

		while (current != null && current.next != null) {
			Node currentTemp = current;
			while (currentTemp.next != null) {
				if (current.data == currentTemp.next.data) {
					currentTemp.next = currentTemp.next.next;
				} else {
					currentTemp = currentTemp.next;
				}
			}
			current = current.next;
		}
		current = head;
		System.out.println("After: ");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}