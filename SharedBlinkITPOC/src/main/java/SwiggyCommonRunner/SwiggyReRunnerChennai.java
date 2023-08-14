package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyReRunnerChennai {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyReRunnerChennai.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 1, 20, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	}

}
