package View;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import Controller.AdminController;
/**
 * A class responsible to build main page.
 * @author Dumitru Muntean
 *
 */
public class MainPage {

	private JFrame frmMarketManagement;
	private JTextField descriptionTextField;
	private JTextField supplierTextField;
	private JTextField nameTextField;
	private JTextField barcCodeTextField;
	private JPanel panel;
	private JButton searchButton;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblSupplier;
	private JLabel lblDescription;
	private JPanel panel_1;
	private JButton addProuctsButton;
	private JButton allProductsButton;
	private JButton orderButton;
	private JButton expireButton;
	private JPanel dispalyPanel;
	private JPanel bigImagePanel;
	
	private ImageIcon mainImage1;
	private ImageIcon mainImage2;
	private JLabel mainImageLabel1;
	private JLabel mainImageLabel2;
	
	private AdminController listener;
	
	/**
	 * 1-argument constructor;
	 */
	public MainPage(AdminController listener) {
		this.listener = listener;
		initialize(this.listener);
		frmMarketManagement.setVisible(true);
		frmMarketManagement.setSize(910, 710);
		frmMarketManagement.setResizable(false);
		frmMarketManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketManagement.setLocationRelativeTo(null);
		frmMarketManagement.setTitle("SIMS Admin");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AdminController listener) {
		frmMarketManagement = new JFrame();
		frmMarketManagement.getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 102, 883, 68);
		frmMarketManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		mainImage1 = new ImageIcon(MainPage.class.getResource("../inventory1.png"));
		mainImageLabel1 = new JLabel(mainImage1);
		mainImage2 = new ImageIcon(MainPage.class.getResource("../inventory2.png"));
		mainImageLabel2 = new JLabel(mainImage2);
		
		searchButton = new JButton("Search");
		searchButton.setIcon(new ImageIcon("D:\\Denmark\\VIA University College\\2-nd semester\\SEP2\\Coding\\Admin\\img\\icon_search.png"));
		searchButton.setBounds(742, -1, 141, 70);
		searchButton.addActionListener(listener);
		panel.add(searchButton);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(564, 28, 173, 35);
		panel.add(descriptionTextField);
		descriptionTextField.setColumns(10);
		
		supplierTextField = new JTextField();
		supplierTextField.setColumns(10);
		supplierTextField.setBounds(379, 28, 173, 35);
		panel.add(supplierTextField);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(194, 28, 173, 35);
		panel.add(nameTextField);
		
		barcCodeTextField = new JTextField();
		barcCodeTextField.setColumns(10);
		barcCodeTextField.setBounds(9, 28, 173, 35);
		panel.add(barcCodeTextField);
		
		lblNewLabel = new JLabel("Barcode:");
		lblNewLabel.setBounds(9, -1, 173, 26);
		panel.add(lblNewLabel);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(194, 0, 173, 26);
		panel.add(lblName);
		
		lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(379, 0, 173, 26);
		panel.add(lblSupplier);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(564, 0, 173, 25);
		panel.add(lblDescription);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 177, 885, 63);
		frmMarketManagement.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		addProuctsButton = new JButton("Add products");
		addProuctsButton.addActionListener(listener);
		panel_1.add(addProuctsButton);
		
		allProductsButton = new JButton("All products");
		allProductsButton.addActionListener(listener);
		panel_1.add(allProductsButton);
		
		orderButton = new JButton("Order");
		orderButton.addActionListener(listener);
		panel_1.add(orderButton);
		
		expireButton = new JButton("Expire");
		expireButton.addActionListener(listener);
		panel_1.add(expireButton);
		
		dispalyPanel = new JPanel();
		dispalyPanel.setBorder(new LineBorder(Color.BLUE, 2));
		dispalyPanel.setBounds(10, 250, 885, 409);
		frmMarketManagement.getContentPane().add(dispalyPanel);
		dispalyPanel.setLayout(null);
		
		searchButton.setFocusPainted(false);
		
		JPanel bigImagePanel = new JPanel();
		bigImagePanel.setBounds(0, 13, 883, 86);
		bigImagePanel.setLayout(new GridLayout(1,2));
		bigImagePanel.add(mainImageLabel2);
		bigImagePanel.add(mainImageLabel1);

		frmMarketManagement.getContentPane().add(bigImagePanel);
	}
	
	/**
	 * Gets add products button;
	 * @return add products button;
	 */
	public JButton getAddProductsButton()
	{
		return addProuctsButton;
	}
	
	/**
	 * Gets order button;
	 * @return order button;
	 */
	public JButton getOrdeButton()
	{
		return orderButton;
	}
	
	/**
	 * Gets expire button;
	 * @return expire jbutton;
	 */
	public JButton getExpireButton()
	{
		return expireButton;
	}
	
	/**
	 * Gets all products button
	 * @return all products jbutton;
	 */
	public JButton getAllProductsButton()
	{
		return allProductsButton;
	}
	
	/**
	 * Gets search button;
	 * @return search jbutton;
	 */
	public JButton getSearchButton()
	{
		return searchButton;
	}
	
	/**
	 * Gets main panel.
	 * @return main jpanel;
	 */
	public JPanel getDisplayPanel()
	{
		return dispalyPanel;
	}
	
	/**
	 * Gets barcode;
	 * @return barcode;
	 */
	public String getBarcode()
	{
		return barcCodeTextField.getText();
	}
	
	/**
	 * Gets supplier;
	 * @return supplier;
	 */
	public String getSupplier()
	{
		return supplierTextField.getText();
	}
	
	/**
	 * Gets description;
	 * @return description;
	 */
	
	public String getDescription()
	{
		return descriptionTextField.getText();
	}
	
	/**
	 * Gets name;
	 * @return name;
	 */
	public String getName()
	{
		return nameTextField.getText();
	}
}
