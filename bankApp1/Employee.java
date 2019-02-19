package com.revature.bankApp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee extends User implements AccountManager{
	final File accountRequest = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1////BankingAppPt1//AccountRequest.txt");
	private final File allFiles = AccountManager.allFiles;
	public Employee(){
		
	}
	@Override
	public void approveAccount(File f) {
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
	public void denyAccount(File f) {
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
			File viewAcct = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//BankingAppPt1//AccountBalance.txt");
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
		File[] fList = allFiles.listFiles();
		
		Scanner myScanner = new Scanner(System.in);

			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Customer Account Information 	-> Enter 1: ");
			System.out.println("Customer Account Balanace 	-> Enter 2: ");
			System.out.println("Approve Account Request 	-> Enter 3: ");
			System.out.println("Deny Account Request 	 	-> Enter 4: ");
			
			// should have a check account status (approved, denied, pending)
			int choice = myScanner.nextInt();
			myScanner.nextLine();
			int i;
			int index;
			File file;
			String str;
			
			switch(choice) {
			case 1:
				System.out.println("Select an account you would like to view peronal information of:");
				for(i=0; i<fList.length;i++) {
					if(fList[i].getName().contains("AccountInfo")) {
						System.out.println("File: " + i + " --> " + fList[i].getName() + "\t\t-> Enter " + i);
					}
				}
				str = myScanner.nextLine();
				index = Integer.parseInt(str);
				file = fList[index];
				
				viewAccount(file);
				//viewAccount();
				myScanner.close();
				break;
				
//			case 2:;
//				getAccountBalance(f);
//				myScanner.close();
//				break;
//			
//			case 3:
//				approveAccount(customer);
//				myScanner.close();
//				break;
//				
//			case 4:
//				denyAccount(customer);
//				myScanner.close();
//				break;
				
			default: myScanner.close();
			}
	}

}
