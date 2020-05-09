
public class OrderManager extends User {
	
	private boolean regular = false ;
	private String season ;
	private SupplierProducts products ;
	private Orders orders ;
	private Proposals proposals ;
	private Suppliers suppliers ;
	private Supplies supplies ;
	
	//Constructor
	public OrderManager(boolean regular, String season, SupplierProducts products, Orders orders, Proposals proposals,
			Suppliers suppliers, Supplies supplies) {
		super();
		this.regular = regular;
		this.season = season;
		this.products = products;
		this.orders = orders;
		this.proposals = proposals;
		this.suppliers = suppliers;
		this.supplies = supplies;
	}
	
	/* Method initializeLists() : extracts the infomations from database 
	** and adds them into lists */
	public void initializeLists() {
		products.extractObjectDB();
		proposals.extractObjectDB();
		suppliers.extractObjectDB();
		supplies.extractObjectDB();
	}
	
	/* Method searchForProduct(): seasrches a product and calls a GUI to 
	** to show the results */
	public void searchForProduct(String key, int column) {
		for ( SupplierProducts prod : products ) {
			if (prod.equals(column) && prod.equals(key)){
				//calls GUI : PresentationForm
			}
		}
	}
	
	/* Method addProduct() : adds the parameter to the product list */
	public void addProduct(SupplierProduct product) {
		products.add(product);
	}
	
	/* Method editProduct() : adds the sp in the specific index position of list products */
	public void editProduct(SupplierProduct sp, int index) {
		products.add(index, sp);
	}
	
	/* Method searchForSupplier() : seasrches a supplier and calls a GUI to 
	** to show the results */
	public void searchForSupplier(String key, int column) {
		for ( Suppliers sup : suppliers ) {
			if ( sup.equals(column) && sup.equals(key)) {
				//Calls GUI : PresentationForm
			}
		}
	}
	
	/* Method addSupplier() : adds the parameter to the supplier list*/
	public void addSupplier(Supplier s) {
		suppliers.add(s);
	}
	
	/* Method editSupplier() : adds the s to the specific index position of list suppliers*/
	public void editSupplier(Supplier s, int index) {
		suppliers.add(index, s);
	}
	
	

	//Getters & Setters
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public SupplierProducts getProducts() {
		return products;
	}

	public void setProducts(SupplierProducts products) {
		this.products = products;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Proposals getProposals() {
		return proposals;
	}

	public void setProposals(Proposals proposals) {
		this.proposals = proposals;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Supplies getSupplies() {
		return supplies;
	}

	public void setSupplies(Supplies supplies) {
		this.supplies = supplies;
	}
	
	

}
