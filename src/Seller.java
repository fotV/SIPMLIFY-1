package src;

public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(String firstName, String surName, String password, String telephone, String AMA, String id,String company) {
		super(firstName,surName,password,telephone,AMA,id,company);
		this.products = new CompanyProducts();
		this.buyers = new Buyers();
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
	
	/* Method addProduct() : adds the parameter to the product list */
	public void addProduct(CompanyProducts product) {
		products.add(product);
	}
	
	/*Method editProduct() : adds the cp in the specific index position of list products */
	public void editProduct(CompanyProducts cp, int index) {
		products.add(index, cp);
	}
	
	/* Method searchForBuyer() : searches a buyer in the list of buyers */
	public void searchForBuyer(String key, int column) {
		for ( Buyers b : buyres ) {
			if ( b.equals(column) && b.equals(key)) {
				//calls GUI :  PresentationForm
			}
		}
	}
	
	/* Method addBuyer() : adds the parameter to the buyers list */
	public void addBuyer(Buyer s) {
		buyers.add(s);
	}
	
	/* Method editBuyer() : adds the b in the specific index position of list products */
	public void editBuyer(Buyer b, int index) {
		buyers.add(index, b);
	}
	
	//Getters & Setters 
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
