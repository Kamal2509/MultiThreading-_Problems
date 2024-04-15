package com.banking;

public class Account {
	private double balance;

	public Account(double initialBalance) {
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			System.out.println("Balance is not sufficient: " + balance);
		}

	}

	public double getBalance() {
		return balance;
	}
}