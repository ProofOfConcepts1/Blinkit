package BigBasketRunnerChennaiAndHyderabad;

import BigBasket.BBCommonScrapper;
import CommonScrapperUtitlity.fileLocations;

public class BigBasketRunnerHyderabadDivya201_225 {
	
	public static void main(String[] args) {
		BBCommonScrapper b = new BBCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathBBHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = "";
		String outputfilepath = BigBasketRunnerHyderabadDivya201_225.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,440, 441, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set done");
		b.dataScrapping(filePath, InputLocation, InputCity, 442, 443, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set done");
		//b.dataScrapping(filePath, InputLocation, InputCity, 211, 215, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("Third set done");
		//b.dataScrapping(filePath, InputLocation, InputCity, 216, 220, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("Fourth set done");
		//b.dataScrapping(filePath, InputLocation, InputCity, 221, 225, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("Fifth set done");
	}

}
		