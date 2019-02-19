package com.revature.bankApp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
	private String name;
	private int age;
	private ArrayList<String> address;

	public Customer() {
		super();
	}
	
	public Customer(String name, int age, ArrayList<String> address, String username, String password) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.setUsername(username);
		this.setPassword(password);
	}

	@Override
	public void transfer(File F) {
		
	}
	public void prompt(ArrayList<String> acct) {
		Scanner myScanner = new Scanner(System.in);
		File acctBal = new File(acct.get(0));
		File acctInf = new File(acct.get(1));
		if(acctBal.exists() && acctInf.exists()) {
			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Make Deopist 		-> Enter 1: ");
			System.out.println("Make Withdrawal 	-> Enter 2: ");
			System.out.println("Transfer		-> Enter 3: ");
			System.out.println("Create a Joint Account 	-> Enter 4: ");
			System.out.println("View My Account Info 	-> Enter 5: ");
			System.out.println("Logout 			-> Enter 6:");
			int choice = myScanner.nextInt();
			
			switch(choice) {
			case 1:
				deposit(acctBal);
				break;
				
			case 2:
				withdraw(acctBal);
				break;
			
			case 3:
				break;
				
			case 4:
				break;
			
			case 5:
				viewAccount(acctInf);
				break;
				
			case 6:
				System.out.println("Logout Successful... Goodbye");
				myScanner.close();
				System.exit(0);
				break;
			}
		myScanner.close();
			
		}else {System.out.println("No Associated Acount. Please create a new account.");}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}
}
