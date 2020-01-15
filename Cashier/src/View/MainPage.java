package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import Controller.CashierController;
import Model.Product;
import Model.Receipt;
import Model.ToSell;

public class MainPage implements Observer{
	
	private JFrame frmCashier;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextPane barcodeTextPane;
	private JPanel panel_3;
	private JTextPane amountTextPane;
	private JButton btnAdd; 
	private JLabel lblBarcode;
	private JLabel lblAmount;
	private JPanel totalPanel;
	private JLabel lblTotal;
	private JLabel lblTaxvat;
	private JLabel totalPriceLabel;
	private JLabel label;
	private JButton btnFinish;
	private JScrollPane scrollPane_1;
	private JPanel productsPanel;
	
	private CashierController listener;
	
	public MainPage(CashierController listener)
	{
		this.listener = listener;
		frmCashier = new JFrame();
		initialize();
		frmCashier.setResizable(false);
		frmCashier.setTitle("SIMS Cashier");
		frmCashier.getContentPane().setBackground(new Color(248, 248, 255));
		frmCashier.setBounds(100, 100, 680, 653);
		frmCashier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashier.getContentPane().setLayout(null);
		frmCashier.setLocationRelativeTo(null);
		frmCashier.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 674, 53);
		frmCashier.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		barcodeTextPane = new JTextPane();
		barcodeTextPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_2.add(barcodeTextPane);
		barcodeTextPane.setForeground(new Color(0, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		amountTextPane = new JTextPane();
		amountTextPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(amountTextPane);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btnAdd);
		btnAdd.addActionListener(listener);
		
		lblBarcode = new JLabel("Barcode");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBarcode.setBounds(0, 13, 143, 31);
		frmCashier.getContentPane().add(lblBarcode);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAmount.setBounds(233, 15, 118, 26);
		frmCashier.getContentPane().add(lblAmount);

		totalPanel = new JPanel();
		totalPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.setBounds(0, 475, 674, 87);
		frmCashier.getContentPane().add(totalPanel);
		totalPanel.setLayout(null);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(12, 0, 85, 41);
		totalPanel.add(lblTotal);
		lblTotal.setForeground(new Color(255, 0, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblTaxvat = new JLabel("Tax (VAT) : ");
		lblTaxvat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTaxvat.setBounds(12, 54, 114, 20);
		totalPanel.add(lblTaxvat);
		
		totalPriceLabel = new JLabel("0.00");
		totalPriceLabel.setForeground(new Color(255, 0, 0));
		totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		totalPriceLabel.setBounds(514, 6, 148, 29);
		totalPanel.add(totalPriceLabel);
		
		label = new JLabel("0.00");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(514, 56, 148, 16);
		totalPanel.add(label);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(0, 564, 674, 53);
		frmCashier.getContentPane().add(btnFinish);
		btnFinish.setForeground(new Color(0, 128, 0));
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnFinish.addActionListener(listener);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 102, 674, 370);
		frmCashier.getContentPane().add(scrollPane_1);
		
		
		
		productsPanel = new JPanel();
		productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.PAGE_AXIS));
		productsPanel.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(productsPanel);
		
	
	}
	
	public JButton getAddButton()
	{
		return btnAdd;
	}
	
	public JButton getFinishButton()
	{
		return btnFinish;
	}
	
	public String getBarcode()
	{
		return barcodeTextPane.getText();
	}
	
	public String getAmount()
	{
		return amountTextPane.getText();
	}
	
	public void displayProduct(JPanel product)
	{
		productsPanel.add(product);
	//	productsPanel.add(Box.createVerticalStrut(20));	

		productsPanel.repaint();
		productsPanel.revalidate();
	}
	@Override
	public void update(Observable o, Object arg) {
		
		//String l = (String)arg;
		//totalPriceLabel.setText(l);
		Receipt r = (Receipt)o;
		String l = r.getTotal();
		
		double vat = Double.parseDouble(l)*0.25;
		
		totalPriceLabel.setText(l);
		String c = Double.toString(vat);
		label.setText(c);
			
	}
	
	public void clearInputFields()
	{
		barcodeTextPane.setText("");
		amountTextPane.setText("");
	}
	
	public void removeProductFromTheList(JPanel product)
	{
		productsPanel.remove(product);
		productsPanel.repaint();
		productsPanel.revalidate();
	}
	
	public void clearMainPanel()
	{
		clearInputFields();
		totalPriceLabel.setText("0.00");
		label.setText("0.00");
		productsPanel.removeAll();
		productsPanel.repaint();
		productsPanel.revalidate();
	}
}
