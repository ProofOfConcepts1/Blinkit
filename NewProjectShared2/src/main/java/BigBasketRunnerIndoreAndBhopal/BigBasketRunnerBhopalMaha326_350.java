package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha326_350 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha326_350.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 326, 330, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 331, 335, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 336, 340, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 341, 345, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 346, 350, reRun, listOfRowNumber, outputfilepath);
	}

}
