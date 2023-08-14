package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner251_300 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner251_300.class.getSimpleName();
		boolean reRun = false;
		Integer[] listOfRowNumber = {14,61,92};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 251, 300, reRun, listOfRowNumber, outputfilepath);
		
	}

}
