import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class CreateChart extends JFrame
{
	/*CreateChart.java
	 * Purpose : Displays the selected chart with the calculated values
	 * @author Fotiadou Vassiliki, Bitsa Antouela
	 */
	private String[] months;
	private String[] options;

	public CreateChart(String[] months, String[] options)
	{
		this.months = months;
		this.options = options;
	}
	
	public void lineChart(ArrayList<Double> value, int numOfMonths, String firstMonth)
	{
		
	}
	
	public void matrixChart(ArrayList<Double> value, int numOfMonths, String firstMonth)
	{
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 1041, 653);
		
		int monthC = 0;
		String date;
		int year;
		int size = value.size();
		String[][] data = new String[size][2];
		String[] columns = new String[2];
		
		//data input (value,dates)
		
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
			
			date = String.valueOf(year);
			date += " ";
			date += months[monthC];
			data[i][0] = date;
			data[i][1] = String.valueOf(value.get(i));
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
		
		//sets name columns
		
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
				
				if(options[1].equals("Product"))
				{
					title += " For Product With ID : ";
					title += options[2];
				}
				else if(options[1].equals("Client"))
				{
					title += " For Client With ID : ";
					title += options[2];
				}
				else if(options[1].equals("Supplier"))
				{
					title += " For Supplier With ID : ";
					title += options[2];
				}
				
				columns[0] = "Date";
				columns[1] = title;
				
				//creates jtable
				
				JTable table = new JTable();
				table.setModel(new DefaultTableModel(data, columns));
				table.setBounds(30,40,200,300); 
				
			    JScrollPane scroll = new JScrollPane();    
			    scroll = new JScrollPane();
				scroll.setBounds(100, 100, 584, 534);
				scroll.setViewportView(table);

				
				panel.add(scroll);
				
				this.setContentPane(panel);
				this.setVisible(true);
				this.setTitle("Matrix Chart");
				this.setBounds(100, 100, 1041, 653);
				this.setResizable(false);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
		
	}
	
	public void barChart(ArrayList<Double> value, int numOfMonths, String firstMonth)
	{
		int monthC = 0;
		int year;
		
		
		//data input (value,date)
		
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
		
		//sets bar chart title
		
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
		
		if(options[1].equals("Product"))
		{
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Client"))
		{
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Supplier"))
		{
			title += " For Supplier With ID : ";
			title += options[2];
		}
		
		//creates bar chart
		
		JFreeChart chart = ChartFactory.createBarChart(title, "Year" , "Value", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame = new ChartFrame("Bar Chart ",chart);
		
		frame.setVisible(true);
		frame.setSize(500, 500);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	
	public void pieChart(ArrayList<Double> value, int numOfMonths, String firstMonth)
	{
		
		int monthC = 0;
		String date;
		int year;
		
		//data input (value,date)
		
		DefaultPieDataset dataset = new DefaultPieDataset();
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
			date = String.valueOf(year);
			date += " ";
			date += months[monthC];
			dataset.setValue(date , value.get(i));
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
		
		//sets pie chart title
		
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
		
		if(options[1].equals("Product"))
		{
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Client"))
		{
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].cequals("Supplier"))
		{
			title += " For Supplier With ID : ";
			title += options[2];
		}
		
		//creates pie chart
		
		JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, true);
		ChartFrame frame = new ChartFrame("Pie Chart ",chart);
		
		frame.setVisible(true);
		frame.setSize(500, 500);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
