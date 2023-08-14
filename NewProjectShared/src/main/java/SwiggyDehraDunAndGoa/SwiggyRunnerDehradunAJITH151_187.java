package SwiggyDehraDunAndGoa;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;

public class SwiggyRunnerDehradunAJITH151_187 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyDehradun;
		String InputLocation = "Dehradun";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerDehradunAJITH151_187.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 151, 160, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 161, 170, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 171, 187, reRun, listOfRowNumber, outputfilepath);
//		s.dataScrapping(filePath, InputLocation, InputCity, 131, 140, reRun, listOfRowNumber, outputfilepath);
//		s.dataScrapping(filePath, InputLocation, InputCity, 141, 150, reRun, listOfRowNumber, outputfilepath);

	}
}
