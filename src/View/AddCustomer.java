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

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel ContactAddress;
	private JTextField textField_1;
	private JLabel lblNewLabel;
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
		setBounds(100, 100, 808, 482);
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
		btnNewButton.setBounds(155, 246, 148, 43);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(604, 23, 0, 0);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.BOLD, 12));
		Name.setBounds(81, 54, 51, 31);
		contentPane.add(Name);
		
		textField = new JTextField();
		textField.setBounds(155, 51, 224, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ContactAddress = new JLabel("Contact Address");
		ContactAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		ContactAddress.setBounds(30, 116, 102, 31);
		contentPane.add(ContactAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 113, 224, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Membership");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(42, 180, 90, 31);
		contentPane.add(lblNewLabel);
		
		chckbxNewCheckBox= new JCheckBox("");
		chckbxNewCheckBox.setBounds(157, 185, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(155, 332, 610, 23);
		lblNewLabel_1.setVisible(false);
		contentPane.add(lblNewLabel_1);
	}
}
