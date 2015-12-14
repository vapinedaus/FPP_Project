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

public class ReturnMovie extends JFrame {


	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnMovie frame = new ReturnMovie();
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Return Movie");
		setBounds(100, 100, 709, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(66, 60, 75, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 58, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnReturned = new JButton("Returned");
		btnReturned.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
			}
		});
		btnReturned.setBounds(140, 124, 115, 29);
		contentPane.add(btnReturned);
		
		JLabel lblResult = new JLabel("New label");
		lblResult.setBounds(140, 199, 485, 29);
		lblResult.setVisible(false);
		contentPane.add(lblResult);
	}
}
