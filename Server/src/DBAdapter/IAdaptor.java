package DBAdapter;

import java.rmi.RemoteException;
import java.sql.SQLException;

import Model.Batch;
import Model.Product;
import Model.Receipt;
import Model.Supplier;

/**
 * The interface for the Adaptor. The Adaptor allows reading and writing to the
 * database
 * 
 * @author 
 */
public interface IAdaptor {
	
	/**
	 * Adds a new batch into the database;
	 * @param batch the batch to be added;
	 * @throws SQLException
	 */
	public void addNewBatch(Batch batch) throws SQLException;
	
	/**
	 * Adds a new supplier into the database
	 * @param supplier
	 * @throws SQLException
	 */
	public void addNewSupplier(Supplier supplier) throws SQLException;
	
	/**
	 * Gets supplier id from the database that matches given supplier;
	 * @param supplier given supplier;
	 * @return a String object that contains supplier id
	 * @throws SQLException
	 */
	public String getSupplierId(Supplier supplier) throws SQLException;
	
	/**
	 * Gets a product by barcode from the database;
	 * @param barcode barcode of the product;
	 * @return a product object that matches given product;
	 * @throws SQLException
	 */
	public Product getProductByBarcode(String barcode) throws SQLException;
	
	/**
	 * Gets all products from the database;
	 * @return an array of Product object that contains all the products;
	 * @throws SQLException
	 */
	public Product[] getAllProducts() throws SQLException;
	
	/**
	 * Remove the amount of products from the stock which are in the receipt object;
	 * @param receipt Given receipt from the cashier;
	 * @throws SQLException
	 */
	public void removeFromStock(Receipt receipt) throws SQLException;
	
	/**
	 * Search for products that matches given information
	 * @param barcode products barcode;
	 * @param name products name;
	 * @param supplier supplier;
	 * @param description key words from the description;
	 * @return an array of Product object that matches given information;
	 * @throws SQLException
	 */
	public Product[] searchProducts(String barcode, String name, String supplier, String description) throws SQLException;
	
	/**
	 * Gets all order id from the database;
	 * @return an array of Integer object that contains all orders id;
	 * @throws SQLException
	 */
	public Integer[] getAllOrdersId() throws SQLException;
	
	/**
	 * Update information of a product in the database;
	 * @param newProduct A product object that contains new information about the product;
	 * @throws SQLException
	 */
	public void updateProduct(Product newProduct) throws SQLException;
	/**
	 * Adds a product to the table with orders;
	 * @param product product to be added;
	 * @throws SQLException
	 */
	public void addToOrdeR(Product product) throws SQLException;
	
	/**
	 * Adds a new product to the database;
	 * @param product new product to be added;
	 * @throws SQLException
	 */
	public void addNewProduct(Product product) throws SQLException;
	/**
	 * Gets all products to be ordered;
	 * @return an array of Product objects;
	 * @throws RemoteException
	 */
	public Product[] getAllProductsToOrder() throws SQLException;

	/**
	 * Removes a product from the database;
	 * @param product product to be removed;
	 * @throws RemoteException
	 */
	public void removeProduct(Product product) throws SQLException;
}
