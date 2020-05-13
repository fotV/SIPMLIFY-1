
public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(String firstName, String surName, String password, String telephone, String AMA, String id,CompanyProducts products, Buyers buyers) {
		super(firstName,surName,password,telephone,AMA,id);
		this.products = products;
		this.buyers = buyers;
	}

	/* Method initializeLists() : extracts the infomations from database 
	** and adds them into lists */
	public void initializeLists() {
		products.extractObjectDB();
		buyers.extractObjectDB();
	}
	
	/* Method searchForProduct(): searches a product and calls a GUI to 
	** to show the results */
	public  void searchForProduct(String key, int column) {
		for ( CompanyProducts prod : products ) {
			if ( prod.equals(column) && prod.equals(key) ) {
				//calls GUI : PresentationForm
			}
		}
	}
	
	
	
	public CompanyProducts getProducts() {
		return products;
	}

	public Buyers getBuyers() {
		return buyers;
	}
}
