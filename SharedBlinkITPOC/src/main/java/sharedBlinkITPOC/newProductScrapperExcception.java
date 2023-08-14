package sharedBlinkITPOC;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import CommonUtility.UserUtility;

public class newProductScrapperExcception {

	public static void waitHelper(RemoteWebDriver driver, String xpath) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(UserUtility.waitTime))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public String getText(RemoteWebDriver driver, String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();

		return text;
	}
	
	public void BBLocationSetup(RemoteWebDriver driver, String location, String city) {
		driver.get("https://www.bigbasket.com/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		driver.findElement(By.xpath("//input[@value='Change Location']")).click();
		driver.findElement(By.xpath("(//span[@tabindex='-1'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("(//input[@type=\"search\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@type=\"search\"])[1]")).sendKeys(location);
		driver.findElement(By.xpath("//span[contains(text(),'"+location+"')]")).click();
		
		waitHelper(driver, "(//input[@qa='areaInput'][contains(@placeholder,'Enter')])[1]");
		
		driver.findElement(By.xpath("(//input[@qa='areaInput'][contains(@placeholder,'Enter')])[1]")).click();
		driver.findElement(By.xpath("(//input[@qa='areaInput'][contains(@placeholder,'Enter')])[1]")).sendKeys(city);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			driver.findElement(By.xpath("(//div[contains(@class,'area-select')]//ul)[1]")).click();
		} catch (Exception e) {
		}
				
				
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		} catch (Exception e2) {
			System.out.println("It is bangalore!!");
		}
	}
	
	public String productCodeSplit(RemoteWebDriver driver) {
		String productCode;

		String currentUrl = driver.getCurrentUrl();

		String[] splitUrl = currentUrl.split("pd/");

		List<String> listUrl = new ArrayList<String>();

		List<String> listUrl2 = new ArrayList<String>();

		String[] splitUrl2 = null;

		for (String string : splitUrl) {
			listUrl.add(string);
		}

		String dummyURL = listUrl.get(1);

		splitUrl2 = dummyURL.split("/");

		for (String string : splitUrl2) {
			listUrl2.add(string);
		}

		productCode = listUrl2.get(0);
		return productCode;
	}
	

	/***
	 * Format for Nykaa => productCodeReturn(URL, "/p/", "\\?");
	 * 
	 * @param url
	 * @param separator1
	 * @param separator2
	 * @return - Product code from the URL
	 */

	public static String productCodeReturn(String url, String separator1, String separator2) {

		String productCode;

		String currentUrl = url;

		String[] splitUrl = currentUrl.split(separator1);

		List<String> listUrl = new ArrayList<String>();

		List<String> listUrl2 = new ArrayList<String>();

		String[] splitUrl2 = null;

		for (String string : splitUrl) {
			listUrl.add(string);
		}

		String dummyURL = listUrl.get(1);

		splitUrl2 = dummyURL.split(separator2);

		for (String string : splitUrl2) {
			listUrl2.add(string);
		}

		productCode = listUrl2.get(0);

		return productCode;
	}

	public List<String> productDetails(RemoteWebDriver driver, HashMap<String, String> locatorsMap,
			String productCodeSplit, boolean qtySplit, String inputProductCode) throws Exception {

		List<String> dataList = new ArrayList<String>();

		String URL = "NA";
		String productCode = "NA";
		String brandName = "NA";
		String productName = "NA";
		String mrp = "NA";
		String sellingPrice = "NA";
		String quantity = "NA";
		String availability = "1";
		String manualInterventionFlag = "NA";
		String logFile = "";
		String about = "NA";

//		Input string URL
		
		if (!inputProductCode.equals("NA")) {
			String InputURL, brandNameXpath, productNameXpath,productNameXpath1, mrpXpath,mrpXpath1, sellingPriceXpath, sellingPriceXpath1,
					qtyXpath,qtyXpath1, availabilityXpath, availabilityXpath1;


			
//			Product name 
			try {
				productNameXpath = locatorsMap.get("productNameXpath");

				if (!productNameXpath.isBlank()) {
					System.out.println("productName is executed");
					waitHelper(driver, productNameXpath);
					productName = getText(driver, productNameXpath);
				}

			}

			catch (Exception e) {
				
				try {
					productNameXpath1 = locatorsMap.get("productNameXpath1");

					if (!productNameXpath1.isBlank()) {
						System.out.println("productName is executed");
						productName = getText(driver, productNameXpath1);
					}

					
				} 
				
				catch (Exception e2) {
					
					manualInterventionFlag = "YES";
					System.out.println(e.getMessage());
					logFile = logFile + "Product Name is not available /---------";
				}

			}
			
//			BrandName
			
			try {
				brandNameXpath = locatorsMap.get("brandNameXpath");

				if (!brandNameXpath.isBlank()) {
					brandName = getText(driver, brandNameXpath);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
//			URL and ProductCode
			
			try {
				URL = driver.findElement(By.xpath(locatorsMap.get("ImageURL"))).getAttribute("src");
				
				productCode = productCodeReturn(URL, "p/l/", "_");
				
				URL = "https://www.bigbasket.com/pd/"+productCode;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			Qty
			
			String[] splitQty = productName.split("\\,");

			List<String> listQty = new ArrayList<String>();

			for (String value : splitQty) {
				listQty.add(value);
			}

			quantity = listQty.get(listQty.size() - 1);
			
//			Selling price
			
			try {
				sellingPriceXpath = locatorsMap.get("sellingPriceXpath");
				
				
				if (!(sellingPriceXpath.isEmpty())) {
					sellingPrice = getText(driver, sellingPriceXpath);

					sellingPrice = UserUtility.rupeesSplit(sellingPrice);
					
					if (sellingPrice.isBlank() || sellingPrice.isEmpty()) {
						throw new Exception("Selling price is empty string") ;
					}
					
				}
				
			}

			catch (Exception e) {
				
				try {
					
					sellingPriceXpath1 = locatorsMap.get("sellingPriceXpath1");
					
					if (!(sellingPriceXpath1.isEmpty())) {
						sellingPrice = getText(driver, sellingPriceXpath1);
						sellingPrice = UserUtility.rupeesSplit(sellingPrice);
						

					}

				} catch (Exception e2) {
					manualInterventionFlag = "YES";
					System.out.println(e2.getMessage());
					logFile = logFile + "Selling price is not available /---------";
				}
			}
			
//			MRP price
			
			try {
				
				mrpXpath = locatorsMap.get("mrpXpath");

				if (!mrpXpath.isBlank()) {
					mrp = getText(driver, mrpXpath);
					mrp = UserUtility.rupeesSplit(mrp);
				}
				
				if (mrp.isBlank() || (mrp.equals("NA"))) {
					mrp = sellingPrice;
				}
				
			} 

			catch(Exception e) {
				
				mrp = sellingPrice;
				} 
			
			try {
				
				availabilityXpath1 = locatorsMap.get("availabilityXpath");
				
				if (!(availabilityXpath1.isEmpty())) {
					availability = getText(driver, availabilityXpath1);
					availability = "0";
					

				}

			} catch (Exception e2) {
			}
			
			try {
				
				String aboutXpath = locatorsMap.get("AboutSection");
				
				if (!(aboutXpath.isEmpty())) {
					about = getText(driver, aboutXpath);
				
			} 
			}catch (Exception e) {
				
			}
				
		}
		
		dataList.add(URL);
		dataList.add(productCode);
		dataList.add(productName);
		dataList.add(mrp);
		dataList.add(sellingPrice);
		dataList.add(quantity);
		dataList.add(brandName);
		dataList.add(availability);
		dataList.add(about);
		dataList.add(manualInterventionFlag);
		dataList.add(logFile);
		
//		System.out.println(dataList);
		return dataList;
	}
	
}


