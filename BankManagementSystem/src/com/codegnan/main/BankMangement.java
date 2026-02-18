package com.codegnan.main;

import java.util.Scanner;
import com.codegnan.service.BankService;

public class BankMangement {

	public static void main(String[] args) {
		BankService obj=new BankService();
Scanner sc=new Scanner(System.in);
int service;
do {
System.out.println("Enter your  service\n"
		           +"1.create Customer\n"
		           +"2.create Account\n"
		           +"3.deposit Amount\n"
		           +"4.withdraw  Amount\n"
		          +"5.View Balance\n"
		           +"6.View Account\n"
		          +"7.EXist\n"
		           +"****************************************\n");
service=sc.nextInt();
switch(service) {
case 1->{
	System.out.println("enter customer Id");
	int id=sc.nextInt();
	System.out.println("Enter name");
	String name=sc.next();
	obj.createCustomer(id, name);
}
case 2->{
	System.out.println("enter account number");
	int acc_no=sc.nextInt();
	System.out.println("Enter bank name");
   String name=sc.next();
   System.out.println("enter Customer Id");
   int cus_id=sc.nextInt();
   System.out.println("enter type");
   String type=sc.next();
   System.out.println("enter balance");
   double balance=sc.nextDouble();
   obj.createAccount(cus_id, name,type,balance,acc_no);
   
   
}
case 3->{
	System.out.println("Enter Account Number");
	int acc_no=sc.nextInt();
	System.out.println("Enter amount to deposite");
	double amount=sc.nextDouble();
	obj.deposit(acc_no,amount);

	
}
case 4->{
	System.out.println("Enter Account Number");
	int acc_no=sc.nextInt();
	System.out.println("Enter amount to deposite");
	double amount=sc.nextDouble();
	obj.withdraw(acc_no,amount);
}
case 5->{
	System.out.println("Enter Account Number");
	int acc_no=sc.nextInt();
	obj.viewBalance(acc_no);
	
}
case 6->{
	System.out.println("Enter Account Number");
	int acc_no=sc.nextInt();
	obj.viewProfile(acc_no);
	
}
case 7->{
	System.out.println("Thankyou for visiting us........");
}
default->{
	System.out.println("Invalid Service.........");
}
}
}while(service!=7);
}
	}


