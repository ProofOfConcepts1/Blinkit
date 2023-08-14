package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya426_450 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya426_450.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 426, 430, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 431, 435, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 436, 440, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 441, 445, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 446, 450, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set done");
	}

}
