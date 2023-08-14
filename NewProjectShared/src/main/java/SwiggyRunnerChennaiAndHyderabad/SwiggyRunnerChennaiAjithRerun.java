package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiAjithRerun {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiAjithRerun.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
//		s.dataScrapping(filePath, InputLocation, InputCity, 8, 8, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("1 set completed");
//		s.dataScrapping(filePath, InputLocation, InputCity, 16, 16, reRun, listOfRowNumber, outputfilepath);
//		System.err.println("2 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 64, 69, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 70, 74, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 79, 79, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 140, 140, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4 completed");
		
		
	}
}
