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
		lastState = new ExtendedProduct(this.name,this.price);
		this.name=name;
	}
	
	@Override
	public void setPrice(float price){
		lastState = new ExtendedProduct(this.name,this.price);
		this.price = price;
	}
	
	public String toString(){
		return "ExtendedProduct: [Name= " + this.name + ", Price= " + this.price + "]";
	}
	
	public boolean undo(){

		if(this.name != this.lastState.name) {
			System.out.println(1);
			this.name = this.lastState.name;
			return true;
		}
		else if(this.price != this.lastState.price){
			System.out.println(2);
			this.price = this.lastState.price;
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
