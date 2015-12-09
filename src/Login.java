import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login {
	public static void main(String[] args) throws ClassNotFoundException {
		
		 try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
        System.out.println("Driver Successfully Loaded!");
        Connection connect=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ClinicAppointment;user=sa;password=mumsql;");
        System.out.println("Connected to Database!");

			connect.close();

        System.out.println("Database Closed!");
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		JFrame frame = new JFrame("Demo application");
		frame.setTitle("Log-in Screen");
		frame.setBounds(580, 200,300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(frame);
		frame.setVisible(true);
	}
	private static void placeComponents(JFrame frame) {
		frame.setLayout(null); // you can do absolute positioning

		JLabel userLabel = new JLabel("User");
		//(x,y,width,height)
		userLabel.setBounds(10, 10, 80, 25); //??
		frame.add(userLabel); // 

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		frame.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		frame.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		passwordText.setEchoChar('*');
		frame.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(130, 80, 80, 25);
		frame.add(loginButton);

	
		//Anonymous class

				loginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JOptionPane.showMessageDialog(source, source.getText()
						+ " button has been pressed");
			}
		});
			
	}

}

	
		

