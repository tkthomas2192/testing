package com.revature.bankApp1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User implements Account{
	private String username;
	private String password;
	private String newID;
	public String approval = "";
	boolean check;
	
	public void newAccount(String username, String password, Customer c) {
		this.username = username;
		this.password = password;
		String ID;
		String accountID;
		int convert;
		
		File newAcctBalance =  new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountBalance.txt");
		File idInfo =  new File("C://Users//thoma//Documents//Week1//BankingAppPt1//UserIDs.txt");
		File newLoginInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//LoginInfo.txt");
		File newCustomerInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AcountInfo.txt");
		File accountRequest = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AccountRequest.txt");
		
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
				accountID = newID;
				idFile.newLine();
				idFile.write(newID);
				idFile.flush();
				idFile.close();
				idScanner.close();
			}else {
				 	String zero = "0";
					idFile.write(zero);
					idFile.flush();
					idFile.close();
					idScanner.close();
					}
			
			}catch(IOException e) {
		}
		
		try {
			if(accountRequest.exists()) {
				Scanner acctScanner = new Scanner(accountRequest);
				while(acctScanner.hasNextLine()) {
					String str = acctScanner.nextLine();
					switch(str){
					case "true":
							approval = "true";
							break;
					case "false":
							approval = "false";
							break;
					case "pending":
							approval = "pending";
							break;
						}
					}
				acctScanner.close();
				}
;			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(approval) {
			case "true":
			System.out.println("... Your acount request has been approved");
			try {
				if(newAcctBalance.createNewFile()) {
					System.out.println("Account Created.");
					if(newLoginInfo.exists()) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
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
			break;
		case "false": 
			System.out.println("Sorry... Your account request has been denied.");
			break;
		case "pending":
			System.out.println("Your account request is pending... Please check back later");
		}
	}

	
	public void viewAccount() {
		try {
			File viewAcct = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AcountInfo.txt");
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
}
