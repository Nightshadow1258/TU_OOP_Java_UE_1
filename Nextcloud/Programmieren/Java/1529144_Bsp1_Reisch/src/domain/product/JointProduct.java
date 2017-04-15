/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JointProduct extends Product {

	// Attribute
	private float discountpercentage;
	private Collection<Product> Liste = new ArrayList<Product>();

	// Konstruktor
	public JointProduct(String name, float discountpercentage) {
		super(name); // verwendet den Konstruktor von der Superklasse als Basis
		this.discountpercentage = discountpercentage;
	}

	public JointProduct(String name, float discountPercentage, Collection<Product> products) {
		super(name);

		if (discountPercentage >= 0 && discountPercentage <= 100)
			this.discountpercentage = discountPercentage;

		else if (discountpercentage < 0)
			this.discountpercentage = 0;

		else if (discountpercentage > 0)
			this.discountpercentage = 100;

		if (products != null && !products.isEmpty())
			Liste.addAll(products);
	}

	// Methoden
	public void addProduct(Product product) {
		Liste.add(product);
	}

	public boolean removeProduct(Product product) {
		if (Liste.contains(product)) {
			Liste.remove(product);
			return true;
		} else
			return false;
	}

	public Collection<Product> getProducts() {
		return Liste;
	}

	public float getPrice() {

		float p = 0;

		for (Iterator<Product> iterator = this.Liste.iterator(); iterator.hasNext();) {
			p = p + iterator.next().price;
		}
		p = p * (100 - this.discountpercentage) / 100;
		return p;
	}

	public String toString() {

		// return "JointProduct: [Name= " + this.name + ", Price= " +
		// this.getPrice() + ", Discount: " + this.discountpercentage + "]";
		String s = "JointProduct [Name: " + this.name + ", Price: " + this.getPrice() + "," + "Discount Percentage: "
				+ this.discountpercentage + ", Liste: " + Liste + "]";
		return s;
	}

	@Override
	public Product deepCopy() {
		return new JointProduct(this.name, this.price, this.Liste);
	}

}
