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
import javax.swing.JComboBox;

public class CustomerEdit extends JPanel implements ActionListener {

	private static final String Edit_STR = "Edit";
	private static final String cancelString = "cancel";
	public static final String Refresh_STR = "Refresh";

	DefaultTableModel tableModel;
	private JTable table;
	private JTextField userField, passField,idField;

	public CustomerEdit(Main main) {

		JLabel lblAddSupplier = new JLabel("Edit Supplier");
		lblAddSupplier.setFont(new Font("Quark", Font.BOLD, 20));
		lblAddSupplier.setBounds(292, 21, lblAddSupplier.getPreferredSize().width,
				lblAddSupplier.getPreferredSize().height);
		add(lblAddSupplier);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 149, 602, 308);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0) {
					String id1 = tableModel.getValueAt(row, 0).toString();
					String cust = tableModel.getValueAt(row, 1).toString();
					String pass = tableModel.getValueAt(row, 2).toString();
					idField.setText(id1);
					userField.setText(cust);
					passField.setText(pass);

					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog ID: " + id1);
					System.out.println("ConsoleLog user: " + cust);
					System.out.println("ConsoleLog pass: " + pass);
					System.out.println("---------------END-----------------");
				}

			}

		});

		String[] columnNames = { "ID", "Username", "Password"};
		tableModel = new DefaultTableModel(columnNames, 0);

		tableModel.setRowCount(0);
		DAO.showTableCustomer(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(264, 53, 195, 20);
		add(idField);

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

		JButton btnEdit = new JButton(Edit_STR);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setForeground(new Color(255, 99, 71));
		btnEdit.setBounds(181, 115, 89, 23);
		add(btnEdit);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(281, 115, 89, 23);
		add(btnCancle);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(386, 115, 142, 23);
		add(btnRefresh);

		btnEdit.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		

		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(217, 54, 37, 14);
		add(lblId);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {
			if (command.equals(Edit_STR)) {
				System.out.println("actionCommand:" + Edit_STR);
				try {
					// retrieve values from text fields.
					int id = Integer.parseInt(idField.getText());
					String user = userField.getText();
					String pass = passField.getText();
					Customer Edit = new Customer(id, user, pass);
					System.out.println("Customer:" + Edit.toString());
					DAO.EditCustomer(Edit);
					// reset text fields
					idField.setText(null);
					userField.setText(null);
					passField.setText(null);

					tableModel.setRowCount(0);
					DAO.showTableCustomer(tableModel);
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
				DAO.showTableCustomer(tableModel);
				table.setModel(tableModel);

			}
		} catch (Exception ex) {
			System.err.println("Error! Invalid data.");
		}

	}
}
