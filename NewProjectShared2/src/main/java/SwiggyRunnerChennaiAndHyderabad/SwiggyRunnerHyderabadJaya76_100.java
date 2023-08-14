package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerHyderabadJaya76_100 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerHyderabadJaya76_100.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {79};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 76, 80, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 81, 85, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 86, 90, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 91, 95, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 96, 100, reRun, listOfRowNumber, outputfilepath);
	}

}	
