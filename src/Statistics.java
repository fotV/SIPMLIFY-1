import java.util.ArrayList;

public class Statistics 
{
	String variable;
	String filter;
	int numOfMonths;
	User ordMan;
	User seller;
	String[] options;
	String firstMonth;
	String[] months;
	ArrayList<Double> value;
	
	public Statistics(String[] options,String[] months)
	{
		this.options = options;
		this.months = months;
		value = new ArrayList<Double>();
	}
	
	public void OrdererStat() 
	{
		
		
	}
	
	public void SupplierStat()
	{
		
		firstMonth = options[4];
		
		//calc numOfMonths
		int years;
		int fromMonth = 0;
		int toMonth = 0;
		years = Integer.parseInt(options[7]) - Integer.parseInt(options[5]);
		
		//calculates the numberofmonths
		
		for(int i = 0; i< 12; i++)
		{
			if(options[4].equals(months[i]))
			{
				fromMonth = i;
			}
			if(options[6].equals(months[i]))
			{
				toMonth = i;
			}
		}	
		if(years == 0)
		{
			numOfMonths = toMonth - fromMonth;
		}
		else if(years >0)
		{
			if(toMonth > fromMonth)
			{
				numOfMonths = toMonth - fromMonth + years*12;
			}
			else
			{
				numOfMonths = fromMonth - toMonth + years*12;
			}
		}
		
		//calls the method based on the value variable
		
		seller = new Seller();
		
	
		if(options[0].equals("Profit"))
		{
			calcProfit(orders);
			
		}
		else if(options[0].equals("Purchases"))
		{
			calcPurchases(orders);
		}
		
		//calls the chosen chart
		
		CreateChart ch = new CreateChart(months);
		
		if(options[3].equals("Pie Chart"))
		{
			ch.pieChart(value,numOfMonths,firstMonth);
		}
		else if(options[3].equals("Line Chart"))
		{
			ch.lineChart(value,numOfMonths,firstMonth);
		}
		else if(options[3].equals("Bar Chart"))
		{
			ch.barChart(value,numOfMonths,firstMonth);
		}
		else if(options[3].equals("Matrix"))
		{
			ch.matrix(value,numOfMonths,firstMonth);
		}
	}
	
	private void calcProfit()
	{
		ArrayList<Order> orders = seller.getOrders();
		
		
			if(options[2].equals("Date"))
			{
				for(int i = 0; i < orders.size(); i++)
				{
					
				}
			}
			else if(options[2].equals("Product"))
			{
				for(int i = 0; i < orders.size(); i++)
				{
					if(options[2].equals(orders.get(i).getProductId()))
						{
							
						}
				}	
				
			}
			else if(options[2].equals("Client"))
			{
				for(int i = 0; i < orders.size(); i++)
				{
					if(options[2].equals(orders.get(i).getOrderManagerId()))
					{
						
					}
				}	
			}
	}
	
	
	private void calcPurchases()
	{
		ArrayList<Order> orders = seller.getOrders();
	
	
		if(options[2].equals("Date"))
		{
			for(int i = 0; i < orders.size(); i++)
			{
			}
		}
		else if(options[2].equals("Product"))
		{
			for(int i = 0; i < orders.size(); i++)
			{
				if(options[2].equals(orders.get(i).getProductId()))
					{
						
					}
			}	
			
		}
		else if(options[2].equals("Client"))
		{
			for(int i = 0; i < orders.size(); i++)
			{
				if(options[2].equals(orders.get(i).getOrderManagerId()))
				{
					
				}
			}	
		}
	}
	
	
	
	
}
