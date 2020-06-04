import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class OrderManager extends User {
	
	private boolean regular = false ;
	private String season ;
	private SupplierProducts products ;
	private Proposals proposals ;
	private Suppliers suppliers ;
	private Supplies supplies ;
	
	//Constructor
	public OrderManager(String firstName, String surName, String password, String telephone, String AMA, String id, String company, boolean regular, String season){
		super(firstName, surName, password, telephone, AMA, company, id);
		this.regular = regular;
		this.season = season;
		products = new SupplierProducts();
		proposals = new Proposals();
		suppliers = new Suppliers();
		supplies = new Supplies();
		
	}
	
	/* Method initializeLists() : extracts the infomations from database 
	** and adds them into lists */
	public void initializeLists() {
		
		this.orders.extractObjectDB();
		ArrayList<Order> ord = new ArrayList<Order>();
		for (Order o: this.orders.getOrders()) {
			if(o.getOrderManagerId().equals(this.id))
				ord.add(o);
		}
		this.orders.getOrders().clear();
		this.orders.getOrders().addAll(ord);
		   
		this.products.extractObjectDB();                           // Extracts the products from DB for the specific order manager      
		ArrayList<SupplierProduct> supProducts = new ArrayList<SupplierProduct>();
		for (SupplierProduct supProd : this.products.getSupplierProducts()) {
			if ( supProd.getOrderManagerId().equals(this.id) ) {
				supProducts.add(supProd);
			}
		}
		this.products.getSupplierProducts().clear();
		this.products.getSupplierProducts().addAll(supProducts);
		
		this.suppliers.extractObjectDB();							//Extracts the suppliers for DB of the specific order manager 
		ArrayList<Supplier> supp = new ArrayList<Supplier>();
		for (Supplier suppl : this.suppliers.getSuppliers()) {
			if ( suppl.getOrderManagerId().equals(this.id) ) {
				supp.add(suppl);
			}
		}
		this.suppliers.getSuppliers().clear();
		this.suppliers.getSuppliers().addAll(supp);
		 
		this.proposals.extractObjectDB();
		ArrayList<Order> prop = new ArrayList<Order>();
		for (Order order: proposals.getProposals()) {
			if ( order.getOrderManagerId().equals(this.id)){
				prop.add(order);
			}
		}
		this.proposals.getProposals().clear();
		this.proposals.getProposals().addAll(prop);
		
		supplies.extractObjectDB();
		ArrayList<Suppl> supll = new ArrayList<Suppl>();
		for (Suppl s : supplies.getSupplies()) {
			for (Supplier sp: this.suppliers.getSuppliers()) {
				if ( s.getSupplierId().equals(sp.getId())) 
					supll.add(s);	
			}
		}
		this.supplies.getSupplies().clear();
		this.supplies.getSupplies().addAll(supll);
		
		
	}
	
	/* Method searchForProduct(): searches a product and calls a GUI to  to show the results 
	 * @Param key     Represents the key for searching
	 * @Param column  Represents the
	**/
	public void searchForProduct(String key, int column) {
		Boolean found=false;
		ArrayList<Object> productsKEY = new ArrayList<>();
		if(column==1) {                                      				//1 for product id 
			for( SupplierProduct supProd : products.getSupplierProducts() )
			{
				if( supProd.getId().equals(key) )
					{
						productsKEY.add(supProd);
						found=true;
					}
			}
		}
		else if (column==2) {                              					//2 for product name 
			for( SupplierProduct supProd : products.getSupplierProducts() )
			{
				if(supProd.getName().equals(key)) {
					productsKEY.add(supProd);
					found=true;
				}
			}
		}
		else if (column==3) {                              					//3 for order manager id
			for( SupplierProduct supProd : products.getSupplierProducts() )
			{
				if(supProd.getOrderManagerId().equals(key)) {
					productsKEY.add(supProd);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, productsKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	/* Method addProduct() : adds the parameter to the product list */
	public void addProduct(SupplierProduct product) {
		products.getSupplierProducts().add(product);
	}
	
	/* Method editProduct() : adds the sp in the specific index position of list products */
	public void editProduct(SupplierProduct sp, int index) {
		products.getSupplierProducts().add(index, sp);
	}
	
	/* Method searchForSupplier() : seasrches a supplier and calls a GUI to 
	** to show the results */
	public void searchForSupplier(String key, int column) {
		Boolean found=false;
		ArrayList<Object> suppliersKEY = new ArrayList<>();
		if(column==1) {                                      		//1 for supplier id
			for( Supplier suppl : suppliers.getSuppliers() )
			{
				if( suppl.getId().equals(key) )
				{
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column==2) {                              		    //2 for supplier name 
			for( Supplier suppl : suppliers.getSuppliers() )
			{
				if(suppl.getName().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column==3) {                              			//3 for supplier last name 
			for( Supplier suppl : suppliers.getSuppliers() )
			{
				if(suppl.getLastName().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column==4) {                              			//4 for supplier AFM
			for( Supplier suppl : suppliers.getSuppliers() )
			{
				if(suppl.getAFM().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, suppliersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	/* Method addSupplier() : adds the parameter to the supplier list*/
	public void addSupplier(Supplier s) {
		suppliers.getSuppliers().add(s);
	}
	
	/* Method editSupplier() : adds the s to the specific index position of list suppliers*/
	public void editSupplier(Supplier s, int index) {
		suppliers.getSuppliers().add(index, s);
	}
	
	/* Method addOrder() : adds the parameter to the orders list */
	public void addOrder(Order order) {
		orders.getOrders().add(order);
	}
	
	/* Method chooseBusinessType() : sets if the business is regular or not */
	public void chooseBusinessType(boolean flag) {
		if ( flag == true ) {
			regular = true; //if flag is true the business is regular
		}
	}
	
	/* Method chooseBusinessSeason() : sets the season of the business*/
	public void chooseBusinessSeason(String seas) {
		if (regular == false) {
			season = seas;
		}
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



	public void setRegular(boolean b) {
		this.regular = b;
		
	}
}
	
	