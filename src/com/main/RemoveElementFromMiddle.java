package com.main;

//Реализуйте алгоритм, удаляющий узел из середины односвязного списка (то
//есть узла, не являющегося ни начальным, ни конечным - не обязательно находящегося точно в середине). 
//Доступ предоставляется только к этому узлу.
//Пример:
//Ввод: узел с из списка a->b->c->d->e ->f
//Вывод: ничего не возвращается, но новый список имеет вид: a->b->d- >e->f
//Подсказки: 72 

public class RemoveElementFromMiddle {
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
		int remove = 6;

		if (current.data == remove) {
			current = current.next;
			head = current;
		} else {
			while (current.next != null) {

				if (current.next.data == remove) {
					current.next = current.next.next;
					break;
				}
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
