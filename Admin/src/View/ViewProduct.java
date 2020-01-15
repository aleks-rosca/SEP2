package View;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import Controller.AdminController;
import Model.Product;
import Model.Supplier;

/**
 * A class that is responsible to display information about a product;
 * @author Alexandru;
 *
 */
public class ViewProduct {
	
	private JFrame frame;
	private JLabel barcodeLabel;
	private JTextPane barcodeTextPane;
	private JLabel nameLabel;
	private JTextPane textPane;
	private JLabel descriptionLabel;
	private JTextPane descriptionTextPane;
	private JLabel supplierLabel;
	private JTextPane supplierIdTextPane;
	private JLabel lblId;
	private JLabel lblName;
	private JTextPane supplierNameTextPane;
	private JLabel minAmountLabel;
	private JTextPane minAmountTextPane;
	private JLabel amountToOrderLabel;
	private JTextPane toOrderTextPane;
	private JLabel daysToExpireLabel;
	private JTextPane daysToExpireTextPane;
	private JLabel priceLabel;
	private JTextPane priceTextPane;
	private JLabel discountLabel;
	private JTextPane discountTextPane;
	private JLabel agreementLabel;
	private JTextPane textPane_1;
	private JButton editInfoButton;
	private JPanel twoButtonsPanel;
	private JButton cancelButton;
	private JButton saveButton;
	private JScrollPane scrollPane;
	private JPanel batchesPanel;
	private JTextPane contactTextPane;
	private JLabel contactLabel;
	
	private Product product;
	
	public ViewProduct(AdminController controller)
	{
		initialize();
		initButtons(controller);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public void openViewProduct(Product product)
	{
		this.product = product;
		fillUpFields(product);
		frame.setVisible(true);
	}
	
	public void close()
	{
		discountTextPane.setText("");
		frame.setVisible(false);
	}
	
	public Product getProduct()
	{
		return product;
	}
	
	public void initButtons(AdminController listener)
	{
		editInfoButton.addActionListener(listener);
		saveButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}
	
	public JButton getEditButton()
	{
		return editInfoButton;
	}
	
	public JButton getCancelButton()
	{
		return cancelButton;
	}
	
	public JButton getSaveButton()
	{
		return saveButton;
	}
	
	public void enableFields(boolean enable)
	{
		textPane.setEnabled(enable); // name
		descriptionTextPane.setEnabled(enable);
		supplierIdTextPane.setEnabled(enable);
		supplierNameTextPane.setEnabled(enable);
		minAmountTextPane.setEnabled(enable);
		toOrderTextPane.setEnabled(enable);
		daysToExpireTextPane.setEnabled(enable);
		priceTextPane.setEnabled(enable);
		discountTextPane.setEnabled(enable);
		textPane_1.setEnabled(enable);//agreement
		contactTextPane.setEnabled(enable);
	}

	public void fillUpFields(Product product)
	{
		barcodeTextPane.setText(product.getBarcode());
		textPane.setText(product.getName());
		descriptionTextPane.setText(product.getDescription());
		supplierIdTextPane.setText(product.getSupplier().getSupplierId());
		supplierNameTextPane.setText(product.getSupplier().getName());
		contactTextPane.setText(product.getSupplier().getContact());
		textPane_1.setText(product.getSupplier().getAgreement());
		minAmountTextPane.setText(Integer.toString(product.getMinAmount()));
		toOrderTextPane.setText(Integer.toString(product.getAmountToOrder()));
		daysToExpireTextPane.setText(Integer.toString(product.getDaysToExpire()));
		priceTextPane.setText(Double.toString(product.getPrice()));
		discountTextPane.setText(Double.toString(product.getDiscount()));
		enableFields(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 627);
		frame.getContentPane().setLayout(null);
		
		barcodeLabel = new JLabel("Barcode:");
		barcodeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		barcodeLabel.setBounds(12, 13, 77, 29);
		frame.getContentPane().add(barcodeLabel);
		
		barcodeTextPane = new JTextPane();
		barcodeTextPane.setBounds(111, 13, 121, 29);
		frame.getContentPane().add(barcodeTextPane);
		barcodeTextPane.setEnabled(false);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameLabel.setBounds(12, 60, 65, 20);
		frame.getContentPane().add(nameLabel);
		
		textPane = new JTextPane();
		textPane.setBounds(111, 51, 121, 29);
		frame.getContentPane().add(textPane);
		
		descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		descriptionLabel.setBounds(12, 307, 98, 16);
		frame.getContentPane().add(descriptionLabel);
		
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setBounds(111, 296, 342, 29);
		frame.getContentPane().add(descriptionTextPane);
		
		supplierLabel = new JLabel("Supplier:");
		supplierLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		supplierLabel.setBounds(12, 104, 77, 16);
		frame.getContentPane().add(supplierLabel);
		
		supplierIdTextPane = new JTextPane();
		supplierIdTextPane.setBounds(111, 104, 121, 29);
		frame.getContentPane().add(supplierIdTextPane);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(111, 86, 56, 16);
		frame.getContentPane().add(lblId);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(111, 140, 56, 16);
		frame.getContentPane().add(lblName);
		
		supplierNameTextPane = new JTextPane();
		supplierNameTextPane.setBounds(111, 158, 121, 29);
		frame.getContentPane().add(supplierNameTextPane);
		
		minAmountLabel = new JLabel("Min. amount:");
		minAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		minAmountLabel.setBounds(236, 19, 121, 16);
		frame.getContentPane().add(minAmountLabel);
		
		minAmountTextPane = new JTextPane();
		minAmountTextPane.setBounds(369, 13, 82, 29);
		frame.getContentPane().add(minAmountTextPane);
		
		amountToOrderLabel = new JLabel("To order:");
		amountToOrderLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		amountToOrderLabel.setBounds(236, 60, 105, 20);
		frame.getContentPane().add(amountToOrderLabel);
		
		toOrderTextPane = new JTextPane();
		toOrderTextPane.setBounds(368, 53, 83, 29);
		frame.getContentPane().add(toOrderTextPane);
		
		daysToExpireLabel = new JLabel("Days to expire:");
		daysToExpireLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		daysToExpireLabel.setBounds(236, 104, 129, 16);
		frame.getContentPane().add(daysToExpireLabel);
		
		daysToExpireTextPane = new JTextPane();
	//	daysToExpireTextPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		daysToExpireTextPane.setBounds(369, 91, 82, 29);
		frame.getContentPane().add(daysToExpireTextPane);
		
		priceLabel = new JLabel("Price:");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		priceLabel.setBounds(236, 139, 56, 16);
		frame.getContentPane().add(priceLabel);
		
		priceTextPane = new JTextPane();
		priceTextPane.setBounds(369, 127, 82, 29);
		frame.getContentPane().add(priceTextPane);
		
		discountLabel = new JLabel("Discount:");
		discountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		discountLabel.setBounds(236, 171, 82, 16);
		frame.getContentPane().add(discountLabel);
		
		discountTextPane = new JTextPane();
		discountTextPane.setBounds(369, 164, 82, 29);
		frame.getContentPane().add(discountTextPane);
		
		agreementLabel = new JLabel("Agreement:");
		agreementLabel.setBounds(111, 245, 77, 16);
		frame.getContentPane().add(agreementLabel);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(111, 265, 340, 29);
		frame.getContentPane().add(textPane_1);
		
		editInfoButton = new JButton("Edit product information\r\n");
		editInfoButton.setBounds(0, 331, 463, 39);
		frame.getContentPane().add(editInfoButton);
		
		twoButtonsPanel = new JPanel();
		twoButtonsPanel.setBounds(0, 544, 463, 36);
		frame.getContentPane().add(twoButtonsPanel);
		twoButtonsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		cancelButton = new JButton("Cancel");
		twoButtonsPanel.add(cancelButton);
		
		saveButton = new JButton("Save");
		twoButtonsPanel.add(saveButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 369, 463, 175);
		frame.getContentPane().add(scrollPane);
		
		batchesPanel = new JPanel();
		scrollPane.setViewportView(batchesPanel);

		contactTextPane = new JTextPane();
		contactTextPane.setBounds(111, 215, 342, 29);
		frame.getContentPane().add(contactTextPane);

		contactLabel = new JLabel("Contact:");
		contactLabel.setBounds(111, 200, 56, 16);
		frame.getContentPane().add(contactLabel);
	}
	
	public Product getModifiedProduct()
	{
		Supplier s = new Supplier(supplierIdTextPane.getText(), supplierNameTextPane.getText(),
				contactTextPane.getText(), textPane_1.getText());
		product.setAmountToOrder(Integer.parseInt(toOrderTextPane.getText()));
		product.setName(textPane.getText());
		product.setSupplier(s);
		product.setDiscount(Double.parseDouble(discountTextPane.getText()));
		product.setMinAmount(Integer.parseInt(minAmountTextPane.getText()));
		product.setDescription(descriptionTextPane.getText());
		product.setDaysToExpire(Integer.parseInt(daysToExpireTextPane.getText()));
		product.setPrice(Double.parseDouble(priceTextPane.getText()));
		
		return product;
		
	}
	
}
