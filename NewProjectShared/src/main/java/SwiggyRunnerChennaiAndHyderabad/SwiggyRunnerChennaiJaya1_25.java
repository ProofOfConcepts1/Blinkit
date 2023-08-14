package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya1_25 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya1_25.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {8,16};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 53, 53, reRun, listOfRowNumber, outputfilepath);
		//s.dataScrapping(filePath, InputLocation, InputCity, 63, 63, reRun, listOfRowNumber, outputfilepath);
		//s.dataScrapping(filePath, InputLocation, InputCity, 78, 78, reRun, listOfRowNumber, outputfilepath);
		//s.dataScrapping(filePath, InputLocation, InputCity, 79, 79, reRun, listOfRowNumber, outputfilepath);
		//s.dataScrapping(filePath, InputLocation, InputCity, 90, 90, reRun, listOfRowNumber, outputfilepath);
	}
}
