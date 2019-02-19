package com.revature.bankApp1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankAppMain {
	static String username;
	static String password;
	public static void main(String[] args) {
		Login log = new Login();
		boolean x = false;
		while(x==false) {
			System.out.println("Admin Login:\t\tEnter: \"admin\"");
			System.out.println("Employee Login:\t\tEnter: \"employee\"");
			System.out.println("Customer Login:\t\tEnter: \"customer\"");		
			System.out.println("Create New Account:\tEnter: \"new\"");
			System.out.println("Exit:\t\t\tEnter: \"exit\"\n");
			Scanner myScanner = new Scanner(System.in);
			String choice = myScanner.nextLine();
			switch(choice) {
				case "admin":
					Admin admin = new Admin();
					while(admin.check==false) {
						System.out.println("Enter username: ");
						username = myScanner.nextLine().trim();
						System.out.println("Enter password: ");
						password = myScanner.nextLine().trim();
						admin.check = log.login(username, password, admin);
						System.out.println();
					}
					admin.prompt();
					myScanner.close();
					x=true;
					break;
				case "employee":
					Employee employ = new Employee();
					while(employ.check==false) {
						System.out.println("Enter username: ");
						username = myScanner.nextLine().trim();
						System.out.println("Enter password: ");
						password = myScanner.nextLine().trim();
						employ.check = log.login(username, password, employ);
						System.out.println();
					}
					employ.prompt();
					myScanner.close();
					x=true;
					break;
				
				case "customer":
					Customer cLog = new Customer();
					while(cLog.check==false) {
						System.out.println("Enter username: ");
						username = myScanner.nextLine().trim();
						System.out.println("Enter password: ");
						password = myScanner.nextLine().trim();
						cLog.check = log.login(username, password, cLog);
						System.out.println();
					}
					cLog.prompt();
					x=true;
					break;
					
				case "new":
					System.out.println("Enter First and Last Name:\t");
					String name = myScanner.nextLine();
					System.out.println("Enter Age:\t");
					int age = myScanner.nextInt();
					myScanner.nextLine();
					System.out.println("Enter Address (Street, City, State):\t");
					StringTokenizer filterAddress = new StringTokenizer(myScanner.nextLine().trim(), ",");
					ArrayList<String> address = new ArrayList<String>();
					while(filterAddress.hasMoreTokens()){
						address.add(filterAddress.nextToken());
					}
					System.out.println("Create username: ");
					username = myScanner.nextLine();
					System.out.println("Create pasword: ");
					password = myScanner.nextLine();
					myScanner.close();
					Customer cNewAcct = new Customer(name, age, address, username, password);
					cNewAcct.newAccount(cNewAcct.getUsername(), cNewAcct.getPassword(), cNewAcct);
					x=true;
					break;
				
				case "exit":
					System.out.println("Goodbye...");
					System.exit(0);
					x=true;
					
				default:
					x=false;
					System.out.println("Invalid input.\nPlease enter one of the following options...\n");
			}
		}
	}

}
