package ZeptoRunnerHyderabadAndChennai;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;
import Zepto.ZeptoCommonScrapper;

public class ZeptoRunnerHyderabadKeerthana21_80 {
	
	public static void main(String[] args) {
		ZeptoCommonScrapper z = new ZeptoCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathZeptoHyderabad;
//		String InputLocation = "Medavakkam";
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = ZeptoRunnerHyderabadKeerthana21_80.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {50};
		
		z.dataScrapping(filePath, InputLocation, InputCity, 10, 10, reRun, listOfRowNumber, outputfilepath);
	//	z.dataScrapping(filePath, InputLocation, InputCity, 104, 104, reRun, listOfRowNumber, outputfilepath);
	//	z.dataScrapping(filePath, InputLocation, InputCity, 104, 104, reRun, listOfRowNumber, outputfilepath);
	}

}
