package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import Controller.AdminController;

/**
 * A class responsible to build Order page;
 * @author Alexandru
 *
 */
public class OrderPage {
	
	private JPanel panel;
	private JPanel addPanel;
	private JTextPane barcodeTextPane;
	private JButton addButton;
	private JLabel lblBarcode;
	private JButton placeOrderButton;
	
	private String placeOrderButtonHtml = "<html><center style=\"color:green;font-size:13px;\">Place order</center></html>";
	
	/**
	 * Builds order page in a given panel;
	 * @param displayPanel JPanel to build the page in;
	 */
	public void buildOrdersPage(JPanel displayPanel)
	{
		displayPanel.removeAll();
		
		Font f = new Font("Tahome", Font.LAYOUT_LEFT_TO_RIGHT, 16);

		addPanel = new JPanel();
		addPanel.setBounds(2, 2, 881, 50);
		displayPanel.add(addPanel);
		addPanel.setLayout(null);
		
		barcodeTextPane = new JTextPane();
		barcodeTextPane.setBounds(114, 2, 161, 48);
		barcodeTextPane.setFont(f);
		addPanel.add(barcodeTextPane);
		
		addButton = new JButton("Add product");
		addButton.setBounds(287, 2, 170, 48);
		addPanel.add(addButton);
		
		lblBarcode = new JLabel("Barcode:");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBarcode.setBounds(12, 15, 96, 32);
		addPanel.add(lblBarcode);
		
		placeOrderButton = new JButton(placeOrderButtonHtml);

		placeOrderButton.setBounds(483, 2, 394, 48);
		addPanel.add(placeOrderButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(2, 55, 881, 352);
		displayPanel.add(scrollPane);
		
		JPanel productsPane = new JPanel();
		scrollPane.setViewportView(productsPane);
		
		displayPanel.repaint();
		displayPanel.revalidate();
	}
	
	/**
	 * Init the buttons with a given listener;
	 * @param listener Listener;
	 */
	public void initButtons(AdminController listener)
	{
		addButton.addActionListener(listener);
		placeOrderButton.addActionListener(listener);
	}
	
	/**
	 * Gets barcode;
	 * @return
	 */
	public String getBarcode()
	{
		return barcodeTextPane.getText();
	}
	
	/**
	 * Gets add button;
	 * @return add JButton;
	 */
	public JButton getAddButton()
	{
		return addButton;
	}
	
	/**
	 * Gets place order;
	 * @return place order jButton;
	 */
	public JButton getPlaceOrder()
	{
		return placeOrderButton;
	}
	
	/**
	 * Clear barcode text field;
	 */
	public void clearBarcode()
	{
		barcodeTextPane.setText("");
	}
	
}
