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
import domain.product.JointProduct;
import domain.product.Product;
import domain.product.SimpleProduct;
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
	List<IProduct> list = new ArrayList<IProduct>();
	
	for( Iterator<IProduct> iterator = this.Li_Pro.iterator(); iterator.hasNext(); ){
		list.add(iterator.next());
	}
		return list; 
	}

	public boolean orderProductForTable(Table table, IProduct product){
		if( table!=null || product != null)
			return false;
		else if(this.Li_Pro.contains(product) && !this.Li_Tab.contains(table)){
			List<IProduct> list = new ArrayList<IProduct>();
			list.add(product);
			Order newOrder = new Order(this.Orderid++ , table ,  list);
			Li_Ord.add(newOrder);
			return true;
		}
		return false;
	}

	public boolean orderProductForTable(Table table, IProduct product, int count){
		if( table!=null || product != null || count != 0)
			return false;
		else if(this.Li_Pro.contains(product) && !this.Li_Tab.contains(table)){
			List<IProduct> list = new ArrayList<IProduct>();
			list.add(product);
			Order newOrder = new Order(this.Orderid++ , table ,  list);
			Li_Ord.add(newOrder);
			return true;
		}
		return false;
	}

	public boolean containsProduct(IProduct compareProduct){
		
		if(this.Li_Pro.contains(compareProduct))
			return true;
		
		else
			return false;
	}
	
	public IProduct findProduct(String productName){
		for( Iterator<IProduct> iterator = this.Li_Pro.iterator(); iterator.hasNext();){
			IProduct element = iterator.next();
		if(element.getName().equals(productName))
			return element;
		}
			return null;	
	}

	public static List<IProduct> generateSimpleProducts(){
		List<IProduct> simpleprod = new ArrayList<IProduct>();
		simpleprod.add(new SimpleProduct("Hamburger", (float) 7.90));
		simpleprod.add(new SimpleProduct("Schnitzel", (float) 8.90));
		simpleprod.add(new SimpleProduct("Bernerwürstel", (float) 6.90));
		simpleprod.add(new SimpleProduct("Pommes", (float) 2.90));
		simpleprod.add(new SimpleProduct("Salat", (float) 3.90));
		
		return simpleprod;
	}

	public static List<IProduct> generateJointProducts(){
		
		List<IProduct> jointprod = new ArrayList<IProduct>();	
		List<Product> hp1 = new ArrayList<Product>();
		List<Product> hp2 = new ArrayList<Product>();
		List<Product> hp3 = new ArrayList<Product>();

		//Vorspeisen:
		SimpleProduct vs1 = new SimpleProduct("Gulaschsuppe", (float) 3.90);
		SimpleProduct vs2 = new SimpleProduct("Frittatensuppe", (float) 2.90);
		SimpleProduct vs3 = new SimpleProduct("gemischter Salat", (float) 3.40);

		
		//Hauptspeisen:
		SimpleProduct shp1 = new SimpleProduct("Hamburger", (float) 7.90);
		SimpleProduct shp2 = new SimpleProduct("Schnitzel", (float) 8.90);
		SimpleProduct shp3 = new SimpleProduct("Bernerwürstel", (float) 6.90);
		//SimpleProduct shp4 = new SimpleProduct("Chicken-Sandwich", (float) 4.90);
		
		//Beilagen:
		SimpleProduct bl1 = new SimpleProduct("Pommes", (float) 1.09);
		SimpleProduct bl2 = new SimpleProduct("Salat", (float) 1.09);
		//SimpleProduct bl3 = new SimpleProduct("Kartoffelpuffer", (float) 1.59);
		
		//Getränke:
		SimpleProduct g1 = new SimpleProduct("Apfelsaft", (float) 1.90);
		SimpleProduct g2 = new SimpleProduct("Orangensaft", (float) 1.90);
		//SimpleProduct g3 = new SimpleProduct("Tee", (float) 2.90);

		//Hauptspeisen-kombo:
		hp1.add(shp1);
		hp1.add(bl1);
		hp1.add(g1);
		JointProduct jp1 = new JointProduct("Hamburger und Pommes", 5, hp1);
		
		hp2.add(shp2);
		hp2.add(bl1);
		hp2.add(bl2);
		hp2.add(g2);
		JointProduct jp2 = new JointProduct("Schnitzel mit Pommes und Salat", 5, hp2);
		
		hp3.add(shp3);
		hp2.add(bl1);
		hp1.add(g1);
		JointProduct jp3 = new JointProduct("Bernerwürstel mit Pommes", 5, hp2);

		
		//Nachspeisen:
		SimpleProduct ns1 = new SimpleProduct("Chocolademousse", (float) 2.50);
		SimpleProduct ns2 = new SimpleProduct("Sachertorte", (float) 3.50);
		SimpleProduct ns3 = new SimpleProduct("Kaiserschmarrn", (float) 2.90);

		JointProduct jpl1 = new JointProduct("Menü 1", 5); jpl1.addProduct(jp1); jpl1.addProduct(vs1); jpl1.addProduct(ns1);
		JointProduct jpl2 = new JointProduct("Menü 2", 5); jpl2.addProduct(jp2); jpl2.addProduct(vs2); jpl2.addProduct(ns2);
		JointProduct jpl3 = new JointProduct("Menü 3", 5); jpl3.addProduct(jp3); jpl3.addProduct(vs3); jpl3.addProduct(ns3);
		
		jointprod.add(jpl1); 
		jointprod.add(jpl2); 
		jointprod.add(jpl3); 
		return jointprod;
	}

	public static void main(String[] args){
		
		Restaurant rest1 = new Restaurant("Test_Restaurant");
		System.out.println(rest1.generateJointProducts());
	}

	
	
}