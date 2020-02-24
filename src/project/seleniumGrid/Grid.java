/**
 * 
 */
package project.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
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
public class Grid {
	WebDriver driver;
	String baseUrl,nodeUrl;
	@BeforeTest
	public void setUp() throws MalformedURLException{
		//若是grid，则不能再此处设置全局变量
//		System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.driver", ".\\tools\\geckodriver.exe");
		baseUrl = "https://www.baidu.com" ;


		nodeUrl = "http://192.168.1.5:8888/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.firefox(); 
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		
		
//		nodeUrl = "http://192.168.1.5:8888/wd/hub";
//		DesiredCapabilities capability = DesiredCapabilities.chrome(); 
//		capability.setBrowserName("chrome");
//		capability.setPlatform(Platform.WINDOWS);
		
		
//		nodeUrl = "http://192.168.1.5:8888/wd/hub";
//		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
//		capability.setBrowserName("internet explorer");
//		capability.setPlatform(Platform.WINDOWS);
		
//		nodeUrl = "http://192.168.1.6:26268/wd/hub";
//		DesiredCapabilities capability = DesiredCapabilities.firefox(); 
//		capability.setBrowserName("firefox");
//		capability.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(new URL(nodeUrl),capability);
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
