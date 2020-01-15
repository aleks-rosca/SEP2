package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.CashierController;
import Model.Product;
import Model.ToSell;

public class ProductPanelGenerator {
	
	private ToSell product;
	
	private JPanel productPanel;
	private JPanel productDescriptionPanel;
	private JPanel buttonPanel;

	private JButton removeButton;

	private JLabel productName;
	private JLabel productAmount;
	private JLabel totalPrice;
	
	private String removeButtonHtml = "<html><center style=\"color:red;font-size:13px;\">Delete</center></html>";
	
	public ProductPanelGenerator(ToSell product)
	{
		this.product = product;
		
		removeButton = new JButton(removeButtonHtml);
		removeButton.setPreferredSize(new Dimension(80, 40));
		removeButton.setFocusPainted(false);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 1));

		buttonPanel.add(removeButton);

		/* =======================Room description panel==================== */
		productDescriptionPanel = new JPanel();

		productDescriptionPanel.setLayout(new BoxLayout(productDescriptionPanel, BoxLayout.X_AXIS));

		productName = new JLabel("<html>"+product.getProduct().getName()+" </html>");

		productAmount = new JLabel("<html>"+ product.getProduct().getPrice() + " x " + product.getAmount()
				+ " </html>");
		
		totalPrice = new JLabel("<html><center>"+product.getTotalPrice()+"</center></html>");
		totalPrice.setPreferredSize(new Dimension(60, 40));
		productDescriptionPanel.add(productName,BorderLayout.WEST);
		productDescriptionPanel.add(Box.createHorizontalStrut(70));	

		productDescriptionPanel.add(productAmount,BorderLayout.CENTER);


		productName.setFont(new Font("Courier New", Font.BOLD, 13));
		productName.setHorizontalAlignment(SwingConstants.CENTER);
		productName.setFont(new Font("Courier New", Font.CENTER_BASELINE, 15));
		/* ====================end Room description panel==================== */

		/* =================Booking Panel PANEL============================ */
		productPanel = new JPanel();
		productPanel.setBackground(Color.WHITE);
		productPanel.setMaximumSize(new Dimension(800, 40));
		productPanel.setAlignmentY(Component.TOP_ALIGNMENT);

		productPanel.setLayout(new BorderLayout());
		productPanel.setBorder(new LineBorder(Color.BLUE));

		productPanel.add(productDescriptionPanel, BorderLayout.CENTER);
		productPanel.add(buttonPanel, BorderLayout.WEST);
		productPanel.add(totalPrice, BorderLayout.EAST);
		/* ================END Booking PANEL========================= */
		
	}
	
	public void initButtons(CashierController listener)
	{
		removeButton.addActionListener(listener);
	}
	
	public JButton getRemoveButton()
	{
		return removeButton;
	}
	
	public JPanel getPanel() {
		return productPanel;
	}
	
	public ToSell getProduct()
	{
		return product;
	}
}
