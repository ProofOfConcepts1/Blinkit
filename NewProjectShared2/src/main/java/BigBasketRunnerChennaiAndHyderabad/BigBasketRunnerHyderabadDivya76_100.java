package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya76_100 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya76_100.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 76, 80, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 81, 85, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 86, 90, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 91, 95, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 96, 100, reRun, listOfRowNumber, outputfilepath);
	}

}
		