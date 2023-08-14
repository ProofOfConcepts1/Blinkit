package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya226_250 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya226_250.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 226, 230, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 231, 235, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 236, 240, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 241, 245, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 246, 250, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set completed");
	}

}
