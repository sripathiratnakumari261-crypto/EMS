package com.codegnan.service;

import java.util.HashMap;
import com.codegnan.model.Account;
import com.codegnan.model.CurrentAccount;
import com.codegnan.model.Customer;
import com.codegnan.model.SavingsAccount;

public class BankService {
HashMap<Integer,Customer>customers=new HashMap<Integer,Customer>();
HashMap<Integer,Account>accounts=new HashMap<Integer,Account>();

public void createCustomer(int id,String name) {
	Customer customer=new Customer(id,name);
	customers.put(id,customer);
	System.out.println("Customer created Succesfully");
	
}
public void createAccount(int cus_id, String name, String type, double balance, int acc_no) {
	
if(customers.containsKey(cus_id)) {	
	if(type.equalsIgnoreCase("savings")) {
		Account account=new SavingsAccount(acc_no,name, customers.get(cus_id),balance);
				accounts.put(acc_no, account);
		
		System.out.println("SavingsAccount created Succesfully..");
		}
	else {
		if(type.equalsIgnoreCase("current")) {
			Account account=new CurrentAccount(acc_no,name, customers.get(cus_id),balance);
					accounts.put(acc_no, account);
			
					
			System.out.println("CurrentAccount created Succesfully..");
	}
		else {
		System.out.println("Invalid Account type");
	}
   }
 }
else {
	System.out.println("Invalid CustomerId......");
}
}
public void deposit(int acc_no, double amount) {
	if(accounts.containsKey(acc_no)) {
		Account account=accounts.get(acc_no);
		account.deposit(amount);
		System.out.println("Deposited Successfully.....CurrentBalance"+account.getBalance());
		
	}else {
		System.out.println("Invalid AccountNumber.......");
	}
	
}
public void withdraw(int acc_no, double amount) {
	if(accounts.containsKey(acc_no)) {
		Account account=accounts.get(acc_no);
		if(account.withdraw(amount)) {
		account.deposit(amount);
		System.out.println("WithdrawSuccessfully.....CurrentBalance"+account.getBalance());
		}
	}else {
		System.out.println("Invalid AccountNumber.......");
	}
	
}
public void viewBalance(int acc_no) {
	if(accounts.containsKey(acc_no)) {
		Account account=accounts.get(acc_no);
		
		System.out.println("CurrentBalance"+account.getBalance());
		
	}else {
		System.out.println("Invalid AccountNumber.......");
	}
	
}
public void viewProfile(int acc_no) {
	if(accounts.containsKey(acc_no)) {
		Account account = accounts.get(acc_no);
		System.out.println("Account Details: "+account);
	}
	else {
		System.out.println("Invalid Account Number.");
	}
}
}
