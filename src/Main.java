
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) 
	{
		//Users u = new Users();
		Suppliers s = new Suppliers();
		SupplierProducts sp = new SupplierProducts();
		Orders o = new Orders();
		Proposals pr = new Proposals();
		CompanyProducts cp = new CompanyProducts();
		Buyers b = new Buyers();
		Supplies sup = new Supplies();
		
		//u.extractObjectDB();
		s.extractObjectDB();
		sp.extractObjectDB();
		o.extractObjectDB();
		pr.extractObjectDB();
		cp.extractObjectDB();
		b.extractObjectDB();
		sup.extractObjectDB();
		
		//System.out.println("\n-----Users-----");
		//for(User k: u.getUsers()) System.out.println(k.getFirstName());
		System.out.println("\n-----Suppliers-----");
		for(Supplier k: s.getSuppliers()) System.out.println(k.getName() + "   " + k.getId());
		System.out.println("\n-----SupplierProducts-----");
		for(SupplierProduct k: sp.getSupplierProducts()) System.out.println(k.getName() + "   " + k.getId());
		System.out.println("\n-----Orders-----");
		for(Order k: o.getOrders()) System.out.println(k.getQuantity() + "   " + k.getDate());
		System.out.println("\n-----Proposals-----");
		for(Order k: pr.getProposals()) System.out.println(k.getStatus() + "   " + k.getPrice());
		System.out.println("\n-----CompanyProducts-----");
		for(CompanyProduct k: cp.getCompanyProducts()) System.out.println(k.getName() + "   " + k.getSafetyStock());
		System.out.println("\n-----Buyers-----");
		for(Buyer k: b.getBuyers()) System.out.println(k.getLastName() + "   " + k.getAFM());
		System.out.println("\n-----Supplies-----");
		for(Suppl k: sup.getSupplies()) System.out.println(k.getSupplierId() + "   " + k.getProductId() + "   " + k.getPrice());
		
		Supplier s1 = new Supplier("Strgios", "Margaritopoulos", "sup123", "6949555666", "12345678", "om123");
		s.getSuppliers().add(s1);
		s.updateObjectDB();
		Suppliers st = new Suppliers();
		st.extractObjectDB();
		System.out.println("\n-----Suppliers-----");
		for(Supplier k: st.getSuppliers()) System.out.println(k.getName() + "   " + k.getId());
		
		Buyer b1 = new Buyer(" Eleni", "Polyzoidou", "buy123", "1234321", "6988222000", "sel111");
		b.getBuyers().add(b1);
		b.updateObjectDB();
		Buyers bt = new Buyers();
		bt.extractObjectDB();
		System.out.println("\n-----Buyers-----");
		for(Buyer k: bt.getBuyers()) System.out.println(k.getLastName() + "   " + k.getAFM());
		
	}
}
