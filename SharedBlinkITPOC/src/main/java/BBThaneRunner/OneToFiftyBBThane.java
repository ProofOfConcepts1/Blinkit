   package BBThaneRunner;

import BigBasket.BigBasketThane;

public class OneToFiftyBBThane {
	
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(1, 50, OneToFiftyBBThane.class.getSimpleName());
	}

}


