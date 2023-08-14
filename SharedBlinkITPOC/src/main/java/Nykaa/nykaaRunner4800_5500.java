package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner4800_5500 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 4800, 5600, nykaaRunner4800_5500.class.getSimpleName());
	}
	
	

}
