package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya126_150 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya126_150.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 126, 130, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 131, 135, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 136, 140, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 141, 145, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 146, 150, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set completed");
	}

}
