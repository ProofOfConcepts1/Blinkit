package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya126_150 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya126_150.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {79};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 126, 130, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 131, 135, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 136, 140, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 141, 145, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 146, 150, reRun, listOfRowNumber, outputfilepath);
	}

}	
