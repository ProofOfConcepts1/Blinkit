package ZeptoRunnerHyderabadAndChennai;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;
import Zepto.ZeptoCommonScrapper;

public class ZeptoRunnerChennaiMoorthi1_80 {
	
	public static void main(String[] args) {
		ZeptoCommonScrapper z = new ZeptoCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathZeptoChennai;
		String InputLocation = "Medavakkam";
		String InputCity = null;
		String outputfilepath = ZeptoRunnerChennaiMoorthi1_80.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {4};
		
		z.dataScrapping(filePath, InputLocation, InputCity, 4, 4, reRun, listOfRowNumber, outputfilepath);
//		z.dataScrapping(filePath, InputLocation, InputCity, 161, 161, reRun, listOfRowNumber, outputfilepath);
//		z.dataScrapping(filePath, InputLocation, InputCity, 239, 239, reRun, listOfRowNumber, outputfilepath);
	}

}
