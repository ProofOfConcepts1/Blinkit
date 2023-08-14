package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha126_150 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha126_150.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 126, 130, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 131, 135, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 136, 140, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 141, 145, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 146, 150, reRun, listOfRowNumber, outputfilepath);
	}

}
