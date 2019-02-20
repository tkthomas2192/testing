package com.revature.bankApp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Employee extends User implements AccountManager{
	private final File allFiles = AccountManager.allFiles;
	private File pending = new File(getPending());
	private File customerAccts = new File(getCustomerAccts());
	private static String customerAcct = "//AccountInfo";
	static Scanner myScanner = new Scanner(System.in);
	
	public Employee(){
		
	}
	@Override
	public void approveAccount(File f) {
		System.out.println("------Pening Accounts------");
		for(File file:f.listFiles()) {
			System.out.println(file.getName());
		}
		System.out.println("Enter the account name to approve...");
		File approveFolder = new File(customerAccts+"\\"+approval);
		try {
			if(approveFolder.createNewFile()) {
				File approvalFile = new File(pending.getPath()+"\\" + approval);
				System.out.println(approval);
				try {
					Files.move(approvalFile.toPath(), approveFolder.toPath(),StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Account Succuessfully Approved!");
				} catch (IOException e) {
					e.printStackTrace();}
				}
		} catch (IOException e1) {
			e1.printStackTrace();}
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

	
	public void getAccountInfo(File f) {
		System.out.println("------Accounts------");
		for(File file:f.listFiles()) {
			System.out.println(file.getName());
		}
		System.out.println("Enter the account view...");
		String denial = myScanner.nextLine();
		try {
			BufferedReader read =  new BufferedReader(new FileReader(customerAccts+"\\"+denial));
			try {
				System.out.println(read.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(customerAccts+"\\"+denial);
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
//				System.out.println("Select an account you would like to view peronal information of:");
//				for(i=0; i<fList.length;i++) {
//					if(fList[i].getName().contains("AccountInfo")) {
//						System.out.println("File: " + i + " --> " + fList[i].getName() + "\t\t-> Enter " + i);
//					}
//				}
//				str = myScanner.nextLine();
//				index = Integer.parseInt(str);
//				file = fList[index];
//				
				getAccountInfo(customerAccts);
				//viewAccount();
				myScanner.close();
				break;
				
//			case 2:;
//				getAccountBalance(f);
//				myScanner.close();
//				break;
//			
			case 3:
				
				approveAccount(pending);
				myScanner.close();
				break;
				
			case 4:
				denyAccount(pending);
				myScanner.close();
				break;
				
			default: myScanner.close();
			}
	}

}
