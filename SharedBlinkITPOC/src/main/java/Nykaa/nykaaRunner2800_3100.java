package Nykaa;

import CommonScrapper.fileLocations;

public class nykaaRunner2800_3100 {
	
	public static void main(String[] args) {
		nykaaScrapper ns = new nykaaScrapper();
		
		ns.dataScrapping(fileLocations.InputDataFilePathNykaaFull, "", "", 2800, 3100, nykaaRunner2800_3100.class.getSimpleName());
	}

}
