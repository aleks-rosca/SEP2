package Model;

import java.io.Serializable;

/**
 * A class that contains all the information about the costumer;
 * @author Alexandru
 *
 */
public class Supplier implements Serializable{
	
	private String suplierId;
	private String name;
	private String contact;
	private String agreement;
	
	/**
	 * 3-argument constructor;
	 * @param name
	 * @param contact
	 * @param agreement
	 */
	public Supplier(String name, String contact, String agreement) {
		super();
		this.suplierId = "";
		this.name = name;
		this.contact = contact;
		this.agreement = agreement;
	}
	
	/**
	 * 4-argument constructor
	 * @param supplierId
	 * @param name
	 * @param contact
	 * @param agreement
	 */
	public Supplier(String supplierId,String name, String contact, String agreement) {
		super();
		this.suplierId = supplierId;
		this.name = name;
		this.contact = contact;
		this.agreement = agreement;
	}
	
	/**
	 * Gets supplier name;
	 * @return supplier name;
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets supplier name;
	 * @param name the supplier name;
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets supplier contact;
	 * @return supplier contact;
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * Sets supplier contact;
	 * @param contact supplier contact;
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * Gets supplier agreement;
	 * @return return supplier agreement;
	 */
	public String getAgreement() {
		return agreement;
	}
	/**
	 * Sets supplier agreement;
	 * @param agreement supplier agreement;
	 */
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	
	/**
	 * Sets supplier id;
	 * @param supplierId supplier id;
	 */
	public void setSupplierId(String supplierId)
	{
		this.suplierId = supplierId;
	}
	
	/**
	 * Gets supplier id;
	 * @return supplier id;
	 */
	public String getSupplierId()
	{
		return suplierId;
	}

	/**
	 * ToString method;
	 */
	@Override
	public String toString() {
		return "Supplier [suplierId=" + suplierId + ", name=" + name
				+ ", contact=" + contact + ", agreement=" + agreement + "]";
	}
	
	

}
