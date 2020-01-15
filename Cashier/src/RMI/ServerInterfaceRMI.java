package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.Batch;
import Model.Product;
import Model.Receipt;

/**
 * The interface for the ServerRMI. 
 * @author 
 *
 */
public interface ServerInterfaceRMI extends Remote {
	
	/**
	 * Add a new batch into the server;
	 * @param batch batch to be added;
	 * @throws RemoteException
	 */
	public void addNewBatch(Batch batch) throws RemoteException;
	
	/**
	 * Gets a product by barcode;
	 * @param barcode barcode of the product;
	 * @return a product object if there is one that matches barcode;
	 * @throws RemoteException
	 */
	public Product getProductByBarcode(String barcode) throws RemoteException;
	
	/**
	 * Gets all products from the server;
	 * @return an array of Product objects that contains all the products;
	 * @throws RemoteException
	 */
	public Product[] getAllProducts() throws RemoteException;
	
	/**
	 * Removes the amount of products that are in receipt from batches;
	 * @param receipt A class that contains the products that have been sold by cashier;
	 * @throws RemoteException
	 */
	public void removeFromStock(Receipt receipt) throws RemoteException;
	
	/**
	 * Search for products by specific information;
	 * @param barcode by barcode;
	 * @param name by name
	 * @param supplier by supplier (id, name or contact)
	 * @param description by product description;
	 * @return an array of Product object that contains all the products that matches given information;
	 * @throws RemoteException
	 */
	public Product[] searchProducts(String barcode, String name, String supplier, String description) throws RemoteException;
	
	/**
	 * Gets all orders id that are present in the server;
	 * @return an array of Integer objects;
	 * @throws RemoteException
	 */
	public Integer[] getAllOrdersId() throws RemoteException;
	
	/**
	 * Update a product on the server;
	 * @param newProduct A product that contains new information;
	 * @throws RemoteException
	 */
	public void updateProduct(Product newProduct) throws RemoteException;
	
	/**
	 * Add a product to the order;
	 * @param product Product object to be added in the order table;
	 * @throws RemoteException
	 */
	public void addToOrdeR(Product product) throws RemoteException;
	
	/**
	 * Add new product in the server
	 * @param product The product object to be added;
	 * @throws RemoteException
	 */
	public void addNewProduct(Product product) throws RemoteException;
	
	/**
	 * Gets all products to be ordered;
	 * @return an array of Product objects;
	 * @throws RemoteException
	 */
	public Product[] getAllProductsToOrder() throws RemoteException;
	
	/**
	 * Removes a product from the database;
	 * @param product product to be removed;
	 * @throws RemoteException
	 */
	public void removeProduct(Product product) throws RemoteException;

}
