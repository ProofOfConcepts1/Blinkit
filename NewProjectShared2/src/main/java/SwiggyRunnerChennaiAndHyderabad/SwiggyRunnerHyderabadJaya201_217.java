package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya201_217 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya201_217.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {79};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 201, 205, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 206, 210, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 211, 215, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 216, 217, reRun, listOfRowNumber, outputfilepath);
//		s.dataScrapping(filePath, InputLocation, InputCity, 196, 200, reRun, listOfRowNumber, outputfilepath);
	}

}	
