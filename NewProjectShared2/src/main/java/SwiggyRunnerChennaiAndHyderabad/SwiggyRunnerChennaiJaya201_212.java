package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya201_212 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya201_212.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 201, 205, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 206, 210, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 211, 212, reRun, listOfRowNumber, outputfilepath);
//		s.dataScrapping(filePath, InputLocation, InputCity, 191, 195, reRun, listOfRowNumber, outputfilepath);
//		s.dataScrapping(filePath, InputLocation, InputCity, 196, 200, reRun, listOfRowNumber, outputfilepath);
	}
}
