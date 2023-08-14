package SwiggyNaviMumbaiAndThaneRunner;

import Swiggy.SwiggyNaviMumbai;

public class SwiggyNaviMumbai1_100 {
	
	public static void main(String[] args) {
		SwiggyNaviMumbai SwiggyNaviMumbai = new SwiggyNaviMumbai();
		
		SwiggyNaviMumbai.dataScrapping(1, 100, SwiggyNaviMumbai1_100.class.getSimpleName());
	}

}
