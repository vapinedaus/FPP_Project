package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.AddCustomerController;
import javax.swing.JCheckBox;
import java.awt.Color;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel ContactAddress;
	private JTextField textField_1;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Customer Registration");
		setBounds(100, 100, 427, 246);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JLabel lblName = new JLabel("Name");
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    AddCustomerController controller = new AddCustomerController();  
			    boolean added =  controller.add(textField.getText(),textField_1.getText(),chckbxNewCheckBox.isSelected());
			    lblNewLabel_1.setVisible(true);
			    if(added)
				{
					lblNewLabel_1.setText("Customer is successfully registerd.");
				}
				else
				{
					lblNewLabel_1.setText("Customer registration failed. Please try again.");
				}
			}
		});
		btnNewButton.setBounds(233, 148, 148, 43);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(604, 23, 0, 0);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel Name = new JLabel("Name:");
		Name.setFont(new Font("Tahoma", Font.BOLD, 12));
		Name.setBounds(71, 30, 51, 31);
		contentPane.add(Name);
		
		textField = new JTextField();
		textField.setBounds(145, 35, 224, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ContactAddress = new JLabel("Contact Address:");
		ContactAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		ContactAddress.setBounds(10, 65, 140, 31);
		contentPane.add(ContactAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 70, 224, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		chckbxNewCheckBox= new JCheckBox("Member");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(145, 103, 97, 23);
		contentPane.add(chckbxNewCheckBox);
	
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 0, 610, 23);
		lblNewLabel_1.setVisible(false);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNonmember = new JCheckBox("Non-Member");
		chckbxNonmember.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNonmember.setBounds(258, 103, 111, 23);
		contentPane.add(chckbxNonmember);
		
		chckbxNonmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxNonmember.setSelected(true);
				chckbxNewCheckBox.setSelected(false);
			}
		});
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxNonmember.setSelected(false);
				chckbxNewCheckBox.setSelected(true);
			}
		});
	}
}
