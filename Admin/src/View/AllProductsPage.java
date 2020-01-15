package View;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * A class responsible to build all products page;
 * @author Alexandru
 *
 */
public class AllProductsPage {
	
	private JScrollPane displayPanelScrollPane;
	private JPanel panel;
	
	/**
	 * Non-argument constructor;
	 */
	public AllProductsPage()
	{
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		displayPanelScrollPane = new JScrollPane(panel);
		
		displayPanelScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		displayPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		displayPanelScrollPane.setBounds(2, 2, 881, 405);
	}
	
	/**
	 * Builds the page in a given panel.
	 * @param displayPanel JPanel to build the page in;
	 */
	public void buildAllProductsPage(JPanel displayPanel)
	{
		displayPanel.removeAll();
		
		displayPanel.add(displayPanelScrollPane);	
		
		displayPanel.repaint();
		displayPanel.revalidate();
	}
	
	/**
	 * Inserts the products in the main panel.
	 * @param products Products to be inserted;
	 */
	public void putProductsIntoPanel(JPanel[] products)
	{
		panel.removeAll();

		for(int i = 0; i < products.length; i++)
		{
			panel.add(products[i]);
		}
		
		panel.repaint();
		panel.revalidate();
	}
	
	

}
