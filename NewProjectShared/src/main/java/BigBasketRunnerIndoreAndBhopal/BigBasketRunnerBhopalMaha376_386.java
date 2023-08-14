package BigBasketRunnerIndoreAndBhopal;

import BigBasket.BBCommonScrapperIndoreAndBhopal;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerBhopalMaha376_386 {
	
	public static void main(String[] args) {
		BBCommonScrapperIndoreAndBhopal b = new BBCommonScrapperIndoreAndBhopal();
		
		String filePath = fileLocations.InputDataFilePathBBBhopal;
		String InputLocation = "Bhopal";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerBhopalMaha376_386.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {56};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 376, 380, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 381, 386, reRun, listOfRowNumber, outputfilepath);
//		b.dataScrapping(filePath, InputLocation, InputCity, 361, 365, reRun, listOfRowNumber, outputfilepath);
//		b.dataScrapping(filePath, InputLocation, InputCity, 366, 370, reRun, listOfRowNumber, outputfilepath);
//		b.dataScrapping(filePath, InputLocation, InputCity, 371, 375, reRun, listOfRowNumber, outputfilepath);
	}

}
