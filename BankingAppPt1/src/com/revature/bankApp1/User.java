package com.revature.bankApp1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class User implements Account{
	private String username;
	private String password;
	private String newID;
	// create file path names for dynamic new account creations
	private static String balanceAcct = "//AccountBalance";
	private static String loginAcct = "//LoginInfo";
	private static String customerAcct = "//AccountInfo";
	private static String pending = "C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//PendingAccounts";
	private String newAcct= "//Account";
	private static String customerAccts = "C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//CustomerAccounts";
	public String approval = "";
	boolean check;
	// ID for unique accounts
	private String accountID;
	
	public User() {
		
	}
	
	public void newAccount(Customer c) {
		String ID;					// for holding file line info
		int convert;				// convert file line to integer

		File idInfo =  new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//UserIDs.txt");
		
		try {
			BufferedWriter idFile = new BufferedWriter(new FileWriter(idInfo, true));
			Scanner idScanner = new Scanner(idInfo);
			if(idInfo.length() != 0) {
				while(idScanner.hasNextLine()) {
					ID = idScanner.nextLine();
					convert = Integer.parseInt(ID) + 1;
					newID = Integer.toString(convert);
				}
				System.out.println(newID);
				this.accountID = newID;
				idFile.newLine();
				idFile.write(newID);
				idFile.flush();
				idFile.close();
				idScanner.close();
			}else {
				 	String zero = "0";
				 	this.accountID = zero;
					idFile.write(zero);
					idFile.flush();
					idFile.close();
					idScanner.close();
					}
			
			}catch(IOException e) {
		}
		
//		try {
//			if(accountRequest.exists()) {
//				Scanner acctScanner = new Scanner(accountRequest);
//				while(acctScanner.hasNextLine()) {
//					String str = acctScanner.nextLine();
//					switch(str){
//					case "true":
//							approval = "true";
//							break;
//					case "false":
//							approval = "false";
//							break;
//					case "pending":
//							approval = "pending";
//							break;
//						}
//					}
//				acctScanner.close();
//				}
//;			} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		switch(approval) {
//			case "true":
			System.out.println("... Your acount request has been approved");
			File newFold = new File(getPending()+newAcct+accountID);
			newFold.mkdir();
			try {
				// create new account balance account 
				File newAcctBalance =  new File(newFold.getPath()+balanceAcct+accountID+".txt");
				if(newAcctBalance.createNewFile()) {
					System.out.println("Account Created.");
					if(newAcctBalance.exists()) {
						BufferedWriter addInfo = new BufferedWriter(new FileWriter(newAcctBalance));
						double balance = 0.00;
						addInfo.write(Double.toString(balance));
						addInfo.flush();
						addInfo.close();
					}
				}else {System.out.println("Account Already Exists");}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				// create new login info database
				File newLoginInfo =  new File(newFold.getPath()+loginAcct+accountID+".txt");
				if(newLoginInfo.createNewFile()) {
					if(newLoginInfo.exists()) {
						BufferedWriter addInfo = new BufferedWriter(new FileWriter(newLoginInfo));
						addInfo.write(username);
						addInfo.newLine();
						addInfo.write(password);
						addInfo.flush();
						addInfo.close();
						System.out.println("Credentials Saved");
					}
				}else {System.out.println("Account Already Exists");}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				// create new customer info database
				File newCustomerInfo =  new File(newFold.getPath()+customerAcct+accountID+".txt");
				if(newCustomerInfo.createNewFile()) {
					System.out.println("Personal Information Saved.");
					if(newCustomerInfo.exists()) {
						BufferedWriter addInfo = new BufferedWriter(new FileWriter(newCustomerInfo));
						String name = "Name: " + c.getName();
						int age = c.getAge();
						String ager = "Age: " + Integer.toString(age);
						String address = "Address: " + c.getAddress().get(0) + "," + c.getAddress().get(1) + "," +
						c.getAddress().get(2);
						addInfo.write(name);
						addInfo.newLine();
						addInfo.write(ager);
						addInfo.newLine();
						addInfo.write(address);
						addInfo.flush();
						addInfo.close();
					}
				}else {System.out.println("Account Already Exists");}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
			
//			break;
//		case "false": 
//			System.out.println("Sorry... Your account request has been denied.");
//			break;
//		case "pending":
//			System.out.println("Your account request is pending... Please check back later");
//		}
//	}

	
	public void viewAccount(File f) {
		try {
			//File viewAcct = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AcountInfo.txt");
			if(f.exists()) {
				Scanner acctScanner = new Scanner(f);
				while(acctScanner.hasNextLine()) {
					System.out.println(acctScanner.nextLine());
				}
				acctScanner.close();
				}
;						} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
//	private String getUsername() {
//		return username;
//	}
	protected final void setUsername(String username) {
		this.username = username;
	}
//	private String getPassword() {
//		return password;
//	}
	protected final void setPassword(String password) {
		this.password = password;
	}
//	public String getAccountID() {
//		return accountID;
//	}

	@Override
	public void withdraw(File acct) {
		String end = "yes";
		Scanner myScanner = new Scanner(System.in);
		while(end=="yes") {
			try {
				System.out.println("How much would you like to withdraw?");
				double take = myScanner.nextDouble();
				Scanner fileScanner = new Scanner(acct);
				String balance = fileScanner.nextLine();
				double remainder = Double.parseDouble(balance)-take;
				FileWriter changeBalance = new FileWriter(acct, false);
				changeBalance.write(Double.toString(remainder));
				System.out.println("You withdrew: $" + take + "\nYour Remaining Balance is: " + remainder );
				fileScanner.close();
				changeBalance.close();
				System.out.println("Would you like to make another withdrawal?\n Type \"yes\" if so, \"no\" otherwise.");
				myScanner.nextLine();
				end = myScanner.nextLine();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		myScanner.close();
	System.exit(0);
	}

	@Override
	public void deposit(File acct) {
		try {
		System.out.println("How much would you like to deposit? ");
		Scanner myScanner = new Scanner(System.in);
		double depo = myScanner.nextDouble();
		double balance;
		String s;
		Scanner acctScanner = new Scanner(acct);
			if(acct.exists()) {
			//System.out.println(acctScanner.nextLine());
				if(acctScanner.hasNextDouble()) {
					//System.out.println(acctScanner.nextLine());
					balance = depo + acctScanner.nextDouble();
					FileWriter deposit = new FileWriter(acct, false);
					s = Double.toString(balance);
					deposit.write(s);
					deposit.flush();
					deposit.close();
					myScanner.close();
					System.out.println("Transaction Complete. Added $ "+depo + " to account. New balance is: " + balance);
					acctScanner.close();
				}else {
				FileWriter deposit = new FileWriter(acct, false);
				s = Double.toString(depo);
				deposit.write(s);
				deposit.close();
				myScanner.close();
				System.out.println("Transaction Complete. Added $ "+depo + " to account");
				myScanner.close();
				acctScanner.close();
				}
			}else {System.out.println("No Account");}
		}catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	File acctBalance =  new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountBalance.txt");
	File viewAcct = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//JointAccount.txt");
	@Override
	public void transfer(File viewAcct) {
		try {
			Scanner transScan = new Scanner(viewAcct);
			Scanner balance = new Scanner(acctBalance);
			while(transScan.hasNextLine()) {
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	final String getbalanceAcct() {
		return balanceAcct;
	}
	final String getcustomerAcct() {
		return customerAcct;
	}
	final String getloginAcct() {
		return loginAcct;
	}

	public static String getPending() {
		return pending;
	}

	public String getCustomerAccts() {
		return customerAccts;
	}

}
