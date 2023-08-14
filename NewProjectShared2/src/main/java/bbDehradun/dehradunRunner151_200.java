package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner151_200 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner151_200.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {63,82,86};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 151, 200, reRun, listOfRowNumber, outputfilepath);
		
	}

}
