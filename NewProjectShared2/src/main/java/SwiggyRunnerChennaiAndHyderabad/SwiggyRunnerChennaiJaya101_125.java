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
		boolean reRun = true;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 101, 105, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 106, 110, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 111, 115, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 116, 120, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 121, 125, reRun, listOfRowNumber, outputfilepath);
	}
}
