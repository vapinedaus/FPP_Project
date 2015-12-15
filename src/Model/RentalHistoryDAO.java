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
         //java.sql.Date returnD = new java.sql.Date(null);
         java.sql.Date expected = new java.sql.Date(expectedReturnDate.getTime());
        
         stmt.setDate(3, borrow);
         stmt.setDate(4, null);
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
	public ResultSet search(int id){
    	  String query = "SELECT * FROM RentalHistory WHERE Customer_ID=" + id + " AND ReturnDate IS NULL"; 
    	//  String count = "SELECT COUNT(*) FROM RentalHistory WHERE Customer_ID=" + id + " AND ReturnDate IS NULL"; 
          ResultSet rs = null;
          int rowcount = 0;
          RentalHistoryObject temp;// = new RentalHistoryObject();
          RentalHistoryObject [] rent = null;//new RentalHistoryObject() ;

          connection = ConnectionFactory.getConnection();
              try {
				st = connection.createStatement();
	            rs = st.executeQuery(query);
	           // rs.next();
		        return rs;

              } 
              catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
              }
              finally {
             // DbUtil.close(rs);
              //DbUtil.close(st);
              //DbUtil.close(connection);

          }
          return null;
    }
    
    public void upadte(int customerId, int movieId){
        Date returndate = new Date();
        java.sql.Date returnD = new java.sql.Date(returndate.getTime());
    	String query = "UPDATE RentalHistory SET ReturnDate= '" + returnD + "' WHERE Movie_ID= " + movieId + " AND Customer_ID= " + customerId ;
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
    
    public RentalHistoryObject select(int customerId, int movieId)
    {
    	String query = "select * from RentalHistory where Customer_ID="+customerId+" and Movie_ID="+movieId;
    	try {
   		 	connection = ConnectionFactory.getConnection();
   		 st = connection.createStatement();
   		ResultSet rs = st.executeQuery(query); 
 
         RentalHistoryObject rhObject = new RentalHistoryObject();
		
	    if (rs != null) {
            while (rs.next()) {
            	rhObject.setReturnDate(rs.getDate("ReturnDate"));
            	rhObject.setExpectedReturnDate(rs.getDate("ExpectedReturnDate"));
            }
         }
   		
		return rhObject;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
           DbUtil.close(st);
           DbUtil.close(connection);          
       }
    	
    	return null;
    }
}
