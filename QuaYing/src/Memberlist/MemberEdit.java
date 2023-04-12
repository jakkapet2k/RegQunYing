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

public class MemberEdit extends JPanel implements ActionListener {
	private static final String Refresh_STR = "รีเฟรช";
	private static final String cancelString = "ยกเลิก";
	private static final String EDIT_STR = "แก้ไข";

	private static JTable table;
	private JTextField firstnameField, SernameField, AgeField, bdField, eduField, jobField, phoneField, aDateField,
			trcField, tcfField;
	private TextArea textArea;
	private String GenderName, TeacherName, LocationName;
	Main main;
	JComboBox<Item> GenderCB, TeacherCB, LocatCB;
	Item g,t,l;;
	DefaultTableModel tableModel;;
	JLabel MidID;
	DAO dao = new DAO();

	public MemberEdit(Main main) {

		setBackground(SystemColor.activeCaption);
		setPreferredSize(new Dimension(1366, 768));

		setLayout(null);

		JLabel label = new JLabel("แก้ไขผู้รับธรรมะ");
		label.setFont(new Font("Angsana New", Font.BOLD, 32));
		label.setBounds(574, 11, label.getPreferredSize().width, label.getPreferredSize().height);
		add(label);

		JLabel lbPhone = new JLabel("เบอร์ติดต่อ");
		lbPhone.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbPhone.setBounds(31, 128, 77, 14);
		add(lbPhone);

		JLabel lbJob = new JLabel("อาชีพ");
		lbJob.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbJob.setBounds(587, 128, 63, 14);
		add(lbJob);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 289, 1323, 398);
		add(scrollPane);

		JLabel lbEdu = new JLabel("การศึกษา");
		lbEdu.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbEdu.setBounds(309, 125, 65, 20);
		add(lbEdu);

		JLabel lbAge = new JLabel("อายุ");
		lbAge.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbAge.setBounds(587, 79, 77, 23);
		add(lbAge);

		JLabel lbSername = new JLabel("สกุล");
		lbSername.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbSername.setBounds(309, 72, 43, 34);
		add(lbSername);

		JLabel lbName = new JLabel("ชื่อ");
		lbName.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbName.setBounds(31, 80, 43, 20);
		add(lbName);

		JLabel lbTRC = new JLabel("อ.แนะนำ");
		lbTRC.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbTRC.setBounds(309, 178, 65, 20);
		add(lbTRC);

		JLabel lbTCF = new JLabel("อ.รับรอง");
		lbTCF.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbTCF.setBounds(574, 178, 65, 20);
		add(lbTCF);

		JLabel lbTeacher = new JLabel("อ.ถ่ายทอด");
		lbTeacher.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbTeacher.setBounds(31, 229, 77, 20);
		add(lbTeacher);

		JLabel lbLocat = new JLabel("สถานธรรม");
		lbLocat.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbLocat.setBounds(309, 234, 77, 20);
		add(lbLocat);

		JLabel lbWarningDate = new JLabel("2566-06-15");
		lbWarningDate.setForeground(new Color(128, 0, 0));
		lbWarningDate.setFont(new Font("Angsana New", Font.BOLD, 26));
		lbWarningDate.setBounds(1221, 23, 98, 20);
		add(lbWarningDate);

		JLabel lbGender = new JLabel("เพศ");
		lbGender.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbGender.setBounds(831, 79, 77, 20);
		add(lbGender);

		JLabel lbBirthday = new JLabel("วันเกิด");
		lbBirthday.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbBirthday.setBounds(1070, 81, 63, 20);
		add(lbBirthday);

		JLabel lbwarning = new JLabel("คำเตือน : วันที่ใส่ แบบนี้เท่านั้น  :");
		lbwarning.setForeground(new Color(128, 0, 0));
		lbwarning.setFont(new Font("Angsana New", Font.BOLD, 22));
		lbwarning.setBounds(1007, 23, 204, 20);
		add(lbwarning);

		JLabel lbAddr = new JLabel("ที่อยู่");
		lbAddr.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbAddr.setBounds(832, 128, 43, 37);
		add(lbAddr);

		JLabel lbDateAc = new JLabel("วันรับธรรมะ");
		lbDateAc.setFont(new Font("Angsana New", Font.BOLD, 21));
		lbDateAc.setBounds(31, 178, 77, 20);
		add(lbDateAc);
		
		JLabel lblMid = new JLabel("MID :");
		lblMid.setFont(new Font("Angsana New", Font.BOLD, 21));
		lblMid.setBounds(31, 33, 43, 20);
		add(lblMid);
		
		MidID = new JLabel("MID");
		MidID.setFont(new Font("Angsana New", Font.BOLD, 21));
		MidID.setBounds(80, 33, 169, 20);
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
					String fname = tableModel.getValueAt(row, 1).toString();
					String sname = tableModel.getValueAt(row, 2).toString();
					String age = tableModel.getValueAt(row, 3).toString();
					String bddate = tableModel.getValueAt(row, 4).toString();
					String phone = tableModel.getValueAt(row, 6).toString();
					String edu = tableModel.getValueAt(row, 7).toString();
					String job = tableModel.getValueAt(row, 8).toString();
					String address = tableModel.getValueAt(row, 9).toString();
					String adate =tableModel.getValueAt(row,10 ).toString();
					String trc = tableModel.getValueAt(row, 11).toString();
					String tcf = tableModel.getValueAt(row, 12).toString();
					MidID.setText(mid);
					firstnameField.setText(fname);
					SernameField.setText(sname);
					AgeField.setText(age);
					bdField.setText(bddate);
					phoneField.setText(phone);
					eduField.setText(edu);
					jobField.setText(job);
					textArea.setText(address);
					 aDateField.setText(adate);
					 trcField.setText(trc);
					 tcfField.setText(tcf);
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

		firstnameField = new JTextField();
		firstnameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		firstnameField.setColumns(10);
		firstnameField.setBounds(118, 82, 165, 34);
		add(firstnameField);

		eduField = new JTextField();
		eduField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		eduField.setColumns(10);
		eduField.setBounds(384, 127, 165, 38);
		add(eduField);

		phoneField = new JTextField();
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneField.setBounds(118, 127, 165, 38);
		add(phoneField);

		SernameField = new JTextField();
		SernameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SernameField.setColumns(10);
		SernameField.setBounds(384, 82, 165, 34);
		add(SernameField);

		AgeField = new JTextField();
		AgeField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AgeField.setColumns(10);
		AgeField.setBounds(636, 82, 165, 34);
		add(AgeField);

		bdField = new JTextField();
		bdField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bdField.setColumns(10);
		bdField.setBounds(1141, 81, 165, 35);
		add(bdField);

		jobField = new JTextField();
		jobField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jobField.setColumns(10);
		jobField.setBounds(636, 127, 165, 38);
		add(jobField);

		aDateField = new JTextField();
		aDateField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		aDateField.setColumns(10);
		aDateField.setBounds(118, 180, 165, 39);
		add(aDateField);

		trcField = new JTextField();
		trcField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		trcField.setColumns(10);
		trcField.setBounds(384, 180, 165, 39);
		add(trcField);

		tcfField = new JTextField();
		tcfField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tcfField.setColumns(10);
		tcfField.setBounds(636, 180, 165, 39);
		add(tcfField);

		GenderCB = new JComboBox<>();
		GenderCB.setBackground(Color.WHITE);
		GenderCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GenderCB.setBounds(887, 80, 165, 36);
		add(GenderCB);

		DAO.ComboBoxGender(GenderCB);
		
		Item selected = (Item) GenderCB.getSelectedItem();
		GenderName = selected.toString();

		GenderCB.setSelectedIndex(-1);

		TeacherCB = new JComboBox<>();
		TeacherCB.setBackground(Color.WHITE);
		TeacherCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TeacherCB.setBounds(118, 230, 165, 37);
		add(TeacherCB);

		LocatCB = new JComboBox<>();
		LocatCB.setBackground(Color.WHITE);
		LocatCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LocatCB.setBounds(384, 230, 165, 37);
		add(LocatCB);

		textArea = new TextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textArea.setBounds(887, 127, 419, 140);
		add(textArea);

		JButton btnRefresh = new JButton(Refresh_STR);
		btnRefresh.setForeground(new Color(0, 191, 255));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(770, 235, 98, 23);
		add(btnRefresh);

		JButton BtnAdd = new JButton(EDIT_STR);
		BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		BtnAdd.setForeground(new Color(218, 165, 32));
		BtnAdd.setBounds(572, 235, 89, 23);
		add(BtnAdd);

		JButton btnCancle = new JButton(cancelString);
		btnCancle.setForeground(new Color(128, 0, 0));
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(671, 234, 89, 23);
		add(btnCancle);

		BtnAdd.addActionListener(this);
		btnCancle.addActionListener(this);
		btnRefresh.addActionListener(this);
		GenderCB.addActionListener(this);
		TeacherCB.addActionListener(this);
		LocatCB.addActionListener(this);
		

		


	}

	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		Object source = evt.getSource();

		try {

			if (source == GenderCB) {
				Item selected = (Item) GenderCB.getSelectedItem();
				GenderName = selected.toString();

				TeacherCB.removeAllItems();
				DAO.ComboBoxTeacher(TeacherCB);

			} else if (source == TeacherCB) {
				Item selected = (Item) TeacherCB.getSelectedItem();
				TeacherName = selected.toString();


				LocatCB.removeAllItems();
				DAO.ComboBoxLocation(LocatCB);
			} else if (source == LocatCB) {

				Item selectedMedel = (Item) LocatCB.getSelectedItem();
				LocationName = selectedMedel.toString();

			} else if (command.equals(EDIT_STR)) {
				System.out.println("actionCommand:" + EDIT_STR);
				try {
					String mid = MidID.getText();
					String fname = firstnameField.getText();
					String sname = SernameField.getText();
					int age = Integer.parseInt(AgeField.getText());
					String bddate = bdField.getText();
					String gender = GenderName;
					String phone = phoneField.getText();
					String edu = eduField.getText();
					String job = jobField.getText();
					String address = textArea.getText();
					String adate = aDateField.getText();
					String trc = trcField.getText();
					String tcf = tcfField.getText();
					String teacher = TeacherName;
					String location = LocationName;

					Member Edit = new Member(mid, fname, sname, age, bddate, gender, phone, edu, job, address, adate,
							trc, tcf, teacher, location);
					System.out.println("Member:" + Edit.toString());
					DAO.EditMember(Edit);
					
					MidID.setText(null);
					firstnameField.setText(null);
					SernameField.setText(null);
					AgeField.setText(null);
					bdField.setText(null);
					GenderCB.setSelectedIndex(-1);
					phoneField.setText(null);
					eduField.setText(null);
					jobField.setText(null);
					textArea.setText(null);
					aDateField.setText(null);
					trcField.setText(null);
					tcfField.setText(null);
					TeacherCB.setSelectedIndex(-1);
					LocatCB.setSelectedIndex(-1);

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

				firstnameField.setText(null);
				SernameField.setText(null);
				AgeField.setText(null);
				bdField.setText(null);
				GenderCB.setSelectedIndex(-1);
				phoneField.setText(null);
				eduField.setText(null);
				jobField.setText(null);
				textArea.setText(null);
				aDateField.setText(null);
				trcField.setText(null);
				tcfField.setText(null);
				TeacherCB.setSelectedIndex(-1);
				LocatCB.setSelectedIndex(-1);
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
