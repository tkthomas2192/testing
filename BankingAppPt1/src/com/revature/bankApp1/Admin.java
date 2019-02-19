package com.revature.bankApp1;

import java.io.File;
import java.util.Scanner;

public class Admin extends User implements AccountManager{
	Customer customer = new Customer();
	private final String username = "Admin";
	private final String password = "AdPass";
	private String checkUsername;
	private String checkPassword;
	public Admin() {
		
	}
	public int withdraw(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deposit(double depo ,Customer c) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(double depo, Customer c) {
		// TODO Auto-generated method stub
		
	}
	
	public void cancelAccount() {
		File cancelAcct = new File("C:/Users/thoma/Documents/Week1/BankingAppPt1/AccountBalance.txt");
		File cancelLoginInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//LoginInfo.txt");
		File cancelAcctInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AcountInfo.txt");
		
		if(cancelAcct.exists()) {
			cancelAcct.delete();
			System.out.println("Cancelation Suscesscul. Account has been canceled.");
		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
		if(cancelLoginInfo.exists()) {
			cancelLoginInfo.delete();
			System.out.println("Cancelation Suscesscul. Account has been canceled.");
		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
		if(cancelAcctInfo.exists()) {
			cancelAcctInfo.delete();
			System.out.println("Cancelation Suscesscul. Account has been canceled.");
		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
	}

	@Override
	public void approveAccount(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void denyAccount(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(File F) {
		// TODO Auto-generated method stub
		
	}

	public void prompt() {
		Scanner myScanner = new Scanner(System.in);
		if(check==true) {
			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Force Customer Withdrawal 	-> Enter 1: ");
			System.out.println("Force Customer Deposit		-> Enter 2: ");
			System.out.println("Transfer Customer Account	-> Enter 3: ");
			System.out.println("Approve Account Request 	-> Enter 4: ");
			System.out.println("Deny Account Request 	 	-> Enter 5: ");
			System.out.println("Cancel Account		 	-> Enter 6: ");
			int choice = myScanner.nextInt();
			
			switch(choice) {
				// force customer withdrawal
				case 1:
					customer.withdraw();
					myScanner.close();
					break;
				// force customer deposit
				case 2:
					customer.deposit();
					myScanner.close();
					break;
				// transfer customer account
				case 3:
					myScanner.close();
					break;
				// approve customer request
				case 4:
					myScanner.close();
					break;
				// deny customer request
				case 5:
					myScanner.close();
					break;
					
				// cancel customer account
				case 6:
					cancelAccount();
					myScanner.close();
					break;
	 		}
		}else {System.out.println("Unsuccessful Login... Username or Password is Incorrect.");}

	}
}
