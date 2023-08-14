package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner35_50 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner35_50.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {425};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 35, 50, reRun, listOfRowNumber, outputfilepath);
		
	}

}
