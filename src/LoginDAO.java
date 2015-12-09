import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	private Connection connection;
    private Statement statement;
    
	public LoginDAO() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("finally")
	public boolean isValidCredential(String username, String password) throws SQLException {
        String query = "SELECT * FROM USERS WHERE username='" + username + "' and password = '" + password +"'";
        ResultSet rs = null;
        LoginObject login = new LoginObject() ;
        boolean isLoggedin = false;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            // just to show the implementation
            if (rs != null) {
                while (rs.next()) {
                	login.setUsername(username);
                	login.setPassword(password);
                	isLoggedin= true;
                }
             }
                
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
            return isLoggedin;
        }
	}

}
