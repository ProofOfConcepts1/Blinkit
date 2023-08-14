package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya326_350 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya326_350.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,151, 155, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 156, 160, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 161, 165, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 166, 170, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 171, 175, reRun, listOfRowNumber, outputfilepath);
	}

}
		