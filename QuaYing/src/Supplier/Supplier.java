package Supplier;

public class Supplier {
	public int id;
	public String name;
	public String address;
	public String province;
	public String phone;
	public Supplier(int id, String name, String address, String province, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.province = province;
		this.phone = phone;
	}
	public String toString() {
		return "id:" + id +", name:" + name +", address:" + address +", province:" + province +", phone:" + phone;
	}
}
