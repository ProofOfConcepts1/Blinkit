package ZeptoRunnerHyderabadAndChennai;

import CommonScrapperUtitlity.fileLocations;
import Swiggy.SwiggyCommonScrapper;
import Zepto.ZeptoCommonScrapper;

public class ZeptoRunnerChennaiMoorthi81_243 {
	
	public static void main(String[] args) {
		ZeptoCommonScrapper z = new ZeptoCommonScrapper();
		
		String filePath = fileLocations.InputDataFilePathZeptoChennai;
		String InputLocation = "Medavakkam";
		String InputCity = null;
		String outputfilepath = ZeptoRunnerChennaiMoorthi81_243.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {2,5,8};
		
		z.dataScrapping(filePath, InputLocation, InputCity, 138, 138, reRun, listOfRowNumber, outputfilepath);
		z.dataScrapping(filePath, InputLocation, InputCity, 161, 161, reRun, listOfRowNumber, outputfilepath);
		z.dataScrapping(filePath, InputLocation, InputCity, 239, 239, reRun, listOfRowNumber, outputfilepath);
		//z.dataScrapping(filePath, InputLocation, InputCity, 201, 243, reRun, listOfRowNumber, outputfilepath);
	}

}
