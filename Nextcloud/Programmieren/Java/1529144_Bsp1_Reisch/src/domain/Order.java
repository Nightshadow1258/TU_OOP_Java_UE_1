/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.product.IProduct;
import domain.record.Record;
import ict.basics.IDeepCopy;


public class Order extends Record implements IDeepCopy{
	
	protected Table table;	
	protected List<IProduct> products = new ArrayList<IProduct>();
	protected OrderState status;
	
	public Order(long identifier, Table table, List<IProduct> products){
		super(identifier);
		this.table = table;
		this.products.addAll(products);
	}
		
	//Methoden
	public List<IProduct> getProducts(){

		List<IProduct> copies = new ArrayList<IProduct>();

		for (Iterator<IProduct> iterator = this.products.iterator(); iterator.hasNext();) {
			IProduct buffer = iterator.next();
			copies.add( (IProduct) buffer.deepCopy());
		}
		return copies;
	}
	
	public boolean setState(OrderState newStatus){
		if(this.status != OrderState.PAID && this.status != OrderState.CANCELLED){
			
			this.status=newStatus;
			return true;
		}
		else
			return false;
	}
	
	public boolean isCancelled(){
		if(this.status == OrderState.CANCELLED)		
			return true;
		else
			return false;
	}
	
	public boolean isPaid(){
		if(this.status == OrderState.PAID)		
			return true;
		else
			return false;
	}
	
	public Table getTable(){
		return this.table;
	}
	
	public Order deepCopy() {
	Order copy = new Order(this.getIdentifier(), this.getTable(), this.getProducts());
	copy.setState(this.status);
	return copy;
	}
	
	public boolean equals(Object obj){

		if (obj instanceof Order) {
			Order O = (Order) obj;
			if( O.getIdentifier() == this.getIdentifier() && O.getTable() == this.table && O.status == this.status)
			{
				
				if(this.products.containsAll(O.products) && O.products.containsAll(this.products))		
					return true;
				else 
					return false;
			}
			else
				return false;
			}
		else
			return false;
	}
}
