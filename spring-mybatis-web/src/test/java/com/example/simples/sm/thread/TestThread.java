package com.example.simples.sm.thread;

import java.util.concurrent.TimeUnit;

public class TestThread {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("11111111");
			}
		});
		t.setDaemon(true);
		t.setPriority(10);
		t.setName("test");
		t.start();
		TimeUnit.SECONDS.sleep(0);
	}

}
