
/*
 * Name: Paul Reisch
 * Matrikelnummer: 1529144
 */

package domain;

import domain.product.IProduct;

public class DuplicateProductException extends Exception {

	private static final long serialVersionUID = 1L;

	private IProduct duplicateproduct;

	public DuplicateProductException(IProduct product) {
		this.duplicateproduct = product;
	}

	public String getMessage() {
		return "Product " + duplicateproduct.getName() + " already exists!";
	}

}
