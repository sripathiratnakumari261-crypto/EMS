package com.codegnan.model;

public class CurrentAccount extends Account{
   static final double OVERDRAFT_AMOUNT= 5000;
	public CurrentAccount(int id, String name, Customer customer, double balance) {
		super(id, name, customer, balance);
		
	}

	@Override
	public boolean withdraw(double amount) {
		if(getBalance()-amount>=-OVERDRAFT_AMOUNT) {
//			double balance=getBalance();
//			balance=super.getBalance()-amount;
			balance-=amount;
			return true;
		}
		return false;
	}

}
