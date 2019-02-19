package com.revature.bankApp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Login {
	
	public boolean login(String username, String password, Object obj) {
		ArrayList<String> userInfo = new ArrayList<String>();
		boolean credential = true;
		File employeeInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//EmployeeInfo.txt");
		File adminInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//AdminInfo.txt");
		File custInfo = new File("C://Users//thoma//Documents//Week1//BankingAppPt1//LoginInfo.txt");
		Admin a = new Admin();
		Employee em = new Employee();
		Customer c = new Customer();
		
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
					}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
							credential = false;
							myScanner.close();}
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
					}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
							credential = false;
							myScanner.close();}
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(custInfo.exists()) {
			if(obj.getClass()==c.getClass()) {
				try {
					Scanner myScanner = new Scanner(custInfo);
					while(myScanner.hasNextLine()) {
						userInfo.add(myScanner.nextLine());
					}
					if(userInfo.get(0).equals(username) && userInfo.get(1).equals(password)) {
						System.out.println("Successful Login... Welcome Back!");
						myScanner.close();
					}else {System.out.println("Unsucessful Login... incorrect Unsername or Password.");
							credential = false;
							myScanner.close();}
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return credential;
	}
}
