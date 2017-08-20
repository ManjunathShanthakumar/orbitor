package generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Hi",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		try{
			Robot r=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img=r.createScreenCapture(screenRect);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			String v=s.format(new Date());
			File destFile=new File("./photos/"+testname+v+".png");
			ImageIO.write(img, "png",destFile);			
		}
		catch(Exception e){			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
