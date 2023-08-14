package bbDehradun;

import BigBasket.BBCommonScrapperDehradunNew;
import CommonScrapperUtitlity.fileLocations;

public class dehradunRunner401_436 {
	
	public static void main(String[] args) {
		BBCommonScrapperDehradunNew b = new BBCommonScrapperDehradunNew();
		
		String filePath = fileLocations.InputDataFilePathBBDehradun;
		String InputLocation = "DehraDun";
		String InputCity = "";
		String outputfilepath = dehradunRunner401_436.class.getSimpleName();
		boolean reRun = true;
		Integer[] listOfRowNumber = {424};
		
		b.dataScrapping(filePath, InputLocation, InputCity, 401, 436, reRun, listOfRowNumber, outputfilepath);
		
	}

}
