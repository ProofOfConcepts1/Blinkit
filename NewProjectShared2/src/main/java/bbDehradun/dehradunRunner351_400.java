package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner351_400 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner351_400.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {422};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 351, 400, reRun, listOfRowNumber, outputfilepath);
		
	}

}
