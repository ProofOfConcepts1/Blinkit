package ZeptoThaneAndNaviMumbaiRunner;

import Zepto.ZeptoThane;

public class ScrapedFileRerunThane {
	public static void main(String[] args) {

		ZeptoThane zeptoThane = new ZeptoThane();

		zeptoThane.dataScrapping(141, 141, ScrapedFileRerunThane.class.getSimpleName());
		zeptoThane.dataScrapping(78, 78, ScrapedFileRerunThane.class.getSimpleName());
		
	}

}
