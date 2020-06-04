import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(String firstName, String surName, String password, String telephone, String AMA, String id, String company) {
		super(firstName, surName, password, telephone, AMA, id, company);
		this.products = new CompanyProducts();
		this.buyers = new Buyers();
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
		ArrayList<CompanyProduct> companyProducts = new ArrayList<CompanyProduct>();
		for (CompanyProduct comProd : this.products.getCompanyProducts()) {
			if ( comProd.getSellerId().equals(this.id) ) {
				companyProducts.add(comProd);
			}
		}
		this.products.getCompanyProducts().clear();
		this.products.getCompanyProducts().addAll(companyProducts);
		
		this.buyers.extractObjectDB();							//Extracts the suppliers for DB of the specific order manager 
		ArrayList<Buyer> supp = new ArrayList<Buyer>();
		for (Buyer buyer : this.buyers.getBuyers()) {
			if ( buyer.getSellerId().equals(this.id) ) {
				supp.add(buyer);
			}
		}
		this.buyers.getBuyers().clear();
		this.buyers.getBuyers().addAll(supp);
		 
	}
	
	/* Method searchForProduct(): searches a product and calls a GUI to 
	** to show the results */
	public  void searchForProduct(String key, int column) {
		Boolean found=false;
		ArrayList<Object> cProductsKEY = new ArrayList<>();
		if(column==1) {                                     				 //1 for product id
			for( CompanyProduct compProd : products.getCompanyProducts())
			{
				if(compProd.getId().equals(key))
					{
						cProductsKEY.add(compProd);
						found=true;
					}
			}
		}
		else if (column==2) {                              					//2 for product name 
			for( CompanyProduct compProd : products.getCompanyProducts())
			{
				if(compProd.getName().equals(key)) {
					cProductsKEY.add(compProd);
					found=true;
				}
			}
		}
		else if (column==3) {                             					 //3 for supplier id ?? den uparxei
			for( CompanyProduct compProd : products.getCompanyProducts())
			{
				if(compProd.getSellerId().equals(key)) {   //prepei na yparxei kapoio getter 
					cProductsKEY.add(compProd);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, cProductsKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);	
	}
	
	/* Method addProduct() : adds the parameter to the product list */
	public void addProduct(CompanyProduct product) {
		products.getCompanyProducts().add(product);
	}
	
	/*Method editProduct() : adds the cp in the specific index position of list products */
	public void editProduct(CompanyProduct cp, int index) {
		products.getCompanyProducts().add(index, cp);
	}
	
	/* Method searchForBuyer() : searches a buyer in the list of buyers */
	public void searchForBuyer(String key, int column) {
		Boolean found=false;
		ArrayList<Object> buyersKEY = new ArrayList<>();
		if(column==1) {                                      //1 for buyer id
			for( Buyer b : buyers.getBuyers() )
			{
				if(b.getId().equals(key))
					{
						buyersKEY.add(b);
						found=true;
					}
			}
		}
		else if (column==2) {                              //2 for name
			for( Buyer b : buyers.getBuyers() )
			{
				if(b.getName().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		else if (column==3) {                              //3 for last name 
			for( Buyer b : buyers.getBuyers() )
			{
				if(b.getLastName().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		else if (column==4) {                              //4 for buyer AFM
			for( Buyer b : buyers.getBuyers() )
			{
				if(b.getAFM().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, buyersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	//kainouria 
	public void searchForSupplier(String text, int selectedIndex) {
		//giati yparxei?
	}
	
	/* Method addBuyer() : adds the parameter to the buyers list */
	public void addBuyer(Buyer s) {
		buyers.getBuyers().add(s);
	}
	
	/* Method editBuyer() : adds the b in the specific index position of list products */
	public void editBuyer(Buyer b, int index) {
		buyers.getBuyers().add(index, b);
	}
	
	//Getters & Setters 
	public CompanyProducts getProducts() {
		return products;
	}

	public Buyers getBuyers() {
		return buyers;
	}

}