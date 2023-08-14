package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya226_250 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya226_250.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,226, 230, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 231, 235, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 236, 240, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 241, 245, reRun, listOfRowNumber, outputfilepath);
		b.dataScrapping(filePath, InputLocation, InputCity, 246, 250, reRun, listOfRowNumber, outputfilepath);
	}

}
		