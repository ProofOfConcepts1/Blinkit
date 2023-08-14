package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya101_125 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya101_125.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {5,8,9,10};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 216, 216, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 214, 215, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 216, 216, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd Set Completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 68, 68, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th Set Completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 69, 69, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th Set Completed");
	}
}
