package Swiggy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonScrapperUtitlity.CommonUserUtilityScrapper;
import CommonScrapperUtitlity.appiumHelp;


public class SwiggyCommonUtility {
	
//	Location setup:
	
	public void SwiggyLocationSetup(RemoteWebDriver driver, String location) {
		driver.get("https://www.swiggy.com/?prevPath=https://www.swiggy.com%2Finstamart");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='SETUP YOUR LOCATION']")).click();
		CommonUserUtilityScrapper.waitHelper(driver, "//input[@type='text']");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(location, Keys.ENTER);
		CommonUserUtilityScrapper.waitHelper(driver, "//span//span[contains(text(),'"+location+"')]");
		driver.findElement(By.xpath("//span//span[contains(text(),'"+location+"')]")).click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
	}
	
//	Product details Scraping:
	
	public List<String> productDetailsScrapping(RemoteWebDriver driver) {
		
		List<String> data = new ArrayList<String>();
		String brandName = "NA";
		String mrp;
		String StockAvailability = "1";
		String productDescription = "NA";
		String ImportantInformation = "NA";
		
			
			CommonUserUtilityScrapper.waitHelper(driver, "//div[@data-testid='item-name']");
			String ItemName;
			try {
				ItemName = driver.findElement(By.xpath("//div[@data-testid='item-name']")).getText();
			} catch (Exception e) {
				driver.navigate().refresh();
				try {
					Thread.sleep(15000);
				} 
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				ItemName = driver.findElement(By.xpath("//div[@data-testid='item-name']")).getText();
			}
			
			try {
				brandName = driver.findElement(By.xpath("//div[@data-testid='item-brand-name']")).getText();
				
			}

			catch (Exception e) {
				
				brandName = "NA";
			}
			
//			if (!brandName.equals("NA")) {
//				ItemName = brandName + " "+ ItemName;
//			}

			String Qty = driver.findElement(By.xpath("//div[contains(@class,'_2M_kP')]//div[contains(@class,'_1TwvP')]")).getText();

			
			String sp = driver.findElement(By.xpath("//div[@data-testid='item-price']")).getText();
			sp = CommonUserUtilityScrapper.rupeesSplit(sp);
			
			try {
				mrp = driver.findElement(By.xpath("//div[@data-testid='item-striked-price']")).getText();
				mrp = CommonUserUtilityScrapper.rupeesSplit(mrp);
			} catch (Exception e) {
				mrp = sp;
			}
			
			String SwiggyQty = null;
			
			try {
				SwiggyQty = driver.findElement(By.xpath("//div//p[contains(text(),'Approx')]")).getText();
			}
			
			catch (Exception e) {
				
			}
			
			
			
			try {
				Qty = Qty + " (" + appiumHelp.SwiggyQty(SwiggyQty) + ")";
			} 
			
			catch (Exception e) {
//				System.out.println("Qty");
			}
			
			String VarianceAvailability = "NA";
			
			try {
				VarianceAvailability = driver.findElement(By.xpath("//*[contains(text(),'option')]")).getText();
				VarianceAvailability = "YES";
			} 
			
			catch (Exception e) {
//				System.out.println("No VarianceAvailability is available");
			}
			
			try {
				WebElement findElement = driver.findElement(By.xpath("//div[@role='button']//*[contains(text(),'Sold')]"));
				StockAvailability = "0";
			}
			
			catch (Exception e) {
			}
			
			try {
				String desc1 = driver.findElement(By.xpath("//div[@class='_3YRSY']")).getText();
				
				if (desc1.contains("Product Description")) {
					productDescription = desc1;
				}
				
				else if (desc1.contains("Important Information")) {
					ImportantInformation = desc1;
				}
				
			} catch (Exception e) {
			}
			
			try {
				String desc2 = driver.findElement(By.xpath("(//div[@class='_3YRSY'])[2]")).getText();
				if (desc2.contains("Product Description")) {
					productDescription = desc2;
				}
				
				else if (desc2.contains("Important Information")) {
					ImportantInformation = desc2;
				}
			} catch (Exception e) {
			}
			

			String productCode;

			String currentUrl = driver.getCurrentUrl();

			String[] splitUrl = currentUrl.split("\\?");

			List<String> listUrl = new ArrayList<String>(); 
			
			List<String> listUrl2 = new ArrayList<String>(); 

			String[] splitUrl2 = null;

			for (String string : splitUrl) {
				listUrl.add(string);
			}
			
			String dummyURL = listUrl.get(0);
			 
			splitUrl2 = dummyURL.split("/");

			for (String string : splitUrl2) {
				listUrl2.add(string);
			}

			productCode = listUrl2.get(listUrl2.size() - 1);
			
			
			data.add(currentUrl);
			data.add(productCode);
			data.add(ItemName);
			data.add(mrp);
			data.add(sp);
			data.add(Qty);
			data.add(StockAvailability);
			data.add(VarianceAvailability);
			data.add(brandName);
			data.add(productDescription);
			data.add(ImportantInformation);
			
			return data;

		
	}
	
//	Product code split
	
	public String productCodeSplit(String data) {
		
		String productCode;


		String[] splitUrl = data.split("\\?");

		List<String> listUrl = new ArrayList<String>(); 
		
		List<String> listUrl2 = new ArrayList<String>(); 

		String[] splitUrl2 = null;

		for (String string : splitUrl) {
			listUrl.add(string);
		}
		
		String dummyURL = listUrl.get(0);
		 
		splitUrl2 = dummyURL.split("/");

		for (String string : splitUrl2) {
			listUrl2.add(string);
		}

		return productCode = listUrl2.get(listUrl2.size() - 1);

	}
}
