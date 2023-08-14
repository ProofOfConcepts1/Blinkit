package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner1000_1800 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 1000, 1800, nykaaRunner1000_1800.class.getSimpleName());
	}

}
