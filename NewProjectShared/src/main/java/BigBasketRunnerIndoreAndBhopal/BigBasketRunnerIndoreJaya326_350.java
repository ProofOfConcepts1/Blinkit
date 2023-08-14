package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya326_350 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya326_350.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 326, 330, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 331, 335, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 336, 340, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 341, 345, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 346, 350, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set done");
	}

}
