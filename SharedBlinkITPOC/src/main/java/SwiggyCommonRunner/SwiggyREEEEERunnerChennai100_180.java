package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEEEERunnerChennai100_180 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyREEEEERunnerChennai100_180.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "",124, 124, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	
	}

}
