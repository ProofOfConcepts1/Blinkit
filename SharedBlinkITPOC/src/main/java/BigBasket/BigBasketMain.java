package BigBasket;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonUtility.UserUtility;

public class BigBasketMain {

	public static void main(String[] args) {
		
		RemoteWebDriver driver = null;
		int rowNum = 1;
		
		UserUtilityNewPOC userUtility1 = new UserUtilityNewPOC(UserUtility.InputDataFilePath,"Input data", "Locators", "NameGiven");
		BigBasketUtility bb = new BigBasketUtility();
		
		driver = userUtility1.launchBrowser(driver, false, false, false);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
//		                                    Load the URL and Set the location
		bb.BBLocationSetup(driver, "Mumbai", "");
		
//		                                  Load the category URL one by one
		
		try {
			driver.get("https://www.bigbasket.com/pc/beauty-hygiene/skin-care/face-care/?nc=ct-fa");
			String thatsAllFolks = "//*[contains(text(),'all folks')]";
			String xpathProducts = "//div//a//img[@sizes='150px']";
			
			
			
			for (int i = 1; i < 2810+1; i++) {
				
				try {
					String availability = "1";
					
					String URLXapth = "(((//section)[2]//section//ul//li)["+i+"]//a)[1]";
					String BrandTitleXapth = "(((//section)[2]//section//ul//li)["+i+"]//a)[2]";
					String SPXpath = "((//section)[2]//section//ul//li)["+i+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span";
					String MRPXpath = "(((//section)[2]//section//ul//li)["+i+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span)[2]";
					String NormalQty = "((//section)[2]//section//ul//li)["+i+"]//div[@class='py-1.5 xl:py-1']//span";
					String stockAvailabilityXpath = "(((//section)[2]//section//ul//li)["+i+"]//a)//*[contains(text(),'Stock')]";
					
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(URLXapth)));
					
					WebElement imageElement = driver.findElement(By.xpath(URLXapth));
					String productCodeURL = imageElement.getAttribute("href");
					String ProductCode = bb.productCodeSplit(productCodeURL);
					String Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
					String SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
					SellingPrice = userUtility1.rupeesSplit(SellingPrice);
					String MRP;
					try {
						MRP = driver.findElement(By.xpath(MRPXpath)).getText();
						MRP = userUtility1.rupeesSplit(MRP);
					} catch (Exception e) {
						MRP = SellingPrice;
					}
					String Qty = driver.findElement(By.xpath(NormalQty)).getText();
					
					try {
						driver.findElement(By.xpath(stockAvailabilityXpath));
						availability = "0";
					} 
					catch (Exception e) {
					}
					
					
					System.out.println(productCodeURL);
					System.out.println(ProductCode);
					System.out.println(Title);
					System.out.println(SellingPrice);
					System.out.println(MRP);
					System.out.println(Qty);
					System.out.println(availability);
					System.out.println("-----------------------------");
					
					List<String> finalList = new ArrayList<String>();
					finalList.add(productCodeURL);
					finalList.add(ProductCode);
					finalList.add(Title);
					finalList.add(MRP);
					finalList.add(SellingPrice);
					finalList.add(Qty);
					finalList.add(availability);
					
					if (rowNum == 1) {
						List<String> header = userUtility1.header("");
						userUtility1.writeIntoSheet(userUtility1.OutputSheet, header);
					}

					userUtility1.writeIntoSheet(userUtility1.OutputSheet, finalList);

					rowNum++;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			userUtility1.writeIntoExcel(userUtility1.OutputWorkBook, userUtility1.OutputDataFilePath);
			System.out.println("Scrapping is completed");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			userUtility1.writeIntoExcel(userUtility1.OutputWorkBook, userUtility1.OutputDataFilePath);
			
			try {
				driver.quit();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
