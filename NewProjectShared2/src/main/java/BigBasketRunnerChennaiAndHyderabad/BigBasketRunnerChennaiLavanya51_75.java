package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya51_75 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya51_75.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 51, 55, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 56, 60, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 61, 65, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 66, 70, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 71, 75, reRun, listOfRowNumber, outputfilepath);
	}

}
