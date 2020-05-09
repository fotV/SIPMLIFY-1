
public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(CompanyProducts products, Buyers buyers) {
		this.products = products;
		this.buyers = buyers;
	}

	public CompanyProducts getProducts() {
		return products;
	}

	public Buyers getBuyers() {
		return buyers;
	}
}
