package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha101_125 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha101_125.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {213,269,278};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 101, 105, reRun, listOfRowNumber, outputfilepath);
		//b.dataScrapping(filePath, InputLocation, InputCity, 106, 110, reRun, listOfRowNumber, outputfilepath);
		//b.dataScrapping(filePath, InputLocation, InputCity, 111, 115, reRun, listOfRowNumber, outputfilepath);
		//b.dataScrapping(filePath, InputLocation, InputCity, 116, 120, reRun, listOfRowNumber, outputfilepath);
		//b.dataScrapping(filePath, InputLocation, InputCity, 121, 125, reRun, listOfRowNumber, outputfilepath);
	}

}
