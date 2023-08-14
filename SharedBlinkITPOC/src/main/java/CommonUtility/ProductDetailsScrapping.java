package CommonUtility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import Shopping.brandNamesForSPXpath;

public class ProductDetailsScrapping {

	public void waitHelper(RemoteWebDriver driver, String xpath) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(UserUtility.waitTime))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
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

	public List<String> productDetails(RemoteWebDriver driver, HashMap<String, String> locatorsMap,
			String productCodeSplit, boolean qtySplit, String inputProductCode) {

		List<String> dataList = new ArrayList<String>();

		String productCode = "NA";
		String URL = "NA";
		String brandName = "NA";
		String productName = "NA";
		String mrp = "NA";
		String sellingPrice = "NA";
		String quantity = "NA";
		String availability = "NA";
		String multiplier = "NA";
		String manualInterventionFlag = "NA";
		String logFile = "";

		if (!inputProductCode.equals("NA")) {
			String InputURL, brandNameXpath, productNameXpath, mrpXpath, sellingPriceXpath, sellingPriceXpath1,
					qtyXpath, availabilityXpath;
			try {
				InputURL = locatorsMap.get("InputURL");

				InputURL = InputURL + inputProductCode;


				if (!InputURL.isBlank()) {
					driver.get(InputURL);
					URL = driver.getCurrentUrl();
				}
			}

			catch (Exception e) {

			}
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
					logFile = logFile + "BrandName is not available /---------";

				}

				if (!productName.isBlank() && !brandName.equals("NA")) {
					productName = brandName + productName;
				}
			}

			catch (Exception e) {

				manualInterventionFlag = "YES";
				System.out.println(e.getMessage());
				logFile = logFile + "Product Name is not available /---------";

			}
			
			
			try {
				
				sellingPriceXpath = locatorsMap.get("sellingPriceXpath");
				sellingPriceXpath1 = locatorsMap.get("sellingPriceXpath1");
				
				try {
					if (!(sellingPriceXpath.isEmpty())) {
						sellingPrice = getText(driver, sellingPriceXpath);

						sellingPrice = UserUtility.rupeesSplit(sellingPrice);
						
						if (sellingPrice.isBlank() || sellingPrice.isEmpty()) {
							throw new Exception("Selling price is empty string") ;
						}
						
						logFile = logFile + "sellingPriceXpath is executed /---------";
					}
				}
				
				catch (Exception e) {
					logFile = logFile + "No discount for this product /---------";

					if (!(sellingPriceXpath1.isEmpty())) {
						sellingPrice = getText(driver, sellingPriceXpath1);
						sellingPrice = UserUtility.rupeesSplit(sellingPrice);
						
						logFile = logFile + "sellingPriceXpath1 is executed /---------";

					}
				}
			
			}

			catch (Exception e) {
				manualInterventionFlag = "YES";
				System.out.println(e.getMessage());
				logFile = logFile + "Selling price is not available /---------";
			}
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

			catch (Exception e) {
				System.out.println(e.getMessage());
				mrp = sellingPrice;

				mrp = UserUtility.rupeesSplit(mrp);
				
				logFile = logFile + "MRP and Selling price is same /---------";
			}
//			try {
//				qtyXpath = locatorsMap.get("qtyXpath");
//
//				if (!qtyXpath.isBlank()) {
//					quantity = getText(driver, qtyXpath);
//				}
//
//				//			if (locatorsMap.get("BrandName") == "Nykaa") {
//				//				quantity = UserUtility.qtySplitFromName(productName, "(", ")", true);
//				//			}
//			}
//
//			catch (Exception e) {
//			}
//			try {
//				availabilityXpath = locatorsMap.get("availabilityXpath");
//
//				if (!availabilityXpath.isBlank()) {
//					availability = getText(driver, availabilityXpath);
//				}
//				
//				else {
////					if (checkAvailability(driver)) {
////						availability = "Out of Stock";
////					}
//					
//					
//				}
//			}
//
//			catch (Exception e) {
//
//			} 
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
	
	public boolean checkAvailability(RemoteWebDriver driver) {
		

		try {
			driver.findElement(By.xpath("//*[contains(text(),'Out Of Stock')]"));
			return true;
		} 
		catch (Exception e) {
			try {
				driver.findElement(By.xpath("//*[contains(text(),'Out of Stock')]"));
				return true;

			} catch (Exception e2) {
				try {
					driver.findElement(By.xpath("//*[contains(text(),'Out of stock')]"));
					return true;

				} 
				catch (Exception e3) {
					try {
						driver.findElement(By.xpath("//*[contains(text(),'Sold Out')]"));
						return true;

					} 
					catch (Exception e4) {
						try {
							driver.findElement(By.xpath("//*[contains(text(),'Sold out')]"));
							return true;

						} 
						catch (Exception e5) {
							try {
								driver.findElement(By.xpath("//*[contains(text(),'sold out')]"));
								return true;

							} 
							catch (Exception e6) {
								try {
									driver.findElement(By.xpath("//*[contains(text(),'Currently unavailable')]"));
									return true;

								} catch (Exception e7) {
									try {
										driver.findElement(By.xpath("//*[contains(text(),'Currently not available')]"));
										return true;

									} catch (Exception e8) {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
			
	}	
}


