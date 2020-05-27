public class Stockkeeper extends User {

	/*
	 * Stock keeper's Constructor.
	 * */
	public Stockkeeper(String firstName, String surName, String password, String telephone, String aFM, String id,
			String company, int type) {
		super(firstName, surName, password, telephone, aFM, id, company, type);
	}

	/*
	 * The following method fills the order list with the data extracted from the database using method extractObjectDB.
	 * Then we filter the list keeping only the orders for this specific stock keeper by removing other unwanted orders.
	 *  */ 
	@Override
	public void initializeLists() {
		this.orders.extractObjectDB();
		for (Order o : this.orders.getOrders())
		{
			if (!o.getStockkeeperId().equals(this.id))
			{
				this.orders.getOrders().remove(o);
			}
		}
	}

	/*
	 * The following method updates the database with the current data as well as fills the order list using the method InitializeLists.
	 */
	@Override
	public void refresh() {
		
		this.orders.updateObjectDB();
		this.initializeLists();
		
		
	}
}
