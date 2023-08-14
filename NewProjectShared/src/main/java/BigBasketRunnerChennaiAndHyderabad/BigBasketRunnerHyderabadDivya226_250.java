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
		boolean reRun = false;
		Integer[] listOfRowNumber = {103};
		
		b.dataScrapping(filePath, InputLocation, InputCity,226, 230, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 231, 235, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 236, 240, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 241, 245, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth test done");
		b.dataScrapping(filePath, InputLocation, InputCity, 246, 250, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth test done");
	}

}
		