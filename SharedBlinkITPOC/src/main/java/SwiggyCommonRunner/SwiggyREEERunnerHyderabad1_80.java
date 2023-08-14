package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEERunnerHyderabad1_80 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String outputfilepath = SwiggyREEERunnerHyderabad1_80.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 11, 20, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 1, 1, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 40, 60, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 61, 80, outputfilepath);
		} 
		catch (Exception e) {
		}
	}

}
