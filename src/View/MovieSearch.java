package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import Controller.SearchMovieController;
import UtilityClass.ConnectionFactory;
import UtilityClass.DbUtil;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class MovieSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSearch frame = new MovieSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MovieSearch() throws SQLException {
		//
		
		setTitle("Search All Movies");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setBounds(28, 25, 63, 14);
		contentPane.add(lblSearchBy);
		
		JComboBox comboBox = new JComboBox(new String[]{"","ID","Title"});
		comboBox.setBounds(101, 22, 110, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(101, 53, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(330, 25, 39, 14);
		contentPane.add(lblGenre);
		
		String[] genre = new String[]{"","Action","Drama","Comedy","Adventure","Animation"};
		JComboBox comboBox_1 = new JComboBox(genre);
		comboBox_1.setBounds(379, 22, 115, 20);
		contentPane.add(comboBox_1);
		
		
	    String[] columnNames = {"MovieID", "Title", "Genre", "RentalPrice"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 678, 324);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SearchMovieController controller = new SearchMovieController();
		         ResultSet rs = controller.search(comboBox_1.getSelectedIndex(),comboBox.getSelectedIndex(),comboBox_1.getSelectedItem(),comboBox.getSelectedItem(),textField.getText());
						
		         table.setModel(DbUtils.resultSetToTableModel(rs));
		
			}
		});
		btnSearch.setBounds(247, 80, 89, 23);
		contentPane.add(btnSearch);
		              
		
	}
}
