package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UtilityClass.ConnectionFactory;

public class SearchMovieDAO {

	Connection connection;
	
	public ResultSet searchDAO(int combo1Index,int comboIndex, Object combo1Text, Object comboText,String textFieldText)
	{
		connection = ConnectionFactory.getConnection();
		
		try{
			   String query="";
			   boolean genre=false,searchbyid=false,searchbyname=false;
			   if(combo1Index>0)//comboBox_1.getSelectedIndex()>0)
			   {
				   genre = true;
			   }
			   if(comboIndex>0)//comboBox.getSelectedIndex()>0)
			   {
				   if(comboIndex==1)
					   searchbyid=true;
				   else if(comboIndex==2)
				   	  searchbyname = true;
			   }
			   		   
			   if(genre==true && searchbyid==false && searchbyname==false)
				   query="select * from Movies where Genre = ?";
			   else if(genre==false && searchbyid==true && searchbyname==false)
				   query="select * from Movies where Movie_ID = ?";
			   else if(genre==false && searchbyid==false && searchbyname==true)
				   query="select * from Movies where MovieName = ?";
			   else if(genre==true && searchbyid==true && searchbyname==false)
				   query = "select * from Movies where Genre=? and Movie_ID=?";
			   else if(genre==true && searchbyid==false && searchbyname==true)
				   query = "select * from Movies where Genre=? and MovieName=?";
			   else
				   query = "select * from Movies";
			   
			   System.out.println("Query is======"+query+"====combo1text==="+(String)combo1Text);
				
			   			   
			   PreparedStatement pst = connection.prepareStatement(query);
			
				
				   if(genre==true && searchbyid==false && searchbyname==false)
				   {
					   pst.setString(1, (String) combo1Text);  //comboBox_1.getSelectedItem()
					   System.out.println("setting pst genre=====");
				   }
				   else if(genre==false && searchbyid==true && searchbyname==false)
					   pst.setInt(1, Integer.parseInt(textFieldText));
				   else if(genre==false && searchbyid==false && searchbyname==true)
					   pst.setString(1, textFieldText.trim());
				   else if(genre==true && searchbyid==true && searchbyname==false)
				   {
					   pst.setString(1, (String) combo1Text);
					   pst.setInt(2, Integer.parseInt(textFieldText));
				   }
				   else if(genre==true && searchbyid==false && searchbyname==true)
				   {
					   pst.setString(1, (String) combo1Text);
					   pst.setString(2, textFieldText.trim());   
				   }
				 
				
				ResultSet rs = pst.executeQuery();
				
				//System.out.println("rs size======"+rs.getString(1));
				return rs;
				
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	
//});
	}

}