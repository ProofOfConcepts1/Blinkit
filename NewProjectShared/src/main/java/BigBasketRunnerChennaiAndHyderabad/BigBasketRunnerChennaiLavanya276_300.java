package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya276_300 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya276_300.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 276, 280, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 281, 285, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 286, 290, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 291, 295, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 296, 300, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set Completed");
	}

}
