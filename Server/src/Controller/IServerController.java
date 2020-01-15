package Controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import Model.Batch;
import Model.Product;
import Model.Receipt;

/**
 * The interface for the server controller;
 * @author Dima
 *
 */
public interface IServerController {
	
	/**
	 * Add new batch into the database using adaptor;
	 * @param batch The batch to be added;
	 * @throws SQLException
	 */
	public void addNewBatch(Batch batch) throws SQLException;
	
	/**
	 * Gets a product by barcode from the database;
	 * @param barcode barcode of the product
	 * @return a product object if there is one that matches barcode;
	 * @throws SQLException
	 */
	public Product getProductByBarcode(String barcode) throws SQLException;
	
	/**
	 * Gets all products from the database using adapter;
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
	 * Search for products by particular information;
	 * @param barcode barcode of the product
	 * @param name name of the product
	 * @param supplier supplier of the product(id, name or contact)
	 * @param description key words from the description
	 * @return return an array of Product object that contains products that matches given information;
	 * @throws SQLException
	 */
	public Product[] searchProducts(String barcode, String name, String supplier, String description) throws SQLException;
	
	/**
	 * Gets all order id from the database;
	 * @return an array of Integer object that contains all order id;
	 * @throws SQLException
	 */
	public Integer[] getAllOrdersId() throws SQLException;
	
	/**
	 * Update the information about a product in the database
	 * @param newProduct A product object that contains new inforamtion;
	 * @throws SQLException
	 */
	public void updateProduct(Product newProduct) throws SQLException;
	
	/**
	 * Adds a product to the order;
	 * @param product the product object to be added;
	 * @throws SQLException
	 */
	public void addToOrdeR(Product product) throws SQLException;
	
	/**
	 * Adds new product object in the database;
	 * @param product the product to be added;
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
