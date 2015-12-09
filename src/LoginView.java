import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginView {

	public static void main(String[] args) throws ClassNotFoundException {

		JFrame frame = new JFrame("Log-in");
		frame.setBounds(580, 200,300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(frame);
		frame.setVisible(true);
	}
	private static void placeComponents(final JFrame frame) {
		frame.setLayout(null); // you can do absolute positioning

		JLabel userLabel = new JLabel("User");
		//(x,y,width,height)
		userLabel.setBounds(10, 10, 80, 25); //??
		frame.add(userLabel); // 

		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		frame.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		frame.add(passwordLabel);

		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		passwordText.setEchoChar('*');
		frame.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(130, 80, 80, 25);
		frame.add(loginButton);
				loginButton.addActionListener(new ActionListener(){
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
				// begin call the controller
				LoginController controller = new LoginController();
				boolean isLoggedin = false;
				isLoggedin = controller.isValidCredential(userText.getText(), passwordText.getText());
				// end call the controller
				JButton source = (JButton) e.getSource();
				if (isLoggedin)
				{
					frame.setVisible(false);
					MainView mainscreen = new MainView();
					mainscreen.createMain();
				}
				else
				{
				JOptionPane.showMessageDialog(source, "Invalid Credetials!");	
				}
			}
		});
			
	}

}

	
		

