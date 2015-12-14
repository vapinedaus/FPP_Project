package Controller;

import java.sql.ResultSet;

import Model.*;

public class RentController {

	public ResultSet rent(String text)
	{
		RentDAO obj = new RentDAO();
		ResultSet rs =obj.rentMovie(text);
		return rs;
	}
	
	public void book(int customerid, int movieid) // rent
	{
		RentalHistoryDAO obj = new RentalHistoryDAO();
		obj.insert(customerid, movieid);// borrowedDate, returnDate, expectedReturnDate);
	}
}
