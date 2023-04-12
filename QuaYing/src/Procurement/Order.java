package Procurement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.DAO;
import Main.Main;

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
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import javax.swing.JComboBox;

public class Order extends JPanel implements ActionListener {

	public static final String Refresh_STR = "Refresh";
	private static final String cancelString = "cancel";
	private static final String Order = "Order";

	private JTable table;
	private JTextField idField;
	private JTextField supField;
	private JTextField qtyField;
	private JTextField ordateField;
	JComboBox<SupCon> supComboBox,goodComboBox;
	DefaultTableModel tableModel;
	int id, suppId,gid,goodId;
	String rd;
	public Order(Main main) {

		JLabel OrderLB = new JLabel("Order");
		OrderLB.setFont(new Font("Quark", Font.BOLD, 20));
		OrderLB.setBounds(340, 23, OrderLB.getPreferredSize().width, OrderLB.getPreferredSize().height);
		add(OrderLB);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 172, 614, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnNames = { "ID", "Supplier", "Goods", "Quantity", "Oreder Date","Oreder Time" };
		tableModel = new DefaultTableModel(columnNames, 0);

		DAO.showTableOrder(tableModel);
		table.setModel(tableModel);

		supComboBox = new JComboBox<>();
		supComboBox.setBounds(173, 76, 189, 20);
		add(supComboBox);

		DAO.ComboBoxOrderSup(supComboBox);

		goodComboBox = new JComboBox<>();
		goodComboBox.setBounds(468, 75, 189, 20);
		add(goodComboBox);
		
		
		DAO.ComboBoxOrderGid(goodComboBox);
		qtyField = new JTextField();
		qtyField.setColumns(10);
		qtyField.setBounds(173, 107, 189, 20);
		add(qtyField);

		LocalDate ReceiveDate = LocalDate.now();
		DateTimeFormatter formatRD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 rd = ReceiveDate.format(formatRD);
		ordateField = new JTextField();
		ordateField.setColumns(10);
		ordateField.setBounds(468, 107, 189, 20);
		ordateField.setText(rd);
		add(ordateField);

		JLabel lblSup = new JLabel("Supplier");
		lblSup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSup.setBounds(43, 77, 120, 19);
		add(lblSup);

		JLabel lbGood = new JLabel("Goods  ID");
		lbGood.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbGood.setBounds(372, 77, 74, 14);
		add(lbGood);

		JLabel lbQty = new JLabel("Quantity");
		lbQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbQty.setBounds(43, 108, 120, 19);
		add(lbQty);

		JLabel lbOrdate = new JLabel("Orderdate");
		lbOrdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbOrdate.setBounds(372, 105, 89, 19);
		add(lbOrdate);

		JButton btnrder = new JButton(Order);
		btnrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnrder.setForeground(new Color(34, 139, 34));
		btnrder.setBounds(216, 138, 89, 23);
		add(btnrder);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(316, 138, 89, 23);
		add(btnCancle);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(415, 138, 89, 23);
		add(btnRefresh);
		
		goodComboBox.addActionListener(this);
		supComboBox.addActionListener(this);
		btnrder.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		goodComboBox.setSelectedIndex(-1);
		supComboBox.setSelectedIndex(-1);


	}

	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {
		  if (source == supComboBox) {
			  SupCon selected = (SupCon) supComboBox.getSelectedItem();
			suppId= selected.getid();
			id=suppId;

			
		}else if(source == goodComboBox){
			SupCon selected = (SupCon) goodComboBox.getSelectedItem();
			goodId= selected.getid();
			gid=goodId;
		} else if (command.equals(Order)) {
			System.out.println("actionCommand:" + Order);
			try {
				// retrieve values from text fields.
				
				ZoneId zone = ZoneId.of("Asia/Bangkok");  
			    ZonedDateTime currentTime = ZonedDateTime.now(zone);
			    String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				int sup = id;
				int goods =gid;
				int qty = Integer.parseInt(qtyField.getText());
				String ordate = ordateField.getText();
				String ortime = formattedTime;
				OrderCont Add = new OrderCont(0, sup, goods, qty, ordate,ortime);
				System.out.println("Order:" + Add.toString());
				DAO.addOrder(Add);
				// reset text fields
				qtyField.setText(null);
				goodComboBox.setSelectedIndex(-1);
				supComboBox.setSelectedIndex(-1);


				tableModel.setRowCount(0);
				DAO.showTableOrder(tableModel);
				table.setModel(tableModel);
			} catch (Exception ex) {
				
				System.err.println("Error! Invalid data." );
			}
			
			// user presses "Cancel"
		} else if (command.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		} else if (command.equals(Refresh_STR)) {
			ordateField.setText(rd);
			tableModel.setRowCount(0);
			DAO.showTableOrder(tableModel);
			table.setModel(tableModel);

		}
		} catch (Exception ex) {
			System.err.println("Error! Invalid data.");
		}

		System.out.println("--------------Start------------------");
		System.out.println("ConsoleLog supp ID : " + id);
		System.out.println("ConsoleLog supp ID : " + gid);
		System.out.println("---------------END-----------------");

	}
}
