package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya101_125 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya101_125.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {218};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 103, 103, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set completed");
	//	s.dataScrapping(filePath, InputLocation, InputCity, 106, 106, reRun, listOfRowNumber, outputfilepath);
	//	System.err.println("2nd set completed");
	//	s.dataScrapping(filePath, InputLocation, InputCity, 113, 113, reRun, listOfRowNumber, outputfilepath);
	//	System.err.println("3rd set completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 116, 120, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("4th set completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 121, 125, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("5th set completed");
	}

}	
