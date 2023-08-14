package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEEEERunnerChennaiOthersJaya {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyREEEEERunnerChennaiOthersJaya.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 78, 79, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	}

}
