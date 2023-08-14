package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEEEERunnerChennaiOthersMaharani {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyREEEEERunnerChennaiOthersMaharani.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 12, 12, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	}

}
