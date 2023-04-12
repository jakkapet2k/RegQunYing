package Procurement;

public class SupCon {
	public int id;
	public String name;


	public SupCon (String name ,int id) {
		this.id = id;
		this.name = name;

	}

	public String toString() {
		return name;
	}
	public int getid() {
		return id;
	}
}

