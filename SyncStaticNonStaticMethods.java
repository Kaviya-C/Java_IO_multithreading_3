package com.multithreading.end.java.io;

public class SyncStaticNonStaticMethods {
	public static synchronized void staticMethod() {
		for (int index = 0; index < 5; index++) {
			System.out.println("static: " + index);
		}
		try {
			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void nonStaticMethod() {
		for (int index = 0; index < 5; index++) {
			System.out.println("Non static Method: " + index);
		}
		try {
			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) {
		SyncStaticNonStaticMethods obj = new SyncStaticNonStaticMethods();

		Thread t1 = new Thread() {
			public void run() {
				staticMethod();

			}
		};

		Thread t2 = new Thread() {
			public void run() {
				obj.nonStaticMethod();
			}
		};
		
		t1.start();
		
		t2.start();
	}

}
