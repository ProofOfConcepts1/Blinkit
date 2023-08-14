package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner1801_3600 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFullDemo, "", "", 1, 130, nykaaRunner1801_3600.class.getSimpleName());
	}

}
