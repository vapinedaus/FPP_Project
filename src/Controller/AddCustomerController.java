package Controller;

import Model.CustomerDAO;

public class AddCustomerController {

	public boolean add(String name,String contact,boolean member)
	{
		CustomerDAO obj = new CustomerDAO();
		return obj.insert(name,contact,member);
	}
}
