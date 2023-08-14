package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya26_50 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya26_50.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 26, 30, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 31, 35, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 36, 40, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 41, 45, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 46, 50, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set completed");
	}

}
		