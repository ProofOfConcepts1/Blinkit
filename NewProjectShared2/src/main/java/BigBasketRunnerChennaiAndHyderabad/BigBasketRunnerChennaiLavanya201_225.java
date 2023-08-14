package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerChennaiLavanya201_225 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBChennai;
		String InputLocation = "Chennai";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerChennaiLavanya201_225.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 201, 205, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 206, 210, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 211, 215, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 216, 220, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 221, 225, reRun, listOfRowNumber, outputfilepath);
	}

}
