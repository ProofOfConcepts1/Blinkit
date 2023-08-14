package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha276_300 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha276_300.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 276, 280, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 281, 285, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 286, 290, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 291, 295, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 296, 300, reRun, listOfRowNumber, outputfilepath);
	}

}
