package com.banking;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Account account = new Account(1000);
		Transaction t = new Transaction(account);
//		a.deposit(10);
//		a.withdraw(500);
//		a.withdraw(500);
//		a.withdraw(500);
//		a.withdraw(500);
//		a.withdraw(500);
//		a.withdraw(500);
		int threadcount = 5;
		Thread[] threads = new Thread[threadcount];
		for (int i = 0; i < threadcount; i++) {
			threads[i] = new Thread();
			threads[i].start();
				System.out.println(
						"Choose your option:\n 1- For deposit \n 2-for withdraw  \n 3-Display Remaining balance \n 4-display transaction Log");
				Scanner sc = new Scanner(System.in);
				int type = sc.nextInt();
				if (type == 1) {
					System.out.println("Enter Amount for deposit");
					double amount = sc.nextDouble();
					t.deposit(amount);
				} else if (type == 2) {
					System.out.println("Enter Amount for withdraw");
					double amount = sc.nextDouble();
					t.withdraw(amount);
				} else if (type == 3) {
					System.out.println("Current balance is: " + account.getBalance());
				} else {
					List<String> tr = t.displaylog();
					for (String message : tr) {
						System.out.println(message);
					}
				}
				
				
			
			
		}
		

		for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

	}

}
