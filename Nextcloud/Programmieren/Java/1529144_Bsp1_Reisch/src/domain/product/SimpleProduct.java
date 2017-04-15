/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

public class SimpleProduct extends Product {

	// Konstruktoren:
	public SimpleProduct(String name, float price) {
		super(name, price); // super verwendet den Konstruktor Körper von der
							// Superklasse
	}

	@Override
	public Product deepCopy() {
		return new SimpleProduct(name, price);
	}

}
