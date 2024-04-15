package com.banking;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
	 private Account account;
	 private List<String>translog;
	 
	 public Transaction(Account account) {
		 this.account= account;
		 this.translog= new ArrayList<>();
	 }

	 public void deposit(double amount) {
		 synchronized (account) {
			 account.deposit(amount);
			 translog.add("amount added: " +amount);
		}
		 
	 }
	 
	 public void withdraw(double amount) {
		 synchronized (account) {
			 if(account.getBalance()>=amount) {
				 account.withdraw(amount);
				 translog.add("amount withdraw: " +amount);
			 }
			 else { 
				 translog.add("Transaction failed-insufficient balance: " +account.getBalance()); 
			 }	
		}		 
	 }
	 
	 public List<String> displaylog() {
		 return translog;
	 }
}
