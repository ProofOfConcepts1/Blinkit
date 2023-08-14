package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner3100_3600 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 3100 , 3601, nykaaRunner3100_3600.class.getSimpleName());
	}

}
