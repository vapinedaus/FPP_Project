package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import Controller.RentController;
import UtilityClass.ConnectionFactory;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class RentMovie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void createRentMain(int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentMovie frame = new RentMovie(cid);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentMovie()
	{
		
	}
	public RentMovie(int cid) {
	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rent Movie");
		setBounds(100, 100, 501, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 446, 45);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentController obj = new RentController();
				
				//main window customer id;
			obj.book(cid,Integer.parseInt(textField.getText()));
			   
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(338, 212, 115, 29);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 31, 446, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Movie ID:");
		lblNewLabel.setBounds(10, 11, 62, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setBounds(82, 15, 229, 20);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setColumns(10);
		
		JButton Search = new JButton("Search");
		Search.setBounds(321, 11, 103, 20);
		panel.add(Search);
		Search.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblMovieDetails = new JLabel("Movie Details:");
		lblMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMovieDetails.setBounds(20, 103, 105, 29);
		contentPane.add(lblMovieDetails);
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RentController controller = new RentController();
				ResultSet rs = controller.rent(textField.getText());
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		
		
		JButton AdvanceSearch = new JButton("Advance Search");
		AdvanceSearch.setBounds(300, 40, 140, 20);
		panel.add(AdvanceSearch);
		AdvanceSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		AdvanceSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MovieSearch Obj;
				try {
					Obj = new MovieSearch();
					Obj.movie();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
	}
	
	
	
	
}
