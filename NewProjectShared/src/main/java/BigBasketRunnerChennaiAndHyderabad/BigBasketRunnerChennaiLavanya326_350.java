package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya326_350 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya326_350.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 326, 330, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 331, 335, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 336, 340, reRun, listOfRowNumber, outputfilepath);
		System.err.println("third set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 341, 345, reRun, listOfRowNumber, outputfilepath);
		System.err.println("fourth set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 346, 350, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set done");
	}

}
