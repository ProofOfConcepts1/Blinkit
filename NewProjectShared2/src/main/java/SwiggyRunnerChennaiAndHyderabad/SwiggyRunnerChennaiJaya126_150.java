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
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 126, 130, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 131, 135, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 136, 140, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 141, 145, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 146, 150, reRun, listOfRowNumber, outputfilepath);
	}
}
