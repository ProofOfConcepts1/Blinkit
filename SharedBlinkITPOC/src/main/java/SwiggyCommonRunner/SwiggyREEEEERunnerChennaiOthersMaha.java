	package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEEEERunnerChennaiOthersMaha {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyREEEEERunnerChennaiOthersMaha.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 39, 39
					, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	}

}
