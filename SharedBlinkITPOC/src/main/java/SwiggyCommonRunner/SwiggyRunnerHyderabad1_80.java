package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyRunnerHyderabad1_80 {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String outputfilepath = SwiggyRunnerHyderabad1_80.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 151, 155, outputfilepath);
		} 
		
		catch (Exception e) {
		}
		
	}

}
