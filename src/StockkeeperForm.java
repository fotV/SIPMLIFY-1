import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;

public class StockkeeperForm extends JFrame{
    public static int progress = 0;
    
	private JPanel panel;
	private JButton btnSearchForOrder;
	private JButton Refreshbutton;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblTelephone;
	private JLabel lblAFM ;
	private JLabel lblID;
	private JLabel resultName;
	private JLabel resultSurname;
	private JLabel resultTelephone;
	private JLabel resultAFM;
	private JLabel resultID;

	public StockkeeperForm(Stockkeeper stk)
	{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(135, 206, 235));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


		btnSearchForOrder = new JButton("Search For Order");
		btnSearchForOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearchForOrder.setBounds(10, 448, 250, 79);
		panel.add(btnSearchForOrder);
		
		
		Refreshbutton = new JButton();
		Refreshbutton.setIcon(new ImageIcon("C:\\Users\\Christina\\Desktop\\43339-200.png"));
		Refreshbutton.setForeground(Color.WHITE);
		Refreshbutton.setBounds(636, 448, 97, 85);
		panel.add(Refreshbutton);
		
		
        
		lblName = new JLabel("First Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(30, 36, 116, 32);
		panel.add(lblName);
		
		lblSurname = new JLabel("SurName :");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSurname.setBounds(30, 107, 116, 32);
		panel.add(lblSurname);
		
		lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelephone.setBounds(30, 180, 116, 32);
		panel.add(lblTelephone);
		
		lblAFM = new JLabel("AFM :");
		lblAFM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAFM.setBounds(30, 252, 116, 32);
		panel.add(lblAFM);
		
		lblID = new JLabel("ID :");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblID.setBounds(30, 327, 116, 32);
		panel.add(lblID);
		
		
		
		
		
		resultName = new JLabel(stk.firstName);
		resultName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		resultName.setBounds(169, 36, 226, 26);
		panel.add(resultName);
		
		resultSurname = new JLabel(stk.surName);
		resultSurname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		resultSurname.setBounds(169, 107, 226, 26);
		panel.add(resultSurname);
		
		resultTelephone = new JLabel(stk.telephone);
		resultTelephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		resultTelephone.setBounds(169, 180, 226, 26);
		panel.add(resultTelephone);
		
		resultAFM = new JLabel(stk.AMA);
		resultAFM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		resultAFM.setBounds(169, 252, 226, 26);
		panel.add(resultAFM);
		
		resultID = new JLabel(stk.id);
		resultID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		resultID.setBounds(169, 339, 226, 26);
		panel.add(resultID);
		
		
		btnSearchForOrder.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
					new SearchForm(1);
			}	
		});

		Refreshbutton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				stk.refresh();
			}
					
		});

	
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setTitle("HomePage");
		this.setBounds(100, 100, 759, 583);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
