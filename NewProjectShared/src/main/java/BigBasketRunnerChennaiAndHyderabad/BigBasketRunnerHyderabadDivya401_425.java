package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya401_425 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya401_425.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {440,441,442,443};
		
		b.dataScrapping(filePath, InputLocation, InputCity,401, 405, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
		//b.dataScrapping(filePath, InputLocation, InputCity, 406, 410, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("2nd set completed");
		//b.dataScrapping(filePath, InputLocation, InputCity, 411, 415, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("3rd set completed");
		//b.dataScrapping(filePath, InputLocation, InputCity, 416, 420, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("4th set completed");
		//b.dataScrapping(filePath, InputLocation, InputCity, 421, 425, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("5th set completed");
	}

}
		