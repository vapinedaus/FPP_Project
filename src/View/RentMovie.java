package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class RentMovie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentMovie frame = new RentMovie();
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
	public RentMovie() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rent Movie");
		setBounds(100, 100, 860, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(40, 44, 62, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(95, 44, 193, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Returned = new JButton("Search");
		Returned.setFont(new Font("Tahoma", Font.BOLD, 11));
		Returned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RentController controller = new RentController();
				ResultSet rs = controller.rent(textField.getText());
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		Returned.setBounds(95, 106, 103, 29);
		contentPane.add(Returned);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 196, 657, 61);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentController obj = new RentController();
				
				//main window customer id;
			//	obj.book(Integer.parseInt(textField.getText()));
			   
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(340, 311, 115, 29);
		contentPane.add(btnNewButton);
	}
	
	
	
	
}
