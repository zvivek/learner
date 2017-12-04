package selenium;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class test {

	
	//comment the above line and uncomment below line to use Chrome
	//import org.openqa.selenium.chrome.ChromeDriver;


	    public static void main(String[] args) throws InterruptedException {
	    	
	    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\geeko\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\geeko\\geckodriver.exe");
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
	    	//WebDriver driver2 = new ChromeDriver();
			
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\ww\\chromedriver.exe");
	        //WebDriver driver = new FirefoxDriver();
	        ChromeDriver driver = new ChromeDriver();
	        String currWindow = driver.getWindowHandle();
	        driver.get("https://www.google.com");

	        Actions act = new Actions(driver);
	        act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	        // Open new tab
	        Set<String> windowsList = driver.getWindowHandles();
	        for (String str : windowsList) {
	        	System.out.println(str);
	           if (!str.equals(currWindow)) {
	           driver.switchTo().window(str);
	           }
	        }
	        driver.get("https://mail.google.com");
	       
	    }

	}
