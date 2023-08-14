package Swiggy;

public class demo {
	
	public static void main(String[] args) {
		
		String data = "store-product-fb946de1-3bd5-47f3-890c-a962791c1432";
		
		String[] newdata = data.split("store-product-");
		data = newdata[1];
		
		System.out.println(data);
	}

}
