package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya151_175 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya151_175.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 151, 155, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 156, 160, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 161, 165, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 166, 170, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 171, 175, reRun, listOfRowNumber, outputfilepath);
	}
}
