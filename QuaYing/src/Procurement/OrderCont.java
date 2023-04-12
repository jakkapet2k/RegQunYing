package Procurement;

import java.time.LocalTime;

public class OrderCont {
	public int idgoods;
	public int supplier;
	public int gid;
	public int quantity;
	public String orderdate;
	public String ordertime;
	public OrderCont(int idgoods, int supplier, int gid, int quantity, String orderdate,String ordertime) {
		this.idgoods = idgoods;
		this.supplier = supplier;
		this.gid = gid;
		this.quantity = quantity;
		this.orderdate = orderdate;
		this.ordertime=ordertime;
	}
	public String toString() {
		return "id:" + idgoods +", supplier:" + supplier +", gid:" + gid +", quantity:" + quantity +", orderdate:" + orderdate+", ordertime:"+ordertime;
	}
}
