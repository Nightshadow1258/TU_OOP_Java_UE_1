/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleProduct p1 = new SimpleProduct ("Burger", 5);
		//System.out.println("Product 1 :" + p1.getName() + p1.getPrice());
		System.out.println(p1.toString());
		SimpleProduct p3 = new SimpleProduct ("Burger2", 3);
		SimpleProduct p4 = new SimpleProduct ("Burger3", 10);
		
		JointProduct p2 = new JointProduct ("Menu_1", 15);
		p2.addProduct(p1);
		p2.addProduct(p3);
		p2.addProduct(p4);
		System.out.println(p2.toString());
		
	}

}
