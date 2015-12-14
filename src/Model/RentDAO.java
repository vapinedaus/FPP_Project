package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UtilityClass.ConnectionFactory;
import net.proteanit.sql.DbUtils;

public class RentDAO {

	Connection connection;
	public ResultSet rentMovie(String text)
	{
		connection = ConnectionFactory.getConnection();
		
		try {
			String query = "select * from Movies where Movie_ID=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(text));
			ResultSet rs = pst.executeQuery();
			
			return rs;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
