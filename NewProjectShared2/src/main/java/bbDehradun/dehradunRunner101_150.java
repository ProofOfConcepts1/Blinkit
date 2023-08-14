package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner101_150 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner101_150.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {82};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 101, 150, reRun, listOfRowNumber, outputfilepath);
		
	}

}
