import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Forecast.java
 * Purpose: The class produces proposals of orders for every product in SupplierProducts(list).
 * @author Polyzoidou Eleni, Gkouli Nikoleta
 */
public class Forecast {

	private double per;
	OrderManager orderManager;
	SupplierProducts productsList;
	Orders order;
	Proposals proposals;
	boolean isTypeRegular;
	
	public Forecast(OrderManager om)
	{    
		  orderManager = om;
		  ArrayList<SupplierProduct> prod = orderManager.getProducts().getSupplierProducts();
		  Suppliers suppliers = orderManager.getSuppliers();
		  Supplies supplies = orderManager.getSupplies();
		  boolean isTypeRegular = orderManager.getRegular();
		  
		  double stockAmount;
		  double expectedAmount;
		  double averageMonthlyConsumption;
		  int leadtime;
		  double safetyStock;
		  double maxStorageAmount;
		 
		  double amount = 0.0;
		  boolean flag = false; //checks if at least one proposal has been created
		  
		  for(SupplierProduct p : prod) {
			  stockAmount = p.getStockAmount();
			  expectedAmount = p. getExpectedAmount();
			  averageMonthlyConsumption = p. getAverageMonthlyConsumption();
			  leadtime = p. getLeadtime();
			  safetyStock = p. getSafetyStock();
			  maxStorageAmount = p.getMaxStockAmount();
		  
			  if(isTypeRegular == true) {
				  
				  per = 1.0;
				  if (stockAmount + expectedAmount - averageMonthlyConsumption - leadtime <= safetyStock) {  
				  	amount = calculateOrder(stockAmount,expectedAmount,averageMonthlyConsumption,leadtime ,safetyStock,per);
				  	flag = true;
				  }
			  }
			  else {
				 
				  String season = om.getSeason();
				  per = Percentage(season);
				  if (stockAmount + expectedAmount - averageMonthlyConsumption - leadtime <= safetyStock) {
					  amount = calculateOrder(stockAmount,expectedAmount,averageMonthlyConsumption,leadtime ,safetyStock,per);    
					  flag = true;
				  }
			  } 
			  
			  
			  Suppl s = new Suppl(p.getId(), "", 0.0);
			  for (Suppl sp : supplies.getSupplies()) {
				  if (p.getId().equals(sp.getProductId())) {
					  s.setSupplierId(sp.getSupplierId());
					  s.setPrice(sp.getPrice());
				  }  
			  } 
			  Supplier sup = new Supplier("", "", s.getSupplierId(), "", "", "");
			  for (Supplier sp : suppliers.getSuppliers()) {
				  if (s.getSupplierId().equals(sp.getId())) {
					  sup.setLastName(sp.getLastName());
					  sup.setAFM(sp.getAFM());
				  }
			  }
			  
			  //get current date
			  SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			  Date date = new Date();
			  String datee = formatter.format(date);
			  
			  //create new order
			  Order order = new Order(p.getOrderManagerId(), " ", amount, s.getSupplierId(), sup.getLastName(), 
					  sup.getAFM(), datee, 0, s.getPrice(), amount*s.getPrice(), p.getName(), p.getId(), " ");
			  //add the order in the proposals-list
			  om.getProposals().getProposals().add(order);
			  
			  if (amount + expectedAmount + stockAmount > maxStorageAmount) {
				  amount = maxStorageAmount - (expectedAmount + stockAmount);
			  }
	
		  }
		  
		  UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
	          UIManager.put("OptionPane.messagebackground", Color.LIGHT_GRAY);
	          UIManager.put("Panel.background", Color.LIGHT_GRAY);
		  if (flag == true) {
			  
			  JOptionPane.showMessageDialog(null, "Forecast calculation is completed!", "Forecast", JOptionPane.DEFAULT_OPTION);
		  }
		  else {
			  JOptionPane.showMessageDialog(null, "There is no product in deficit!", "Forecast", JOptionPane.DEFAULT_OPTION);
		  }
		 	  
	}

	
	/**
	 * The method calculates an amount of every product that must been ordered.
	 * @param stockAmount
	 * @param expectedAmount
	 * @param averageMonthlyConsumption
	 * @param leadtime
	 * @param safetyStock
	 * @param per
	 * @return amount
	 */
	private double calculateOrder(double stockAmount,double expectedAmount,double averageMonthlyConsumption,double leadtime,double safetyStock,double per)
	{   
		double amount = (safetyStock + 2*averageMonthlyConsumption + leadtime - stockAmount - expectedAmount)*per;
		return amount;
		
	}	
	
	
	/**
	 * The method set the right value in per depends on the type of season company
	 * @param season
	 * @return per
	 */
	private double Percentage( String season)
	{   
		//get current month
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = formatter.format(date);
		Integer month = Integer.parseInt(str.substring(5, 7));
		
		double per;
		if (((month>=3) && (month<9) && (season == "summer"))||((month>=9) && (month<3) && (season == "winter")))
		{
			per = 1.2;
		}
		else {
			per = 0.7;
		}
		return per;
	}
}	
