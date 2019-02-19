package com.revature.bankApp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee extends User implements AccountManager{
	private final String username = "Employee";
	private final String password = "EmPass";
	private String checkUsername;
	private String checkPassword;
	Customer customer = new Customer();
	public Employee(){
		
	}
	@Override
	public void approveAccount(Customer c) {
		File accountRequest = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountRequest.txt");
		try {
			FileWriter approve = new FileWriter(accountRequest);
			approve.write("true");
			approve.flush();
			approve.close();
			System.out.println("Aprroved Request Successful...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public void denyAccount(Customer c) {
		File accountRequest = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountRequest.txt");
		try {
			FileWriter deny = new FileWriter(accountRequest);
			deny.write("false");
			deny.flush();
			deny.close();
			System.out.println("Denied Request Successful...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getContactInfo(Customer c) {
		String s = null;
		return s;
	}
	
	public String getAccountInfo(Customer c){
		String s = null;
		return s;
	}
	
	public void getAccountBalance(Customer c) {
		try {
			File viewAcct = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountBalance.txt");
			if(viewAcct.exists()) {
				Scanner acctScanner = new Scanner(viewAcct);
				while(acctScanner.hasNextLine()) {
					System.out.println(acctScanner.nextLine());
				}
				acctScanner.close();
				}
;						} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prompt() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		checkUsername = myScanner.nextLine();
		System.out.println("Enter password: ");
		checkPassword = myScanner.nextLine();
		if(username.equals(checkUsername) && password.equals(checkPassword)) {
			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Customer Account Information 	-> Enter 1: ");
			System.out.println("Customer Account Balanace 	-> Enter 2: ");
			System.out.println("Approve Account Request 	-> Enter 3: ");
			System.out.println("Deny Account Request 	 	-> Enter 4: ");
			
			// should have a check account status (approved, denied, pending)
			int choice = myScanner.nextInt();
			
			switch(choice) {
			case 1:
				viewAccount();
				myScanner.close();
				break;
				
			case 2:;
				getAccountBalance(customer);
				myScanner.close();
				break;
			
			case 3:
				approveAccount(customer);
				myScanner.close();
				break;
				
			case 4:
				denyAccount(customer);
				myScanner.close();
				break;
				
			default: myScanner.close();
			}
		}else {System.out.println("Unsuccessful Login... Username or Password is Incorrect.");}
	}

}
