package ORM;

import java.util.*;

public class RentalHistoryObject {

	private int Customer_ID;
	private int Movie_ID;
	private Date BorrowedDate;
	private Date ReturnDate;
	private Date ExpectedReturnDate;
	private String MovieName;
	
	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public RentalHistoryObject() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public int getMovie_ID() {
		return Movie_ID;
	}

	public void setMovie_ID(int movie_ID) {
		Movie_ID = movie_ID;
	}

	public Date getBorrowedDate() {
		return BorrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		BorrowedDate = borrowedDate;
	}

	public Date getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}

	public Date getExpectedReturnDate() {
		return ExpectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		ExpectedReturnDate = expectedReturnDate;
	}

	
}
