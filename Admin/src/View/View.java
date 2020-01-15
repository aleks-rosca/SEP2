package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.AdminController;
import Controller.IAdminController;
import Model.Product;

/**
 * View
 * @author Dumitru Muntean
 *
 */
public class View {

	private MainPage mainPage;
	private AddProductsPage addProductsPage;
	private AllProductsPage allProductsPage;
	private OrderPage orderPage;
	private ProductPanelFactory productPanelFactory;	
	private AdminController controller;
	private ViewProduct vp;

	public View(AdminController controller) {
		this.controller = controller;
		mainPage = new MainPage(this.controller);
		allProductsPage = new AllProductsPage();
		orderPage = new OrderPage();
		addProductsPage = new AddProductsPage(controller.getAllOrdersNumbers());
		vp = new ViewProduct(controller);
		
	}

	public void buildAddProductPage() {
		addProductsPage.buildAddProductPage(mainPage.getDisplayPanel());
		addProductsPage.initButtons(controller);
	}
	
	public void buildAllProductsPage(Product[] products)
	{
		allProductsPage.buildAllProductsPage(mainPage.getDisplayPanel());
		displayProducts(products);
	}
	
	public void buildOrderPage()
	{
		orderPage.buildOrdersPage(mainPage.getDisplayPanel());
		orderPage.initButtons(controller);
	}
	
	public void displayProducts(Product[] products)
	{
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		
		for(int i = 0; i < products.length; i++)
			panels.add(ProductPanelFactory.getProductPanelFor(products[i], controller));
		
		allProductsPage.buildAllProductsPage(mainPage.getDisplayPanel());
		allProductsPage.putProductsIntoPanel(panels.toArray(new JPanel[panels.size()]));
	}

	public JButton getAllProductsButton()
	{
		return mainPage.getAllProductsButton();
	}
	
	public JButton getAddProductsButton() {
		return mainPage.getAddProductsButton();
	}

	public JButton getAddNewProductButton() {
		return addProductsPage.getAddButton();
	}

	public JButton getClearAddNewProductFormButton() {
		return addProductsPage.getClearButton();
	}

	public String getAddNewProductBarcode() {
		return addProductsPage.getBarcode();
	}

	public String getAddNewProductName() {
		return addProductsPage.getProductName();
	}

	public int getAddNewProductOrderId() {
		return addProductsPage.getOrderNo();
		
	}

	public String getAddNewProductSupplierName() {
		return addProductsPage.getSupplierName();
	}

	public String getAddNewProductSupplierContact() {
		return addProductsPage.getSupplierContact();
	}

	public String getAddNewProductSupplierAgreement() {
		return addProductsPage.getDeliveryAgreement();
	}

	public String getAddNewProductDescription() {
		return addProductsPage.getDescription();
	}

	public String getExpireDate() {
		return addProductsPage.getExpireDate();
	}

	public double getAddNewProductPrice() {
		return Double.parseDouble(addProductsPage.getPrice());
	}

	public int getAddNewProductQuantity() {
		return Integer.parseInt(addProductsPage.getAmount());
	}

	public int getAddNewProductAmountToOrder() {
		return Integer.parseInt(addProductsPage.getAmountToOrder());
	}

	public int getAddNewProductMinQuantity() {
		return Integer.parseInt(addProductsPage.getMinQuantity());
	}

	public String getAddNewProductExpireDate() {
		return addProductsPage.getExpireDate();
	}

	public int getAddNewProductDaysToExpire() {
		return Integer.parseInt(addProductsPage.getDaysToExpire());
	}
	
	public String getAddNewProductSupplierId()
	{
		return addProductsPage.getSupplierId();
	}

	// get buttons

	public JButton getAddNewProductAddButton() {
		return addProductsPage.getAddButton();
	}

	public JButton getAddNewProductClearButton() {
		return addProductsPage.getClearButton();
	}

	public JButton getAddNewProductFindButton() {
		return addProductsPage.getFindButton();
	}

	public void clearAddNewProductFields() {
		addProductsPage.clearFields();
	}

	public void fillUpAddNewProductFileds(Product product) {
		addProductsPage.fillUpFields(product);
	}
	
	public void disableAddNewProductBarcode()
	{
		addProductsPage.disableBarcode();
	}

	public void setEnableAddNewProductFields(boolean enable) {
		addProductsPage.setEnabledFields(enable);
	}

	public void showConfirmationMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public int showMessageDialog(String message) {
		Object[] options = { "Yes", "No" };
		int n = JOptionPane.showOptionDialog(null,
				message,
				"Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		return n;
	}
	
	public JButton getSearchButton()
	{
		return mainPage.getSearchButton();
	}
	
	public String getNameToSearch()
	{
		return mainPage.getName().toLowerCase();
	}
	
	public String getDescriptionSearch()
	{
		return mainPage.getDescription().toLowerCase();
	}
	
	public String getSupplierSearch()
	{
		return mainPage.getSupplier().toLowerCase();
	}
	
	public String getBarcodeToSearch()
	{
		return mainPage.getBarcode().toLowerCase();
	}
	
	public JButton getOrdersButton()
	{
		return mainPage.getOrdeButton();
	}
	
	public void buildViewProductFrameFor(Product product)
	{
		vp.openViewProduct(product);
	}
	
	public void closeViewProductFrame()
	{
		vp.close();
	}
	
	public JButton getViewProductEditButton()
	{
		return vp.getEditButton();
	}
	
	public JButton getViewProductCancelButton()
	{
		return vp.getCancelButton();
	}
	
	public JButton getViewProductSaveButton()
	{
		return vp.getSaveButton();
	}
	
	public void enableViewProductTextPanes()
	{
		vp.enableFields(true);
	}
	
	public Product getViewProductModifiedProduct()
	{
		return vp.getModifiedProduct();
	}
	
	public JButton getOrdersAddButton()
	{
		return orderPage.getAddButton();
	}
	
	public JButton getOrdersPlaceOrderButton()
	{
		return orderPage.getPlaceOrder();
	}
	
	public String getOrdersBarcode()
	{
		return orderPage.getBarcode();
	}
	
	public void clearBarcodeOrders()
	{
		orderPage.clearBarcode();
	}
	
	public void enableAddProductButtons(boolean enabled)
	{
		addProductsPage.enableButtons(enabled);
	}
}
