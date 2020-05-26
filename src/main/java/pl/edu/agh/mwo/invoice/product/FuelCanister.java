
package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product {
	
    public FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }
    
    public BigDecimal getPriceWithTax() {
    	if (currentDate.getDayOfMonth() == 26 || currentDate.getMonthValue() == 4) {
    		return super.getPriceWithTax();
    	}
    	else {
    		return super.getPriceWithTax().add(new BigDecimal("5.56"));
    	}
    }

}
