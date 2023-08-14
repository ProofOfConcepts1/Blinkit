package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya351_375 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya351_375.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 351, 355, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 356, 360, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 361, 365, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 366, 365, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 370, 375, reRun, listOfRowNumber, outputfilepath);
	}

}
