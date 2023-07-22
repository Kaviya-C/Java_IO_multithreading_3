package com.multithreading.end.java.io;

public class ThreadInterruptStatus {

	public static void main(String... args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int index = 0; index < 6; index++) {
					System.out.println("i am run " + Thread.currentThread().getName());
					try {
						Thread.sleep(1000);

						if (Thread.interrupted()) {
							System.out.println("i got interrupted..");
						    return;
						
						}

					} catch (InterruptedException e) {
						System.out.println("I got interrupted/...");
					}
				}

			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					Thread thread = new Thread();
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int index = 0; index < 6; index++) {

					System.out.println("i am run " + Thread.currentThread().getName());
				}

			}
		};

		t1.start();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println(t1.isInterrupted() + "  " + Thread.interrupted());
		// t2.start();

	}
}
