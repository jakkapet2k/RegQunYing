package Report;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Main.DAO;
import Main.Main;



public class OrderReport extends JPanel implements ActionListener{
	
	public static final String View_STR = "View Order";
	DefaultTableModel tableModel;
	JTable table;
	Main main;
	Menu menu;
	String formattedNum;
	JLabel lblBaht,lblTotal,lblTotal_1;
	
	public OrderReport(Main main)   {
		
		
		
		this.setBounds(0,0,500,300);
		this.setLayout(null);
		
		JLabel lblGoodsInfo = new JLabel("Orders Report");
		lblGoodsInfo.setFont(new Font("Quark", Font.BOLD, 23));
		lblGoodsInfo.setBounds(272, 42, 136,33);
		this.add(lblGoodsInfo);
		setPreferredSize(new Dimension(684,486));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 664, 309);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		
		String[] columnNames = {"ID", "Supplier", "Goods", "Quantity", "Order Date", "Time", "Total Price"};
		tableModel = new DefaultTableModel(columnNames, 0);

		
		DAO.showTableOrderReport(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(30);
		column1 = table.getColumnModel().getColumn(2);
		column1.setPreferredWidth(150);
		column1 = table.getColumnModel().getColumn(3);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(4);
		column1.setPreferredWidth(30);
		column1 = table.getColumnModel().getColumn(5);
		column1.setPreferredWidth(20);
		column1 = table.getColumnModel().getColumn(6);
		column1.setPreferredWidth(30);
		
		int sum = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
		    sum += Integer.parseInt(table.getValueAt(i, 6).toString());
		}
	
		NumberFormat formatter = NumberFormat.getNumberInstance();
		String formattedNum = formatter.format(sum);
		
		JButton btnViewGoods = new JButton(View_STR);
		btnViewGoods.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewGoods.setForeground(new Color(0, 191, 255));
		btnViewGoods.setBounds(10, 409, 123, 23);
		add(btnViewGoods);

		 lblTotal = new JLabel("Total");
		lblTotal.setBounds(449, 414, 46, 14);
		add(lblTotal);
		
		 lblBaht = new JLabel("Baht");
		lblBaht.setBounds(578, 414, 46, 14);
		add(lblBaht);
		
		 lblTotal_1 = new JLabel();
		lblTotal_1.setBounds(505, 414, 63, 14);
		lblTotal_1.setText(formattedNum);
		add(lblTotal_1);
		
		btnViewGoods.addActionListener(this);
		
		
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();
		if(command.equals(View_STR)) {
			tableModel.setRowCount(0);
			DAO.showTableOrderReport(tableModel);
			table.setModel(tableModel);

	}
		}
	
  

	
}
