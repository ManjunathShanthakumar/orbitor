package com.orbitor.test;

import generic.BaseTest;
import generic.Excel;

import org.testng.annotations.Test;

import com.orbitor.page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2,groups={"login","invalid"})
	public void testInvalidLogin(){
		int rc=Excel.getRowCount(XLPATH, "InvalidLogin");		

		for(int i=1;i<=rc;i++){
			
			String un=Excel.getCellValue(XLPATH,"InvalidLogin", i, 0);
			//Enter invalid username		
			String pw=Excel.getCellValue(XLPATH,"InvalidLogin", i, 1);
			//Enter invalid password
			LoginPage l=new LoginPage(driver);
			l.setUsername(un);			
			l.setPassword(pw);
			l.clickLogin();		
			l.sleep(2);		
			l.VerifyErrorMsgIsDisplayed();		
		}
	}
}
