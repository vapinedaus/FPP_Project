import java.sql.SQLException;


public class LoginController {

	private LoginDAO  loginDAO = new LoginDAO();
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValidCredential(String username, String password)
	{
		boolean isLoggedin = false;
		try {
			isLoggedin= loginDAO.isValidCredential(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLoggedin;
	}

}
