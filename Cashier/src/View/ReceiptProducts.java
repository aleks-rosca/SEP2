package View;

import java.util.ArrayList;

public class ReceiptProducts {
	
	private static ArrayList<ProductPanelGenerator> products = new ArrayList<ProductPanelGenerator>();
	
	public static void addProdduct(ProductPanelGenerator product)
	{
		products.add(product);
	}
	
	public static ProductPanelGenerator hasButton(Object obj)
	{
		ProductPanelGenerator result = null;
		
		for(int i = 0; i < products.size(); i++)
			if(products.get(i).getRemoveButton() == obj)
			{
				result = products.get(i);
				break;
			}
		return result;
	}
	
	public void clear()
	{
		products.clear();
	}
}
