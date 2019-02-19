package com.revature.bankApp1;
import com.revature.bankApp1.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


	final class Login {
		private String acctName = "C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//CustomerAccounts//LoginInfo";
		private String acctBalance; 									// holds account balance database
		private String acctInfo; 										// holds account info database
		private boolean credential;										// validate user input
		private ArrayList<String> userInfo = new ArrayList<String>();	// for comparison
		private ArrayList<String> accounts = new ArrayList<String>();	// for sending valid information out
		
		// only users can login
		public Login(User u) {	
			this.acctBalance = u.getbalanceAcct();						// sets the account balance database
			this.acctInfo = u.getcustomerAcct();						// sets the account into database
		}
		
		// login
		public boolean login(String username, String password, Object obj) {
			
			File employeeInfo = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//EmployeeInfo.txt");
			File adminInfo = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//AdminInfo.txt");
			File allFiles = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//CustomerAccounts");
			Admin a = new Admin();			
			Employee em = new Employee();	
			Customer c = new Customer();
			
			// check if user is an admin
			if(adminInfo.exists()) {
				if(obj.getClass()==a.getClass()) {
					try {
						Scanner myScanner = new Scanner(adminInfo);
						while(myScanner.hasNextLine()) {
							userInfo.add(myScanner.nextLine());
						}
						if(userInfo.get(0).equals(username) && userInfo.get(1).equals(password)) {
							System.out.println("Successful Login... Welcome Back!");
							myScanner.close();
							credential = true;
						}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
								credential = false;
								myScanner.close();}
		
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			
			// check if user is an employee
			if(employeeInfo.exists()) {
				if(obj.getClass()==em.getClass()) {
					try {
						Scanner myScanner = new Scanner(employeeInfo);
						while(myScanner.hasNextLine()) {
							userInfo.add(myScanner.nextLine());
						}
						if(userInfo.get(0).equals(username) && userInfo.get(1).equals(password)) {
							System.out.println("Successful Login... Welcome Back!");
							myScanner.close();
							credential = true;
						}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
								credential = false;
								myScanner.close();}
		
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			
			// check if user is a customer
			if(obj.getClass()==c.getClass()) {
				int i = 0;
				while(i<allFiles.length()) {							// traverse the data base
					try {
						File custInfo = new File(acctName+(Integer.toString(i))+".txt");
						if(custInfo.exists()) {							// if database exists
							Scanner myScanner = new Scanner(custInfo);	
							while(myScanner.hasNextLine()) {
								userInfo.add(myScanner.nextLine());		// get user credentials
							}
							// validate user credentials
							if(userInfo.get(0).equals(username) && userInfo.get(1).equals(password)) {
								System.out.println("Successful Login... Welcome Back!");
								myScanner.close();
								credential = true;
								userInfo.clear();
								acctBalance+=(Integer.toString(i)+".txt");	// update to corresponding user
								acctInfo+=(Integer.toString(i)+".txt");		// update to corresponding user
								break;
							}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
									credential = false;
									myScanner.close();}
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					userInfo.clear();	// empty list for new loop iteration
					i++;
			}
		}
		return credential;
	}
		
		// access database once credentials are validated
		public final ArrayList<String> loginCredentials(boolean bool) {
			if(bool = true) {
				accounts.add(acctBalance);
				accounts.add(acctInfo);
				return accounts;
			}else {return accounts;}
		}
}
