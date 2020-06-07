import java.util.ArrayList;

public class Stockkeeper extends User {

	/*
	 * Stock keeper's Constructor.
	 * */
	public Stockkeeper(String firstName, String surName, String password, String telephone, String aFM, String id, String company) {
		super(firstName, surName, password, telephone, aFM, id, company);
	}

	/**
	 * Fills the order list with the data extracted from the database using method extractObjectDB and then filters the list keeping only the orders for this specific stock keeper by removing other unwanted orders.
	 */ 
	@Override
	public void initializeLists() {
		this.orders.extractObjectDB();						//Extracts the orders from DB 
		ArrayList<Order> ord = new ArrayList<Order>();			
		for (Order o: this.orders.getOrders()) {
			if(o.getStockkeeperId().equals(this.id))
				ord.add(o);
		}
		this.orders.getOrders().clear();
		this.orders.getOrders().addAll(ord);
	}

	/**
	 * Updates the database with the current data as well as fills the order list using the method InitializeLists.
	 */
	@Override
	public void refresh() {
		
		this.orders.updateObjectDB();
		this.orders.getOrders().clear();
		this.initializeLists();
		
		
	}
}
