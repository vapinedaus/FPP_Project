package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import ORM.CustomersObject;
import ORM.RentalHistoryObject;
import UtilityClass.ConnectionFactory;
import UtilityClass.DbUtil;

public class RentalHistoryDAO {
	private Connection connection;
    private Statement st;
    
    public void insert(int customrId, int movieId ){
       Date borrowedDate= new Date();
       Date returnDate =null;
       
       Calendar cal = Calendar.getInstance();
       cal.setTime(borrowedDate);
       cal.add(Calendar.DATE, 1); 
       Date expectedReturnDate = cal.getTime();
       
    	String query = "INSERT INTO RentalHistory(Customer_ID,Movie_ID,BorrowedDate,ReturnDate,ExpectedReturnDate) VALUES (?,?,?,?,?)"; //" + customrId + "," + movieId + "," + borrowedDate + "," + returnDate + "," + expectedReturnDate + ")";              
    	try {
   		 		
   		 connection = ConnectionFactory.getConnection();
	     PreparedStatement stmt = connection.prepareStatement(query);
         stmt.setInt( 1, customrId ); 
         stmt.setInt( 2, movieId );
         
         java.sql.Date borrow = new java.sql.Date(borrowedDate.getTime());
         java.sql.Date returnD = new java.sql.Date(returnDate.getTime());
         java.sql.Date expected = new java.sql.Date(expectedReturnDate.getTime());
        
         stmt.setDate(3, borrow);
         stmt.setDate(4, returnD);
         stmt.setDate(5, expected);
         
         stmt.executeUpdate();
   		 		 	
           // st = connection.createStatement();
			//st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
           DbUtil.close(st);
           DbUtil.close(connection);          
       }
    }
    
    @SuppressWarnings({ "finally", "resource" })
	public RentalHistoryObject [] search(int id){
    	  String query = "SELECT * FROM RentalHistory WHERE Customer_ID=" + id + " AND ReturnDate =" + null + " "; 
    	  String count = "SELECT COUNT(*) FROM RentalHistory WHERE Customer_ID=" + id + " AND ReturnDate IS NULL"; 
          ResultSet rs = null;
          int rowcount = 0;
          RentalHistoryObject temp;// = new RentalHistoryObject();
          RentalHistoryObject [] rent = null;//new RentalHistoryObject() ;
          
          try {
              connection = ConnectionFactory.getConnection();
              st = connection.createStatement();
              rs = st.executeQuery(count);      
             
              // get the number of rows from the result set
              rs.next();
              rowcount = rs.getInt(1);    
              
              rs = st.executeQuery(query);
              if (rs != null){
            	 rent = new RentalHistoryObject[rowcount];
            	 for(int i =0; i < rowcount;i++){
            		 temp = new RentalHistoryObject();
            		 temp.setCustomer_ID(rs.getInt(0));
            		 temp.setMovie_ID(rs.getInt(1));
            		 temp.setBorrowedDate(rs.getDate(2));
               	  	 temp.setReturnDate(rs.getDate(3));
               	  	 temp.setExpectedReturnDate(rs.getDate(4));
               	  	 rent[i] = temp;
            	 }
              }
              }finally {
              DbUtil.close(rs);
              DbUtil.close(st);
              DbUtil.close(connection);
              return rent;
          }
    }
    
    public void upadte(int customerId, int movieId, Date returndate){
    	String query = "UPDATE RentalHistory SET ReturnDate=" + returndate + "' WHERE Movie_ID=" + movieId + " AND Customer_ID=" + customerId + " ";
    	try {
   		 	connection = ConnectionFactory.getConnection();
            st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
           DbUtil.close(st);
           DbUtil.close(connection);          
       }
    	
    }
}
