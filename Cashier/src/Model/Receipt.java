package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 * A class containing information about a recepit;
 * @author Alexandru
 *
 */
public class Receipt extends Observable implements Serializable{
	
	private ArrayList<ToSell> products;
	
	
	/**
	 * Non-argument constructor;
	 */
	public Receipt()
	{
		products = new ArrayList<ToSell>();
	}
	
	/**
	 * Adds a product to the receipt;
	 * @param product the product to be added;
	 */
	public void addProduct(ToSell product)
	{
		products.add(product);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Gets an array list with all products from the receipt;
	 * @return array list of products;
	 */
	public ArrayList<ToSell> getProducts()
	{
		return products;
	}
	
	/**
	 * Gets total amount to be paid by the costumer;
	 * @return total price;
	 */
	public String getTotal()
	{
		double  res = 0;
		
		for(int i = 0; i < products.size(); i++)
			res += products.get(i).getTotalPrice();
				
		return Double.toString(res);
	}
	
	/**
	 * Remove a product from the receipt;
	 * @param product the product to be removed;
	 */
	public void removeProduct(ToSell product)
	{
		products.remove(product);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Remove all the products from the receipt;
	 */
	public void empty()
	{
		products.clear();
	}

	/**
	 * ToString method;
	 */
	@Override
	public String toString() {
		return "Receipt [products=" + products + "]";
	}
	
	
}
