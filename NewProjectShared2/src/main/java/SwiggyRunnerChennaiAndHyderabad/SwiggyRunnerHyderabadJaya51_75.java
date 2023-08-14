package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya51_75 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya51_75.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {79};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 51, 55, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 56, 60, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 61, 65, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 66, 70, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 71, 75, reRun, listOfRowNumber, outputfilepath);
	}

}	
