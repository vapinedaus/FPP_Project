package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.SearchMovieDAO;

public class SearchMovieController {

	public ResultSet search(int combo1Index,int comboIndex, Object combo1Text, Object comboText,String textFieldText)
	{
		SearchMovieDAO obj = new SearchMovieDAO();
		ResultSet rs = obj.searchDAO(combo1Index, comboIndex, combo1Text, comboText,textFieldText);
		return rs;
	}
}
