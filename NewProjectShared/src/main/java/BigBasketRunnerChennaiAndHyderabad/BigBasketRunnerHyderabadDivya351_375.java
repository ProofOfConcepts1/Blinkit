package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya351_375 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya351_375.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,351, 355, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 356, 360, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 361, 365, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 366, 370, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 371, 375, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth test done");
	}

}
		