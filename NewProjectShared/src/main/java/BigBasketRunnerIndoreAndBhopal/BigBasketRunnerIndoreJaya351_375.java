package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya351_375 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya351_375.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 351, 355, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 356, 360, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 361, 365, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 366, 370, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set Completed");
		b.dataScrapping(filePath, InputLocation, InputCity, 371, 375, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set Completed");
	}

}
