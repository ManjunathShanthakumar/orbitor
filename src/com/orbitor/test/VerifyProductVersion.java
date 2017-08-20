package com.orbitor.test;

import org.testng.annotations.Test;

import com.orbitor.page.EnterTimeTrackPage;
import com.orbitor.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class VerifyProductVersion extends BaseTest{	

	@Test(priority=3,groups={"login","valid"})	

	public void testInvalidLogin(){		

		int rc=Excel.getRowCount(XLPATH, "VerifyProductVersion");		

		for(int i=1;i<=rc;i++){
			String un=Excel.getCellValue(XLPATH,"VerifyProductVersion", i, 0);

			String pw=Excel.getCellValue(XLPATH,"VerifyProductVersion", i, 1);

			String eVersion=Excel.getCellValue(XLPATH,"VerifyProductVersion", i, 2);

			//Enter valid user name
			LoginPage l=new LoginPage(driver);
			l.setUsername(un);
			//Enter valid password
			l.setPassword(pw);
			l.sleep(1);
			//click on login
			l.clickLogin();
			l.sleep(2);
			//click on help
			EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
			e.clickHelp();
			l.sleep(1);
			//click about your actitime
			e.clickAboutActiTIME();
			l.sleep(1);
			//verify that version is 'actiTIME 2017.3'
			e.verifyVersion(eVersion);
			l.sleep(1);
			//click on close button
			e.clickCloseButton();
			l.sleep(1);
			//click on logout
			e.clickLogout();
		}
	}
}
