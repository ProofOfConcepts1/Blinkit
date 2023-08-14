package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya301_325 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya301_325.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 301, 305, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 306, 310, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 311, 315, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 316, 320, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 321, 325, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set completed");
	}

}
