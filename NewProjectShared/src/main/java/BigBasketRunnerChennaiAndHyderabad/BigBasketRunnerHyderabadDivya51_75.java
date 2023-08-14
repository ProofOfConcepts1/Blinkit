package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya51_75 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya51_75.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 51, 55, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 56, 60, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 61, 65, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 66, 70, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 71, 75, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set completed");
	}

}
		