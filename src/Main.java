
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) 
	{
		Users u = new Users();
		Suppliers s = new Suppliers();
		SupplierProducts sp = new SupplierProducts();
		Orders o = new Orders();
		Proposals pr = new Proposals();
		CompanyProducts cp = new CompanyProducts();
		Buyers b = new Buyers();
		Supplies sup = new Supplies();
		
		u.extractObjectDB();
		s.extractObjectDB();
		sp.extractObjectDB();
		o.extractObjectDB();
		pr.extractObjectDB();
		cp.extractObjectDB();
		b.extractObjectDB();
		sup.extractObjectDB();
		
		System.out.println("\n-----Users-----");
		for(User k: u.getUsers()) System.out.println(k.getFirstName());
		System.out.println("\n-----Suppliers-----");
		for(Supplier k: s.getSuppliers()) System.out.println(k.getName() + "   " + k.getId());
		System.out.println("\n-----SupplierProducts-----");
		for(SupplierProduct k: sp.getSupplierProducts()) System.out.println(k.getName() + "   " + k.getId());
		System.out.println("\n-----Orders-----");
		for(Order k: o.getOrders()) System.out.println(k.getQuantity() + "   " + k.getDate());
		System.out.println("\n-----Proposals-----");
		for(Order k: pr.getProposals()) System.out.println(k.getStatus() + "   " + k.getPrice());
		System.out.println("\n-----CompanyProducts-----");
		for(CompanyProduct k: cp.getCompanyProducts()) System.out.println(k.getName() + "	" + k.getSafetyStock());
		System.out.println("\n-----Buyers-----");
		for(Buyer k: b.getBuyers()) System.out.println(k.getLastName() + "   " + k.getAFM() + "	" + k.getSellerId());
		System.out.println("\n-----Supplies-----");
		for(Suppl k: sup.getSupplies()) System.out.println(k.getSupplierId() + "   " + k.getProductId() + "   " + k.getPrice());
		
		/*Supplier s1 = new Supplier("ELENI", "POLYZOIDOU", "SE0005", "6949555777", "B000345678", "OR0003");
		s.getSuppliers().add(s1);
		s.updateObjectDB();
		Suppliers st = new Suppliers();
		st.extractObjectDB();
		System.out.println("\n-----Suppliers-----");
		for(Supplier k: st.getSuppliers()) System.out.println(k.getName() + "   " + k.getId());
		
		Buyer b1 = new Buyer("ELENI", "PAPADOPOULOU", "OR0004", "AB01234321", "SE0004");
		b.getBuyers().add(b1);
		b.updateObjectDB();
		Buyers bt = new Buyers();
		bt.extractObjectDB();
		System.out.println("\n-----Buyers-----");
		for(Buyer k: bt.getBuyers()) System.out.println(k.getLastName() + "   " + k.getAFM());
		
		Suppl sup1 = new Suppl("108001","SE0004", 25.5);
		sup.getSupplies().add(sup1);
		sup.updateObjectDB();
		Supplies supt = new Supplies();
		supt.extractObjectDB();
		System.out.println("\n-----Supplies-----");
		for(Suppl k: sup.getSupplies()) System.out.println(k.getSupplierId() + "   " + k.getProductId() + "   " + k.getPrice());
		*/
		CompanyProduct cpp = new CompanyProduct("PC", "108012", "SE0002", 10.0, 150.0, 25.0, 400.0);
		cp.getCompanyProducts().add(cpp);
		cp.getCompanyProducts().get(0).setStockAmount(666.0);
		cp.getCompanyProducts().get(1).setPrice(6.6);
		cp.updateObjectDB();
		CompanyProducts cpt = new CompanyProducts();
		cpt.extractObjectDB();
		System.out.println("\n-----CompanyProducts-----");
		for(CompanyProduct k: cpt.getCompanyProducts()) System.out.println(k.getName() + "   " + k.getSafetyStock() + "	" + k.getPrice());
		
		/*
		SupplierProduct spp = new SupplierProduct("PLATE", "108022", "OR0003", 1500.0, 5000.0, 2000.0, 1100.0, 26, 500.0);
		sp.getSupplierProducts().add(spp);
		sp.getSupplierProducts().get(0).setStockAmount(999.0);
		sp.getSupplierProducts().get(1).setLeadTime(99);
		sp.updateObjectDB();
		SupplierProducts spt = new SupplierProducts();
		spt.extractObjectDB();
		System.out.println("\n-----SupplierProducts-----");
		for(SupplierProduct k: spt.getSupplierProducts()) System.out.println(k.getName() + "	" + k.getLeadtime() +"   " + k.getStockAmount());
		*/
	}
}
