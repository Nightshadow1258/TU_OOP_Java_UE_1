/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain;

public class Table extends Object {

	//An identifier as text
	//The number of seats
	protected String identifier;
	protected int seats;
	
	//Konstruktor
	public Table(String id){
		this.identifier = id;
		this.seats = 2;
	}
	
	public Table(String id, int seats){
		this.identifier = id;
		this.seats = seats;
	}
	
	public int getSeatCount(){
		return this.seats;
	}		
	
	public String getTableIdentifier(){
		return this.identifier;
	}
	
	@Override
	public String toString(){
		return "Table: [ID= " + this.identifier + ", Sitzanzahl= " + this.seats +"]";
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Table) {
	        return true;
	    }
		else
			return false;
	}
	
}
