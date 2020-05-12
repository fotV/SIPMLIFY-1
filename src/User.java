import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class User {
	protected String firstName;
	protected String surName;
	protected String password;
	protected String telephone;
	protected String AMA;
	protected String id;
	protected String company;
	protected int type;
	protected Orders orders = new Orders();
	

	public User(String firstName, String surName, String password, String telephone, String aMA, String id) {
		//super();
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.telephone = telephone;
		this.AMA = aMA;
		this.id = id;
	
		
	}
	
	public User() {
		this.firstName = "";
		this.surName = "";
		this.AMA = "";
		this.id = "";
		this.company = "";
		this.password = " ";
	}

	public void initializeLists()
	{
		
	}
	
	public void refresh()
	{
		
	}
	
	public void searchForOrder(String key, int column)
	{
		Boolean found=false;
		ArrayList<Object> ordersKEY = new ArrayList<>();
		if(column==1) {                                      //1 to orderId
			for(Order o : orders.orders)
			{
				if(o.getOrderId().equals(key))
					{
						ordersKEY.add(o);
						found=true;
					}
			}
		}
		else if (column==2) {                              //2 to supplierId
			for(Order o : orders.orders)
			{
				if(o.getSupplierId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==3) {                              //3 to productId
			for(Order o : orders.orders)
			{
				if(o.getProductId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==4) {                              //4 to productName
			for(Order o : orders.orders)
			{
				if(o.getProductName().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==5) {                              //5 to date
			for(Order o : orders.orders)
			{
				if(o.getDate().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==6) {                             //6 to status
			int intkey = Integer.parseInt(key);
			for(Order o : orders.orders)
			{
				if(o.getStatus()==intkey) ordersKEY.add(o);
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(ordersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void editOrder(Order o, int index)
	{
		orders.orders.set(index, o);
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
		
	}

	public void setSurName(String surname) {
		this.surName = surname;
		
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
		
	}

	public void setAFM(String ama) {
		this.AMA = 	ama;
	}

	public void setId(String id) {
		this.id = id;
		
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastName() {
		return surName;
	}
}
