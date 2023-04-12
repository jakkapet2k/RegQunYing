package Memberlist;

public class Item {
	public String id;
	public String name;


	public Item (String name ,String id) {
		this.id = id;
		this.name = name;

	}


	public String toString() {
		return name;
	}
	public String getid() {
		return id;
	}
}

