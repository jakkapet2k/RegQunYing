package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Customer.Customer;
import Memberlist.Member;
import Memberlist.Item;
import Procurement.Check;
import Procurement.OrderCont;
import Procurement.SupCon;

public class DAO {

	// -------------------------------------------------Goods-------------------------------------------------------------------//
	public static void addmember(Member m) {
	
		try {
			String insertSql = "INSERT INTO memberlist  (firstname,surname,age,b_date,gender,phone,edu,job,address,a_date,teacher_rc,teacher_cf	,teacher,location)  VALUES" + "('"+m.firstname+"','"+m.surname+"','"+m.age+"','"+m.b_date+"','"+m.gender+"','"+m.phone+"','"+m.edu+"','"+m.job+"','"+m.address+"','"+m.a_date+"','"+m.teacher_rc+"','"+m.teacher_cf+"','"+m.teacher+"','"+m.location+"')";
			System.out.println("insertSql:" + insertSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Goods added successfully.");
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	
	public static void EditMember(Member m) {
		
		try {
			String EditSql = "UPDATE memberlist SET  firstname='"+m.firstname+"',surname='"+m.surname+"',age='"+m.age+"',b_date='"+m.b_date+"',gender='"+m.gender+"',phone='"+m.phone+"',edu='"+m.edu+"',job='"+m.job+"',address='"+m.address+"',a_date='"+m.a_date+"',teacher_rc='"+m.teacher_rc+"',teacher_cf='"+m.teacher_cf+"',teacher='"+m.teacher+"',location='"+m.location+"' WHERE mid = '"+m.mid+"'";
			System.out.println("insertSql:" + EditSql);
			
			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			 
			 
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(EditSql);
				stmnt.close();
				con.close();
				System.out.println("Member Edited successfully.");
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void DeleteMember(Member m) {
		
		try {
			String deleteSql = "DELETE FROM memberlist WHERE mid='" + m.mid+"'";
			System.out.println("deleteSql:" + deleteSql);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			 
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Goods Deleted successfully.");
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	

	public static void showTableMemberlist(DefaultTableModel tableModel) {

		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "SELECT * FROM memberlist";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				
				String mid = rs.getString("mid");
				String fname = rs.getString("firstname");
				String sname = rs.getString("surname");
				String age = rs.getString("age");
				String bddate = rs.getString("b_date");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String edu = rs.getString("edu");
				String job = rs.getString("job");
				String address = rs.getString("address");
				String adate = rs.getString("a_date");
				String trc = rs.getString("teacher_rc");
				String tcf = rs.getString("teacher_cf");
				String teacher = rs.getString("teacher");
				String location = rs.getString("location");

				Object[] row = { mid, fname, sname, age, bddate, gender,phone,edu,job,address,adate,trc,tcf,teacher,location };

				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}
	
	


//	// -------------------------------------------------EndGoods-------------------------------------------------------------------//
//	// -------------------------------------------------Supplier-------------------------------------------------------------------//
//	public static void addSupplier(Pan sp) {
//
//		try {
//			String insertSql = "INSERT INTO supplier  (sup, addr, pv, phone)  VALUES" + "('" + sp.name + "','" + sp.address + "','" + sp.province+ "','" + sp.phone+"')";
//			System.out.println("insertSql:" + insertSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(insertSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Supplier added successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//public static void EditSupplier(Pan sp) {
//		
//		try {
//			String EditSql = "UPDATE supplier SET  sup='"+sp.name+"' ,addr= '"+sp.address+"',pv='"+sp.province+"',phone='"+sp.phone+"' WHERE id = '"+sp.id+"'";
//			System.out.println("insertSql:" + EditSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(EditSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Supplier Edited successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//
//
//public static void DeleteSupplier(Pan sp) {
//
//	try {
//		String deleteSql = "DELETE FROM supplier WHERE id=" + sp.id;
//		System.out.println("deleteSql:" + deleteSql);
//
//		ConnMariaDB connDB = new ConnMariaDB();
//		Connection con = connDB.getConnection();
//		 
//		Statement stmnt = null;
//		if (con != null) {
//			stmnt = con.createStatement();
//			stmnt.execute(deleteSql);
//			stmnt.close();
//			con.close();
//			System.out.println("Supplier Deleted successfully.");
//		}
//	} catch (Exception e) {
//		System.err.println("Got an exception! ");
//		System.err.println(e.getMessage());
//	}
//}
//	
//	
//	
//	public static void showTableSupplier(DefaultTableModel tableModel) {
//
//		try {
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();;
//			 
//
//			String query = "SELECT * FROM Supplier";
//
//			Statement st = con.createStatement();
//
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				String id = rs.getString("id");
//				String sup = rs.getString("sup");
//				String addr = rs.getString("addr");
//				String pv = rs.getString("pv");
//				String phone = rs.getString("phone");
//
//
////				System.out.format("%s, %s, %s, %s, %s\n", id, sup, addr, pv, phone);
//
//				Object[] row = { id, sup, addr, pv, phone };
//
//				tableModel.addRow(row);
//			}
//			st.close();
//			rs.close();
//			con.close();
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	
//
//
//	
//	
//	
//	// -------------------------------------------------ENDSupplier-------------------------------------------------------------------//
//	// -------------------------------------------------Procurement-------------------------------------------------------------------//
//	
//	public static void addOrder(OrderCont order) {
//
//		try {
//			String insertSql = "INSERT INTO pcm (supid,gid,qty,ordate,ortime,rcdate,rctime) VALUES ("+order.supplier+","+order.gid+","+order.quantity+",'"+order.orderdate+"','"+order.ordertime+"','Not Date!!','00:00:00')";
//			System.out.println("insertSql:" + insertSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(insertSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Order added successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//	public static void AcceptOrder(Check order) {
////		System.err.println("rcdate : "+order.receivedate+" id : "+order.id);
//		try {
//			String EditSql = "UPDATE pcm SET rcdate='"+order.receivedate+"',rctime = '"+order.rctime+"' WHERE id ="+order.id;
//			String addorder = "UPDATE goods,pcm SET goods.stocks =goods.stocks + pcm.qty WHERE goods.id = pcm.gid AND pcm.id = "+order.id;
//			System.out.println("insertSql:" + EditSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();;
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(EditSql);
//				stmnt.execute(addorder);
//				stmnt.close();
//				con.close();
//				System.out.println("AcceptOrder Edited successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//	public static void showTableOrder(DefaultTableModel tableModel) {
//
//		try {
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			String query = "SELECT pcm.id,supplier.sup,goods.name,qty,ordate,ortime,rcdate FROM pcm INNER JOIN supplier ON supplier.id= pcm.supid INNER JOIN goods ON goods.id= pcm.gid ORDER BY pcm.id ASC";
//
//			Statement st = con.createStatement();
//
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				String id = rs.getString("id");
//				String sup = rs.getString("sup");
//				String goods = rs.getString("name");
//				String qty = rs.getString("qty");
//				String ordate = rs.getString("ordate");
//				String ortime = rs.getString("ortime");
//
//
//
////				System.out.format("%s, %s, %s, %s ,%s\n", id, sup, goods, qty, ordate);
//
//				Object[] row = { id, sup, goods,qty,ordate,ortime };
//
//				tableModel.addRow(row);
//			}
//			st.close();
//			rs.close();
//			con.close();
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	public static void showTableCheckOrder(DefaultTableModel tableModel) {
//
//		try {
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();;
//
//			String query = "SELECT pcm.id,supplier.sup,goods.name,qty,ordate,rcdate ,rctime FROM pcm INNER JOIN supplier ON supplier.id= pcm.supid INNER JOIN goods ON goods.id= pcm.gid ORDER BY pcm.rcdate DESC";
//
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				String id = rs.getString("id");
//				String sup = rs.getString("sup");
//				String goods = rs.getString("name");
//				String qty = rs.getString("qty");
//				String ordate = rs.getString("ordate");
//				String rcdate = rs.getString("rcdate");
//				String rctime = rs.getString("rctime");
//
//				System.out.format("%s, %s, %s, %s ,%s,%s\n", id, sup, goods, qty, ordate ,rcdate,rctime);
// 
//				Object[] row = { id, sup, goods,qty,ordate,rcdate,rctime };
//
//				tableModel.addRow(row);
//			}
//			st.close();
//			rs.close();
//			con.close();
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	
//	
//	
//	
//	
//
//	
//	
//	
//	// -------------------------------------------------ENDProcurement-------------------------------------------------------------------//
//	// -------------------------------------------------Customer-------------------------------------------------------------------//
//	
//
//	public static void addCustomer(Customer cust) {
//		
//
//		try {
//			String insertSql = "INSERT INTO customer (username,password) VALUES ('"+cust.user+"','"+cust.pass+"')";
//			System.out.println("insertSql:" + insertSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(insertSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Customer added successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//
//	public static void EditCustomer(Customer cust) {
//		
//		try {
//			String EditSql = "UPDATE customer SET  username='"+cust.user+"',password= '"+cust.pass+"' WHERE id = "+cust.id;
//			System.out.println("insertSql:" + EditSql);
//			
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(EditSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Customer Edited successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//	
//	public static void DeleteCustomer(Customer cust) {
//		
//		try {
//			String deleteSql = "DELETE FROM customer WHERE id=" + cust.id;
//			System.out.println("deleteSql:" + deleteSql);
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.execute(deleteSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Customer Deleted successfully.");
//			}
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//	}
//	
//	
//	
//	public static void showTableCustomer(DefaultTableModel tableModel) {
//
//		try {
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 
//
//			String query = "SELECT * FROM customer";
//
//			Statement st = con.createStatement();
//
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				String id = rs.getString("id");
//				String user = rs.getString("username");
//				String pass = rs.getString("password");
//
//
//
////				System.out.format("%s, %s, %s, %s, %s\n", id, sup, addr, pv, phone);
//
//				Object[] row = { id, user, pass };
//
//				tableModel.addRow(row);
//			}
//			st.close();
//			rs.close();
//			con.close();
//		} catch (Exception e) {
//			System.err.println("Got an exception! ");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	// -------------------------------------------------ENDCustomer-------------------------------------------------------------------//
	// -------------------------------------------------OTHER Functions-------------------------------------------------------------------//
	
	public static void ComboBoxLocation(JComboBox<Item> comboBox) {
		try {


			 String query ="SELECT l_name,lid FROM location ";
				ConnMariaDB connDB = new ConnMariaDB();
				Connection con = connDB.getConnection();;
			 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				Item item = new Item(rs.getString("l_name"), rs.getString("lid"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}
	public static void ComboBoxTeacher(JComboBox<Item> comboBox) {
		try {


			 String query ="SELECT t_name,tid FROM teacher";
				ConnMariaDB connDB = new ConnMariaDB();
				Connection con = connDB.getConnection();
			 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				Item item = new Item(rs.getString("t_name"), rs.getString("tid"));
				comboBox.addItem(item);
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}
	public static void ComboBoxGender(JComboBox<Item> comboBox) {
		try {

				ConnMariaDB connDB = new ConnMariaDB();
				Connection con = connDB.getConnection();
				String query ="SELECT * FROM gender ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				Item item = new Item(rs.getString("g_name"), rs.getString("gid"));
				comboBox.addItem(item);
				
//				System.err.print(rs.getString("g_name")+rs.getString("gid"));

//				System.err.print("Name : "+ rs.getString("g_name")+"GID : "+rs.getString("gid")+"\n");
			
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}
//
//	public static void ComboBoxOrderSup(JComboBox<SupCon> comboBox) {
//		try {
//
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 String query = "SELECT sup,id FROM supplier";
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				SupCon item = new SupCon(rs.getString(1), rs.getInt("id"));
//				comboBox.addItem(item);
//				
//			}
//
//			st.close();
//			rs.close();
//
//		} catch (Exception e) {
//			System.err.println("Got an exception!");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	
//	public static void ComboBoxOrderGid(JComboBox<SupCon> comboBox) {
//		try {
//
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 String query = "SELECT name,id FROM goods";
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				SupCon item = new SupCon(rs.getString(1), rs.getInt("id"));
//				comboBox.addItem(item);
//				
//			}
//
//			st.close();
//			rs.close();
//
//		} catch (Exception e) {
//			System.err.println("Got an exception!");
//			System.err.println(e.getMessage());
//		}
//
//	}
//	
//	public static void ComboBoxProvince(JComboBox<ProvinceCont> comboBox) {
//		try {
//
//
//			ConnMariaDB connDB = new ConnMariaDB();
//			Connection con = connDB.getConnection();
//			 String query = "SELECT hs,name FROM province";
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				ProvinceCont item = new ProvinceCont(rs.getString(2), rs.getString(1));
//				comboBox.addItem(item);
//				
//			}
//
//			st.close();
//			rs.close();
//
//		} catch (Exception e) {
//			System.err.println("Got an exception!");
//			System.err.println(e.getMessage());
//		}
//
//	}



	
	

	
	
	
	
	
	// -------------------------------------------------OTHER Functions-------------------------------------------------------------------//
	
	// -------------------------------------------------Report Functions-------------------------------------------------------------------//

	
	
	public static void showTableSales(DefaultTableModel tableModel) {

		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "SELECT trans.id,trans.ordate,trans.time,customer.username,goods.name,goods.unit_price,trans.qty,goods.unit_price*trans.qty AS total_price FROM trans LEFT JOIN customer ON trans.cid=customer.id LEFT JOIN goods ON trans.gid=goods.id";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String id = rs.getString("id");
				String ordate = rs.getString("ordate");
				String time = rs.getString("time");
				String cust = rs.getString("username");
				String name = rs.getString("name");
				String qty = rs.getString("qty");
				String tp = rs.getString("total_price");



//				System.out.format("%s, %s, %s, %s ,%s\n", id, sup, goods, qty, ordate);

				Object[] row = { id, ordate, time,cust,name,qty,tp };

				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}
	

	public static void showTableOrderReport(DefaultTableModel tableModel) {

		try {

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "SELECT pcm.id,ordate,ortime,supplier.sup,goods.name,goods.unit_price,qty, goods.unit_price*qty AS total_price  FROM pcm INNER JOIN supplier ON supplier.id= pcm.supid INNER JOIN goods ON goods.id= pcm.gid;";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String id = rs.getString("id");
				String ordate = rs.getString("ordate");
				String ortime = rs.getString("ortime");
				String sup = rs.getString("sup");
				String goods = rs.getString("name");
				String qty = rs.getString("qty");
				String tp = rs.getString("total_price");
				




//				System.out.format("%s, %s, %s, %s ,%s\n", id, sup, goods, qty, ordate);

				Object[] row = { id, sup, goods,qty,ordate,ortime,tp };

				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	
	}
	
	
	
	
	
}
