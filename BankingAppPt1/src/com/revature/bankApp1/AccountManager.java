package com.revature.bankApp1;

import java.io.File;

public interface AccountManager {
	final File allFiles = new File("C://Users//thoma//Desktop//bankApp//testing//BankingAppPt1//CustomerAccounts");
	void approveAccount(File apr);
	void denyAccount(File deny);
}
