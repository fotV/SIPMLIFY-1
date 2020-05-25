

public class Stockkeeper extends User {

	public Stockkeeper(String firstName, String surName, String password, String telephone, String aMA, String id,String company) {
		super(firstName, surName, password, telephone, aMA, id,company);
		
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
