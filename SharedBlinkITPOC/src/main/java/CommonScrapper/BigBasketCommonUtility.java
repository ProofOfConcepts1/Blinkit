package CommonScrapper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonUtility.appiumHelp;


public class BigBasketCommonUtility {
	
//	Location setup:
	
	public void BBLocationSetup(RemoteWebDriver driver, String location, String city) {
		driver.get("https://www.bigbasket.com/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		CommonUserUtilityScrapper.waitHelper(driver, "//input[@value='Change Location']");
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
		
		CommonUserUtilityScrapper.waitHelper(driver, "(//input[@qa='areaInput'][contains(@placeholder,'Enter')])[1]");
		
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
	
//	Product details Scraping:
	
	public void productDetailScrapping(RemoteWebDriver driver) {
		String BlinkitPid = "NA";
		List<String> data = new ArrayList<String>();
		String brandName;
		String Qty;
		
		CommonUserUtilityScrapper.waitHelper(driver, "//section//div//h1");
		
			try {
				brandName = driver
						.findElement(By.xpath(
								"//section//section//div//a"))
						.getText();

				if (brandName.equals("")) {
					brandName = "NA";
				}
			}

			catch (Exception e) {

				brandName = "NA";
			}

			String ItemName = driver
					.findElement(By
							.xpath("//section//div//h1"))
					.getText();

			String[] splitQty = ItemName.split("\\,");

			List<String> listQty = new ArrayList<String>();

			for (String value : splitQty) {
				listQty.add(value);
			}

			Qty = listQty.get(listQty.size() - 1);

			String sp1 = null;
			String Mrp1 = null;

			String path1 = "//table";
			String path2 = "//table//tr//td";

			try {
				List<String> price = new ArrayList<String>();
				price = appiumHelp.productDetails(driver, path1);

				Mrp1 = price.get(0);
				if (Mrp1 == null) {
					price = appiumHelp.productDetails(driver, path2);
				}

				Mrp1 = price.get(0);
				sp1 = price.get(1);
			} catch (Exception e) {
				Mrp1 = "NA";
				sp1 = "NA";
			}
			
			Mrp1 = appiumHelp.removeRupeeSymbol(Mrp1);
			sp1 = appiumHelp.removeRupeeSymbol(sp1);


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

			data.add(BlinkitPid);	
			data.add(ItemName);
			data.add(productCode);
			data.add(currentUrl);
			data.add(ItemName);
			data.add(Mrp1);
			data.add(sp1);
			data.add(Qty);
			data.add("1");
			data.add(brandName);			
			
		System.out.println(data);
	}
	
	public String productCodeSplit(String currentUrl) {
		String productCode;


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
	
}
