package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner201_250 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner201_250.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {422};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 201, 250, reRun, listOfRowNumber, outputfilepath);
		
	}

}