package com.revature.bankApp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User implements Account{
	private String name;
	private int age;
	private ArrayList<String> address;
	
	public Customer() {
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
	public void withdraw() {
		try {
			System.out.println("How much would you like to withdraw?");
			Scanner myScanner = new Scanner(System.in);
			double take = myScanner.nextDouble();
			File withdraw = new File("C:/Users/thoma/Documents/Week1/BankingAppPt1/AccountBalance.txt");
			Scanner fileScanner = new Scanner(withdraw);
			String balance = fileScanner.nextLine();
			double remainder = Double.parseDouble(balance)-take;
			FileWriter changeBalance = new FileWriter(withdraw, false);
			changeBalance.write(Double.toString(remainder));
			System.out.println("You withdrew: $" + take + "\nYour Remaining Balance is: " + remainder );// + remainder);
			fileScanner.close();
			myScanner.close();
			changeBalance.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deposit() {
		try {
			System.out.println("How much would you like to deposit? ");
			Scanner myScanner = new Scanner(System.in);
			double depo = myScanner.nextDouble();
			double balance;
			String s;
			File account = new File("C:/Users/thoma/Documents/Week1/BankingAppPt1/AccountBalance.txt");
			Scanner acctScanner = new Scanner(account);
			if(account.exists()) {
				//System.out.println(acctScanner.nextLine());
					if(acctScanner.hasNextDouble()) {
						//System.out.println(acctScanner.nextLine());
						balance = depo + acctScanner.nextDouble();
						FileWriter deposit = new FileWriter(account, false);
						s = Double.toString(balance);
						deposit.write(s);
						deposit.flush();
						deposit.close();
						myScanner.close();
						System.out.println("Transaction Complete. Added $ "+depo + " to account. New balance is: " + balance);
						acctScanner.close();
					}else {
					FileWriter deposit = new FileWriter(account, false);
					s = Double.toString(depo);
					deposit.write(s);
					deposit.close();
					myScanner.close();
					System.out.println("Transaction Complete. Added $ "+depo + " to account");
					myScanner.close();
					acctScanner.close();
				
					}
				
			}else {System.out.println("No Account");}
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
	}

	@Override
	public void transfer(File F) {
		
		
	}


	public void prompt() {
		Scanner myScanner = new Scanner(System.in);
		File custAcct = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountBalance.txt");
		if(custAcct.exists()) {
				if(check == true) {
	
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
						deposit();
						break;
						
					case 2:
						withdraw();
						break;
					
					case 3:
						break;
						
					case 4:
						break;
					
					case 5:
						viewAccount();
						break;
						
					case 6:
						System.out.println("Logout Successful... Goodbye");
						myScanner.close();
						System.exit(0);
						break;
					}
					myScanner.close();
			}
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
