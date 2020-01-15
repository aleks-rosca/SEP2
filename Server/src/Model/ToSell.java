package Model;

import java.io.Serializable;

/**
 * A class that contains information about one product from the receipt; 
 * @author Dima
 *
 */
public class ToSell implements Serializable{
	
	private Product product;
	private double  amount;
	
	/**
	 * 2-argument constructor;
	 * @param product Product 
	 * @param amount Amount
	 */
	public ToSell(Product product, double amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	
	/**
	 * Gets product;
	 * @return Product object;
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Sets product;
	 * @param product Product object
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * Gets amount;
	 * @return amount;
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Sets amount;
	 * @param amount amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Get total price : amount * products price;
	 * @return total price for a specific product;
	 */
	public double getTotalPrice()
	{
		return amount*product.getPrice();
	}
	
	/**
	 * ToString method;
	 */

}
