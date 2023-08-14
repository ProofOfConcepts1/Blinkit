package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {426};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 26, 50, reRun, listOfRowNumber, outputfilepath);
		
	}

}
