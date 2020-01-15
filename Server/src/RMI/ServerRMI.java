package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import Controller.IServerController;
import Controller.ServerController;
import Model.Batch;
import Model.Product;
import Model.Receipt;

/**
 * @inheritDoc
 * @author Dumitru Muntean
 *
 */
public class ServerRMI extends UnicastRemoteObject implements ServerInterfaceRMI{
	
	private IServerController server;
	
	/**
	 * Non-argument constructor;
	 * @throws RemoteException
	 */
	public ServerRMI()throws RemoteException
	{
		super();
		try
		{
			server = new ServerController();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void addNewBatch(Batch batch) throws RemoteException {
		try {
			server.addNewBatch(batch);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product getProductByBarcode(String barcode) throws RemoteException {
		
		Product result = null;
	
		try {
			result = server.getProductByBarcode(barcode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Product[] getAllProducts() throws RemoteException {
		
		Product[] products = null;
		
		try {
			products = server.getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public void removeFromStock(Receipt receipt) throws RemoteException {
		
		try {
			server.removeFromStock(receipt);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public Product[] searchProducts(String barcode, String name,
			String supplier, String description) throws RemoteException {
		
		Product[] products = null;
		
		try {
			products = server.searchProducts(barcode, name, supplier, description);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Integer[] getAllOrdersId() throws RemoteException {
		
		Integer[] result = null;
		
		try {
			result = server.getAllOrdersId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void updateProduct(Product newProduct) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			server.updateProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addToOrdeR(Product product) throws RemoteException {
		
		try {
			server.addToOrdeR(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addNewProduct(Product product) throws RemoteException {
		
		try {
			server.addNewProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Product[] getAllProductsToOrder() throws RemoteException {
		Product[] products = null;
		
		return products;
		
	}

	@Override
	public void removeProduct(Product product) throws RemoteException {
		
		try {
			server.removeProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
	
	
}
