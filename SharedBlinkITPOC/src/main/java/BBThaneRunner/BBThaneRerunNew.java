package BBThaneRunner;

import BigBasket.BigBasketThane;

public class BBThaneRerunNew {
	public static void main(String[] args) {
		BigBasketThane bbThane = new BigBasketThane();
		bbThane.dataScrapping(56,56 , RerunThaneBB.class.getSimpleName());
		bbThane.dataScrapping(407,417 , RerunThaneBB.class.getSimpleName());
//		bbThane.dataScrapping(309,309 , RerunThaneBB.class.getSimpleName());
	}

}
