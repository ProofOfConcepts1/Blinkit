package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner1_1800 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 1, 1801, nykaaRunner1_1800.class.getSimpleName());
	}

}
