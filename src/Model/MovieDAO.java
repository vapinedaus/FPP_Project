package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ORM.CustomersObject;
import ORM.MoviesObject;
import UtilityClass.ConnectionFactory;
import UtilityClass.DbUtil;
public class MovieDAO {
	private Connection connection;
    private Statement st;
    
    @SuppressWarnings("finally")
	public MoviesObject search(int id){
    	  String query = "SELECT * FROM Movies WHERE Movie_ID='" + id + "'";
          ResultSet rs = null;
          MoviesObject movie = new MoviesObject() ;
                 
        	 try {        		 
        		 connection = ConnectionFactory.getConnection();
                 st = connection.createStatement();
                 rs = st.executeQuery(query);
                 if(rs != null){
                	 movie.setMovie_ID(rs.getInt(0));
    				 movie.setMovieName(rs.getString(1));
    	        	 movie.setGenre(rs.getString(2));
    	        	 movie.setRentalPrice(rs.getDouble(3));
                 }		 			
			}finally {
	              DbUtil.close(rs);
	              DbUtil.close(st);
	              DbUtil.close(connection);
	              return movie;
	          }
        	 
     }
    
    @SuppressWarnings("finally")
	public MoviesObject searchByName(String name){
    	  String query = "SELECT * FROM Movies WHERE MovieName='" + name + "'";
          ResultSet rs = null;
          MoviesObject movie = new MoviesObject() ;
                 
        	 try {        		 
        		 connection = ConnectionFactory.getConnection();
                 st = connection.createStatement();
                 rs = st.executeQuery(query);
                 if(rs != null){
                	 movie.setMovie_ID(rs.getInt(0));
    				 movie.setMovieName(rs.getString(1));
    	        	 movie.setGenre(rs.getString(2));
    	        	 movie.setRentalPrice(rs.getDouble(3));
                 }		 			
			}finally {
	              DbUtil.close(rs);
	              DbUtil.close(st);
	              DbUtil.close(connection);
	              return movie;
	          }
        	 
     }
    
    public void insert(int id, String moviename, String genre, double rentalprice){
    	String query = "INSERT INTO Movies VALUES (" + id + "," + moviename + "," + genre + "," + rentalprice + ")";
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


