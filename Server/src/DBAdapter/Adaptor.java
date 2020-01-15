package DBAdapter;

import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.Region;

import Model.Batch;
import Model.Product;
import Model.Receipt;
import Model.Supplier;
import Model.ToSell;

/**
 * @inheritDoc
 * @author
 *
 */
public class Adaptor implements IAdaptor {

	private Adaptee adaptee;

	/**
	 * Non-argument constructor
	 * 
	 * @throws ClassNotFoundException
	 */
	public Adaptor() throws ClassNotFoundException {
		adaptee = new Adaptee();
	}

	@Override
	public String getSupplierId(Supplier supplier) throws SQLException {
		String sql = "select supplierid from supplier where supname='"
				+ supplier.getName() + "';";

		ResultSet rs = adaptee.query(sql);
		String result = "";
		while (rs.next()) {
			result = rs.getString("supplierid");
		}

		if (result.equals("")) {
			addNewSupplier(supplier);
			result = getSupplierId(supplier);
		}

		return result;
	}

	@Override
	public void addNewSupplier(Supplier supplier) throws SQLException {
		String sql = "insert into supplier values(1, '" + supplier.getName()
				+ "', '" + supplier.getContact() + "', '"
				+ supplier.getAgreement() + "');";

		adaptee.update(sql);
	}

	private int getGeneratedBatchNo(int orderid) throws SQLException {
		String sql = "select max(batchid) as batchid from receivedbatch where orderid="
				+ orderid + ";";

		ResultSet rs = adaptee.query(sql);

		int res = -1;

		while (rs.next()) {
			res = rs.getInt("batchid");
		}

		return res;
	}

	@Override
	public void addNewBatch(Batch batch) throws SQLException {
		String sql1 = "select addReceivedBatch(" + batch.getOrderId() + ");";
		adaptee.query(sql1);
		int batchid = getGeneratedBatchNo(batch.getOrderId());
		String sql2 = "insert into batch values('" + batchid + "','"
				+ batch.getProduct().getBarcode() + "','"
				+ batch.getExpireDate() + "','" + batch.getAmount() + "');";
		adaptee.update(sql2);
	}

	@Override
	public Product getProductByBarcode(String barcode) throws SQLException {
		String sql = "select * from AllProdInfo where barcode='" + barcode
				+ "';";

		ResultSet rs = adaptee.query(sql);
		Product product = null;

		// barcode,prodName,description,price,p.supplierid,minAmount,amountToOrder,daysToExpire,s.supName,contact,deliveryAgrement
		while (rs.next()) {
			String barcoder = rs.getString("barcode");
			String prodName = rs.getString("prodName");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			int minAmount = rs.getInt("minAmount");
			int amountToOrder = rs.getInt("amountToOrder");
			int daysToExpire = rs.getInt("daysToExpire");
			String supName = rs.getString("supName");
			String supContact = rs.getString("contact");
			String deliveryAgreement = rs.getString("deliveryAgrement");
			String supplierId = rs.getString("supplierid");
			double discount = rs.getDouble("discount");

			Supplier supplier = new Supplier(supplierId, supName, supContact,
					deliveryAgreement);
			product = new Product(barcode, prodName, description, price,
					supplier, amountToOrder, minAmount, daysToExpire, discount);
		}

		return product;
	}

	@Override
	public Product[] getAllProducts() throws SQLException {
		String sql = "select * from AllProdInfo;";

		ResultSet rs = adaptee.query(sql);

		ArrayList<Product> products = new ArrayList<Product>();

		while (rs.next()) {
			String barcode = rs.getString("barcode");
			String prodName = rs.getString("prodName");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			int minAmount = rs.getInt("minAmount");
			int amountToOrder = rs.getInt("amountToOrder");
			int daysToExpire = rs.getInt("daysToExpire");
			String supName = rs.getString("supName");
			String supContact = rs.getString("contact");
			String deliveryAgreement = rs.getString("deliveryAgrement");
			String supplierId = rs.getString("supplierid");
			double discount = rs.getDouble("discount");

			Supplier supplier = new Supplier(supplierId, supName, supContact,
					deliveryAgreement);
			Product product = new Product(barcode, prodName, description,
					price, supplier, amountToOrder, minAmount, daysToExpire,
					discount);

			products.add(product);
		}

		return products.toArray(new Product[products.size()]);

	}

	public void inFromCashier(ToSell product) throws SQLException {
		String sql = "infromcasier(" + product.getProduct() + ","
				+ product.getAmount() + ");";
		adaptee.update(sql);
	}

	@Override
	public void removeFromStock(Receipt receipt) throws SQLException {

		for (int i = 0; i < receipt.getProducts().size(); i++)
			inFromCashier(receipt.getProducts().get(i));
	}

	@Override
	public Product[] searchProducts(String barcode, String name,
			String supplier, String description) throws SQLException {

		String sql = "select * from AllProdInfo where ";

		int k = 0;

		if (!barcode.equals("")) {
			sql += " barcode='" + barcode + "'";
			k++;
		}
		if (!name.equals("")) {
			if (k > 0)
				sql += " and ";
			sql += "  prodName like'%" + name + "%' ";
			k++;
		}
		if (!supplier.equals("")) {
			if (k > 0)
				sql += " and ";
			sql += " (" + "supName  like '%" + supplier + "%' or supplierid='"
					+ supplier + "' or contact like '%" + supplier + "%' ) ";
			k++;
		}

		if (!description.equals("")) {
			if (k > 0)
				sql += " and ";

			sql += " description like '%" + description + "%'";
			k++;
		}

		sql += ";";

		ResultSet rs = adaptee.query(sql);

		ArrayList<Product> products = new ArrayList<Product>();

		while (rs.next()) {
			String Barcode = rs.getString("barcode");
			String prodName = rs.getString("prodName");
			String Description = rs.getString("description");
			double price = rs.getDouble("price");
			int minAmount = rs.getInt("minAmount");
			int amountToOrder = rs.getInt("amountToOrder");
			int daysToExpire = rs.getInt("daysToExpire");
			String supName = rs.getString("supName");
			String supContact = rs.getString("contact");
			String deliveryAgreement = rs.getString("deliveryAgrement");
			String supplierId = rs.getString("supplierid");
			double discount = rs.getDouble("discount");

			Supplier Supplier = new Supplier(supplierId, supName, supContact,
					deliveryAgreement);
			Product product = new Product(Barcode, prodName, Description,
					price, Supplier, amountToOrder, minAmount, daysToExpire,
					discount);

			products.add(product);
		}

		return products.toArray(new Product[products.size()]);

	}

	@Override
	public Integer[] getAllOrdersId() throws SQLException {

		String sql = "select orderid from orders;";

		ResultSet rs = adaptee.query(sql);

		ArrayList<Integer> result = new ArrayList<Integer>();

		while (rs.next()) {
			result.add(rs.getInt("orderid"));
		}

		return result.toArray(new Integer[result.size()]);
	}

	@Override
	public void updateProduct(Product newProduct) throws SQLException {

		String sql = "update AllProdInfo set prodName='" + newProduct.getName()
				+ "', description='" + newProduct.getDescription()
				+ "', price='" + newProduct.getPrice() + "', minAmount='"
				+ newProduct.getMinAmount() + "', amountToOrder='"
				+ newProduct.getAmountToOrder() + "', daysToExpire='"
				+ newProduct.getDaysToExpire() + "', supName='"
				+ newProduct.getSupplier().getName() + "', contact='"
				+ newProduct.getSupplier().getContact()
				+ "', deliveryAgrement='"
				+ newProduct.getSupplier().getAgreement() + "', supplierid='"
				+ newProduct.getSupplier().getSupplierId()
				+ "' where barcode = '" + newProduct.getBarcode() + "' ;";

		adaptee.update(sql);
	}

	@Override
	public void addToOrdeR(Product product) throws SQLException {

		String sql = "select addToOrder('" + product.getBarcode() + "');";

		adaptee.update(sql);

	}

	/*
	 * String sql = "insert into AllProdInfo values('" + product.getBarcode() +
	 * "', '" + product.getName() + "', '" + product.getDescription() + "', '" +
	 * product.getPrice() + "', '" +supplier.getSupplierId()+"', '" +
	 * product.getMinAmount() + "', '" + product.getAmountToOrder() + "', '" +
	 * product.getDaysToExpire() + "', '" + supplier.getName() + "', '" +
	 * supplier.getContact() + "', '" + supplier.getAgreement() + "');";
	 */

	@Override
	public void addNewProduct(Product product) throws SQLException {

		Supplier supplier = product.getSupplier();

		String sql = "insert into AllProdInfo values('" + product.getBarcode()
				+ "', '" + product.getName() + "', '"
				+ product.getDescription() + "', '" + product.getPrice()
				+ "', '" + supplier.getSupplierId() + "', '"
				+ product.getMinAmount() + "', '" + product.getAmountToOrder()
				+ "', '" + product.getDaysToExpire() + "', '"
				+ supplier.getName() + "', '" + supplier.getContact() + "', '"
				+ supplier.getAgreement() + "' , '" + 0 + "');";

		try {
			adaptee.update(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Product[] getAllProductsToOrder() throws SQLException {
	//	String sql = "select barcode from toorder"
		
		return null;
	}

	@Override
	public void removeProduct(Product product) throws SQLException {
		
		String sql = "delete from product where barcode='" + product.getBarcode() +"';";
		
		adaptee.update(sql);
		
	}
	
	
	
	
	
}
