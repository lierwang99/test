/**
 * 
 */
package project.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Administrator
 *
 */
public class Grid2 {
	WebDriver driver;
	String baseUrl,nodeUrl;
	@BeforeTest
	public void setUp() throws MalformedURLException{
		System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.driver", ".\\tools\\geckodriver.exe");
		baseUrl = "https://www.baidu.com" ;
		driver = new FirefoxDriver();
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	@Test
	public synchronized void simpleTest() {
		driver.get(baseUrl);
		/**
		 * java.lang.IllegalMonitorStateException是在调用object的wait和notify，notifyAll方法的时候可能会出现的异常,下方用到synchronized关键字
		 */
		try {
			synchronized(driver){
				driver.wait(3000);
			}

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(true,driver.getTitle().contains("知道"));
	}
}
