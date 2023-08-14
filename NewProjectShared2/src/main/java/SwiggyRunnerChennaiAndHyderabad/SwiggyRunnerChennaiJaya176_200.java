package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya176_200 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya176_200.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 176, 180, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 181, 185, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 186, 190, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 191, 195, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 196, 200, reRun, listOfRowNumber, outputfilepath);
	}
}
