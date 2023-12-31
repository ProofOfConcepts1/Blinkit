package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya151_175 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya151_175.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 151, 155, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 156, 160, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 161, 165, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 166, 170, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 171, 175, reRun, listOfRowNumber, outputfilepath);
	}

}
