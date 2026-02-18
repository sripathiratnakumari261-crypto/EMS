package com.codegnan.model;

public  class SavingsAccount extends Account{
	static final double MINIMUM_BALANCE=1000;
	public SavingsAccount(int id, String name, Customer customer, double balance) {
		super(id, name, customer, balance);
		
	}

@Override
public boolean withdraw(double amount) {
	if(getBalance()-amount>MINIMUM_BALANCE) {
		double balance=getBalance();
		balance-=amount;
		return true;
	}
	return false;
}
	
}
