package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiJaya76_100 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiJaya76_100.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 76, 80, reRun, listOfRowNumber, outputfilepath);
		System.err.println("First set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 81, 85, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Second set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 86, 90, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Third set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 91, 95, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fourth set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 96, 100, reRun, listOfRowNumber, outputfilepath);
		System.err.println("Fifth set completed");
	}
}
