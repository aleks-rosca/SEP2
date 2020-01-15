package Controller;

import Model.Product;

/**
 * The interface for the administrator controller;
 * @author Dumitru Muntean
 *
 */

public interface IAdminController {
	/**
	 * Gets all order number;
	 * @return an array of Integer;
	 */
	public Integer[] getAllOrdersNumbers();
	
	/**
	 * Adds a new product in the warehouse;
	 */
	public void addNewProduct();
	
	/**
	 * Finds a product with a specific barcode;
	 * @param barcode barcode of the product to be found;
	 * @return a Product object;
	 */
	public Product findProduct(String barcode);
	
	/**
	 * Gets all the products;
	 * @return An array that contains all the products;
	 */
	public Product[] getAllProducts();
	
	/**
	 * Search for some products with a specific information;
	 * @param barcode barcode
	 * @param name name of  the product
	 * @param supplier supplier of the product;
	 * @param description description of the product;
	 * @return an array of product that matches given information;
	 */
	public Product[] searchProduct(String barcode, String name, String supplier, String description);
	/**
	 * Update the information about a specific product
	 * @param newProduct a product that contains new information;
	 */
	public void updateProduct(Product newProduct);
	
	/**
	 * Adds a product to the order list;
	 * @param barcode barcode of the product to be added;
	 */
	public void addProductToTheOrder(String barcode);
	
	/**
	 * Adds a new batch;
	 */
	public void addNewBatch();
}
