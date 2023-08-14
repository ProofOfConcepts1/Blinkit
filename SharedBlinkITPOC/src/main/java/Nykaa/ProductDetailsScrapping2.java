package Nykaa;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import CommonScrapper.CommonUserUtilityScrapper;
import CommonScrapper.fileLocations;

public class ProductDetailsScrapping2 {

	public void waitHelper(RemoteWebDriver driver, String xpath) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(fileLocations.waitTime))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public String getText(RemoteWebDriver driver, String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();

		return text;
	}
	

	/***
	 * Format for Nykaa => productCodeReturn(URL, "/p/", "\\?");
	 * 
	 * @param url
	 * @param separator1
	 * @param separator2
	 * @return - Product code from the URL
	 */

	public String productCodeReturn(String url, String separator1, String separator2) {

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

	public List<String> productDetails(RemoteWebDriver driver, HashMap<String, String> locatorsMap) {

		List<String> dataList = new ArrayList<String>();

		String productCode = "NA";
		String URL = "NA";
		String brandName = "NA";
		String productName = "NA";
		String mrp = "NA";
		String sellingPrice = "NA";
		String quantity = "NA";
		String availability = "1";
		String multiplier = "NA";
		String manualInterventionFlag = "NA";
		String logFile = "";

//		Input string URL

		String brandNameXpath, productNameXpath, productNameXpath1, mrpXpath, mrpXpath1, sellingPriceXpath,
				sellingPriceXpath1;


//			Product name 
		try {
			productNameXpath = locatorsMap.get("productNameXpath");

			if (!productNameXpath.isBlank()) {
				System.out.println("productName is executed");
				waitHelper(driver, productNameXpath);
				productName = getText(driver, productNameXpath);
			}

			try {
				brandNameXpath = locatorsMap.get("brandNameXpath");

				if (!brandNameXpath.isBlank()) {
					brandName = getText(driver, brandNameXpath);
				}
			}

			catch (Exception e) {

			}

			if (!productName.isBlank() && !brandName.equals("NA")) {
				productName = brandName + productName;
			}
		}

		catch (Exception e) {

			try {
				productNameXpath1 = locatorsMap.get("productNameXpath1");

				if (!productNameXpath1.isBlank()) {
					System.out.println("productName is executed");
					productName = getText(driver, productNameXpath1);
				}

				try {
					brandNameXpath = locatorsMap.get("brandNameXpath");

					if (!brandNameXpath.isBlank()) {
						brandName = getText(driver, brandNameXpath);
					}
				}

				catch (Exception e1) {

				}

				if (!productName.isBlank() && !brandName.equals("NA")) {
					productName = brandName + productName;
				}

			}

			catch (Exception e2) {

				manualInterventionFlag = "YES";
				System.out.println(e.getMessage());
				logFile = logFile + "Product Name is not available /---------";
			}

		}
		
//		Current URL
		
		
		URL = driver.getCurrentUrl();

		System.out.println(URL);
		productCode = productCodeReturn(URL, "/p/", "\\?");

//			Qty

		try {
			quantity = productCodeReturn(productName, "\\(", "\\)");
		} catch (Exception e) {
			manualInterventionFlag = "YES";
			System.out.println(e.getMessage());
			logFile = logFile + "Qty is not available /---------";
		}
		

//			Selling price

		try {

			sellingPriceXpath = locatorsMap.get("sellingPriceXpath");

			if (!(sellingPriceXpath.isEmpty())) {
				sellingPrice = getText(driver, sellingPriceXpath);

				sellingPrice = CommonUserUtilityScrapper.rupeesSplit(sellingPrice);

				if (sellingPrice.isBlank() || sellingPrice.isEmpty()) {
					throw new Exception("Selling price is empty string");
				}

			}

		}

		catch (Exception e) {

			try {

				sellingPriceXpath1 = locatorsMap.get("sellingPriceXpath1");

				if (!(sellingPriceXpath1.isEmpty())) {
					sellingPrice = getText(driver, sellingPriceXpath1);
					sellingPrice = CommonUserUtilityScrapper.rupeesSplit(sellingPrice);

				}

			} catch (Exception e2) {
				manualInterventionFlag = "YES";
				System.out.println(e.getMessage());
				logFile = logFile + "Selling price is not available /---------";
			}
		}

//			MRP price

		try {
			mrpXpath = locatorsMap.get("mrpXpath");

			if (!mrpXpath.isBlank()) {
				mrp = getText(driver, mrpXpath);
				mrp = CommonUserUtilityScrapper.rupeesSplit(mrp);
			}

			if (mrp.isBlank() || (mrp.equals("NA"))) {
				mrp = sellingPrice;
			}
		}

		catch (Exception e) {

			try {
				mrpXpath1 = locatorsMap.get("mrpXpath");

				if (!mrpXpath1.isBlank()) {
					mrp = getText(driver, mrpXpath1);
					mrp = CommonUserUtilityScrapper.rupeesSplit(mrp);
				}

				if (mrp.isBlank() || (mrp.equals("NA"))) {
					mrp = sellingPrice;
				}
			}

			catch (Exception e2) {

				mrp = sellingPrice;

//					manualInterventionFlag = "YES";
//					System.out.println(e.getMessage());
//					logFile = logFile + "MRP price is not available /---------";
			}

		}

		dataList.add(productCode);
		dataList.add(URL);
		dataList.add(productName);
		dataList.add(mrp);
		dataList.add(sellingPrice);
		dataList.add(quantity);
		dataList.add(availability);
		dataList.add(multiplier);
		dataList.add(manualInterventionFlag);
		dataList.add(logFile);

		return dataList;
	}
	
	 
}


