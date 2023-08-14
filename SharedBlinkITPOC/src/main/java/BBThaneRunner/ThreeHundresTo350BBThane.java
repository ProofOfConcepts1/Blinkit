package BBThaneRunner;

import BigBasket.BigBasketThane;

public class ThreeHundresTo350BBThane {
	
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(301, 350, ThreeHundresTo350BBThane.class.getSimpleName());
	}

}
