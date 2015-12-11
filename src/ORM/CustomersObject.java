package ORM;

public class CustomersObject {

	private  int Customer_ID;
	private  String Name;
	private String Contact;
	private boolean Member;	
	
	
	public CustomersObject() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getContact() {
		return Contact;
	}


	public void setContact(String contact) {
		Contact = contact;
	}


	public boolean isMember() {
		return Member;
	}


	public void setMember(boolean member) {
		Member = member;
	}


	public int getCustomer_ID() {
		return Customer_ID;
	}

	
	
}
