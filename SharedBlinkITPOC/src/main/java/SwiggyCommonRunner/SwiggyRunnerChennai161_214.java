package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyRunnerChennai161_214 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyChennai;
		String outputfilepath = SwiggyRunnerChennai161_214.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 161, 180, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 181, 200, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Chennai", "", 201, 214, outputfilepath);
		} 
		catch (Exception e) {
		}
//		try {
//			swiggy.dataScrapping(filePath, "Chennai", "", 141, 160, outputfilepath);
//		} 
//		catch (Exception e) {
//		}
	}

}
