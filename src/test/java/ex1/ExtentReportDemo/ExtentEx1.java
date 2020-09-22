package ex1.ExtentReportDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentEx1 {
	ExtentReports extent;
	WebDriver driver;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test results");
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sush");
	}
	
	
  @Test
  public void initialDemo() {
	  
	 ExtentTest test=extent.createTest("Initial Demo");
	  System.setProperty("webdriver.chrome.driver", "//Users//supreeth//Downloads//chromedriver");
		driver=new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getTitle();
		test.fail("Results donot match");
		extent.flush();
		
  }
	
	@AfterTest
	public void end() {
		
	}
}
