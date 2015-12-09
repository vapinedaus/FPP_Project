import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBTest {

	public DBTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			 System.out.println("Driver Successfully Loaded!");
			 Connection connect=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=MovieRental;user=sa;password=mumsql;");
			 System.out.println("Connected to Database!");
			 connect.close();
			 System.out.println("Database Closed!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
