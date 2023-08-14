package CommonUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class dummyXpathCheck {

	public static void main(String[] args) throws InterruptedException {
		UserUtility userUtility = new UserUtility(UserUtility.InputDataFilePath3, "Input data", "Locators");
		
		RemoteWebDriver driver = null;
		driver = userUtility.launchBrowser(driver, false, false, false);
		String URL = "https://www.amazon.in/ScotchNABOPPNAPackagingNATapeNAClear/dp/B0C288QXS1/ref=sr_1_27?crid=23D3ALJ059ESM&keywords=Scotch+Bopp+Transparent+Packaging+Tape+%2850+m%29NA1+unit&qid=1688636718&sprefix=scotch+bopp+transparent+packaging+tape+50+m+NA1+unit%2Caps%2C224&sr=8NA27";
		String Xpath = "//span[@class='aok-relative']//child::span//child::span//span";
		driver.get(URL);
		Thread.sleep(10000);
		WebElement findElement = driver.findElement(By.xpath(Xpath));
		System.out.println(userUtility.rupeesSplit(findElement.getText()));
	}

}
