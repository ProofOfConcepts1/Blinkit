package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapper;
import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerIndoreJaya176_200 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBIndore;
		String InputLocation = "Indore";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerIndoreJaya176_200.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {208};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 176, 180, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 181, 185, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 186, 190, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 191, 195, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 196, 200, reRun, listOfRowNumber, outputfilepath);
	}

}
