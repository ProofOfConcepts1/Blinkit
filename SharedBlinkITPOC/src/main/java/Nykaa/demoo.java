package Nykaa;

public class demoo {
	
	public static void main(String[] args) {
		
		String productCode = "https://www.nykaa.com/lakme-nail-colour-remover-with-vitamin-e/p/1157?productId=1157&pps=1";
		
		String qty = "Lakme Eyeconic Kajal - Classic Brown\r\n"
				+ "(0.35g)";
		
		ProductDetailsScrapping2 pds = new ProductDetailsScrapping2();
		productCode = pds.productCodeReturn(productCode,"/p/", "\\?");
		qty = pds.productCodeReturn(qty, "\\(", "\\)");
		System.out.println(productCode);
		System.out.println(qty);
	}

}
