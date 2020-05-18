import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.SystemColor;
import java.awt.Color;


public class PresentationForm extends JFrame{
	
	private JPanel panel;
	private JTable table = new JTable();
	private JScrollPane scroll;
	private int n;
	
	public PresentationForm(ArrayList <Object> objectList)
	{
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Christina\\Desktop\\3\\Organizedorders\\window logo.png"));
		String[][] data = new String[objectList.size()][3];
		panel = new JPanel();
		panel.setBounds(100, 100, 584, 534);
		
		scroll = new JScrollPane();
		panel.add(scroll, BorderLayout.CENTER);


		if (objectList.get(0) instanceof Order)   
		{
			n=1;
			for (int i=0; i<objectList.size(); i++)
			{
				Order temp = (Order) objectList.get(i);
				data[i][0]=temp.getProductName();
				data[i][1]=temp.getOrderId();
				data[i][2]=temp.getStatus()+"";
			}
			table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Order ID", "Status"}));
		}
		else if (objectList.get(0) instanceof CompanyProduct)
		{
			n=2;
			for (int i=0; i<objectList.size(); i++)
			{
				CompanyProduct temp = (CompanyProduct) objectList.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getStockamount()+"";
			}
			table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Product Id", "StockAmount"}));
		}
		else if (objectList.get(0) instanceof SupplierProduct)
		{
			n=3;
			for (int i=0; i<objectList.size(); i++)
			{
				SupplierProduct temp = (SupplierProduct) objectList.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getStockAmount()+"";
			}
			table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Product Id", "StockAmount"}));
		}
		else if (objectList.get(0) instanceof Supplier)
		{
			n=4;
			for (int i=0; i<objectList.size(); i++)
			{
				Supplier temp = (Supplier) objectList.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getAFM();
			}
			table.setModel(new DefaultTableModel(data, new String[] {"Supplier Name", "Supplier Id", "Supplier AFM"}));
		}
		else if (objectList.get(0) instanceof Buyer)
		{
			n=5;
			for (int i=0; i<objectList.size(); i++)
			{
				Buyer temp = (Buyer) objectList.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getAFM();
			}
			table.setModel(new DefaultTableModel(data, new String[] {"Buyer Name", "Buyer Id", "Buyer AFM"}));
		}
		table.setForeground(Color.BLACK);
		table.setBackground(SystemColor.info);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scroll.setViewportView(table);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
		        
		        TableModel model = table.getModel();
		        
		        String SelectedId = model.getValueAt(index, 1).toString();
		        if(n==1)
		        {
			        for(Object o : objectList)
					{
			        	Order temp = (Order) o;
						if(temp.getOrderId().equals(SelectedId)) new ShowOrder(temp);
					}
		        }
		        else if (n==2)
		        {
		        	for(Object o : objectList)
					{
			        	CompanyProduct temp = (CompanyProduct) o;
						if(temp.getId().equals(SelectedId)) new ShowProduct(temp);
					}
		        }
		        else if (n==3)
		        {
		        	for(Object o : objectList)
					{
		        		SupplierProduct temp = (SupplierProduct) o;
						if(temp.getId().equals(SelectedId)) new ShowProduct(temp);
					}
		        }
		        else if(n==4)
		        {
		        	for(Object o : objectList)
					{
		        		Supplier temp = (Supplier) o;
						if(temp.getId().equals(SelectedId)) new ShowBuyerSeller(temp);
					}
		        }
		        else if (n==5)
		        {
		        	for(Object o : objectList)
					{
		        		Buyer temp = (Buyer) o;
						if(temp.getId().equals(SelectedId)) new ShowBuyerSeller(temp);
					}
		        }
			}
		});
		
		

		
		this.setContentPane(panel);
	
		
		this.setVisible(true);
		this.setTitle("PresentationForm");
		this.setBounds(100, 100, 511, 488);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	                    
	
}