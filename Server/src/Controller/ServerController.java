package Controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import DBAdapter.Adaptor;
import Log.LogLine;
import LogFile.FileAdaptor;
import Model.Batch;
import Model.Product;
import Model.Receipt;
import View.View;

/**
 * @inheritDoc
 * @author Dima
 *
 */
public class ServerController implements IServerController {

	private View view;
	private Adaptor adaptor;
	private FileAdaptor fileAdaptor;;

	public ServerController() throws ClassNotFoundException {
		fileAdaptor = new FileAdaptor();
		view = new View();
		adaptor = new Adaptor();
	}

	@Override
	public void addNewBatch(Batch batch) throws SQLException {
		String log = "New batch added in database : " + batch.toString();
		LogLine l = new LogLine(log);
		adaptor.addNewBatch(batch);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
	}

	@Override
	public Product getProductByBarcode(String barcode) throws SQLException {
		Product result = adaptor.getProductByBarcode(barcode);
		String log = "Requested product; Barcode = " + barcode + "\nResult:"
				+ result;
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		return result;
	}

	@Override
	public Product[] getAllProducts() throws SQLException {
		Product[] result = adaptor.getAllProducts();
		String log = "All products requested;\nResult:\n";
		for (int i = 0; i < result.length; i++)
			log += result[i] + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		return result;
	}

	@Override
	public void removeFromStock(Receipt receipt) throws SQLException {
		String log = "Remove from the batch the following products:";
		
		for(int i = 0; i < receipt.getProducts().size(); i++)
			log += receipt.getProducts().get(i) + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		adaptor.removeFromStock(receipt);
	}

	@Override
	public Product[] searchProducts(String barcode, String name,
			String supplier, String description) throws SQLException {

		Product[] result = adaptor.searchProducts(barcode, name, supplier,
				description);
		String log = "Search products;\nParameters:" + "\nBarcode:" + barcode
				+ "\nName:" + name + "\nSupplier:" + supplier
				+ "\nDescription:" + description + "\nResult:\n";

		for (int i = 0; i < result.length; i++)
			log += result[i].toString() + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		return result;
	}

	@Override
	public Integer[] getAllOrdersId() throws SQLException {
		Integer[] result = adaptor.getAllOrdersId();
		String log = "All order id requested;\nResult:\n";
		for (int i = 0; i < result.length; i++)
			log += result[i] + "\n";

		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());

		return result;
	}

	@Override
	public void updateProduct(Product newProduct) throws SQLException {
		String log = "Update the product;\n Barcode:" + newProduct.getBarcode()
				+ "\nUpdated information:\n" + newProduct + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		adaptor.updateProduct(newProduct);
	}

	@Override
	public void addToOrdeR(Product product) throws SQLException {
		String log = "Add a product to order table;\nProdcut:" + product + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		adaptor.addToOrdeR(product);

	}

	@Override
	public void addNewProduct(Product product) throws SQLException {
		String log = "New product added;\nProduct:" + product + "\n";
		LogLine l = new LogLine(log);
		fileAdaptor.writeToFile(l);
		view.print(l.toString());
		adaptor.addNewProduct(product);
	}

	@Override
	public Product[] getAllProductsToOrder() throws SQLException {
		
		return null;
	}

	@Override
	public void removeProduct(Product product) throws SQLException {
		
		adaptor.removeProduct(product);
		
	}
	
	
}
