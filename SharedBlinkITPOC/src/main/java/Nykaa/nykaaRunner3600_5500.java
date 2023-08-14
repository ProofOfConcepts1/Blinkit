package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner3600_5500 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 3600, 5600, nykaaRunner3600_5500.class.getSimpleName());
	}
	
	

}
