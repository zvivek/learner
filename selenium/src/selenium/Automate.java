package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Automate {


    public static void main(String[] args) throws InterruptedException {
    	
    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\geeko\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\geeko\\geckodriver.exe");
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
    	//WebDriver driver2 = new ChromeDriver();
		
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\vivekkumarsingh\\Desktop\\sel\\ww\\chromedriver.exe");
        //WebDriver driver = new FirefoxDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://172.27.52.20/om_apm_qs/");

        
        WebElement username = driver.findElement(By.name("wtUserNameInput"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("wtPasswordInput"));
        password.sendKeys("admin");
        driver.findElement(By.xpath("//a[contains(.,'Log on')]")).click();
       
        // driver.findElement(By.xpath("//a[@class='dashboard-menu-entry ThemeGrid_Width4' or contains(text(), 'SSO')]")).click();
       // driver.findElement(By.className("title")).click();
       // driver.findElement(By.xpath("//*[contains(text(), '/om_apm_suntrust_ui/SSOScreen.jsf?Name=NEW')]")).click();
       // driver.findElement(By.cssSelector("#om_apm_wt7/3a wtMainContent/3a wtPluginsLR/3a 7/3a wt2/a wt2")).click();
      //  Thread.sleep(10);
       // WebElement SSO = driver.findElement(By.id("om_apm_wt7:wtMainContent:wtPluginsLR:7:wt2:wt2"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(.,'Tests SSO Parameters simulation')]")).click();
        WebElement bcin = driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_BusinessCIN"));
        bcin.clear();
        bcin.sendKeys("00440659456");
        WebElement gcin = driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_GuarantorCIN"));
        gcin.clear();
        gcin.sendKeys("00440676062");
        
        
      WebElement submit =  driver.findElement(By.id("om_apm_wt39:wtMainContent:wt48"));
      submit.click();
      Thread.sleep(3000);

      Select drpCountry = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplicationProductType")));
		drpCountry.selectByVisibleText("Standard");
		Thread.sleep(1000);
		Select rewards = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplication_RewardId")));
		rewards.selectByVisibleText("No Rewards");
		Thread.sleep(1000);
        
		WebElement bmail = driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_Email"));
        bmail.sendKeys("test@mail.com");
        WebElement bdesc = driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_BusinessDescription"));
        bdesc.sendKeys("test@mail.com");
        WebElement bphone = driver.findElement(By.name("om_apm_wt390:wtMainContent:wtBusinessContactPhone_PhoneNumber"));
        bphone.sendKeys("1234567890");
        Select bphtype = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtBusinessContactPhone_PhoneType")));
        bphtype.selectByVisibleText("Business");
//        driver.findElement(By.xpath("//*[@id="om_apm_wt390:wtMainContent:wt1239"]/span")).click();
        /*WebElement copy = driver.findElement(By.id("om_apm_wt390:wtMainContent:wt1239"));copy.click();
        driver.findElement(By.xpath("//span[contains(.,'Copy physical address')]")).click();*/
        //WebElement elementToClick = driver.findElement(By.xpath("//*[@id="om_apm_wt390:wtMainContent:wt1239"]/span"));

        WebElement elementToClick =driver.findElement(By.xpath("//*[contains(text(), 'Copy physical address')]"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
        elementToClick.click();
        //driver.findElement(By.xpath("//span[contains(.,'Copy physical address')]")).click();
       // Thread.sleep(3000);
       //WebElement bphone2 = driver.findElement(By.linkText("Copy physical address"));bphone2.click();
        //driver.findElement(By.linkText("Copy physical address").click();
        /*IJavaScriptExecutor ex = (IJavaScriptExecutor)Driver;
        ex.ExecuteScript("arguments[0].click();", elementToClick);*/
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_AnnualSales")).sendKeys("234,444.44");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_EstimatedMonthlySpending")).sendKeys("23.44");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_Phone")).sendKeys("1234567890");
        Select gphtype = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_PhoneType")));
        gphtype.selectByVisibleText("Business");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_Email")).sendKeys("test@mail.com");
        
        Select gmail = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_EmailAddressType")));
        gmail.selectByVisibleText("Business");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_title")).sendKeys("Mr");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtguarantorAnnualIncomeDisclouse")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_TotalAnnualIncome")).sendKeys("9000000");
        
        String parentWindowHandler = driver.getWindowHandle();
        Select org = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSTBankerSubmiiterInfo_Organization")));
        org.selectByVisibleText("Branch Banker");
        Select grp = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSTBankerSubmiiterInfo_BankingGroup")));
        grp.selectByVisibleText("Cross sell");
        
        WebElement elementToClick2 =driver.findElement(By.xpath("//*[@id='om_apm_wt390:wtMainContent:wtFairCreditReportActDisclosur']"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().y+")");
        elementToClick2.click();
        
        WebElement elementToClick3 =driver.findElement(By.xpath("//*[@id='om_apm_wt390:wtMainContent:wtOverarchingDisclosure']"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick3.getLocation().y+")");
        elementToClick3.click();
        
       driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSearch_Officer")).click();
       
       for(String window : driver.getWindowHandles()) {
    	   System.out.println(window);
       driver.switchTo().window(window);
       driver.manage().window().maximize();
   }
       Select code = new Select(driver.findElement(By.id("om_apm_wt47:wtMainContent:wtSTOfficer_SearchParamType")));
		code.selectByVisibleText("Officer Id");
		
		
		driver.findElement(By.id("om_apm_wt47:wtMainContent:wt28")).sendKeys("00038090");
       // Thread.sleep(500);
       // driver.findElement(By.name("om_apm_wt390:wtMainContent:wtOverarchingDisclosure")).click();
        Thread.sleep(500);
        
     //   driver.findElement(By.id("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtInfoDigitalCommunication")).click();
     //   driver.findElement(By.name("om_apm_wt390:wtMainContent:wtofficer")).click();
        
        
        // Store your parent window
       
        System.out.println("parent "+parentWindowHandler);
        /*for(String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            driver.manage().window().maximize();
        }*/
       /* WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='om_apm_wt4:wtMainContent:wt1']")));*/
        //
     //   waitForNumberofWindowsToEqual(2);
        Thread.sleep(3000);
       /* String subWindowHandler = null;

       Set<String> handles = driver.getWindowHandles(); // get all window handles
       String lastWindow = (String) handles.toArray()[handles.size() - 1];
       driver.switchTo().window(lastWindow);
        System.out.println("size= "+handles.size());
        Iterator<String> iterator = handles.iterator();
       // driver.switchTo().frame(1);
        
        System.out.println("*********");
       */
        /*while (iterator.hasNext()){
            subWindowHandler = iterator.next();
                    }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        System.out.println(subWindowHandler);*/
        Thread.sleep(1000);
        //driver.findElement(By.name("om_apm_wt390:wtMainContent:wtFairCreditReportActDisclosur")).click();
       // driver.findElement(By.name("om_apm_wt390:wtMainContent:wtOverarchingDisclosure")).click();
       /* WebElement elementToClick2 =driver.findElement(By.xpath("//*[contains(text(), 'Decline')]"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().x+")");

        elementToClick2.click();*/
     //   WebDriverWait wait = new WebDriverWait(driver, 1);
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("om_apm_wt4:wtMainContent:wtClose")));
        
        /*WebDriverWait wait = new WebDriverWait(driver, 300);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='om_apm_wt4:wtMainContent:wt1']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("om_apm_wt4:wtMainContent:wt1")));*/
      //*[@id="om_apm_wt4:wtMainContent:wt1"]
       // driver.findElement(By.xpath("//*[@id='om_apm_wt4:wtMainContent:wt1']")).click();
     /*   WebElement elementToClick2 =driver.findElement(By.xpath("//*[contains(text(), 'Decline')]"));
        //((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().y+")");
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().x+")");

        elementToClick2.click();*/
      //  driver.findElement(By.id("om_apm_wt4:wtMainContent:wt1")).click();

        // Now you are in the popup window, perform necessary actions here
        
        //driver.switchTo().window(parentWindowHandler); 
       // driver.switchTo().window(parentWindowHandler); 
        /*WebElement elementToClick2 =driver.findElement(By.xpath("//*[contains(text(), 'Decline')]"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().y+")");
        elementToClick2.click();*/
        //driver.findElement(By.xpath("//a[contains(.,'Decline')]")).click();
      //driver.findElement(By.id("om_apm_wt4:wtMainContent:wt1")).click();
        //Decline
       // om_apm_wt390:wtMainContent:wtSmallBusiness_AnnualSales
       //driver.close();
       
    }

}
