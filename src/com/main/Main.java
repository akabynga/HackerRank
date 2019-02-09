package com.main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

	public static void main(String args[]) {
		float x = 1.0F;
		int numFloats = 0;
		while (x <= 2.0) {
		    numFloats++;
		    System.out.println(x);
		    x = Math.nextUp(x);
		}
		System.out.println(numFloats);
//		CountDownLatch cd1 = new CountDownLatch(6);
//		CountDownLatch cd2 = new CountDownLatch(6);
//		CountDownLatch cd3 = new CountDownLatch(6);
//		CountDownLatch cd4 = new CountDownLatch(6);
//		ExecutorService es = Executors.newFixedThreadPool(2);
//
//		System.out.println("Запуск потоков");
//
//		// запустить потоки исполнения
//		es.execute(new MyThread(cd1, "A"));
//		es.execute(new MyThread(cd2, "B"));
//		es.execute(new MyThread(cd3, "C"));
//		es.execute(new MyThread(cd4, "D"));
//
//		try {
//			cd1.await();
//			cd2.await();
//			cd3.await();
//			cd4.await();
//		} catch (InterruptedException exc) {
//			System.out.println(exc);
//		}
//
//		es.shutdown();
//		System.out.println("Завершение потоков");
	}
}

class MyThread implements Runnable {
	String name;
	CountDownLatch latch;

	MyThread(CountDownLatch c, String n) {
		latch = c;
		name = n;

//		new Thread(this);
	}

	public void run() {

		for (int i = 0; i < 6; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}
