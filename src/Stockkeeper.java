public class Stockkeeper extends User {

	public Stockkeeper(String firstName, String surName, String password, String telephone, String aMA, String id) {
		super(firstName, surName, password, telephone, aMA, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeLists() {
		this.orders.extractObjectDB();
	}

	@Override
	public void refresh() {
		
		this.orders.updateObjectDB();
		this.orders.extractObjectDB();
		
		
	}

}
