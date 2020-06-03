
public class CreateChart {

  public void lineChart(ArrayList<Double> value, int numOfMonths, String firstMonth)
	{
		int monthC = 0;
		int year;
		
		//data input
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		year = Integer.parseInt(options[5]);
		for(int i = 0;  i < months.length; i++)
		{
			if(firstMonth.equals(months[i]))
			{
				monthC = i;
			}
		}
		
		for(int i = 0; i <value.size(); i++)
		{
			
			dataset.addValue(value.get(i), months[monthC], String.valueOf(year) );
			if(monthC == 11)
			{
				monthC = 0;
				year++;
			}
			else
			{
				monthC++;
			}
			
		}
		
		//set line chart title
		String title = new String() ;
		if(options[0].equals("Profit"))
		{
			title = "Profit";
		}
		else if(options[0].equals("Purchases"))
		{
			title = "Purchases";
		}
		else if(options[0].equals("Cost"))
		{
			title = "Cost";
		}
		else if(options[0].equals("Orders"))
		{
			title = "Orders";
		}
		
		if(options[1].contentEquals("Product"))
		{
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].contentEquals("Client"))
		{
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].contentEquals("Supplier"))
		{
			title += " For Supplier With ID : ";
			title += options[2];
		}
		
		//create line chart
		JFreeChart lineChart = ChartFactory.createLineChart(title, "Year", "Value", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame = new ChartFrame("Line Chart", lineChart);
		
		frame.setVisible(true);
		frame.setSize(500, 500);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
  
}
