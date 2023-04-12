package Memberlist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Main.DAO;
import Main.Main;

public class MemberDelete extends JPanel implements ActionListener {
	private static final String Refresh_STR = "รีเฟรช";
	private static final String cancelString = "ยกเลิก";
	private static final String DELETE_STR = "ลบ";

	private static JTable table;
	private String GenderName, TeacherName, LocationName;
	Main main;
	Item g,t,l;;
	DefaultTableModel tableModel;;
	JLabel MidID,NameLB,SernameLB;
	DAO dao = new DAO();

	public MemberDelete(Main main) {

		setBackground(SystemColor.activeCaption);
		setPreferredSize(new Dimension(1366, 768));

		setLayout(null);

		JLabel label = new JLabel("ลบผู้รับธรรมะ");
		label.setFont(new Font("Angsana New", Font.BOLD, 32));
		label.setBounds(574, 11, label.getPreferredSize().width, label.getPreferredSize().height);
		add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 1323, 508);
		add(scrollPane);

		JLabel lbwarning = new JLabel("คำเตือน : หากทำการลบจะไม่สามารถกู้ข้อมูลได้\r\n");
		lbwarning.setForeground(new Color(128, 0, 0));
		lbwarning.setFont(new Font("Angsana New", Font.BOLD, 22));
		lbwarning.setBounds(1054, 88, 279, 37);
		add(lbwarning);
		
		JLabel lblMid = new JLabel("MID :");
		lblMid.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblMid.setBounds(266, 81, 62, 44);
		add(lblMid);
		
		 NameLB = new JLabel("ชื่อ");
		NameLB.setFont(new Font("Angsana New", Font.BOLD, 25));
		NameLB.setBounds(536, 81, 223, 44);
		add(NameLB);
		
		JLabel lbName = new JLabel("ชื่อ :");
		lbName.setFont(new Font("Angsana New", Font.BOLD, 25));
		lbName.setBounds(504, 81, 62, 44);
		add(lbName);
		
		 SernameLB = new JLabel("สกุล");
		SernameLB.setFont(new Font("Angsana New", Font.BOLD, 25));
		SernameLB.setBounds(805, 81, 242, 44);
		add(SernameLB);
		
		JLabel lbSername = new JLabel("สกุล :");
		lbSername.setFont(new Font("Angsana New", Font.BOLD, 25));
		lbSername.setBounds(737, 81, 62, 44);
		add(lbSername);
		
		
		MidID = new JLabel("MID");
		MidID.setFont(new Font("Angsana New", Font.BOLD, 25));
		MidID.setBounds(325, 81, 169, 44);
		add(MidID);

//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(43, 212, 586, 261);
//		add(scrollPane);

		table = new JTable();
		table.setBackground(SystemColor.inactiveCaption);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					String mid = tableModel.getValueAt(row, 0).toString();
					String name = tableModel.getValueAt(row, 1).toString();
					String ser = tableModel.getValueAt(row, 2).toString();
					MidID.setText(mid);
					NameLB.setText(name);
					SernameLB.setText(ser);

				}
			}

		});

		String[] columnNames = { "MID", "ชื่อ", "สกุล", "อายุ", "วันเกิด", "เพศ", "เบอร์", "การศึกษา", "งาน", "ที่อยู่",
				"วันรับธรรมะ", "แนะนำ", "รับรอง", "ถ่ายทอด", "สถานธรรม" };
		tableModel = new DefaultTableModel(columnNames, 0);

		DAO.showTableMemberlist(tableModel);
		table.setModel(tableModel);
		table.setRowHeight(30);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.black);
		tableHeader.setForeground(Color.white);
		Font headerFont = new Font("Tahoma", Font.BOLD, 15);
		tableHeader.setFont(headerFont);

		TableColumn column1 = table.getColumnModel().getColumn(4);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setPreferredWidth(0);
		column1 = table.getColumnModel().getColumn(6);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setPreferredWidth(0);
		column1 = table.getColumnModel().getColumn(7);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setPreferredWidth(0);
		column1 = table.getColumnModel().getColumn(8);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setPreferredWidth(0);
		column1 = table.getColumnModel().getColumn(9);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setPreferredWidth(0);


		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(new Color(0, 191, 255));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(208, 657, 98, 23);
		add(btnRefresh);

		JButton BtnAdd = new JButton(DELETE_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(128, 0, 0));
		BtnAdd.setBounds(10, 657, 89, 23);
		add(BtnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setForeground(new Color(0, 0, 0));
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(109, 656, 89, 23);
		add(btnCancle);

		BtnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		
		JLabel lblMid_1 = new JLabel("คลิกที่ตารางเพื่อเลือก");
		lblMid_1.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblMid_1.setBounds(23, 82, 188, 44);
		add(lblMid_1);


		


	}

	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {
 if (command.equals(DELETE_STR)) {
				System.out.println("actionCommand:" + DELETE_STR);
				try {
					String mid = MidID.getText();


					Member Delete = new Member(mid, null, null, 0, null, null, null, null, null, null, null, null, null, null, null);
					System.out.println("Member:" + Delete.toString());
					DAO.DeleteMember(Delete);
					MidID.setText(null);

					tableModel.setRowCount(0);
					DAO.showTableMemberlist(tableModel);
					table.setModel(tableModel);
				} catch (Exception ex) {
					System.err.println("Error! Invalid data.");
				}
				// user presses "Cancel"
			} else if (command.equals(cancelString)) {
				System.out.println("actionCommand:" + cancelString);
				setVisible(false);
			} else if (command.equals(Refresh_STR)) {

			
				MidID.setText(null);
				tableModel.setRowCount(0);
				DAO.showTableMemberlist(tableModel);
				table.setModel(tableModel);

			}

			System.out.println("--------------Start------------------");
			System.out.println("ConsoleLog G : " + GenderName);
			System.out.println("ConsoleLog T : " + TeacherName);
			System.out.println("ConsoleLog L : " + LocationName);
			System.out.println("---------------END-----------------");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

	}
}
