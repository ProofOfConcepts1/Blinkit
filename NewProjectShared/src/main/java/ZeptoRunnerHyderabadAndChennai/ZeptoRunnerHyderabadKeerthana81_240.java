package ZeptoRunnerHyderabadAndChennai;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;
import Zepto.ZeptoCommonScrapper;

public class ZeptoRunnerHyderabadKeerthana81_240 {
	
	public static void main(String[] args) {
		ZeptoCommonScrapper z = new ZeptoCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathZeptoHyderabad;
//		String InputLocation = "Medavakkam";
		String InputLocation = "Hyderabad";
		String InputCity = null;
		String outputfilepath = ZeptoRunnerHyderabadKeerthana81_240.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {2,5,8};
		
		z.dataScrapping(filePath, InputLocation, InputCity, 20, 20, reRun, listOfRowNumber, outputfilepath);
		z.dataScrapping(filePath, InputLocation, InputCity, 90, 90, reRun, listOfRowNumber, outputfilepath);
		z.dataScrapping(filePath, InputLocation, InputCity, 93, 93, reRun, listOfRowNumber, outputfilepath);
		
	}

}
