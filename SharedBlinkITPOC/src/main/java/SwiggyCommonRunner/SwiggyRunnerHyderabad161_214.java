package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyRunnerHyderabad161_214 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String outputfilepath = SwiggyRunnerHyderabad161_214.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 161, 180, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 181, 200, outputfilepath);
		} 
		catch (Exception e) {
		}
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 201, 214, outputfilepath);
		} 
		catch (Exception e) {
		}
//		try {
//			swiggy.dataScrapping(filePath, "Hyderabad", "", 141, 160, outputfilepath);
//		} 
//		catch (Exception e) {
//		}
	}

}
