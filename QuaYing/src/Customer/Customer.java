package Customer;

public class Customer {
	public int id;
	public String user;
	public String pass;
	public Customer(int id, String user, String pass) {
		this.id = id;
		this.user = user;
		this.pass = pass;;
	}
	public String toString() {
		return "id:" + id +", user:" + user +", pass:" + pass;
	}
}
