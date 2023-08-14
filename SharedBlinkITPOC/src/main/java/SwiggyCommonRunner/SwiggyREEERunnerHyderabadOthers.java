package SwiggyCommonRunner;

import CommonScrapper.SwiggyCommonScrapper;
import CommonScrapper.fileLocations;

public class SwiggyREEERunnerHyderabadOthers {
	
	public static void main(String[] args) {
		SwiggyCommonScrapper swiggy = new SwiggyCommonScrapper();
		String filePath = fileLocations.InputDataFilePathSwiggyHyderabad;
		String outputfilepath = SwiggyREEERunnerHyderabadOthers.class.getSimpleName();
		
		try {
			swiggy.dataScrapping(filePath, "Hyderabad", "", 66, 66, outputfilepath);
		} 
		
		catch (Exception e) {
		}
	}

}
