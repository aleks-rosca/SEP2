package View;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controller.CashierController;
import Model.Product;
import Model.ToSell;

/**
 * A class that is responsible to build view part of the cashier;
 * @author Dima
 *
 */
public class View {
	
	private CashierController controller;
	private MainPage mainPage;
	
	/**
	 * 1-argument constructor
	 * @param controller
	 */
	public View(CashierController controller)
	{
		this.controller = controller;
		mainPage  = new MainPage(controller);
	}
	

	public String getBarcode()
	{
		return mainPage.getBarcode();
	}
	
	public double getAmount()
	{
		String rs = mainPage.getAmount();
		
		if(rs.equals(""))
			rs = "1";
		
		return Double.parseDouble(rs);
	}
	
	public JButton getAddButton()
	{
		return mainPage.getAddButton();
	}
	
	public JButton getFinishButton()
	{
		return mainPage.getFinishButton();
	}
	
	public void displayProduct(ToSell product)
	{
		ProductPanelGenerator p = new ProductPanelGenerator(product);
		p.initButtons(controller);
		
		ReceiptProducts.addProdduct(p);
		
		mainPage.displayProduct(p.getPanel());
	}
	
	public MainPage getMainPage()
	{
		return mainPage;
	}
	
	public void clearMainPanel()
	{
		mainPage.clearMainPanel();
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void clearInputFields()
	{
		mainPage.clearInputFields();
	}
	
	public void removeProductFromTheList(ProductPanelGenerator product)
	{
		mainPage.removeProductFromTheList(product.getPanel());
	}
}
