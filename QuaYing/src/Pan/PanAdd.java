package Pan;

import Main.DAO;
import Main.Main;
import Memberlist.Item;
import Memberlist.Member;

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

public class PanAdd extends JPanel implements ActionListener {

	private static final String ADD_STR = "Add";
	private static final String cancelString = "cancel";
	public static final String Refresh_STR = "Refresh";

	DefaultTableModel tableModel;
	private JTable table;
	private JTextField nameField, addressField, phoneField;

	JComboBox<ProvinceCont> HsComboBox;
	String hsId;

	public PanAdd(Main main) {

		JLabel lblAddSupplier = new JLabel("ADD Supplier");
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

		String[] columnNames = { "ID", "Supplier", "address", "Province", "Phon" };
		tableModel = new DefaultTableModel(columnNames, 0);

		tableModel.setRowCount(0);
		DAO.showTableSupplier(tableModel);
		table.setModel(tableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(5);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(179, 84, 195, 20);
		add(nameField);

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(179, 115, 195, 20);
		add(addressField);

		HsComboBox = new JComboBox<>();
		HsComboBox.setBounds(460, 84, 191, 20);
		add(HsComboBox);

		DAO.ComboBoxProvince(HsComboBox);
		HsComboBox.setSelectedIndex(-1);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(460, 110, 191, 20);
		add(phoneField);

		JLabel Name = new JLabel("Supplier Name");
		Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		Name.setBounds(49, 85, 120, 14);
		add(Name);

		JLabel address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.BOLD, 15));
		address.setBounds(49, 116, 120, 14);
		add(address);

		JLabel province = new JLabel("Province");
		province.setFont(new Font("Tahoma", Font.BOLD, 15));
		province.setBounds(384, 85, 79, 14);
		add(province);

		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.BOLD, 15));
		phone.setBounds(384, 111, 70, 14);
		add(phone);

		JButton btnAdd = new JButton(ADD_STR);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(255, 99, 71));
		btnAdd.setBounds(179, 146, 89, 23);
		add(btnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(279, 146, 89, 23);
		add(btnCancle);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(SystemColor.activeCaption);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(384, 146, 142, 23);
		add(btnRefresh);

		btnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		HsComboBox.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

//		try {
//			if (source == HsComboBox) {
//				ProvinceCont selected = (ProvinceCont) HsComboBox.getSelectedItem();
//				hsId = selected.getid();
//				idpv = hsId;
//			} else if (command.equals(ADD_STR)) {
//				System.out.println("actionCommand:" + ADD_STR);
//				try {
//					// retrieve values from text fields.
//					String sup = nameField.getText();
//					String addr = addressField.getText();
//					String pv = idpv;
//					String phone = phoneField.getText();
//					Supplier Add = new Supplier(0, sup, addr, pv, phone);
//					System.out.println("Supplier:" + Add.toString());
//					DAO.addSupplier(Add);
//					// reset text fields
//					nameField.setText(null);
//					addressField.setText(null);
//					HsComboBox.setSelectedIndex(-1);
//					phoneField.setText(null);
//
//					tableModel.setRowCount(0);
//					DAO.showTableSupplier(tableModel);
//					table.setModel(tableModel);
//				} catch (Exception ex) {
//					System.err.println("Error! Invalid data.");
////					ex.printStackTrace();
//				}
//				// user presses "Cancel"
//			} else if (command.equals(cancelString)) {
//				System.out.println("actionCommand:" + cancelString);
//				setVisible(false);
//			} else if (command.equals(Refresh_STR)) {
//				tableModel.setRowCount(0);
//				DAO.showTableSupplier(tableModel);
//				table.setModel(tableModel);
//
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		try {

			if (source == HsComboBox) {
				// Handle changes to the "catagoryCB" JComboBox
				ProvinceCont selected = (ProvinceCont) HsComboBox.getSelectedItem();
				hsId = selected.getid();

			} else if (command.equals(cancelString)) {
				System.out.println("actionCommand:" + cancelString);
				setVisible(false);
			} else if (command.equals(Refresh_STR)) {

				tableModel.setRowCount(0);
				DAO.showTableSupplier(tableModel);
				table.setModel(tableModel);

			} else if (command.equals(ADD_STR) & nameField.getText().isEmpty() || addressField.getText().isEmpty()
					|| phoneField.getText().isEmpty()) {

				System.err.println("Error! Invalid data.");
			} else {
				System.out.println("actionCommand:" + ADD_STR);

				String pv = hsId;
				String sup = nameField.getText();
				String addr = addressField.getText();
				String phone = phoneField.getText();
				Pan Add = new Pan(0, sup, addr, pv, phone);
				System.out.println("Suppler:" + Add.toString());
				DAO.addSupplier(Add);
				// reset text fields
				HsComboBox.setSelectedIndex(-1);
				phoneField.setText(null);
				addressField.setText(null);
				nameField.setText(null);

				tableModel.setRowCount(0);
				DAO.showTableSupplier(tableModel);
				table.setModel(tableModel);
			}

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

	}
}
