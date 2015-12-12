package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainView extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void createMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					layoutComponents(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		setTitle("Movie Rental Management System");
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public static void layoutComponents(JFrame jFrame)
	{
		//START MENU BAR
		JMenuBar menuBar = new JMenuBar();
		JMenu customerMenu = new JMenu("Customer");
		JMenu movieMenu = new JMenu("Movie");

		JMenuItem addCustMenuItem = new JMenuItem("Add");
		customerMenu.add(addCustMenuItem);
		JMenuItem searchCustMenuItem = new JMenuItem("Search");
		customerMenu.add(searchCustMenuItem);
		
		JMenuItem searchMovie = new JMenuItem("Search");
		movieMenu.add(searchMovie);
		
		menuBar.add(customerMenu);
		menuBar.add(movieMenu);
		
		jFrame.setJMenuBar(menuBar);
		//END MENU BAR
		
		//START HEADER PANEL
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jFrame.add(searchPanel, BorderLayout.NORTH);
		
		final JTextField txtCustomer = new JTextField(100);
		txtCustomer.setColumns(50);
		JButton btnSearchCust = new JButton("Search Customer");
		
		searchPanel.add(txtCustomer);
		searchPanel.add(btnSearchCust);
		//END HEADER PANEL
		
		//START CENTER PANEL
		JPanel centerPanel = new JPanel(new GridLayout(2,1));
		jFrame.add(centerPanel, BorderLayout.WEST);
		
		JPanel custDtlPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblCustDetailHdr = new JLabel("<HTML><U>CUSTOMER DETAILS:</U></HTML>", SwingConstants.LEFT);
		JLabel lblCustID = new JLabel("Customer ID:", SwingConstants.LEFT);
		JLabel lblCustomerID = new JLabel("ABC-101010", SwingConstants.LEFT);
		JLabel lblName = new JLabel("Name:", SwingConstants.LEFT);
		JLabel lblCustName = new JLabel("Jennyfer", SwingConstants.LEFT);
		JLabel lblContact = new JLabel("Contact No.:", SwingConstants.LEFT);
		JLabel lblCustContact = new JLabel("6414512222", SwingConstants.LEFT);
		JLabel lblMembership = new JLabel("Member Status:", SwingConstants.LEFT);
		JLabel lblCustMembership = new JLabel("Active", SwingConstants.LEFT);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		custDtlPanel.add(lblCustDetailHdr,c);
		//custDtlPanel.add(lblFiller);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		custDtlPanel.add(lblCustID, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		custDtlPanel.add(lblCustomerID,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		custDtlPanel.add(lblName,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		custDtlPanel.add(lblCustName,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		custDtlPanel.add(lblContact,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		custDtlPanel.add(lblCustContact,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		custDtlPanel.add(lblMembership,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		custDtlPanel.add(lblCustMembership,c);
		
		//RENTED MOVIES
		JPanel rentedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		centerPanel.add(custDtlPanel);
		//END CENTER PANEL
		
		
		
	}

}
