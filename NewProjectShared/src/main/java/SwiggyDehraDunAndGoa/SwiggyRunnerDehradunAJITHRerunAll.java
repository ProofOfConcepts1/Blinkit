package SwiggyDehraDunAndGoa;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerDehradunAJITHRerunAll {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyDehradun;
		String InputLocation = "Dehradun";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerDehradunAJITHRerunAll.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 21, 22, reRun, listOfRowNumber, outputfilepath);
		System.err.println("1 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 26, 26, reRun, listOfRowNumber, outputfilepath);
		System.err.println("2 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 47, 47, reRun, listOfRowNumber, outputfilepath);
		System.err.println("3 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 54, 54, reRun, listOfRowNumber, outputfilepath);
		System.err.println("4 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 88, 89, reRun, listOfRowNumber, outputfilepath);
		System.err.println("5 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 100, 100, reRun, listOfRowNumber, outputfilepath);
		System.err.println("6 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 118, 118, reRun, listOfRowNumber, outputfilepath);
		System.err.println("7 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 125, 125, reRun, listOfRowNumber, outputfilepath);
		System.err.println("8 set completed");
		s.dataScrapping(filePath, InputLocation, InputCity, 177, 177, reRun, listOfRowNumber, outputfilepath);
		System.err.println("9 set completed");
		

	}
}
