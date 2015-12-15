package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.RentController;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnMovie extends JFrame {


	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void returnMain(int custid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnMovie frame = new ReturnMovie(custid);
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
	public ReturnMovie() {
		
	}
	public ReturnMovie(int custid) {

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Return Movie");
		setBounds(100, 100, 404, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 88, 75, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 86, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblResult = new JLabel("");
		lblResult.setForeground(Color.RED);
		lblResult.setBounds(34, 7, 372, 29);
		lblResult.setVisible(true);
		contentPane.add(lblResult);
		
		JButton btnReturned = new JButton("Returned");
		btnReturned.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RentController obj = new RentController();
				try {
					String str = obj.returnMovie(custid, Integer.parseInt(textField.getText()));
					lblResult.setText(str);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnReturned.setBounds(263, 137, 115, 29);
		contentPane.add(btnReturned);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 47, 87, 14);
		lblNewLabel_1.setForeground(Color.GREEN);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(127, 48, 46, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText(String.valueOf(custid));
	}
}
