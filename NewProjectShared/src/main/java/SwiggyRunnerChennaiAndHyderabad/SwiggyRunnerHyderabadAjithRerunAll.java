package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadAjithRerunAll {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadAjithRerunAll.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {121,122,123};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 65, 65, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1st set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 99, 99, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2nd set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 101, 101, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3rd set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 114, 115, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4th set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 119, 119, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5th set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 135, 135, reRun, listOfRowNumber, outputfilepath);
		System.err.println("6th set Completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 137, 137, reRun, listOfRowNumber, outputfilepath);
		System.err.println("7th set Completed");
	}

}	
