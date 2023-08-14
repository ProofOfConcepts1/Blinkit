package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha1_25 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha1_25.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 1, 5, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 6, 10, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 11, 15, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 16, 20, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 21, 25, reRun, listOfRowNumber, outputfilepath);
	}

}
