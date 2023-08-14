package CommonScrapper;

public class BBRunner {
	
	public static void main(String[] args) {
		
		BBCommonScrapper scrap = new BBCommonScrapper();
		
		scrap.dataScrapping(fileLocations.InputDataFilePathBBMumbai, "Chennai","",1, 1, BBRunner.class.getSimpleName());
	}

}
