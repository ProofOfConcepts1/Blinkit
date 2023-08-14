package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya251_275 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya251_275.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 251, 255, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 256, 260, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 261, 265, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 266, 270, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 271, 275, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set done");
	}

}
