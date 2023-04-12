package Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Customer.CustomerAdd;
import Customer.CustomerDelete;
import Customer.CustomerEdit;
import Memberlist.MemberAdd;
import Memberlist.MemberDelete;
import Memberlist.MemberEdit;
import Memberlist.MemberView;
import Pan.PanAdd;
import Pan.PanDelete;
import Pan.PanEdit;
import Procurement.CheckOrder;
import Procurement.Order;
import Report.OrderReport;
import Report.SalesReport;


public class Menu extends JFrame  implements ActionListener {

	public final static int FRAME_WIDTH = 684;
	final public static int FRAME_HEIGHT = 486;

	static final String HOME_STR = "Home";

	private static final String MBString = "ผู้รับธรรมะ";
	private static final String SupplierString = "Supplier";
	private static final String ProcurementString = "Procurement";
	private static final String CustomerString = "Customer";

	private static final String EXIT_STR = "Exit";

	private static final String MB_ADD_STR = "เพิ่มผู้รับธรรมะ";
	private static final String MB_EDIT_STR = "แก้ไขผู้รับธรรมะ";
	private static final String MB_DELETE_STR = "ลบผู้รับธรรมะ";
	private static final String MB_VIEW_STR = "แสดงผู้รับธรรมะ";

	private static final String Supplier_ADD_STR = "ADD Supplier";
	private static final String Supplier_EDIT_STR = "Edit Supplier";
	private static final String Supplier_DELETE_STR = "Delete Supplier";

	private static final String Procurement_ORDER_STR = "Order ";
	private static final String Procurement_CKORDER_STR = "Check Order ";

	private static final String Customer_ADD_STR = "ADD Customer";
	private static final String Customer_EDIT_STR = "Edit Customer";
	private static final String Customer_DELETE_STR = "Delete Customer";
	
	private static final String REPORT_STR = "Reports";
	private static final String Sales_STR = "Sales Report";
	private static final String Order_STR = "Order Report";

	private static final String CATLV1_ADD_STR = "ADD Catagory Lv.1";
	private static final String CATLV1_EDIT_STR = "Edit Catagory Lv.1";
	private static final String CATLV1_DELETE_STR = "Delete Catagory Lv.1";

	private static final String CATLV2_ADD_STR = "ADD Catagory Lv.2";
	private static final String CATLV2_EDIT_STR = "Edit Catagory Lv.2";
	private static final String CATLV2_DELETE_STR = "Delete Catagory Lv.2";

	private static final String CATLV3_ADD_STR = "ADD Catagory Lv.3";
	private static final String CATLV3_EDIT_STR = "Edit Catagory Lv.3";
	private static final String CATLV3_DELETE_STR = "Delete Catagory Lv.3";

	Main mainmenu;
	JPanel mainPanel;

	Home home;
	SalesReport salesRe;
	OrderReport orderRe;

	MemberAdd memberadd;
	MemberDelete memberdelete;
	MemberEdit memberedit;
	MemberView memberview;
	
	
	PanAdd supplieradd;
	PanDelete supplierdelete;
	PanEdit supplieredit;

	CustomerAdd customeradd;
	CustomerDelete customerdelete;
	CustomerEdit customeredit;

	Order order;
	CheckOrder ckorder;

	public Menu(Main main) {
		super("REG QunYing");
		setBackground(Color.WHITE);
		setSize(1366, 768);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width - FRAME_WIDTH) / 2, (screenDim.height - FRAME_HEIGHT) / 2);
//		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//	    setSize(ge.getMaximumWindowBounds().width, ge.getMaximumWindowBounds().height);
	    setLayout(new BorderLayout());
	    
		JMenu file, menu, submenu, goods, clv1, clv2, clv3,Report;
		JMenuItem ihome, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20,
				iexit,salesre,orderre;
		JMenuBar mb = new JMenuBar();

		setJMenuBar(mb);
		file = new JMenu("File");
		ihome = new JMenuItem(HOME_STR);
		iexit = new JMenuItem(EXIT_STR);
		file.add(ihome);
		file.add(iexit);
		
		Report = new JMenu(REPORT_STR);
		orderre = new JMenuItem(Order_STR);
		salesre = new JMenuItem(Sales_STR);
		Report.add(salesre);
		Report.add(orderre);
		
		
		
		
		
		menu = new JMenu(MBString);
		menu.setFont(new Font("Angsana New", Font.BOLD, 20));
		i1 = new JMenuItem(MB_ADD_STR);
		i1.setFont(new Font("Angsana New", Font.BOLD, 20));
		i2 = new JMenuItem(MB_EDIT_STR);
		i2.setFont(new Font("Angsana New", Font.BOLD, 20));
		i3 = new JMenuItem(MB_DELETE_STR);
		i3.setFont(new Font("Angsana New", Font.BOLD, 20));
		i4 = new JMenuItem(MB_VIEW_STR);
		i4.setFont(new Font("Angsana New", Font.BOLD, 20));

		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);


		ihome.addActionListener(this);
		iexit.addActionListener(this);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);

		mb.add(file);
		mb.add(menu);
		mb.add(Report);

		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(Color.WHITE);
		getContentPane().add(mainPanel);
		
		home = new Home(mainmenu);
		mainPanel.add(home, HOME_STR);

		
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

	public void actionPerformed(ActionEvent evt) {

		String command = evt.getActionCommand();
		System.out.println("command:" + command);
//		Object source = evt.getSource();
		CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
		

		

		if(command.equals(HOME_STR)) {

			home = new Home(mainmenu);
			mainPanel.add(home, HOME_STR);
			cardLayout.show(mainPanel, HOME_STR);
			
			//-----------------Goods---------------------//
		} else if(command.equals(MB_ADD_STR)) {
			memberadd = new MemberAdd(mainmenu);
			getContentPane().add(memberadd);
			mainPanel.add(memberadd, MB_ADD_STR);
			cardLayout.show(mainPanel, MB_ADD_STR);
			
			
		} else if(command.equals(MB_DELETE_STR)) {
			memberdelete = new MemberDelete(mainmenu);
			mainPanel.add(memberdelete, MB_DELETE_STR);
			cardLayout.show(mainPanel, MB_DELETE_STR);

		
			
		}else if(command.equals(MB_EDIT_STR)) {
			memberedit = new MemberEdit(mainmenu);
			mainPanel.add(memberedit, MB_EDIT_STR);
			cardLayout.show(mainPanel, MB_EDIT_STR);
			
		}else if(command.equals(MB_EDIT_STR)) {
			memberedit = new MemberEdit(mainmenu);
			mainPanel.add(memberedit, MB_EDIT_STR);
			cardLayout.show(mainPanel, MB_EDIT_STR);

			//------------------Supplier--------------------//
			

		} else if(command.equals(Supplier_ADD_STR)) {
			supplieradd = new PanAdd(mainmenu);
			mainPanel.add(supplieradd, Supplier_ADD_STR);
			cardLayout.show(mainPanel, Supplier_ADD_STR);
		}else if(command.equals(Supplier_DELETE_STR)) {
			supplierdelete = new PanDelete(mainmenu);
			mainPanel.add(supplierdelete, Supplier_DELETE_STR);
			cardLayout.show(mainPanel, Supplier_DELETE_STR);
		}else if(command.equals(Supplier_EDIT_STR)) {
			supplieredit = new PanEdit(mainmenu);
			mainPanel.add(supplieredit, Supplier_EDIT_STR);
			cardLayout.show(mainPanel, Supplier_EDIT_STR);
			//------------------Customer--------------------//
		}else if(command.equals(Customer_ADD_STR)) {
			customeradd = new CustomerAdd(mainmenu);
			mainPanel.add(customeradd, Customer_ADD_STR);
			cardLayout.show(mainPanel, Customer_ADD_STR);

		}else if(command.equals(Customer_DELETE_STR)) {
			customerdelete = new CustomerDelete(mainmenu);
			mainPanel.add(customerdelete, Customer_DELETE_STR);
			cardLayout.show(mainPanel, Customer_DELETE_STR);
		}else if(command.equals(Customer_EDIT_STR)) {
			customeredit = new CustomerEdit(mainmenu);
			mainPanel.add(customeredit, Customer_EDIT_STR);
			cardLayout.show(mainPanel, Customer_EDIT_STR);
			//----------------Procurement----------------------//
		}else if(command.equals(Procurement_ORDER_STR)) {
			order = new Order(mainmenu);
			mainPanel.add(order, Procurement_ORDER_STR);
			cardLayout.show(mainPanel, Procurement_ORDER_STR);
		}else if(command.equals(Procurement_CKORDER_STR)) {
			ckorder = new CheckOrder(mainmenu);
			mainPanel.add(ckorder, Procurement_CKORDER_STR);
			cardLayout.show(mainPanel, Procurement_CKORDER_STR);
			//----------------Report----------------------//
		}else if(command.equals(Sales_STR)) {
			salesRe = new SalesReport(mainmenu);
			mainPanel.add(salesRe, Sales_STR);
			cardLayout.show(mainPanel, Sales_STR);
		}else if(command.equals(Order_STR)) {
			orderRe = new OrderReport(mainmenu);
			mainPanel.add(orderRe, Order_STR);
			cardLayout.show(mainPanel, Order_STR);
			//----------------EXIT----------------------//
			
			
		}else if(command.equals(EXIT_STR)) {
			System.exit(0);
		}else {
			System.err.println("Not Command");
		}
		

	}
}
