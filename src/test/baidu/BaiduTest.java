package test.baidu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import project.AncestorImpl;
import project.baidu.Baidu;

public class BaiduTest {
	WebDriver driver = null ;
	Baidu baidu = null ;
  @BeforeTest
  public void beforeTest() {
	  driver = AncestorImpl.getDriver("https://www.baidu.com");
	  baidu = new Baidu(driver);
  }

  @AfterTest
  public void afterTest() {
	  baidu.quit();
  }


  @Test
  public void queryTest() {
	  baidu.query("jenkins");
  }
}
