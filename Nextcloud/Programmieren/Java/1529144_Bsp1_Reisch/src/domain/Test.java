package domain;

import domain.product.*;

public class Test {

	public static void main(String[] args) throws DuplicateProductException {
		// TODO Auto-generated method stub

		Restaurant rest = new Restaurant ("Test");
		
		SimpleProduct product = new SimpleProduct("Sp", 5);
		JointProduct jproduct = new JointProduct("Jp", 10);
		ExtendedProduct eproduct = new ExtendedProduct("Ep", 15);
		
		rest.addProduct(product);
		//System.out.println(rest.getProducts());
		rest.addProduct(rest.generateSimpleProducts());
		rest.addProduct(rest.generateJointProducts());

		Table tab1 = new Table("dfsfssf", 6);
		rest.createTable("T5");
		
		
		System.out.println(rest.getSpecificTable("T5"));
		//System.out.println(rest.getProducts());
		//System.out.println(product);
		System.out.print(tab1);
		
		System.out.println(rest.debugging(tab1, product));

		
		
	}

}
