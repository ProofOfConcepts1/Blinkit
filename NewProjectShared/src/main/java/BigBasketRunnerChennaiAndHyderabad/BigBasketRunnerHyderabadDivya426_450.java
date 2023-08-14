package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya426_450 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya426_450.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,426, 430, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 431, 435, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 436, 440, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 441, 445, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 446, 450, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth test done");
	}

}
		