package Procurement;

public class Check {
	public int id ;
	public String receivedate;
	public String rctime;
	public Check(	int id , String receivedate ,String rctime) {
		this.id = id;
		this.receivedate=receivedate;
		this.rctime=rctime;
	}
	
	public String toString() {
		return "id:" + id +", receivedate:" + receivedate+", rctime:"+rctime;
	}
}
