import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Forecast {

	int i;
	OrderManager orderManager;
	SupplierProducts productsList;
	Orders order;
	Proposals proposal;
	String name;
	String id;
	double Per;
	int Leadtime ;
	double SafetyStock;
	double stockAmount;
	double maxStorageAmount;
	double averageonthlyConsumption;
	double expectedAmount;
	boolean type;
	private ArrayList<SupplierProduct> prod;
	double amount;
	String season;
	String date;
	
	//Forecast method
	private Forecast(OrderManager om)
	{    
		  prod = om.getProducts().getSupplierProducts();
		  Suppliers suppliers = om.getSuppliers();
	      Supplies supplies = om.getSupplies();
		  type = om.getRegular();
		 
	 for(i=0; i<prod.size(); i-- )
	 {
		stockAmount = SupplierProduct.getStockAmount();
		expectedAmount = SupplierProduct. getExpectedAmount();
		averagetion = SupplierProduct. getAverageMonthlyConsumption();
		Leadtime = SupplierProduct. getLeadtime();
		SafetyStock = SupplierProduct. getSafetyStock();
		maxStorageAmount = SupplierProduct.getMaxStockAmount();
		
		
		
		
		if(type == true)
		{    
            Per = 1;
            date = " ";
             
		   amount = Calculaterder(stockAmount,expectedAmount,averaonsumption,Leadtime ,SafetyStock,maxStorageAmount,Per);
		
		}
		else
		{
			Calendar cal;
			//get current date
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
		  
		  season = om.getSeason();
		 Per = Percentage(season,month,day);
		 amount = Calculaterder(stockAmount,expectedAmount,averageonthlyConsumption,Leadtime ,SafetyStock,maxStorageAmount,Per);
		  
		 //create an order
		   order = new Orders();
		  
		  //add the order to the proposals
		  om.getProposals().getProposals().add(order);
		
		}
		
		
     }
		 
		  
	}
	
	



	private double Calculateder(double stockAmount,double expectedAmount,double averageonsumption,int Leadtime,double SafetyStock,double maxStorageAmount,double Per)
	{   
		if(type==true)
	    {
			if((stockAmount+expectedAmount-averageonthlyConsumption- Leadtime)<=SafetyStock)	
	        {
	    	   amount = SafetyStock+2*averageonthlyConsumption-stockAmount-expectedAmount+Leadtime;
	    	   if((amount+expectedAmount+stockAmount)>maxStorageAmount)
	    	   {
	    		   amount = maxStorageAmount-expectedAmount-stockAmount;
	    	   }
	        
	        }
			else 
			{
				System.out.println("Product's storage is full,there is no need for a new order.");
			}
	    }	
		else
		{
			if((stockAmount+expectedAmount-averagehlyConsumption- Leadtime)<= SafetyStock*Per)	
	        {
				
				
				amount = SafetyStock+2*averagethlyConsumption-stockAmount-expectedAmount+Leadtime;
				amount = amount *Per;
	        }
			else
			{
				System.out.println("Product's storage is full,there is no need for a new order.");
			}
		}
		
		return amount;
		
	}	
	
	
	private double Percentage( String season,int month,int day)
	{   
		
		
		if((day>=1 && month>=3) && (day<1 && month<9))
		{
			if(season == "summer"){
				Per = 1.2;
			}
			else{
				Per = 0.7;
			}
		}
		else {
			if(season == "summer"){
				Per = 0.7;
			}
			else{
				Per = 1.2;
			}
		}
		
		
		return Per;
	}
	
	