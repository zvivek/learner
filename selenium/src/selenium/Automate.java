package selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automate {


    public static void main(String[] args) throws InterruptedException, IOException {
    	
        final String FILE_NAME = "C:\\Users\\vivekkumarsingh\\Desktop\\InpuParamenterst.xlsx";
        
        
        FileInputStream fileIn = new FileInputStream("C:\\Users\\vivekkumarsingh\\Desktop\\Mails\\InpuParamenterst.xls");
        POIFSFileSystem fs = new POIFSFileSystem(fileIn); 
        HSSFWorkbook filename = new HSSFWorkbook(fs);
        HSSFSheet sheet = filename.getSheetAt(0);

       /* 
        String column1 = "Key";
        String column2 = "Value";
        Integer columnNo1 = null;
        Integer columnNo2 = null;
        List<Cell> cells = new ArrayList<Cell>();
        Row firstRow =(Row)sheet.getRow(0);

        for(org.apache.poi.ss.usermodel.Cell cell:firstRow){
            if (cell.getStringCellValue().equals(column1)){
                columnNo1 = cell.getColumnIndex();
            }
        }

        for(org.apache.poi.ss.usermodel.Cell cell:firstRow){
            if (cell.getStringCellValue().equals(column2)){
                columnNo2 = cell.getColumnIndex();
            }
        }
        System.out.println(columnNo1);
        System.out.println(columnNo2);
*/
        
        
        try {
        	Integer NumberOfApplications=0;
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            HashMap<String,String> hashMap= new HashMap<String,String>();
            String cellvalue = null ;
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                HSSFRow myRow = null;
                while (cellIterator.hasNext()) {/*
                	Cell currentCell = cellIterator.next();
					Iterator cellIter = (  currentCell).cellIterator();
	                while(cellIter.hasNext()){
	                    HSSFCell myCell = (HSSFCell) cellIter.next();
	                    cellvalue =  myCell.getStringCellValue();
	                }
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    	hashMap.put(currentCell.getStringCellValue() ,cellvalue);
                    			System.out.println("Hi");    
                    			
                    			
                    			
                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() );
                        if(currentCell.getStringCellValue().equals("NumberOfApplications")) 
                			NumberOfApplications=(int) currentCell.getNumericCellValue()	;
                    }

                */}
                //System.out.println(NumberOfApplications);

            }
            System.out.println(hashMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
     
              /* HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
                Iterator rowIter = sheet.rowIterator(); 
     
                while(rowIter.hasNext()){
                    HSSFRow myRow = (HSSFRow) rowIter.next();
                    Iterator cellIter = myRow.cellIterator();
                    Vector<Integer> cellStoreVector=new Vector<Integer>();
                    while(cellIter.hasNext()){
                        HSSFCell myCell = (HSSFCell) cellIter.next();
                        Integer cellvalue = Integer.parseInt(myCell.getStringCellValue());
                        cellStoreVector.addElement(cellvalue);
                    }
                    String firstcolumnValue = null;
                    Integer secondcolumnValue = null;
     
                    int i = 0;
                    firstcolumnValue = cellStoreVector.get(i).toString(); 
                    secondcolumnValue = cellStoreVector.get(i+1);
     
                    hashMap.put(firstcolumnValue,secondcolumnValue);
                    System.out.println(hashMap);*/
              
                
               
        
        
        
        
    	//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
     	System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://172.27.52.20/om_apm_qs/");

        
        driver.findElement(By.name("wtUserNameInput")).sendKeys("admin");
         driver.findElement(By.name("wtPasswordInput")).sendKeys("admin");
        driver.findElement(By.xpath("//a[contains(.,'Log on')]")).click();
       
        
        WebDriverWait wait4 = new WebDriverWait(driver, 20);
	       wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Tests SSO Parameters simulation')]")));
        
        
        
        driver.findElement(By.xpath("//a[contains(.,'Tests SSO Parameters simulation')]")).click();
        
        WebDriverWait wait5 = new WebDriverWait(driver, 20);
	       wait5.until(ExpectedConditions.presenceOfElementLocated(By.name("om_apm_wt39:wtMainContent:wtStsso_BusinessCIN")));
        
        driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_BusinessCIN")).clear();
        driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_BusinessCIN")).sendKeys("00440659456");
        driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_GuarantorCIN")).clear();
        driver.findElement(By.name("om_apm_wt39:wtMainContent:wtStsso_GuarantorCIN")).sendKeys("00440676062");
        
        
      driver.findElement(By.id("om_apm_wt39:wtMainContent:wt48")).click();
      Thread.sleep(500);
      
      //WebDriverWait wait11 = new WebDriverWait(driver, 300);
      new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.name("om_apm_wt390:wtMainContent:wtAmlBsaPatriotDisClosure")));
      driver.findElement(By.name("om_apm_wt390:wtMainContent:wtAmlBsaPatriotDisClosure")).click();
     // WebDriverWait wait9 = new WebDriverWait(driver, 300);
      new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.name("om_apm_wt390:wtMainContent:wtApplicationProductType")));

      //Select drpCountry = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplicationProductType")));
      new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplicationProductType"))).selectByVisibleText("Standard");
		Thread.sleep(500);
		//Select rewards = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplication_RewardId")));
		new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtApplication_RewardId"))).selectByVisibleText("No Rewards");
		Thread.sleep(500);
        
		driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_Email")).sendKeys("test@mail.com");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_BusinessDescription")).sendKeys("test@mail.com");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtBusinessContactPhone_PhoneNumber")).sendKeys("1234567890");
        //Select bphtype = new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtBusinessContactPhone_PhoneType")));
        new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtBusinessContactPhone_PhoneType"))).selectByVisibleText("Business");

        WebElement elementToClick =driver.findElement(By.xpath("//*[contains(text(), 'Copy physical address')]"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
        elementToClick.click();


        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_AnnualSales")).sendKeys("234,444.44");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSmallBusiness_EstimatedMonthlySpending")).sendKeys("23.44");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_Phone")).sendKeys("1234567890");
        new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_PhoneType"))).selectByVisibleText("Business");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_Email")).sendKeys("test@mail.com");
        
        new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_EmailAddressType"))).selectByVisibleText("Business");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_title")).sendKeys("Mr");
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtguarantorAnnualIncomeDisclouse")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_TotalAnnualIncome")).sendKeys("9000000");
        
        WebElement elementToClick6 =driver.findElement(By.id("om_apm_wt390:wtMainContent:wtCoApplicantsTable:0:wtGuarantor_DigitalCom"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick6.getLocation().y+")");
        elementToClick6.click();
       String parentWindowHandler= driver.getWindowHandle();
        Thread.sleep(1000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Disclosure_Popup.jsf?DisclosureType')]")));
	     new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.id("om_apm_wt4:wtMainContent:wtClose")));
	       driver.findElement(By.id("om_apm_wt4:wtMainContent:wt1")).click();
	       driver.switchTo().window(parentWindowHandler);
        new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSTBankerSubmiiterInfo_Organization"))).selectByVisibleText("Branch Banker");
        new Select(driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSTBankerSubmiiterInfo_BankingGroup"))).selectByVisibleText("Cross sell");
        
        WebElement elementToClick2 =driver.findElement(By.xpath("//*[@id='om_apm_wt390:wtMainContent:wtFairCreditReportActDisclosur']"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick2.getLocation().y+")");
        elementToClick2.click();
        
        WebElement elementToClick3 =driver.findElement(By.xpath("//*[@id='om_apm_wt390:wtMainContent:wtOverarchingDisclosure']"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick3.getLocation().y+")");
        elementToClick3.click();
        
       driver.findElement(By.name("om_apm_wt390:wtMainContent:wtSearch_Officer")).click();
       Thread.sleep(1000);

      
       driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Officer_Popup.jsf?branchCostCenterNumber')]")));
       new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'om_apm_wt47:wtMainContent:wt28\']")));
       new Select(driver.findElement(By.id("om_apm_wt47:wtMainContent:wtSTOfficer_SearchParamType"))).selectByVisibleText("Officer Id");
		
		driver.findElement(By.id("om_apm_wt47:wtMainContent:wt28")).sendKeys("00038090");
		driver.findElement(By.id("om_apm_wt47:wtMainContent:wt33")).click();
		new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("om_apm_wt47:wtMainContent:wtofficerRecords:0:wt12")));
	       driver.findElement(By.id("om_apm_wt47:wtMainContent:wtofficerRecords:0:wt12")).click();
	       Thread.sleep(3000);

	       driver.findElement(By.id("om_apm_wt47:wtMainContent:wt31")).click();
	       
	       Thread.sleep(3000);
	       driver.switchTo().window(parentWindowHandler);

	       new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated((By.id("om_apm_wt390:wtMainContent:wtofficer"))));
	       WebElement elementToClick4 =driver.findElement(By.id("om_apm_wt390:wtMainContent:wtofficer"));	       

	       ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick4.getLocation().y+")");
	        elementToClick4.click();
		       Thread.sleep(3000);

	        
	       driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Originatingbranch_Popup.jsf?(Not.Licensed.For.Production)')]")));
	       WebDriverWait wait6 = new WebDriverWait(driver, 3000);
	       wait6.until(ExpectedConditions.presenceOfElementLocated(By.id("om_apm_wt15:wtMainContent:wt9")));
	    		   driver.findElement(By.id("om_apm_wt15:wtMainContent:wt9")).sendKeys("0113");	     

	    		   driver.findElement(By.id("om_apm_wt15:wtMainContent:wt33")).click();
	       
	    		   new WebDriverWait(driver, 10000).until(ExpectedConditions.presenceOfElementLocated(By.id("om_apm_wt15:wtMainContent:wtOriginationBranchRecords:0:wt3")));
	    		   driver.findElement(By.id("om_apm_wt15:wtMainContent:wtOriginationBranchRecords:0:wt3")).click();
	    		   Thread.sleep(2000);
	    		   driver.findElement(By.id("om_apm_wt15:wtMainContent:wt12")).click();
	    		   Thread.sleep(3000);
	    	       driver.switchTo().window(parentWindowHandler);

	    		  
	    		   WebElement submit2 =  driver.findElement(By.id("om_apm_wt390:wtActions:wtsubmitBtn"));
	    		      submit2.click();
     
       //driver.close();
       
    }

}
