package Controller;

import ORM.CustomersObject;
import ORM.RentalHistoryObject;
import java.sql.SQLException;


public class MainViewController {
	
	public MainViewController()
	{
		
	}
	
	public CustomersObject getCustomerDetails(String custName)
	{
		CustomersObject custObj = new CustomersObject();
		
		return custObj;
	}
	
	public RentalHistoryObject[] getRentalHistory(int custID)
	{
		RentalHistoryObject[] rentHistArr = new RentalHistoryObject[10];
		
		return rentHistArr;
	}

}
