package Memberlist;

public class Member {
	public String mid;
	public String firstname;
	public String surname;
	public int age;
	public String b_date;
	public String gender;
	public String phone;
	public String edu;
	public String job;
	public String address;
	public String a_date;
	public String teacher_rc;
	public String teacher_cf;
	public String teacher;
	public String location;
	
	
	
	

	public Member(String mid,String firstname,String surname,int age, String b_date,String gender,String phone,String edu,String job,String address,String a_date,String teacher_rc	,String teacher_cf	,String teacher,String location) {
		this.mid=mid;
		this.firstname=firstname;
		this.surname=surname;
		this.age=age;
		this.b_date=b_date;
		this.gender=gender;
		this. phone= phone;
		this.edu=edu;
		this.job=job;
		this.address=address;
		this.a_date=a_date;
		this.teacher_rc=teacher_rc;
		this.teacher_cf=teacher_cf;
		this.teacher=teacher;
		this.location=location;
		
	
	}



	public String getid() {
		return mid;
	}
	public String getfirstname() {
		return firstname;
	}
	public String getsurname() {
		return surname;
	}
	public int getage() {
		return age;
	}
	public String getb_date() {
		return b_date;
	}
	public String getgender() {
		return gender;
	}
	public String getphone() {
		return phone;
	}
	public String getedu() {
		return edu;
	}
	public String getjob() {
		return job;
	}
	public String getaddess() {
		return address;
	}
	public String geta_date() {
		return a_date;
	}
	public String getteacher_rc() {
		return teacher_rc;
	}
	public String getteacher_cf() {
		return teacher_cf;
	}
	public String getteacher() {
		return teacher;
	}
	public String getlocation() {
		return location;
	}
	
	
}
