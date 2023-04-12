package Supplier;

public class ProvinceCont {

	public String hr;
	public String name;


	public ProvinceCont (String name ,String hr) {
		this.hr = hr;
		this.name = name;

	}

	public String toString() {
		return name;
	}
	public String getid() {
		return hr;
	}
}
