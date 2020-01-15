package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.AdminController;
import Model.Product;

public class ProductPanelGenerator {
	
	private Product product;
	private JButton viewButton;
	
	private JPanel barcodeNumberPanel;
	private JPanel productPanel;
	private JPanel productDescriptionPanel;
	private JPanel buttonPanel;

	private JButton removeButton;
	private JButton checkInButton;

	private JLabel barcode;
	private JLabel productName;
	private JLabel productDescription;
	
	private String removeButtonHtml = "<html><center style=\"color:red;font-size:13px;\">Remove</center></html>";
	private String viewButtonHtml = "<html><center style=\"color:green;font-size:13px;\">View</center></html>";
	
	public ProductPanelGenerator(Product product)
	{
		this.product = product;
		
		removeButton = new JButton(removeButtonHtml);
		removeButton.setFocusPainted(false);
		viewButton = new JButton(viewButtonHtml);
		viewButton.setFocusPainted(false);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));

		buttonPanel.add(viewButton);
		buttonPanel.add(removeButton);

		barcode = new JLabel(
				"<html><center style=\"color:black;font-size:10px;\">"
						+ product.getBarcode() + "</center></html>");

		/* ==================ROOM PANEL============================ */
		barcodeNumberPanel = new JPanel();
		barcodeNumberPanel.setLayout(new GridLayout(1, 1));

		barcodeNumberPanel.add(barcode);
		/* ===============END ROOM PANE============================ */
		/* =======================Room description panel==================== */
		productDescriptionPanel = new JPanel();
		productDescriptionPanel.setLayout(new GridLayout(1, 2));

		productDescription = new JLabel("<html><center style=\"padding-left:100px; font-size:20px;\">"
				+ product.getName() + "</center></html>");

		

		productName = new JLabel("<html><center style=\"padding-top:0px;\">"+product.getDescription()+ "<br>Price:"+product.getPrice()+"</center></html>");

		productDescriptionPanel.add(productDescription);

		productDescriptionPanel.add(productName);
		productDescription.setFont(new Font("Times New Roman",
				Font.LAYOUT_NO_START_CONTEXT, 20));
		productName.setFont(new Font("Courier New", Font.BOLD, 15));
		productName.setHorizontalAlignment(SwingConstants.CENTER);
		productName.setFont(new Font("Courier New", Font.CENTER_BASELINE, 15));
		/* ====================end Room description panel==================== */

		/* =================Booking Panel PANEL============================ */
		productPanel = new JPanel();
		productPanel.setMaximumSize(new Dimension(900, 60));
		productPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		productPanel.setBackground(Color.WHITE);
		productPanel.setLayout(new BorderLayout());
		productPanel.setBorder(new LineBorder(Color.BLUE));

		productPanel.add(barcodeNumberPanel, BorderLayout.WEST);
		productPanel.add(productDescriptionPanel, BorderLayout.CENTER);
		productPanel.add(buttonPanel, BorderLayout.EAST);
		/* ================END Booking PANEL========================= */
		
	}
	
	public void initButtons(AdminController listener)
	{
		removeButton.addActionListener(listener);
		viewButton.addActionListener(listener);
	}
	
	public JButton getViewButton()
	{
		return viewButton;
	}
	
	public JButton getRemoveButton()
	{
		return removeButton;
	}
	
	public JPanel getPanel() {
		return productPanel;
	}
	
	public Product getProduct()
	{
		return product;
	}
}
