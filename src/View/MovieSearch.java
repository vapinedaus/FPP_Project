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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;


public class MovieSearch extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void movie() {
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] genre = new String[]{"","Action","Drama","Comedy","Adventure","Animation"};
		
		
	    String[] columnNames = {"MovieID", "Title", "Genre", "RentalPrice"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 151, 452, 195);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(23, 11, 442, 129);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox(new Object[]{"","ID","Title"});
		comboBox.setBounds(101, 11, 110, 20);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(231, 11, 168, 20);
		panel.add(textField);
		
		JLabel lblOrGenre = new JLabel("Or Genre:");
		lblOrGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrGenre.setBounds(39, 55, 115, 14);
		panel.add(lblOrGenre);
		
		JComboBox comboBox_1 = new JComboBox(genre);
		comboBox_1.setBounds(101, 52, 110, 20);
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Search By:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(28, 14, 63, 14);
		panel.add(label_1);
		
		JButton button = new JButton("Search");
		button.setBounds(343, 95, 89, 23);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SearchMovieController controller = new SearchMovieController();
		         ResultSet rs = controller.search(comboBox_1.getSelectedIndex(),comboBox.getSelectedIndex(),comboBox_1.getSelectedItem(),comboBox.getSelectedItem(),textField.getText());
						
		         table.setModel(DbUtils.resultSetToTableModel(rs));
		
			}
		});
		              
		
	}
}
