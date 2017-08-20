package com.orbitor.test;

import org.testng.annotations.Test;

import com.orbitor.page.EnterTimeTrackPage;
import com.orbitor.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class ValidLogin extends BaseTest{
	@Test(priority=1,groups={"login","valid"})

	public void testValidLogin(){
		int rc=Excel.getRowCount(XLPATH, "ValidLogin");		


		for(int i=1;i<=rc;i++){
			String un=Excel.getCellValue(XLPATH,"ValidLogin", i, 0);
			//Enter invalid username		
			String pw=Excel.getCellValue(XLPATH,"ValidLogin", i, 1);
			//Enter invalid password
			//Enter valid username
			LoginPage l=new LoginPage(driver);
			l.setUsername(un);
			//Enter valid password
			l.setPassword(pw);
			//click on login
			l.clickLogin();
			//Verify home page is displayed
			l.sleep(2);
			EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
			e.verifyTitle(driver, 10, "actiTIME - Enter Time-Track");
		}
	}
}

