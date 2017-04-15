/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.product;

// IDeepCopy muss vom anderem Packet importiert werden
import ict.basics.IDeepCopy;

/* Angabe:
 * Dieses Package definiert ein Interface die f�r Klassen festlegt, dass Kopien Ihrer 
 * Objekte erstellt werden k�nnen.
 * 
 * Interfaces enthalten nur:
 * Konstanten 
 * Methodendeklarationen
*/

public interface IProduct extends IDeepCopy {

	// Methoden nur Deklartationen im Interface
	public String getName();

	float getPrice();

}
