package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya1_25 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya1_25.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {218};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 121, 121, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set Completed");
	//	s.dataScrapping(filePath, InputLocation, InputCity, 122, 122, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("2nd set Completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 123, 123, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("3rd set Completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 16, 20, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("4th set Completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 21, 25, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("5th set Completed");
	}

}	
