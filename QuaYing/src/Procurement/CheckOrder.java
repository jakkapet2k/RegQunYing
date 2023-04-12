package Procurement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.DAO;
import Main.Main;
import Memberlist.Goods;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CheckOrder extends JPanel implements ActionListener  {
	
	
	
	public static final String Refresh_STR = "Refresh";
	private static final String cancelString = "cancel";
	private static final String ACCEPT = "Accept";
	
	
	
	private JTable table;
	private JTextField idField;
	private JTextField RecDateField;
	DefaultTableModel tableModel;
	public CheckOrder(Main main) {
		
		
		JLabel lblDeleteGoods = new JLabel("Check Order");
		lblDeleteGoods.setFont(new Font("Quark", Font.BOLD, 20));
		lblDeleteGoods.setBounds(299, 22,lblDeleteGoods.getPreferredSize().width,lblDeleteGoods.getPreferredSize().height);
		add(lblDeleteGoods);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 165, 629, 294);
		add(scrollPane);
		
		idField = new JTextField();
		idField.setBounds(231, 62, 243, 20);
		add(idField);
		idField.setColumns(10);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					String id1 = tableModel.getValueAt(row, 0).toString();
					idField.setText(id1);
					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog ID: " + id1);
					System.out.println("---------------END-----------------");
				}
				
				}
				
			});
		
		String[] columnNames = { "ID", "Supplier", "Goods", "Quantity", "Oreder Date","Receive Date","Receive Time" };
		tableModel = new DefaultTableModel(columnNames, 0);

		DAO.showTableCheckOrder(tableModel);
		table.setModel(tableModel);


		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbId.setBounds(195, 63, 34, 21);
		add(lbId);
		
		JButton btnNewButton = new JButton(ACCEPT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setBounds(208, 118, 89, 23);
		add(btnNewButton);
		
		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(307, 118, 89, 23);
		add(btnCancle);
		
		LocalDate ReceiveDate = LocalDate.now();
		DateTimeFormatter formatRD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String rd = ReceiveDate.format(formatRD);
		RecDateField = new JTextField();
		RecDateField.setColumns(10);
		RecDateField.setBounds(231, 93, 243, 20);
		RecDateField.setText(rd);
		add(RecDateField);
		
		
		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(406, 118, 89, 23);
		add(btnRefresh);
		
	    
		JLabel lblReceive = new JLabel("Receive Date");
		lblReceive.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReceive.setBounds(111, 94, 118, 21);
		add(lblReceive);
		
		btnNewButton.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();
		if (command.equals(ACCEPT)) {
			System.out.println("actionCommand:" + ACCEPT);
			try {
				// retrieve values from text fields.
				
				ZoneId zone = ZoneId.of("Asia/Bangkok");  
			    ZonedDateTime currentTime = ZonedDateTime.now(zone);
			    String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				int id = Integer.parseInt(idField.getText());
				String name = RecDateField.getText();

				Check Update = new Check(id, name,formattedTime);
				System.out.println("goods:" + Update.toString());
				DAO.AcceptOrder(Update);
				// reset text fields
				idField.setText(null);

				tableModel.setRowCount(0);
				DAO.showTableCheckOrder(tableModel);
				table.setModel(tableModel);
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (command.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		} else if (command.equals(Refresh_STR)) {

			tableModel.setRowCount(0);
			DAO.showTableCheckOrder(tableModel);
			table.setModel(tableModel);

		}
		
	}
	

		

}
