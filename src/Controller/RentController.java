package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import Model.*;
import ORM.RentalHistoryObject;

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
	
	public String returnMovie(int customerId, int movieId) throws SQLException
	{
		RentalHistoryDAO obj = new RentalHistoryDAO();
		obj.upadte(customerId, movieId);
		
		RentalHistoryObject rs =  obj.select(customerId, movieId);
		Date returnD =rs.getReturnDate();
		Date expectedD = rs.getExpectedReturnDate();
		
		

		
		if((returnD.getTime() >expectedD.getTime()))
		{
			@SuppressWarnings("deprecation")
			int diff = returnD.getDay() - expectedD.getDay();
			
			return " Pay the penalty of $"+ Math.abs(diff)+".";
		}
		else
			return "Return is successful";
		
	}
}
