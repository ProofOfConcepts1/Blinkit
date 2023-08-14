package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyRunnerHyderabad81_160 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String outputfilepath = SwiggyRunnerHyderabad81_160.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 81, 100, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 101, 120, outputfilepath);
		} 
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 121, 140, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 141, 160, outputfilepath);
		} 
		catch (Exception e) {
		}
	}

}
