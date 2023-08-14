package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya301_325 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya301_325.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 301, 305, reRun, listOfRowNumber, outputfilepath);
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
