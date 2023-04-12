package Supplier;

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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

public class SupplierDelete extends JPanel implements ActionListener {
	
	public static final String Refresh_STR = "Refresh";
	private static final String cancelString = "cancel";
	private static final String DeleteString = "Delete";
	DefaultTableModel tableModel;
	private JTable table;
	private JTextField idField;
	
	
	public SupplierDelete(Main main) {
		
		
		JLabel lblDeleteSupplier = new JLabel("Delete Supplier");
		lblDeleteSupplier.setFont(new Font("Quark", Font.BOLD, 20));
		lblDeleteSupplier.setBounds(34, 30,lblDeleteSupplier.getPreferredSize().width,lblDeleteSupplier.getPreferredSize().height);
		add(lblDeleteSupplier);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 70, 626, 348);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String[] columnNames = {"ID", "Supplier", "address", "Province", "Phon"};
		 tableModel = new DefaultTableModel(columnNames, 0);
		
		tableModel.setRowCount(0);
		DAO.showTableSupplier(tableModel);
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		
		
		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);
		
		idField = new JTextField();
		idField.setBounds(276, 32, 189, 20);
		add(idField);
		idField.setColumns(10);
		
		JLabel lbSupplier = new JLabel("Supplier ID");
		lbSupplier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSupplier.setBounds(173, 33, 118, 21);
		add(lbSupplier);
		
		JButton btnDelete = new JButton(DeleteString);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setForeground(new Color(165, 42, 42));
		btnDelete.setBounds(472, 30, 89, 23);
		add(btnDelete);
		
		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(571, 30, 89, 23);
		add(btnCancle);
		
		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(34, 429, 89, 23);
		add(btnRefresh);

		
		
		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		if (command.equals(DeleteString)) {
			System.out.println("actionCommand:" + DeleteString);
			try {
				int id = 0;
				int idsup = Integer.parseInt(idField.getText());;

				Supplier Delete = new Supplier(idsup, null, null, null, null);
				DAO.DeleteSupplier(Delete);

				// reset text fields
				idField.setText(null);

				tableModel.setRowCount(0);
				DAO.showTableSupplier(tableModel);
				table.setModel(tableModel);
				
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
			// user presses "Cancel"
		} else if (command.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}else if (command.equals(Refresh_STR)) {

			tableModel.setRowCount(0);
			DAO.showTableSupplier(tableModel);
			table.setModel(tableModel);

		}
		
	}
}
