package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import Controller.AdminController;
import Model.Product;

/**
 * A class responsible to build Add products page;
 * @author Dumitru Muntean
 *
 */
public class AddProductsPage {
	
	private JButton findButton;
	private JLabel natchNoLabel;
	private JTextPane barcodePane;
	private JComboBox<Integer> batchNoTextArea;
	private JLabel lblNewLabel_1;
	private JTextPane nameTextPane;
	private JLabel descriptionLabel;
	private JTextPane descriptionTextPanel;
	private JLabel supplierLabel;
	private JTextPane supplierNameTextPane;
	private JTextPane supplierContactPanel;
	private JLabel supplierNameLabel;
	private JLabel supplierContactLabel;
	private JLabel expireDateLabel;
	private JTextPane expireDatePanel;
	private JLabel quantityLabel;
	private JTextPane quantityTextArea;
	private JLabel lblMinQuantity;
	private JTextPane minQuantityTextArea;
	private JLabel toBeOrderedLabel;
	private JTextPane toBeOrderedTextArea;
	private JLabel priceLabel;
	private JTextPane priceTextArea;
	private JButton addButton;
	private JButton clearButton;
	private JLabel deliveryAgreementLabel;
	private JLabel daysToExpireLabel;
	private JTextPane daysToExpirePane;
	private JTextArea agreementTextPane;
	private JLabel supplierIdLabel;
	private JTextPane supplierIdTextPanel;
	
	private Integer[] orderNumbers;
	
	/**
	 * 1-argument constructor
	 * @param orderNumbers order numbers
	 */
	public AddProductsPage(Integer [] orderNumbers)
	{
		this.orderNumbers = orderNumbers;
	}
	
	/**
	 * Builds entire page;
	 * @param dispalyPanel The panel to build the page in;
	 */
	public void buildAddProductPage(JPanel dispalyPanel)
	{
		dispalyPanel.removeAll();

		Font f = new Font("Tahome", Font.LAYOUT_LEFT_TO_RIGHT, 16);
		
		JLabel barCodeLabel = new JLabel("Barcode:");
		barCodeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		barCodeLabel.setBounds(12, 13, 93, 35);
		dispalyPanel.add(barCodeLabel);
		
		findButton = new JButton("Find");
		findButton.setBounds(316, 13, 546, 36);
		dispalyPanel.add(findButton);
		
		natchNoLabel = new JLabel("Order no:");
		natchNoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		natchNoLabel.setBounds(12, 91, 81, 16);
		dispalyPanel.add(natchNoLabel);
		
		barcodePane = new JTextPane();
		barcodePane.setFont(f);
		barcodePane.setBounds(117, 13, 175, 35);
		dispalyPanel.add(barcodePane);
		
		
		batchNoTextArea = new JComboBox(orderNumbers);
		batchNoTextArea.setFont(f);;
		batchNoTextArea.setBounds(118, 79, 175, 43);
		dispalyPanel.add(batchNoTextArea);
		
		lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 169, 81, 16);
		dispalyPanel.add(lblNewLabel_1);
		
		nameTextPane = new JTextPane();
		nameTextPane.setFont(f);
		nameTextPane.setBounds(118, 154, 175, 43);
		dispalyPanel.add(nameTextPane);
		
		
		descriptionLabel = new JLabel("Description :");
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		descriptionLabel.setBounds(305, 91, 106, 16);
		dispalyPanel.add(descriptionLabel);
		
		descriptionTextPanel = new JTextPane();
		descriptionTextPanel.setFont(f);
		descriptionTextPanel.setBounds(423, 79, 175, 43);
		dispalyPanel.add(descriptionTextPanel);
		
		supplierLabel = new JLabel("Supplier :");
		supplierLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		supplierLabel.setBounds(12, 240, 81, 16);
		dispalyPanel.add(supplierLabel);
		
		//117, 227, 175, 43
		supplierNameTextPane = new JTextPane();
		supplierNameTextPane.setFont(f);
		supplierNameTextPane.setBounds(114, 290, 175, 43);
		dispalyPanel.add(supplierNameTextPane);
		
		//114, 290, 175, 43
		supplierContactPanel = new JTextPane();
		supplierContactPanel.setFont(f);
		supplierContactPanel.setBounds(114, 353, 175, 43);
		dispalyPanel.add(supplierContactPanel);
		
		//114, 205, 56, 16
		supplierNameLabel = new JLabel("Name:");
		supplierNameTextPane.setFont(f);
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supplierNameLabel.setBounds(114, 272, 56, 16);
		dispalyPanel.add(supplierNameLabel);
		
		//114, 272, 56, 16
		supplierContactLabel = new JLabel("Contact:");
		supplierContactPanel.setFont(f);
		supplierContactLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supplierContactLabel.setBounds(114, 335, 56, 16);
		dispalyPanel.add(supplierContactLabel);
		
		//114, 335, 56, 16
		supplierIdLabel = new JLabel("Id: ");
		supplierIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supplierIdLabel.setBounds(114, 205, 56, 16);
		dispalyPanel.add(supplierIdLabel);
		
		//114, 353, 175, 43
		supplierIdTextPanel  = new JTextPane();
		supplierIdTextPanel.setFont(f);
		supplierIdTextPanel.setBounds(117, 227, 175, 43);
		dispalyPanel.add(supplierIdTextPanel);
		
		expireDateLabel = new JLabel("Expire:");
		expireDateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		expireDateLabel.setBounds(305, 169, 81, 16);
		dispalyPanel.add(expireDateLabel);
		
		expireDatePanel = new JTextPane();
		expireDatePanel.setFont(f);
		expireDatePanel.setBounds(423, 154, 175, 43);
		dispalyPanel.add(expireDatePanel);
		
		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		quantityLabel.setBounds(305, 240, 81, 16);
		dispalyPanel.add(quantityLabel);
		
		quantityTextArea = new JTextPane();
		quantityTextArea.setFont(f);
		quantityTextArea.setBounds(423, 227, 175, 43);
		dispalyPanel.add(quantityTextArea);
		
		lblMinQuantity = new JLabel("Min. Quantity:");
		lblMinQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMinQuantity.setBounds(623, 92, 115, 16);
		dispalyPanel.add(lblMinQuantity);
		
		minQuantityTextArea = new JTextPane();
		minQuantityTextArea.setFont(f);
		minQuantityTextArea.setBounds(773, 79, 87, 43);
		dispalyPanel.add(minQuantityTextArea);
		
		toBeOrderedLabel = new JLabel("To be ordered:");
		toBeOrderedLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		toBeOrderedLabel.setBounds(623, 169, 131, 16);
		dispalyPanel.add(toBeOrderedLabel);
		
		toBeOrderedTextArea = new JTextPane();
		toBeOrderedTextArea.setFont(f);
		toBeOrderedTextArea.setBounds(773, 154, 87, 43);
		dispalyPanel.add(toBeOrderedTextArea);

		priceLabel = new JLabel("Price:");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		priceLabel.setBounds(623, 240, 56, 16);
		dispalyPanel.add(priceLabel);
		
		priceTextArea = new JTextPane();
		priceTextArea.setFont(f);
		priceTextArea.setBounds(773, 225, 87, 43);
		dispalyPanel.add(priceTextArea);
		
		daysToExpireLabel = new JLabel("Days to expire:");
		daysToExpireLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
										//18	
		daysToExpireLabel.setBounds(623, 299, 125, 16);
		dispalyPanel.add(daysToExpireLabel);
		
		daysToExpirePane = new JTextPane();
		daysToExpirePane.setFont(f); // 12
		daysToExpirePane.setBounds(773, 290, 87, 43);
		dispalyPanel.add(daysToExpirePane);
		
		addButton = new JButton("Add");
		addButton.setBounds(735, 350, 125, 47);
		dispalyPanel.add(addButton);
		
		clearButton = new JButton("Clear");
								//290
		clearButton.setBounds(617, 350, 106, 47);
		dispalyPanel.add(clearButton);
		
		deliveryAgreementLabel = new JLabel("Agreement: ");
		deliveryAgreementLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
										  // 299
		deliveryAgreementLabel.setBounds(301, 299, 106, 16);
		dispalyPanel.add(deliveryAgreementLabel);
		
		agreementTextPane = new JTextArea();
		agreementTextPane.setBounds(423, 290, 175, 109);
		agreementTextPane.setFont(f);
		
		dispalyPanel.add(agreementTextPane);
		enableButtons(false);
		dispalyPanel.repaint();
		dispalyPanel.revalidate();
	}
	
	/**
	 * Add action listener to buttons;
	 * @param controller Action listener
	 */
	public void initButtons(AdminController controller)
	{
		clearButton.addActionListener(controller);
		addButton.addActionListener(controller);
		findButton.addActionListener(controller);
	}
	
	/**
	 * Get barcode;
	 * @return barcode
	 */
	public String getBarcode()
	{
		return barcodePane.getText();
	}
	
	/**
	 * Gets order number
	 * @return order number
	 */
	public int getOrderNo()
	{
		return (Integer)batchNoTextArea.getSelectedItem();
	}
	
	/**
	 * Gets product name;
	 * @return product name;
	 */
	public String getProductName()
	{
		return nameTextPane.getText();
	}
	
	/**
	 * Get supplier name;
	 * @return supplier name;
	 */
	public String getSupplierName()
	{
		return supplierNameTextPane.getText();
	}
	
	/**
	 * Gets supplier contact;
	 * @return supplier contact;
	 */
	public String getSupplierContact()
	{
		return supplierContactPanel.getText();
	}
	
	/**
	 * Gets delivery agreement;
	 * @return delivery agreement;
	 */
	public String getDeliveryAgreement()
	{
		return agreementTextPane.getText();
	}
	
	/**
	 * Get minimum quantity;
	 * @return minimum quantity;
	 */
	public String getMinQuantity()
	{
		return minQuantityTextArea.getText();
	}
	
	/**
	 * Gets amount to order;
	 * @return amount to order;
	 */ 
	public String getAmountToOrder()
	{
		return toBeOrderedTextArea.getText();
	}
	
	/**
	 * Gets description;
	 * @return description;
	 */
	public String getDescription()
	{
		return descriptionTextPanel.getText();
	}
	
	/**
	 * Gets price;
	 * @return price;
	 */
	public String getPrice()
	{
		return priceTextArea.getText();
	}
	
	/**
	 * Expire date
	 * @return expire date;
	 */
	public String getExpireDate()
	{
		return expireDatePanel.getText();
	}
	
	/**
	 * Gets amount
	 * @return amount;
	 */
	
	public String getAmount()
	{
		return quantityTextArea.getText();
	}
	
	//get buttons
	/**
	 * Gets Add button;
	 * @return JButton 
	 */
	public JButton getAddButton()
	{
		return addButton;
	}
	
	/**
	 * Gets clear Jbutton;
	 * @return JButton;
	 */
	public JButton getClearButton()
	{
		return clearButton;
	}
	
	/**
	 * Gets find button;
	 * @return find button;
	 */
	public JButton getFindButton()
	{
		return findButton;
	}
	
	/**
	 * Gets days to expire;
	 * @return days to expire;
	 */
	public String getDaysToExpire()
	{
		return daysToExpirePane.getText();
	}
	
	/**
	 * Gets supplier id;
	 * @return supplier id;
	 */
	public String getSupplierId()
	{
		return supplierIdTextPanel.getText();
	}
	
	/**
	 * Clear all text fields;
	 */
	public void clearFields()
	{
		nameTextPane.setText("");
		barcodePane.setText("");
		nameTextPane.setText("");
		supplierNameTextPane.setText("");
		supplierContactPanel.setText("");
		agreementTextPane.setText("");
		descriptionTextPanel.setText("");
		expireDatePanel.setText("");
		minQuantityTextArea.setText("");
		toBeOrderedTextArea.setText("");
		priceTextArea.setText("");
		daysToExpirePane.setText("");
		quantityTextArea.setText("");
		supplierIdTextPanel.setText("");
		
		setEnabledFields(true);
	}
	
	// fill up fields
	
	/**
	 * Fill up text fields with information about the given product;
	 * @param product Product;
	 */
	public void fillUpFields(Product product)
	{
		barcodePane.setText(product.getBarcode());
		barcodePane.setEnabled(false);
		nameTextPane.setText(product.getName());
		nameTextPane.setEnabled(false);
		supplierContactPanel.setText(product.getSupplier().getName());
		supplierContactPanel.setEnabled(false);
		supplierNameTextPane.setText(product.getSupplier().getContact());
		supplierNameTextPane.setEnabled(false);
		agreementTextPane.setText(product.getSupplier().getAgreement());
		agreementTextPane.setEnabled(false);
		minQuantityTextArea.setText(Integer.toString(product.getMinAmount()));
		minQuantityTextArea.setEnabled(false);
		descriptionTextPanel.setText(product.getDescription());
		descriptionTextPanel.setEnabled(false);
		priceTextArea.setText(Double.toString(product.getPrice()));
		priceTextArea.setEnabled(false);
		daysToExpirePane.setText(Integer.toString(product.getDaysToExpire()));
		daysToExpirePane.setEnabled(false);
		toBeOrderedTextArea.setText(Integer.toString(product.getAmountToOrder()));
		toBeOrderedTextArea.setEnabled(false);
		supplierIdTextPanel.setText(product.getSupplier().getSupplierId());
		supplierIdTextPanel.setEnabled(false);
	}
	
	/**
	 * Enable or disable text fields;
	 * @param enabled true/false;
	 */
	public void setEnabledFields(boolean enabled)
	{
		barcodePane.setEnabled(enabled);
		nameTextPane.setEnabled(enabled);
		supplierContactPanel.setEnabled(enabled);
		supplierNameTextPane.setEnabled(enabled);
		minQuantityTextArea.setEnabled(enabled);
		descriptionTextPanel.setEnabled(enabled);
		priceTextArea.setEnabled(enabled);
		daysToExpirePane.setEnabled(enabled);
		daysToExpirePane.setEnabled(enabled);
		supplierNameTextPane.setEnabled(enabled);
		batchNoTextArea.setEnabled(enabled);
		expireDatePanel.setEnabled(enabled);
		quantityTextArea.setEnabled(enabled);
		agreementTextPane.setEnabled(enabled);
		toBeOrderedTextArea.setEnabled(enabled);
		supplierIdTextPanel.setEnabled(enabled);
	}
	
	/**
	 * Disable barcode text field;
	 */
	public void disableBarcode()
	{
		barcodePane.setEnabled(false);
	}
	
	/**
	 * Enable or dissable buttons buttons;
	 * @param enabled true/false;
	 */
	public void enableButtons(boolean enabled)
	{
		addButton.setEnabled(enabled);
		clearButton.setEnabled(enabled);
	}
}
