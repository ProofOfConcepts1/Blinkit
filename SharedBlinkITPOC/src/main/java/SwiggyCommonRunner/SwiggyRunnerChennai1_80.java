package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyRunnerChennai1_80 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyRunnerChennai1_80.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 1, 20, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 21, 40, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 41, 60, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 61, 80, outputfilepath);
		} 
		catch (Exception e) {
		}
	}

}
