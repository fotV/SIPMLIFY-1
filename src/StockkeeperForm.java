package src;
import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

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
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


		btnSearchForOrder = new JButton("Search For Order");
		btnSearchForOrder.setBackground(new Color(255, 255, 224));
		btnSearchForOrder.setFont(new Font("Futura Bk BT", Font.PLAIN, 24));
		btnSearchForOrder.setBounds(10, 448, 243, 79);
		panel.add(btnSearchForOrder);
		
		
		Refreshbutton = new JButton();
		Refreshbutton.setBackground(new Color(255, 255, 224));
		Refreshbutton.setIcon(new ImageIcon("C:\\Users\\Christina\\Desktop\\3\\Organizedorders\\refresh.png"));
		Refreshbutton.setForeground(Color.WHITE);
		Refreshbutton.setBounds(647, 448, 86, 85);
		panel.add(Refreshbutton);
		
		
        
		lblName = new JLabel("First Name :");
		lblName.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		lblName.setBounds(30, 36, 116, 32);
		panel.add(lblName);
		
		lblSurname = new JLabel("SurName :");
		lblSurname.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		lblSurname.setBounds(30, 107, 116, 32);
		panel.add(lblSurname);
		
		lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		lblTelephone.setBounds(30, 180, 116, 32);
		panel.add(lblTelephone);
		
		lblAFM = new JLabel("AFM :");
		lblAFM.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		lblAFM.setBounds(30, 252, 116, 32);
		panel.add(lblAFM);
		
		lblID = new JLabel("ID :");
		lblID.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		lblID.setBounds(30, 327, 116, 32);
		panel.add(lblID);
		
		
		
		
		
		resultName = new JLabel(stk.firstName);
		resultName.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		resultName.setBounds(232, 36, 226, 26);
		panel.add(resultName);
		
		resultSurname = new JLabel(stk.surName);
		resultSurname.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		resultSurname.setBounds(232, 110, 226, 26);
		panel.add(resultSurname);
		
		resultTelephone = new JLabel(stk.telephone);
		resultTelephone.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		resultTelephone.setBounds(232, 183, 226, 26);
		panel.add(resultTelephone);
		
		resultAFM = new JLabel(stk.AFM);
		resultAFM.setBackground(new Color(230, 230, 250));
		resultAFM.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		resultAFM.setBounds(232, 255, 226, 26);
		panel.add(resultAFM);
		
		resultID = new JLabel(stk.id);
		resultID.setBackground(new Color(255, 250, 240));
		resultID.setFont(new Font("Futura Bk BT", Font.PLAIN, 20));
		resultID.setBounds(232, 330, 226, 26);
		panel.add(resultID);
		
		
		btnSearchForOrder.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{

					new SearchForm(1, stk);

			}	
		});

		Refreshbutton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				stk.refresh();
			}	
		});

	
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Christina\\Desktop\\3\\Organizedorders\\window logo.png"));
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setTitle("HomePage");
		this.setBounds(100, 100, 759, 583);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public StockkeeperForm() {
		// TODO Auto-generated constructor stub
	}

}
