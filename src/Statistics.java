
public class Statistics 
{
	String variable;
	String filter;
	int numOfMonths;
	//User ordMan;
	//User sup;
	String[] options;
	
	public Statistics(String[] options)
	{
		this.options = options;
	}
	
	public void SupplierStat()
	{
		
	}

	public void OrdererStat() 
	{
		firstMonth = options[4];
		
		//calc numOfMonths
		int years;
		int fromMonth = 0;
		int toMonth = 0;
		years = Integer.parseInt(options[7]) - Integer.parseInt(options[5]);
		
		//checks which months is fromMonth and which month is toMonth and keeps the index
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
		
		//calculates the numberofmonths 
		if(years == 0)
		{
			numOfMonths = toMonth - fromMonth;
		}
		else if(years > 0)
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
		
		ArrayList <TryOrder> orders = ordMan.getOrders();  //giati mou bgazei error
		
		if(options[0].equals("Cost"))
		{
			calcCost(orders, fromMonth, numOfMonths, ordMan);
			
		}
		else if(options[0].equals("Purchases"))
		{
			calcOrder(orders, fromMonth, numOfMonths, ordMan);
		}
		
		//calls the chosen chart
		TryCreateChart ch = new TryCreateChart(months);
				
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
			ch.matrixChart(value,numOfMonths,firstMonth);
		}
	}
	
	private void calcCost(ArrayList<TryOrder> orders, int fromMonth, int numOfMonths2, OrderManager ordMan2) {
		
		double sum = 0;
		String date = null;
		int year;
		
		year = Integer.parseInt(options[5]);
		
		//in every if after the sum = 0; there is a date update 
		if(options[1].equals("Date"))
		{
			for(int j = 0; j < numOfMonths+1; j++)
			{
				sum = 0;
					
				if(fromMonth+1 != 12)
				{
					date += String.valueOf(year);
					if(fromMonth < 9)
					{
						date += "-0";
					}
					else 
					{
						date += "-";
					}
					date +=  String.valueOf(fromMonth+1);
				}
				//if 12 the month is december must update year
				else if(fromMonth+1 == 12)					
				{	
					fromMonth = 0;
					date += String.valueOf(year);
					date += "-0";
					date +=  String.valueOf(fromMonth+1);	
				}
				
				for(int i = 0; i < orders.size(); i++)
				{
					//checks if the first 7 letters of string are the same as date given by the order manager
					if(date.equals(orders.get(i).getDate().substring(0,6)))				
					{
						// updates sum with quantity*price in order to find the profit of the order
						sum += (orders.get(i).getQuantity())*(orders.get(i).getPrice());	
					}
						
				}
				
				if(sum != 0)
				{
					value.add(sum);	//adds the total profit of the month in value
				}			
					fromMonth += 1;
					date = new String();
				}	
			} 
			else if(options[1].equals("Supplier"))
			{
				for(int j = 0; j < numOfMonths+1; j++)
				{
					sum = 0;
					
					if(fromMonth+1 != 12)
					{
						date += String.valueOf(year);
						if(fromMonth < 9)
						{
							date += "-0";
						}
						else 
						{
							date += "-";
						}
						date +=  String.valueOf(fromMonth+1);
					}
					else if(fromMonth+1 == 12)
					{
						year += 1;
						fromMonth = 0;
						date += String.valueOf(year);
						date += "-0";
						date +=  String.valueOf(fromMonth+1);	
					}
					
					for(int i = 0; i < orders.size(); i++)
					{
						
						if(date.equals(orders.get(i).getDate().substring(0,6)))
						{
							if(options[2].equals(orders.get(i).getSupplierId()))
							{
								sum += (orders.get(i).getQuantity())*(orders.get(i).getPrice());
								
							}
									
						}	
							
					}
					value.add(sum);
					fromMonth += 1;
					date = new String();
				}
						
				
			}
			else if(options[1].equals("Product"))
			{
				for(int j = 0; j < numOfMonths+1; j++)
				{
					sum = 0;
					
					if(fromMonth+1 != 12)
					{
						date += String.valueOf(year);
						if(fromMonth < 9)
						{
							date += "-0";
						}
						else 
						{
							date += "-";
						}
						date +=  String.valueOf(fromMonth+1);
					}
					else if(fromMonth+1 == 12)
					{
						year += 1;
						fromMonth = 0;
						date += String.valueOf(year);
						date += "-0";
						date +=  String.valueOf(fromMonth+1);	
					}
					
					for(int i = 0; i < orders.size(); i++)
					{
						if(date.equals(orders.get(i).getDate().substring(0,6)))
						{
							if(options[2].equals(orders.get(i).getProductId()))
							{
								sum += (orders.get(i).getQuantity())*(orders.get(i).getPrice());
							}		
						}					
					}
					value.add(sum);
					fromMonth += 1;
					date = new String();
				}		
			}
	}
	
	private void calcOrder(ArrayList<TryOrder> orders, int fromMonth, int numOfMonths2, OrderManager ordMan2) {
		
		double sum;
		String date = null;
		String year;
		
		year = options[5];
	
		if(options[1].equals("Date"))
		{
			for(int j = 0; j < numOfMonths+1; j++)
			{
				sum = 0;
				
				if(fromMonth+1 != 12)
				{
					date += String.valueOf(year);
					if(fromMonth < 9)
					{
						date += "-0";
					}
					else 
					{
						date += "-";
					}
					date +=  String.valueOf(fromMonth+1);
				}
				else if(fromMonth+1 == 12)
				{
					year += 1;
					fromMonth = 0;
					date += String.valueOf(year);
					date += "-0";
					date +=  String.valueOf(fromMonth+1);	
				}
				
				for(int i = 0; i < orders.size(); i++)
				{
				
					if(date.equals(orders.get(i).getDate().substring(0,6)))
					{
						sum += orders.get(i).getQuantity();
					}
					
				}
				if(sum != 0)
				{
					//adds the total profit of the month in value
					value.add(sum);	
				}
				fromMonth += 1;
				date = new String();
			}	
		}
		else if(options[1].equals("Supplier"))
		{
			for(int j = 0; j < numOfMonths+1; j++)
			{
				sum = 0;
				
				if(fromMonth+1 != 12)
				{
					date += String.valueOf(year);
					if(fromMonth < 9)
					{
						date += "-0";
					}
					else 
					{
						date += "-";
					}
					date +=  String.valueOf(fromMonth+1);
				}
				else if(fromMonth+1 == 12)
				{
					year += 1;
					fromMonth = 0;
					date += String.valueOf(year);
					date += "-0";
					date +=  String.valueOf(fromMonth+1);	
				}
				
				for(int i = 0; i < orders.size(); i++)
				{
					
					if(date.equals(orders.get(i).getDate().substring(0,6)))
					{
						if(options[2].equals(orders.get(i).getSupplierId()))
						{
							sum += (orders.get(i).getQuantity());
						}
					}	
				}
				value.add(sum);
				fromMonth += 1;
				date = new String();
			}
		}
		else if(options[1].equals("Product"))
		{
			for(int j = 0; j < numOfMonths+1; j++)
			{
				sum = 0;
				
				if(fromMonth+1 != 12)
				{
					date += String.valueOf(year);
					if(fromMonth < 9)
					{
						date += "-0";
					}
					else 
					{
						date += "-";
					}
					date +=  String.valueOf(fromMonth+1);
				}
				else if(fromMonth+1 == 12)
				{
					year += 1;
					fromMonth = 0;
					date += String.valueOf(year);
					date += "-0";
					date +=  String.valueOf(fromMonth+1);	
				}
				
				for(int i = 0; i < orders.size(); i++)
				{
					
					if(date.equals(orders.get(i).getDate().substring(0,6)))
					{
						if(options[2].equals(orders.get(i).getProductId()))
						{
							sum += (orders.get(i).getQuantity());
							
						}		
					}				
				}
				value.add(sum);
				fromMonth += 1;
				date = new String();
			}			
		}
}
