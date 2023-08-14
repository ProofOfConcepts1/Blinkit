package SwiggyRunnerChennaiAndHyderabad;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerChennaiAjithRerun {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String InputLocation = "Chennai";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerChennaiAjithRerun.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 8, 8, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 16, 16, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 64, 69, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 70, 74, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 140, 140, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 94, 94, reRun, listOfRowNumber, outputfilepath);
		System.err.println("6 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 96, 96, reRun, listOfRowNumber, outputfilepath);
		System.err.println("7 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 98, 98, reRun, listOfRowNumber, outputfilepath);
		System.err.println("8 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 100, 100, reRun, listOfRowNumber, outputfilepath);
		System.err.println("9 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 123, 124, reRun, listOfRowNumber, outputfilepath);
		System.err.println("10 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 134, 134, reRun, listOfRowNumber, outputfilepath);
		System.err.println("11 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 137, 137, reRun, listOfRowNumber, outputfilepath);
		System.err.println("12 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 144, 144, reRun, listOfRowNumber, outputfilepath);
		System.err.println("13 completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 154, 154, reRun, listOfRowNumber, outputfilepath);
		System.err.println("14 completed");
		
	}
}
