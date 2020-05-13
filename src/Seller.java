
public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(String firstName, String surName, String password, String telephone, String AMA, String id,CompanyProducts products, Buyers buyers) {
		super(firstName,surName,password,telephone,AMA,id);
		this.products = products;
		this.buyers = buyers;
	}

	
	
	public CompanyProducts getProducts() {
		return products;
	}

	public Buyers getBuyers() {
		return buyers;
	}



	public void searchForProduct(String text, int selectedIndex) {
		// TODO Auto-generated method stub
		
	}



	public void searchForSupplier(String text, int selectedIndex) {
		// TODO Auto-generated method stub
		
	}
}
