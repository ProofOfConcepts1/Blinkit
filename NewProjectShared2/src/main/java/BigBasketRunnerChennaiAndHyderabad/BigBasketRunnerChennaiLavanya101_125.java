package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya101_125 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya101_125.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {317};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 421, 421, reRun, listOfRowNumber, outputfilepath);
	//	b.dataScrapping(filePath, InputLocation, InputCity, 422, 422, reRun, listOfRowNumber, outputfilepath);
	//	b.dataScrapping(filePath, InputLocation, InputCity, 423, 423, reRun, listOfRowNumber, outputfilepath);
	//	b.dataScrapping(filePath, InputLocation, InputCity, 424, 424, reRun, listOfRowNumber, outputfilepath);
	//	b.dataScrapping(filePath, InputLocation, InputCity, 425, 425, reRun, listOfRowNumber, outputfilepath);
	}

}
