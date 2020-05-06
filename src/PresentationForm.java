import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class PresentationForm extends JFrame{
	
	private JPanel panel;
	private JTable table = new JTable();
	private JScrollPane scroll;

	
	public PresentationForm(ArrayList <Object> objectList)
	{
		
		panel = new JPanel();
		String[][] data = new String[objectList.size()][3];
		
		
		for (int i=0; i<objectList.size(); i++)
		{
			if (objectList.get(i) instanceof Order)   //εκανα προς το παρων μονο για order πειδη εχω κανει την searchfororder. Χρειαζεται ακομα και για τα αλλα.
			{
				Order temp = (Order) objectList.get(i);
				data[i][0]=temp.productName;
				data[i][1]=temp.orderId;
				data[i][2]=temp.status+"";
			}
		}
		
		
		table.setModel(new DefaultTableModel(
				data, new String[] {"Product Name", "Order ID", "Status"}
			));
		
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
		        
		        TableModel model = table.getModel();
		        
		        String id = model.getValueAt(index, 1).toString();
		        for(Object o : objectList)
				{
		        	Order temp = (Order) o;
					if(temp.orderId.equals(id)) new ShowOrder(temp);
				}
			}
		});
		scroll = new JScrollPane(table);
		
		panel.add(scroll);
		
		this.setContentPane(panel);
	
		
		this.setVisible(true);
		this.setTitle("GUI AND DS EXAMPLE");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	                    
	
}