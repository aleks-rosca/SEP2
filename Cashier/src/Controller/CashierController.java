package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import Model.Product;
import Model.Receipt;
import Model.ToSell;
import RMI.ServerInterfaceRMI;
import View.ProductPanelGenerator;
import View.ReceiptProducts;
import View.View;

/**
 * Cashier controller;
 * @author Dima
 *
 */
public class CashierController implements ICashierController, ActionListener{

	private ServerInterfaceRMI sir;
	private View view;
	private Receipt receipt;
	
	public CashierController(ServerInterfaceRMI sir)
	{
		this.sir = sir;
		view = new View(this);
		receipt = new Receipt();
		receipt.addObserver(view.getMainPage());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.getAddButton())
		{
			String barcode = view.getBarcode();
			double amount = view.getAmount();
			
			Product toBuy = null;
			
			try {
				toBuy = sir.getProductByBarcode(barcode);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(toBuy == null)
			{
				view.showMessage("Wrong barcode!!!");
			}else
			{
				ToSell pr = new ToSell(toBuy, amount);
				
				receipt.addProduct(pr);
				view.clearInputFields();
				view.displayProduct(pr);
			}
		}else if(e.getSource() == view.getFinishButton())
		{
			try {
				sir.removeFromStock(receipt);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			view.clearMainPanel();
			receipt.empty();
		}else if(ReceiptProducts.hasButton(e.getSource()) != null)
		{
			ProductPanelGenerator p = ReceiptProducts.hasButton(e.getSource());
			receipt.removeProduct(p.getProduct());
			view.removeProductFromTheList(p);
		}
		
	}
	
	

}
