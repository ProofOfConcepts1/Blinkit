package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya126_150 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya126_150.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {39};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 8, 8, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 16, 16, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("2nd Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 136, 140, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("3rd Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 141, 145, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("4th Set Completed");
		//s.dataScrapping(filePath, InputLocation, InputCity, 146, 150, reRun, listOfRowNumber, outputfilepath);
		//System.err.println("5th Set Completed");
	}
}
