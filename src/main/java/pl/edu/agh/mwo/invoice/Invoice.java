package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.Product;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
	private Map<Product, Integer> products = new HashMap<>();
	

	public void addProduct(Product product) {
		this.addProduct(product, 1);
	}
	
	public void addProduct(Product product, Integer quantity) {
		if (quantity <= 0){
			throw new IllegalArgumentException("Product quantity cannot be null or negative");
		}
		this.products.put(product, quantity);
	}

	public BigDecimal getNetPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		 
		for(Product product : this.products.keySet()) {
			Integer quantity = this.products.get(product);
			sum = sum.add(product.getPrice().multiply(new BigDecimal(quantity)));
		}
		return sum;
	}

	public BigDecimal getTax() {
		return this.getGrossPrice().subtract(this.getNetPrice());
	}

	public BigDecimal getGrossPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		
		for(Product product : this.products.keySet()) {
			Integer quantity = this.products.get(product);
			sum = sum.add(product.getPriceWithTax().multiply(new BigDecimal(quantity)));
		}
		return sum;
	}
}
