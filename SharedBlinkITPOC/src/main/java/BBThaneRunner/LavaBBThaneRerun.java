package BBThaneRunner;

import BigBasket.BigBasketThane;

public class LavaBBThaneRerun {
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(220,220 , RerunThaneBB.class.getSimpleName());
		//bbThane.dataScrapping(338,338 , RerunThaneBB.class.getSimpleName());
		//bbThane.dataScrapping(443,443 , RerunThaneBB.class.getSimpleName());
	}


}
