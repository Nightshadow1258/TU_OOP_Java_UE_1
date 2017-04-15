/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain.record;

public abstract class Record extends Object implements IRecord {

	// Attributes
	private long identifier;

	// Konstruktor
	public Record(long identifier) {
		this.identifier = identifier;
	}

	// Methoden
	public long getIdentifier() {
		return this.identifier;
	}

}
