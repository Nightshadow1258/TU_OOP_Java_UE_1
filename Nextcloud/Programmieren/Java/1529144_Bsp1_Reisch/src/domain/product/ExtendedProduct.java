/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

public class ExtendedProduct extends SimpleProduct {

	private ExtendedProduct lastState;
	
	//Konstruktors:
	public ExtendedProduct(String name, float price){
		super(name, price); //super verwendet den Konstruktor Körper von der Superklasse
	}
	
	public ExtendedProduct(ExtendedProduct product){
		super(product.name, product.price);
		
	}
	
	@Override
	public void setName(String name){
		lastState.setName(name);
		this.setName(name);
	}
	
	@Override
	public void setPrice(float price){
		this.setPrice(price);
	}
	
	public String toString(){
		return "ExtendedProduct: [Name= " + this.name + ", Price= " + this.name + "]";
	}
	
	public boolean undo(){
// not done
		if(this.name != this.lastState.name) {
			this.setName(this.lastState.name);
			return true;
		}
		if(this.price != this.lastState.price){
			this.setPrice(this.lastState.price);
			return true;
		}
		else
			return false;
	}
	
	@Override
	public ExtendedProduct deepCopy(){
		return new ExtendedProduct(name,price);
	}
	
}
