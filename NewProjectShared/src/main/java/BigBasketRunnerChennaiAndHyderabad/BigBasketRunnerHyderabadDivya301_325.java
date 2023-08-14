package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya301_325 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya301_325.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,301, 305, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 306, 310, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 311, 315, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 316, 320, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 321, 325, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set done");
	}

}
		