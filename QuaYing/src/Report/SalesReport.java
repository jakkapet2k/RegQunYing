package Report;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Main.DAO;
import Main.Main;



public class SalesReport extends JPanel implements ActionListener{
	
	public static final String View_STR = "View Sales";
	DefaultTableModel tableModel;
	JTable table;
	Main main;
	Menu menu;
	
	public SalesReport(Main main)   {
		
		
		
		this.setBounds(0,0,500,300);
		this.setLayout(null);
		
		JLabel lblGoodsInfo = new JLabel("Sales Report");
		lblGoodsInfo.setFont(new Font("Quark", Font.BOLD, 23));
		lblGoodsInfo.setBounds(272, 42, 136,33);
		this.add(lblGoodsInfo);
		setPreferredSize(new Dimension(684,486));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 664, 309);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		
		String[] columnNames = {"ID", "Order Date", "Time", "Customer", "Goods", "Quantity", "Total Price"};
		tableModel = new DefaultTableModel(columnNames, 0);

		
		DAO.showTableSales(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(30);
		column1 = table.getColumnModel().getColumn(2);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(3);
		column1.setPreferredWidth(5);
		column1 = table.getColumnModel().getColumn(4);
		column1.setPreferredWidth(150);
		column1 = table.getColumnModel().getColumn(5);
		column1.setPreferredWidth(20);
		column1 = table.getColumnModel().getColumn(6);
		column1.setPreferredWidth(30);
		
	
		
		JButton btnViewGoods = new JButton(View_STR);
		btnViewGoods.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewGoods.setForeground(new Color(0, 191, 255));
		btnViewGoods.setBounds(10, 409, 123, 23);
		add(btnViewGoods);
		
		btnViewGoods.addActionListener(this);

		
		
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();
		if(command.equals(View_STR)) {
			
			tableModel.setRowCount(0);
			DAO.showTableSales(tableModel);
			table.setModel(tableModel);
			
			
	}
		}
	
  

	
}
