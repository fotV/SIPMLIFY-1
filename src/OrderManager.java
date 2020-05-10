
public class OrderManager extends User {
	
	Suppliers suppliers = new Suppliers();
	CompanyProducts products = new CompanyProducts();
	Supplies supplies = new Supplies();
	Orders orders = new Orders();

	public OrderManager(String firstName, String surName, String password, String telephone, String aMA, String id) {
		super(firstName, surName, password, telephone, aMA, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeLists() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
