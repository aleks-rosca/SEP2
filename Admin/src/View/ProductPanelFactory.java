package View;
import java.util.HashMap;

import javax.swing.JPanel;

import Controller.AdminController;
import Model.Product;
;

/**
 * A class responsible for creating and storing CheckInGui frames;
 * @author Alexandru
 *
 */
public class ProductPanelFactory {

private static HashMap<Product,ProductPanelGenerator> productPanels = new HashMap<Product, ProductPanelGenerator>();
	
/**
 * Retrieve the CheckInGui object for the given booking;
 * @param booking
 * @param listener listener to be assigned to the buttons;
 * @return A checkInGui object;
 */
	public static JPanel getProductPanelFor(Product product, AdminController listener)
	{
		ProductPanelGenerator res = productPanels.get(product);

		if(res == null)
		{
			res = new ProductPanelGenerator(product);
			res.initButtons(listener);
			productPanels.put(product, res);
		}
		
		return res.getPanel();
	}
	
	/**
	 * Check through the map if there is a button matching given listener;
	 * @param button
	 * @return CheckInGui object - if there is a button matching the listener; null - if there is no button;
	 */
	public static ProductPanelGenerator hasButton(Object button)
	{
		for(ProductPanelGenerator n : productPanels.values())
		{
			if(n.getRemoveButton() == button || n.getViewButton() == button )
				return n;
		}
		
		return null;
	}
	
}