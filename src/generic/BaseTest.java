package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;



@Listeners(CustomListener.class)
public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String node,String browser) throws MalformedURLException{
		URL whichSystem = new URL(node);
		DesiredCapabilities whichBrowser=new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver=new RemoteWebDriver(whichSystem, whichBrowser);		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(){
		driver.close();
	}
}
