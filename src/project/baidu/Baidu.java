/**
 * 
 */
package project.baidu;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import project.AncestorImpl;

/**
 * @author Administrator
 *
 */
public class Baidu extends AncestorImpl{
	private WebDriver driver = null;
	private String inputXpath = "//input[@id='kw']" ; 
	

	public Baidu() {

	}

	public Baidu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void query(String content) {
		this.sendKeysByXpath(inputXpath, content);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
