package BBThaneRunner;

import BigBasket.BigBasketThane;

public class FiftyToHundredBBThane {
	
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(51,100, FiftyToHundredBBThane.class.getSimpleName());
	}

}
