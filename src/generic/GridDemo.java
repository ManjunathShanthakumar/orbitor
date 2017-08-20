package generic;



import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridDemo {

	public static void main(String[] args) throws Exception {
	URL whichSystem = new URL("http://192.168.0.4:4444/wd/hub");
	DesiredCapabilities whichBrowser=new DesiredCapabilities();
	whichBrowser.setBrowserName("chrome");
	WebDriver driver=new RemoteWebDriver(whichSystem, whichBrowser);
	driver.get("http://google.com");
	System.out.println("executed");
	Thread.sleep(2000);
	
	driver.quit();

	}

}
