package domain;

import domain.product.*;

public class Test {

	public static void main(String[] args) throws DuplicateProductException {
		// TODO Auto-generated method stub

		Restaurant rest = new Restaurant ("Test"); 
		
		SimpleProduct product = new SimpleProduct("Käse", 10);
		
		rest.createTable("T5");
		System.out.println(rest.getSpecificTable("T5"));
		rest.addProduct(product);
		System.out.println(rest.);
	}

}
