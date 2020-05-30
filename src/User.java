import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class User {
	protected String firstName;
	protected String surName;
	protected String password;
	protected String telephone;
	protected String AFM;
	protected String id;
	protected String company;
	protected int type;
	protected Orders orders;
	
	/*
	 * Empty Constructor
	 */
	public User() {
	}

	/*
	 * Constructor
	 */
	public User(String firstName, String surName, String password, String telephone, String aFM, String id, String company, int type)
	{
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.telephone = telephone;
		AFM = aFM;
		this.id = id;
		this.company = company;
		this.type = type;
		this.orders=new Orders();
	}


	public void initializeLists()
	{
		
	}
	
	public void refresh()
	{
		
	}
	
	/*
	 * The following method is used to search based on a key and a field that the user chooses in Search Form
	 */
	public void searchForOrder(String key, int column)
	{
		
		Boolean found=false;
		ArrayList<Object> ordersKEY = new ArrayList<>();
		if(column==0) {                                      //0 to orderId
			for(Order o : this.orders.orders)
			{
				if(o.getOrderId().equals(key))
					{
						ordersKEY.add(o);
						found=true;
					}
			}
		}
		else if (column==1) {                              //1 to supplierId
			for(Order o : this.orders.orders)
			{
				if(o.getSupplierId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==2) {                              //2 to productId
			for(Order o : this.orders.orders)
			{
				if(o.getProductId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==3) {                              //3 to productName
			for(Order o : this.orders.getOrders())
			{
				if(o.getProductName().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==4) {                              //4 to date
			for(Order o : this.orders.orders)
			{
				if(o.getDate().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==5) {                             //5 to status
			int intkey = Integer.parseInt(key);
			for(Order o : this.orders.orders)
			{
				if(o.getStatus()==intkey) ordersKEY.add(o);
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, ordersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * The following method is used to edit an order.
	 */
	public void editOrder(Order o, int index)
	{
		orders.getOrders().set(index, o);
	}

	
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAFM() {
		return AFM;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}