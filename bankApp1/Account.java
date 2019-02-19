package com.revature.bankApp1;

import java.io.File;

// Account interface. All accounts can be transfered to, withdrawn from, or deposited into.
public interface Account {
	
	// perform on specified database as argument
	void withdraw(File with);
	void transfer(File trans);
	void deposit(File depo);
}
