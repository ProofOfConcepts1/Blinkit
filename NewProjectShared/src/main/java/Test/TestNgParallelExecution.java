package Test;

import org.testng.annotations.Test;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;
import SwiggyDehraDunAndGoa.SwiggyRunnerDehradunAJITH101_150;
import SwiggyDehraDunAndGoa.SwiggyRunnerDehradunAJITH1_50;

public class TestNgParallelExecution {
	@Test
	private void test() {

		
SwiggyCommonScrapper s = new SwiggyCommonScrapper();

String filePath = fileLocations.InputDataFilePathSwiggyDehradun;
String InputLocation = "Dehradun";
String InputCity = null;
String outputfilepath = SwiggyRunnerDehradunAJITH1_50.class.getSimpleName();
boolean reRun = false;
Integer[] listOfRowNumber = {30};

s.dataScrapping(filePath, InputLocation, InputCity, 4, 5, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 12, 14, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 29, 29, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 57, 57, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 68, 68, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 71, 71, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 79, 79, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 80, 80, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 91, 91, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 107, 107, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 113, 115, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 119, 119, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 120, 120, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 130, 130, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 132, 137, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 137, 142, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 142, 147, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 147, 150, reRun, listOfRowNumber, outputfilepath);
s.dataScrapping(filePath, InputLocation, InputCity, 196, 196, reRun, listOfRowNumber, outputfilepath);

	}
	@Test
	private void test1() {
SwiggyCommonScrapper s = new SwiggyCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathSwiggyDehradun;
		String InputLocation = "Dehradun";
		String InputCity = null;
		String outputfilepath = SwiggyRunnerDehradunAJITH101_150.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {30};
		
		s.dataScrapping(filePath, InputLocation, InputCity, 101, 110, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 111, 120, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 121, 130, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 131, 140, reRun, listOfRowNumber, outputfilepath);
		s.dataScrapping(filePath, InputLocation, InputCity, 141, 150, reRun, listOfRowNumber, outputfilepath);

	}

}
