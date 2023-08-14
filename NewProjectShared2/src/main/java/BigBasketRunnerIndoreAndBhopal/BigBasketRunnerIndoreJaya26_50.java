package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya26_50 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya26_50.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 26, 30, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 31, 35, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 36, 40, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 41, 45, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 46, 50, reRun, listOfRowNumber, outputfilepath);
	}

}
