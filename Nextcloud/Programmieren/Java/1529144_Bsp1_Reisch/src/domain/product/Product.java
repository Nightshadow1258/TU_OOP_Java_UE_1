/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

public abstract class Product extends Object implements IProduct{

	//Attribute:
	protected float price;
	protected String name;
	
	//Konstruktoren:
	public Product(String name){
		if(name == null)
			this.name= "";
		else
			this.name = name;
		
		this.price = 0;
	}
	
	public Product(String name, float price){
		if(name == null)
			this.name= "";
		else
			this.name = name;
		
		this.price = price;
	}
	
	//Methoden:
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	public void setPrice(float price) throws IllegalArgumentException{
		this.price = price;
	}
	
	public String toString(){
		return "Product: [Name= " + this.name + ", Price= " + this.price + "]";
	}

	@Override
	public final boolean equals(Object obj){
		//Indicates whether some other object is "equal to" this one.
		if (obj instanceof Product) {
	        return true;
	    }
		else
			return false;
		
		/*Alternative:
		 * 
		 * Table t;
		 * t= (Table) obj;
		 * if(table.id == this.id)
		 *	return true;
		 *  else
		 *  return false;
		 */
	}
	
	public abstract Product deepCopy();

	
	
	
	
	
	
	
	
	
	
}
