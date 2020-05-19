package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();
    private static int nextNumber = 0;
    private final int number = ++nextNumber;
    private String productList = "Numer faktury: " + Integer.toString(number) + System.lineSeparator();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        else if(products.containsKey(product)) {
        	products.put(product, products.get(product)+1);
        }
        else {
        	products.put(product, quantity);
        }
        
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getNumber() {
        return number;
    }
    
    public Map<Product, Integer> getProducts() {
        return products;
    }
    
    public String getProductList() {
    	int counter = 0;
    	for (Map.Entry<Product, Integer> entry : products.entrySet()) {
    		counter++;
    	    Product key = entry.getKey();
    	    Integer value = entry.getValue();
    	    String line = key.getName() + " " + key.getPrice().toString() + " " + Integer.toString(value) + System.lineSeparator();
    	    productList += line;
    	}
    	productList += "Liczba pozycji: " + Integer.toString(counter);
    	return productList;
    }
}
