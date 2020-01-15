package Model;

import java.io.Serializable;

/**
 * A class that contains information about a product;
 * @author Daniela Crucerescu
 *
 */
public class Product implements Serializable{
	
	private String name;
	private String description;
	private String barcode;
	private double price;
	private Supplier supplier;
	private int amountToOrder;
	private int minAmount;
	private int daysToExpire;
	private double discount;
	
	/**
	 * 8-argument constructor;
	 * @param barcode
	 * @param name
	 * @param description
	 * @param price
	 * @param supplier
	 * @param amountToOrder
	 * @param minAmount
	 * @param daysToExpire
	 */
	public Product(String barcode,String name, String description, double price,
			Supplier supplier, int amountToOrder, int minAmount,  int daysToExpire) {
		super();
		this.daysToExpire = daysToExpire;
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.price = price;
		this.supplier = supplier;
		this.amountToOrder = amountToOrder;
		this.minAmount = minAmount;
	}
	/**
	 * 9-argument constructor
	 * @param barcode
	 * @param name
	 * @param description
	 * @param price
	 * @param supplier
	 * @param amountToOrder
	 * @param minAmount
	 * @param daysToExpire
	 * @param discount
	 */
	public Product(String barcode,String name, String description, double price,
			Supplier supplier, int amountToOrder, int minAmount,  int daysToExpire, double discount) {
		super();
		this.daysToExpire = daysToExpire;
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.price = price;
		this.supplier = supplier;
		this.amountToOrder = amountToOrder;
		this.minAmount = minAmount;
		this.discount = discount;
	}
	/**
	 * Gets discount;
	 * @return discount;
	 */
	public double getDiscount()
	{
		return discount;
	}
	
	/**
	 *Sets discount;
	 * @param discount discount
	 */
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}
	/**
	 * Gets product name;
	 * @return product name;
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set product name;
	 * @param name product name;
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets description;
	 * @return product description;
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets product description;
	 * @param description product description;
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the product price; 
	 * @return product price;
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets product price;
	 * @param price the price to be set;
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets product supplier;
	 * @return product supplier;
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * Sets product supplier;
	 * @param supplier supplier;
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	/**
	 * Gets amount to order of the product;
	 * @return amount to be ordered;
	 */
	public int getAmountToOrder() {
		return amountToOrder;
	}
	
	/**
	 * Sets amount to order of the product;
	 * @param amountToOrder amount to order;
	 */
	public void setAmountToOrder(int amountToOrder) {
		this.amountToOrder = amountToOrder;
	}
	
	/**
	 * Get minimum amount of the product;
	 * @return minimum amount of the product;
	 */
	public int getMinAmount() {
		return minAmount;
	}
	
	/**
	 * Sets minimum amount of the product;
	 * @param minAmount minimum amount;
	 */
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}
	
	/**
	 * Gets barcode of the product;
	 * @return barcode;
	 */
	public String getBarcode() {
		return barcode;
	}
	
	/**
	 * Sets the barcode of the product; 
	 * @param barcode the barcode;
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	/**
	 * Gets days to expire of the product;
	 * @return days to expire;
	 */
	public int getDaysToExpire() {
		return daysToExpire;
	}
	
	/**
	 * Sets the number of days to expire of the product;
	 * @param daysToExpire days to expire;
	 */
	public void setDaysToExpire(int daysToExpire) {
		this.daysToExpire = daysToExpire;
	}
	
	/**
	 * ToString method;
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description
				+ ", barcode=" + barcode + ", price=" + price + ", supplier="
				+ supplier + ", amountToOrder=" + amountToOrder
				+ ", minAmount=" + minAmount + ", daysToExpire=" + daysToExpire
				+ ", discount=" + discount + "]";
	}
	
	
}
