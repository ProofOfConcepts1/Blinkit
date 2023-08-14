package Zepto;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonUtility.appiumHelp;


public class ZeptoUtility {
	
//	Location setup:
	
	public void ZeptoLocationSetup(RemoteWebDriver driver, String location) {
		driver.get("https://www.zeptonow.com/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
//		driver.findElement(By.xpath("//button[@type='button']//div//div//p")).click();
		UserUtilityZepto.waitHelper(driver, "//p[text()='Type manually']");
		driver.findElement(By.xpath("//p[text()='Type manually']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//div[contains(@class,'_8lUDd6')]//*//div//input[@type='text']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'_8lUDd6')]//*//div//input[@type='text']")).sendKeys(location);
		UserUtilityZepto.waitHelper(driver, "//h4[contains(text(),'"+location+"')]");
		driver.findElement(By.xpath("//h4[contains(text(),'"+location+"')]")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		UserUtilityZepto.waitHelper(driver, "//button[@aria-label='Confirm Action']");
		driver.findElement(By.xpath("//button[@aria-label='Confirm Action']")).click();
		
		
		try {
			driver.findElement(By.xpath("//button//p[text()='Login']"));
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath("//button[@aria-label='Confirm Action']")).click();
			} catch (Exception e2) {
			}
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	Product details Scraping:
	
//	Product code split
	
	public String productCodeSplit(String data) {
		
		String[] newdata = data.split("store-product-");
		return data = newdata[1];
	}
}
