package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ORM.CustomersObject;
import UtilityClass.ConnectionFactory;
import UtilityClass.DbUtil;

public class CustomerDAO {
	
	private Connection connection;
    private Statement st;
    
    @SuppressWarnings("finally")
	public CustomersObject customer(int id){
    	  String query = "SELECT * FROM Customers WHERE Customer_ID='" + id + "'";
          ResultSet rs = null;
          CustomersObject cust = new CustomersObject() ;
    	
          try {
              connection = ConnectionFactory.getConnection();
              st = connection.createStatement();
              rs = st.executeQuery(query);
              
              if(rs != null){
            	  cust.setName(rs.getString(0));
            	  cust.setContact(rs.getString(1));
            	  cust.setMember(rs.getBoolean(2));
              }
          }finally {
              DbUtil.close(rs);
              DbUtil.close(st);
              DbUtil.close(connection);
              return cust;
          }
    }
    
    public boolean insert(String name, String contact, boolean member){
    	String query = "INSERT INTO Customers(Name,Contact,Member) VALUES(?,?,?)";  //(" + name + "," + contact + "," + member + ")";
    	try {
    		 connection = ConnectionFactory.getConnection();
    	      PreparedStatement stmt = connection.prepareStatement(query);
              stmt.setString( 1, name ); //nameText variable contains the text of the jtextfield)
              stmt.setString( 2, contact );//phoneText variable contains the text of the jtextfield)
              stmt.setBoolean(3, member );//emailText  variable contains the text of the jtextfield)
              stmt.executeUpdate();
              
    		
             //st = connection.createStatement();
			// st.executeUpdate(query);
			 
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            DbUtil.close(st);
            DbUtil.close(connection);          
        }
    	
    	return false;
    }

}
