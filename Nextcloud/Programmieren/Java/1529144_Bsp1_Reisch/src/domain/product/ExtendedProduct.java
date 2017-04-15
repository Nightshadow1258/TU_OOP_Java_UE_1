/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

public class ExtendedProduct extends SimpleProduct {

	private ExtendedProduct lastState;

	// Konstruktors:
	public ExtendedProduct(String name, float price) {
		super(name, price); // super verwendet den Konstruktor Körper von der
							// Superklasse
	}

	public ExtendedProduct(ExtendedProduct product) {
		super(product.name, product.price);

	}

	@Override
	public void setName(String name) {
		lastState = new ExtendedProduct(this.name, this.price);
		this.name = name;
	}

	@Override
	public void setPrice(float price) throws IllegalArgumentException{
		lastState = new ExtendedProduct(this.name, this.price);
		if(price<0)
			throw new IllegalArgumentException("Preis kleiner als 0");
		else
			this.price = price;
	}

	public String toString() {
		return "ExtendedProduct: [Name= " + this.name + ", Price= " + this.price + "]";
	}

	public boolean undo() {

		if (this.lastState == null)
			return false;

		else if (this.name != this.lastState.name) {
			this.name = this.lastState.name;
			return true;
		} else if (this.price != this.lastState.price) {
			this.price = this.lastState.price;
			return true;
		} else
			return false;
	}

	@Override
	public ExtendedProduct deepCopy() {
		return new ExtendedProduct(name, price);
	}

}
