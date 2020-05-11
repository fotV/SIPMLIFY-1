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
		
	}
	
	public String getName() {
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
}
