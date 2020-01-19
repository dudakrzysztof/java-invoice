package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private HashMap<Product, Integer> products;

	public void addProduct(Product product) {
		
	}
	
	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}

	public BigDecimal getNetPrice() {
		return BigDecimal.ZERO;
	}

	public BigDecimal getTax() {
		return BigDecimal.ZERO;
	}

	public BigDecimal getGrossPrice() {
		return BigDecimal.ZERO;
	}
}
