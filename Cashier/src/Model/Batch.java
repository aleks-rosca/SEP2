package Model;

import java.io.Serializable;

/**
 * A class that contains information about a batch;
 * @author Dima
 *
 */
public class Batch implements Serializable{
	
	private Product product;
	private int amount;
	private String expireDate;
	private int orderId;
	
	/**
	 * 4 - arguments constructor
	 * @param product
	 * @param amount
	 * @param expireDate
	 * @param orderid
	 */
	public Batch(Product product, int amount, String expireDate, int orderid) {
		super();
		this.product = product;
		this.amount = amount;
		this.expireDate = expireDate;
		this.orderId = orderid;
	}
	/**
	 * Gets the product
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Sets the product
	 * @param product the products
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * Gets amount of products
	 * @return amount of products
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Sets amount of products
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets expire date;
	 * @return expire date
	 */
	public String getExpireDate() {
		return expireDate;
	}
	
	/**
	 * Sets expire date;
	 * @param expireDate the expire date
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	/**
	 * Gets order id;
	 * @return order id;
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * Sets order id;
	 * @param orderId order id;
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * ToString method;
	 */
	@Override
	public String toString() {
		return "Batch [product=" + product + ", amount=" + amount
				+ ", expireDate=" + expireDate + ", orderId=" + orderId + "]";
	}
	
	
}
