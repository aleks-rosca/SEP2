package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import Model.Batch;
import Model.Product;
import Model.Supplier;
import RMI.ServerInterfaceRMI;
import View.ProductPanelFactory;
import View.ProductPanelGenerator;
import View.View;

/**
 * @inheritDoc
 * @author Dumitru Muntean
 *
 */
public class AdminController implements IAdminController, ActionListener{
	
	private View view;
	private ServerInterfaceRMI sir;
	private boolean found;

	/**
	 * 1-argument constructor
	 * @param sir Server interface
	 */
	public AdminController(ServerInterfaceRMI sir)
	{
		found = true;
		this.sir = sir;
		view = new View(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == view.getAddProductsButton())
		{
			view.buildAddProductPage();
		}else if(e.getSource() == view.getAddNewProductAddButton())
		{
			if(found == true)
			{
				addNewBatch();
			}else
			{
				addNewProduct();
			}
			view.clearAddNewProductFields();
			view.showConfirmationMessage("Product added succesfully");
			view.setEnableAddNewProductFields(true);
			found = true;
			
		}else if(e.getSource() == view.getAddNewProductFindButton())
		{
			String barcode = view.getAddNewProductBarcode();
			Product product = findProduct(barcode);

			if(product != null)
			{
				view.enableAddProductButtons(true);
				view.fillUpAddNewProductFileds(product);
			}else
			{
				
				int r = view.showMessageDialog("There is no item with this barcode!\n Do you want to creade a new one?");
				if(r == 0)
				{
					view.enableAddProductButtons(true);
					view.disableAddNewProductBarcode();
					found = false;
				}else
				{
					found = true;
					view.clearAddNewProductFields();
				}
			}
		}else if(e.getSource() == view.getClearAddNewProductFormButton())
		{
			view.clearAddNewProductFields();
		}else if(e.getSource() == view.getAllProductsButton())
		{
			//view.enableAddProductButtons(false);
			Product[] products = getAllProducts();
			
			if(products != null)
				view.buildAllProductsPage(products);
			else 
				view.showConfirmationMessage("There are no products");
			
		}else if(e.getSource() == view.getSearchButton())
		{
			String name = view.getNameToSearch();
			String barcode = view.getBarcodeToSearch();
			String supplier = view.getSupplierSearch();
			String descritpion = view.getDescriptionSearch();
			
			Product[] found = searchProduct(barcode, name, supplier, descritpion);
			
			if(found != null)
			{
				view.displayProducts(found);
			}else {
				view.showConfirmationMessage("No products found");
			}
		}else if(e.getSource() == view.getOrdersButton())
		{
			view.buildOrderPage();
		}else if(ProductPanelFactory.hasButton(e.getSource()) != null)
		{
			ProductPanelGenerator pr = ProductPanelFactory.hasButton(e.getSource());

			if(e.getSource() == pr.getViewButton())
			{
				Product product = pr.getProduct();
				view.buildViewProductFrameFor(product);
			}else{
				try {
					sir.removeProduct(pr.getProduct());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}else if(e.getSource() == view.getViewProductEditButton())
		{
			view.enableViewProductTextPanes();
		}else if(e.getSource() == view.getViewProductCancelButton())
		{
			view.closeViewProductFrame();
		}else if(e.getSource() == view.getViewProductSaveButton())
		{
			Product newProduct = view.getViewProductModifiedProduct();
			
			int r = view.showMessageDialog("Save changes?");
			
			if(r == 0)
			{
				updateProduct(newProduct);
			}

			view.closeViewProductFrame();
			
		}else if(e.getSource() == view.getOrdersAddButton())
		{
			String barcode = view.getOrdersBarcode();

			view.clearBarcodeOrders();
			
			addProductToTheOrder(barcode);
		}
		
	}
	
	@Override
	public void addNewProduct()
	{
		String barcode 				= view.getAddNewProductBarcode().toLowerCase();
		String name 				= view.getAddNewProductName().toLowerCase();
		String description 			= view.getAddNewProductDescription().toLowerCase();
		String supplierName 		= view.getAddNewProductSupplierName().toLowerCase();
		String supplierContact 		= view.getAddNewProductSupplierContact().toLowerCase();
		String supplierAgreement 	= view.getAddNewProductSupplierAgreement().toLowerCase();
		String id					= view.getAddNewProductSupplierId().toLowerCase();
		int minQuantity 			= view.getAddNewProductMinQuantity();
		int amountToOrder 			= view.getAddNewProductAmountToOrder();
		int daysToExpire			= view.getAddNewProductDaysToExpire();
		double price 				= view.getAddNewProductPrice();
					
		//create product
		Supplier supplier = new Supplier(id, supplierName, supplierContact, supplierAgreement);
		Product product = new Product(barcode, name, description, price, supplier, amountToOrder, minQuantity, daysToExpire);
		
		//send prudct on the server
		try {
			sir.addNewProduct(product);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void addNewBatch()
	{
		int orderid 				= view.getAddNewProductOrderId();
		String barcode 				= view.getAddNewProductBarcode().toLowerCase();
		String name 				= view.getAddNewProductName().toLowerCase();
		String description 			= view.getAddNewProductDescription().toLowerCase();
		String supplierName 		= view.getAddNewProductSupplierName().toLowerCase();
		String supplierContact 		= view.getAddNewProductSupplierContact().toLowerCase();
		String supplierAgreement 	= view.getAddNewProductSupplierAgreement().toLowerCase();
		String expireDate 			= view.getAddNewProductExpireDate().toLowerCase();
		String id					= view.getAddNewProductSupplierId().toLowerCase();
		int quantity 				= view.getAddNewProductQuantity();
		int minQuantity 			= view.getAddNewProductMinQuantity();
		int amountToOrder 			= view.getAddNewProductAmountToOrder();
		int daysToExpire			= view.getAddNewProductDaysToExpire();
		double price 				= view.getAddNewProductPrice();
					
		//create product
		Supplier supplier = new Supplier(id, supplierName, supplierContact, supplierAgreement);
		Product product = new Product(barcode, name, description, price, supplier, amountToOrder, minQuantity, daysToExpire);
		Batch batch = new Batch(product, quantity, expireDate, orderid);
		
		//send prudct on the server
		try {
			sir.addNewBatch(batch);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public Product findProduct(String barcode)
	{
		Product product = null;
		try {
			 product = sir.getProductByBarcode(barcode);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		return product;
	}
	
	@Override
	public Product[] getAllProducts()
	{
		Product[] products = null;
		try {
			products = sir.getAllProducts();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		return products;
	}
	
	@Override
	public Product[] searchProduct(String barcode, String name, String supplier, String description)
	{

		Product[] found = null;
		
		try {
			found = sir.searchProducts(barcode, name, supplier, description);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return found;
	}
	
	@Override
	public void updateProduct(Product newProduct)
	{
		try {
			sir.updateProduct(newProduct);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void addProductToTheOrder(String barcode)
	{
		Product p = null;
		
		try {
			p = sir.getProductByBarcode(barcode);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(p != null)
		{
			try {
				sir.addToOrdeR(p);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else
		{
			view.showConfirmationMessage("There is no product with this barcode!");
		}
	}
	
	@Override
	public Integer[] getAllOrdersNumbers()
	{
		Integer[] res = null;
		
		try {
			res = sir.getAllOrdersId();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
