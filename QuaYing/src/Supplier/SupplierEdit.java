package Supplier;
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

public class SupplierEdit extends JPanel implements ActionListener {

	private static final String Edit_STR = "Edit";
	private static final String cancelString = "cancel";
	public static final String Refresh_STR = "Refresh";

	DefaultTableModel tableModel;
	private JTable table;
	private JTextField idField, nameField, addressField, phoneField;

	JComboBox<ProvinceCont> HsComboBox;
	String idpv, hsId;

	public SupplierEdit(Main main) {

		JLabel lblAddSupplier = new JLabel("Edit Supplier");
		lblAddSupplier.setFont(new Font("Quark", Font.BOLD, 20));
		lblAddSupplier.setBounds(292, 21, lblAddSupplier.getPreferredSize().width,
				lblAddSupplier.getPreferredSize().height);
		add(lblAddSupplier);
		setPreferredSize(new Dimension(684, 486));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 190, 602, 261);
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
					String sup1 = tableModel.getValueAt(row, 1).toString();
					String address1 = tableModel.getValueAt(row, 2).toString();
					String phone1 = tableModel.getValueAt(row, 4).toString();
					idField.setText(id1);
					nameField.setText(sup1);
					addressField.setText(address1);
					phoneField.setText(phone1);

					System.out.println("--------------Start------------------");
					System.out.println("ConsoleLog ID: " + id1);
					System.out.println("ConsoleLog Name: " + sup1);
					System.out.println("ConsoleLog Address: " + address1);
					;
					System.out.println("ConsoleLog Phone: " + phone1);
					System.out.println("---------------END-----------------");
				}

			}

		});

		String[] columnNames = { "ID", "Supplier", "address", "Province", "Phon" };
		tableModel = new DefaultTableModel(columnNames, 0);

		tableModel.setRowCount(0);
		DAO.showTableSupplier(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(179, 63, 195, 20);
		add(idField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(179, 94, 195, 20);
		add(nameField);

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(179, 125, 195, 20);
		add(addressField);

		HsComboBox = new JComboBox<>();
		HsComboBox.setBounds(460, 94, 191, 20);
		add(HsComboBox);

		DAO.ComboBoxProvince(HsComboBox);
		HsComboBox.setSelectedIndex(-1);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(460, 120, 191, 20);
		add(phoneField);

		JLabel ID = new JLabel("ID");
		ID.setFont(new Font("Tahoma", Font.BOLD, 15));
		ID.setBounds(49, 66, 120, 14);
		add(ID);

		JLabel Name = new JLabel("Supplier Name");
		Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		Name.setBounds(49, 95, 120, 14);
		add(Name);

		JLabel address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.BOLD, 15));
		address.setBounds(49, 126, 120, 14);
		add(address);

		JLabel province = new JLabel("Province");
		province.setFont(new Font("Tahoma", Font.BOLD, 15));
		province.setBounds(384, 95, 79, 14);
		add(province);

		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.BOLD, 15));
		phone.setBounds(384, 121, 70, 14);
		add(phone);

		JButton btnEdit = new JButton(Edit_STR);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setForeground(new Color(255, 99, 71));
		btnEdit.setBounds(179, 156, 89, 23);
		add(btnEdit);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(279, 156, 89, 23);
		add(btnCancle);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(384, 156, 142, 23);
		add(btnRefresh);

		btnEdit.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		HsComboBox.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {
			if (source == HsComboBox) {
				ProvinceCont selected = (ProvinceCont) HsComboBox.getSelectedItem();
				hsId = selected.getid();
				idpv = hsId;
				System.out.println("ConsoleLog supp ID : " + hsId);

			} else if (command.equals(Edit_STR)) {
				System.out.println("actionCommand:" + Edit_STR);
				try {
					// retrieve values from text fields.
					int id = Integer.parseInt(idField.getText());
					String sup = nameField.getText();
					String addr = addressField.getText();
					String pv = idpv;
					String phone = phoneField.getText();
					Supplier Edit = new Supplier(id, sup, addr, pv, phone);
					System.out.println("Supplier:" + Edit.toString());
					DAO.EditSupplier(Edit);
					// reset text fields
					idField.setText(null);
					nameField.setText(null);
					addressField.setText(null);
					HsComboBox.setSelectedIndex(-1);
					phoneField.setText(null);

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
			} else if (command.equals(Refresh_STR)) {
				tableModel.setRowCount(0);
				DAO.showTableSupplier(tableModel);
				table.setModel(tableModel);

			}
		} catch (Exception ex) {
			System.err.println("Error! Invalid data.");
		}

	}
}
