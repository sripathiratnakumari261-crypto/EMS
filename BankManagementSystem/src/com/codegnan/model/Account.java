package com.codegnan.model;

public  abstract class Account {
	private int id;
	private String name;
	private Customer customer;
	//private double balance;
	double balance;
	public Account(int id, String name, Customer customer, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.customer = customer;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
public void deposit(double amount) {
	balance+=amount;
}
public abstract boolean withdraw(double amount);
@Override
public String toString() {
	return "Account [id=" + id + ", name=" + name + ", customer=" + customer + ", balance=" + balance + "]";
}
}

