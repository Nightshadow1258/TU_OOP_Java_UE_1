/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import domain.product.IProduct;
import domain.product.Product;
import domain.Table;
import domain.Order;

public class Restaurant {
	
	//Attribute
	private String rest_name;
	private List<IProduct> Li_Pro = new ArrayList<IProduct>();
	private List<Table> Li_Tab = new ArrayList<Table>();
	private List<Order> Li_Ord = new ArrayList<Order>();
	private int Orderid = 0;
	
	//Konstruktor
	Restaurant(String name){
		this.rest_name = name;
	}
	
	//Methoden
	public String getName(){
		return this.rest_name;
	}
	
	public boolean createTable(String tableIdentifier){
		for( Iterator<Table> iterator = this.Li_Tab.iterator(); iterator.hasNext(); ){
			if(iterator.next().getTableIdentifier() == tableIdentifier)
				return false;
			}
				Li_Tab.add(new Table(tableIdentifier));
				return true;
	}	

	public Table getSpecificTable(String identifier){
		for( Iterator<Table> iterator = this.Li_Tab.iterator(); iterator.hasNext(); ){
				Table t = iterator.next();
				if(t.getTableIdentifier() == identifier)
					return t;
			}
	return null;
	}

	public boolean addProduct(IProduct product) throws DuplicateProductException{
		if(product == null)
			return false;
		for( Iterator<IProduct> iterator = this.Li_Pro.iterator(); iterator.hasNext(); ){
			IProduct Ip = iterator.next();
			if(Ip.equals(product)){
				return false;
			}
		}
		Li_Pro.add(product);
		return true;
	}

	public boolean addProduct(Collection<IProduct> products) throws DuplicateProductException{		
		
		for(Iterator<IProduct> iterator = products.iterator(); iterator.hasNext(); ){
			 IProduct Ip = iterator.next();
			 if(Ip==null)
				continue;
			if(this.Li_Pro.equals(Ip))
					continue;
			if(!this.Li_Pro.equals(Ip)){
			Li_Pro.add(Ip);
			return true;
			}
		}
		return false;
	}

	public List<IProduct> getProducts(){
	/*Returns a list of copies of all IProducts in the assortment.
	Returns:
	a list of IProducts
	*/
	return this.Li_Pro; 
	}

	public boolean orderProductForTable(Table table, IProduct product){
		return false;
	}




}