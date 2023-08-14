package BBThaneRunner;

import BigBasket.BigBasketThane;

public class RerunThaneBB {
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(220,220 , RerunThaneBB.class.getSimpleName());
//		bbThane.dataScrapping(217,217 , RerunThaneBB.class.getSimpleName());
//		bbThane.dataScrapping(225,225 , RerunThaneBB.class.getSimpleName());
	}

   
}
