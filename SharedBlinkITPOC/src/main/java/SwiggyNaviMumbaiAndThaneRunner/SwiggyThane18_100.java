package SwiggyNaviMumbaiAndThaneRunner;

import Swiggy.SwiggyNaviMumbai;
import Swiggy.SwiggyThane;

public class SwiggyThane18_100 {
	
	public static void main(String[] args) {
		SwiggyThane swiggyThane = new SwiggyThane();
		
		swiggyThane.dataScrapping(40, 40, SwiggyThane18_100.class.getSimpleName());
		swiggyThane.dataScrapping(152, 152, SwiggyThane18_100.class.getSimpleName());
	}

}
