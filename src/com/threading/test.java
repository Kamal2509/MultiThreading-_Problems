package com.threading;

public class test {

	public static void main(String[] args) {
		WelcomeThread wt= new WelcomeThread();
		Thread thread= new Thread(wt);
		thread.start();

		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread : "+i);
		}
	}
}

class WelcomeThread implements Runnable {
	@Override
	public void run() {
		for(int j=1;j<=10;j++) {
			System.out.println("Welcome Thread : "+j);
		}
	}
}