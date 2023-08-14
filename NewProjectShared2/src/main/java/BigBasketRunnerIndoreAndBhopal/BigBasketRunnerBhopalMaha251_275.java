package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha251_275 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha251_275.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 251, 255, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 256, 260, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 261, 265, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 266, 270, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 271, 275, reRun, listOfRowNumber, outputfilepath);
	}

}
