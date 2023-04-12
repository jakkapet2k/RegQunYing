package Customer;

import Main.DAO;
import Main.Main;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class CustomerAdd extends JPanel implements ActionListener {

	private static final String ADD_STR = "Add";
	private static final String cancelString = "cancel";
	public static final String Refresh_STR = "Refresh";

	DefaultTableModel tableModel;
	private JTable table;
	private JTextField userField, passField;


	public CustomerAdd(Main main) {

		JLabel lblAddCustomer = new JLabel("ADD Customer");
		lblAddCustomer.setFont(new Font("Quark", Font.BOLD, 20));
		lblAddCustomer.setBounds(292, 21, lblAddCustomer.getPreferredSize().width,
				lblAddCustomer.getPreferredSize().height);
		add(lblAddCustomer);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 149, 602, 300);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] columnNames = { "ID", "Username", "Password" };
		tableModel = new DefaultTableModel(columnNames, 0);

		tableModel.setRowCount(0);
		DAO.showTableCustomer(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);

		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(135, 84, 195, 20);
		add(userField);

		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(433, 84, 195, 20);
		add(passField);

		JLabel Name = new JLabel("Username");
		Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		Name.setBounds(49, 85, 120, 14);
		add(Name);

		JLabel passwoedlB = new JLabel("Password");
		passwoedlB.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwoedlB.setBounds(343, 85, 82, 14);
		add(passwoedlB);

		JButton btnAdd = new JButton(ADD_STR);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(255, 99, 71));
		btnAdd.setBounds(177, 115, 89, 23);
		add(btnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(277, 115, 89, 23);
		add(btnCancle);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(382, 115, 142, 23);
		add(btnRefresh);

		btnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();


		try {
			if (command.equals(ADD_STR)) {
				System.out.println("actionCommand:" + ADD_STR);

				String user = userField.getText();
				String pass = passField.getText();
				Customer Add = new Customer(0, user, pass);
				System.out.println("Customer:" + Add.toString());
				DAO.addCustomer(Add);
				// reset text fields
				userField.setText(null);
				passField.setText(null);

				tableModel.setRowCount(0);
				DAO.showTableCustomer(tableModel);
				table.setModel(tableModel);
			
			} else if (command.equals(Refresh_STR)) {

				tableModel.setRowCount(0);
				DAO.showTableCustomer(tableModel);
				table.setModel(tableModel);

			} else if (command.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		 }

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

	}
}
