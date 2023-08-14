package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya276_300 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya276_300.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 276, 280, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 281, 285, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 286, 290, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 291, 295, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 296, 300, reRun, listOfRowNumber, outputfilepath);
	}

}
		