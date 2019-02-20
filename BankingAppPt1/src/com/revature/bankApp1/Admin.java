package com.revature.bankApp1;

import java.io.File;
import java.util.Scanner;

public class Admin extends User implements AccountManager{
	Customer customer = new Customer();
	private String acctBalance; 									// holds account balance database
	private String acctInfo; 
	private String loginInfo; 
	private final File allFiles = AccountManager.allFiles;
	private File pending = new File(getPending());
	private File customerAccts = new File(getCustomerAccts());
	static Scanner myScanner = new Scanner(System.in);
	
	
	public Admin() {
	}
	public Admin(User u) {
		this.acctBalance = u.getbalanceAcct();
		this.acctInfo =u.getcustomerAcct();
		this.getloginAcct();
	}


	public void deposit(double depo ,Customer c) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(double depo, Customer c) {
		// TODO Auto-generated method stub
		
	}
	
	public void cancelAccount() {
		
		
//		File cancelAcctBal = new File();
//		File cancelLoginInfo = new File();
//		File cancelAcctInfo = new File();
//		
//		if(cancelAcctBal.exists()) {
//			cancelAcctBal.delete();
//			System.out.println("Cancelation Suscesscul. Account has been canceled.");
//		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
//		if(cancelLoginInfo.exists()) {
//			cancelLoginInfo.delete();
//			System.out.println("Cancelation Suscesscul. Account has been canceled.");
//		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
//		if(cancelAcctInfo.exists()) {
//			cancelAcctInfo.delete();
//			System.out.println("Cancelation Suscesscul. Account has been canceled.");
//		}else {System.out.println("Cancelation Unsuccessful. No such active account.");}
	}


	@Override
	public void transfer(File F) {
		// TODO Auto-generated method stub
		
	}

	public void prompt() {
		File[] fList = allFiles.listFiles();
		Scanner myScanner = new Scanner(System.in);
//		try {
//			Scanner fileScanner = new Scanner(allFiles);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Force Customer Withdrawal 	-> Enter 1: ");
			System.out.println("Force Customer Deposit		-> Enter 2: ");
			System.out.println("Transfer Customer Account	-> Enter 3: ");
			System.out.println("Approve Account Request 	-> Enter 4: ");
			System.out.println("Deny Account Request 	 	-> Enter 5: ");
			System.out.println("Cancel Account		 	-> Enter 6: ");
			int choice = myScanner.nextInt();
			myScanner.nextLine();
			int i;
			String str;
			int index;
			File withdr;
			
		switch(choice) {
			// force customer withdrawal
			case 1:
				System.out.println("Select an account to withdraw from:");
				i = 0;
				while(i<fList.length) {
					if(fList[i].getName().contains("Balance")){
					System.out.println("File: " + i + " --> " + fList[i].getName() + "\t\t-> Enter " + i);
				}
					i++;
				}
				str = myScanner.nextLine();
				index = Integer.parseInt(str);
				withdr = fList[index];
//					String[] str = myScanner.nextLine().split(",");
//					for(String s:str){
//						Integer.parseInt(s);
//					}
//					for(int n=0; n<str.length;n++) {
//						File withdr = fList[n];
//					}

				withdraw(withdr);
				myScanner.close();
				break;
			// force customer deposit
			case 2:
				System.out.println("Select an account to deposit to:");
				i = 0;
				while(i<fList.length) {
					if(fList[i].getName().contains("Balance")){
					System.out.println("File: " + i + " --> " + fList[i].getName() + "\t\t-> Enter " + i);
				}
					i++;
				}
				str = myScanner.nextLine();
				index = Integer.parseInt(str);
				withdr = fList[index];
				customer.deposit(withdr);
				myScanner.close();
				break;
			// transfer customer account
			case 3:
				myScanner.close();
				break;
			// approve customer request
			case 4:
				approveAccount(pending);
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
	}
	@Override
	public void approveAccount(File f) {
		System.out.println("------Pening Accounts------");
		for(File file:f.listFiles()) {
			System.out.println(file.getName());
		}
		System.out.println("Enter the account name to deny...");
		String denial = myScanner.nextLine();
		for(File file:f.listFiles()) {
			if(file.isDirectory()) {
				if(file.getName().equals(denial)) {
					long size = file.length();
					if(file.length()>0) {
						for(File subFiles:file.listFiles()) {
							subFiles.delete();
							System.out.println("Account Content Succesfuly Removed!");
						}
					}
					if(file.length()==size) {
						file.delete();}
				}
			}
		}
		
	}
	@Override
	public void denyAccount(File f) {
		System.out.println("------Pening Accounts------");
		for(File file:f.listFiles()) {
			System.out.println(file.getName());
		}
		System.out.println("Enter the account name to deny...");
		String denial = myScanner.nextLine();
		for(File file:f.listFiles()) {
			if(file.isDirectory()) {
				if(file.getName().equals(denial)) {
					long size = file.length();
					if(file.length()>0) {
						for(File subFiles:file.listFiles()) {
							subFiles.delete();
							System.out.println("Account Content Succesfuly Removed!");
						}
					}
					if(file.length()==size) {
						file.delete();}
				}
			}
		}
		
	}
}
