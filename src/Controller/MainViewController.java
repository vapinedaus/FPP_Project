package Controller;

import ORM.CustomersObject;
import ORM.RentalHistoryObject;
import Model.RentalHistoryDAO;
import Model.CustomerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MainViewController {
	
	
	
	public MainViewController()
	{
		
	}
	
	public CustomersObject getCustomerDetails(String custName)
	{
		CustomerDAO custDAO = new CustomerDAO();
		CustomersObject custObj = custDAO.search(custName);
		
		return custObj;
	}
	
	public ResultSet getRentalHistory(int custID)
	{
		RentalHistoryDAO rentHistDAO = new RentalHistoryDAO();
		ResultSet rentHistArr = rentHistDAO.search(custID);
		
		return rentHistArr;
	}
	

}
