package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerSearch;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void createMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		setTitle("Movie Rental Management System");
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Movie Rental Management System");
		setBounds(0,0,800,700);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBounds(0, 0, 784, 27);
		contentPane.add(panel_1);
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
		
		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmAddCust = new JMenuItem("Add");
		mnCustomer.add(mntmAddCust);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnCustomer.add(mntmSearch);
		
		JMenu mnMovie = new JMenu("Movie");
		menuBar.add(mnMovie);
		
		JMenuItem mntmAddMovie = new JMenuItem("Add");
		mnMovie.add(mntmAddMovie);
		
		JMenuItem mntmSearchMovie = new JMenuItem("Search");
		mnMovie.add(mntmSearchMovie);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 784, 33);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel);
		
		txtCustomerSearch = new JTextField();
		panel.add(txtCustomerSearch);
		txtCustomerSearch.setColumns(30);
		
		JButton btnCustSearch = new JButton("Search Customer");
		btnCustSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnCustSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 60, 784, 135);
		contentPane.add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCustDetailHdr = new JLabel("<HTML><B><U>CUSTOMER DETAILS:</U></B></HTML>");
		panel_2.add(lblCustDetailHdr, "2, 2");
		
		JLabel lblID = new JLabel("Customer ID:");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblID, "2, 4, left, bottom");
		
		JLabel lblCustomerID = new JLabel("<CUSTOMER ID>");
		lblCustomerID.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustomerID, "4, 4");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblName, "2, 6");
		
		JLabel lblCustomerName = new JLabel("<CUSTOMER NAME>");
		lblCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustomerName, "4, 6");
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblContact, "2, 8");
		
		JLabel lblCustomerContact = new JLabel("<CUSTOMER CONTACT>");
		panel_2.add(lblCustomerContact, "4, 8");
		
		JLabel lblMembership = new JLabel("Membership:");
		lblMembership.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblMembership, "2, 10");
		
		JLabel lblCustMembership = new JLabel("<MEMBERSHIP>");
		lblCustMembership.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustMembership, "4, 10");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 206, 784, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRentVideo = new JButton("Rent Video");
		btnRentVideo.setBounds(656, 352, 128, 23);
		contentPane.add(btnRentVideo);
	}
	

}
