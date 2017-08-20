package com.orbitor.page;

import generic.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EnterTimeTrackPage extends BasePage{
	@FindBy (xpath="//div[contains(text(),'Help')]")  //div[contains(.,'Help')]") is not working?
	private WebElement help;
	
	@FindBy (linkText="About your actiTIME")
	private WebElement aboutActiTIME;
	
	@FindBy (xpath="//span[@class='productVersion']")
	private WebElement version;    
	
	@FindBy (id="aboutPopupCloseButtonId")
	private WebElement closeButton;
	
	@FindBy (id="logoutLink")
	private WebElement logout;
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelp(){
		sleep(2);
		help.click();
	}
	public void clickAboutActiTIME(){
		sleep(1);
		aboutActiTIME.click();
	}
	public void verifyVersion(String eVersion){
		String aVersion=version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	public void clickCloseButton(){
		sleep(1);
		closeButton.click();
	}
	public void clickLogout(){
		sleep(1);
		logout.click();
	}

}
