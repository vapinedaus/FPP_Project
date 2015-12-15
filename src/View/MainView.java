package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Controller.MainViewController;
import ORM.CustomersObject;
import ORM.RentalHistoryObject;


public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerSearch;
	private JTable table;
	JButton btnRentVideo;
	JPanel panel_2;
	JScrollPane scrollPane;
	JLabel lblNotExistCust;
	
	JLabel lblCustomerID;
	JLabel lblCustomerName;
	JLabel lblCustomerContact;
	JLabel lblCustMembership;
	MainViewController mainViewController = new MainViewController();
	JButton btnReturn;
	int custID;
	
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Movie Rental Management System");
		setBounds(0,0,800,410);
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
		
	//	JMenuItem mntmSearch = new JMenuItem("Search");
	//	mnCustomer.add(mntmSearch);
		
		JMenu mnMovie = new JMenu("Movie");
		menuBar.add(mnMovie);
		
	
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
				boolean isCustExist = false;
				
				CustomersObject custObj = mainViewController.getCustomerDetails(txtCustomerSearch.getText().trim());
				
				if(custObj.getCustomer_ID() != 0)
				{
					isCustExist = true;
				}
				
				if(isCustExist)
				{
					populateCustomerDetails();			
				
					populateTable();
				
					btnRentVideo.setVisible(true);
				}
				else
				{
					lblNotExistCust.setVisible(true);
				}
				
			}
		});
		panel.add(btnCustSearch);
		
		lblNotExistCust = new JLabel("Customer does not exist.");
		lblNotExistCust.setForeground(Color.RED);
		panel.add(lblNotExistCust);
		
		panel_2 = new JPanel();	
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
		
		lblCustomerID = new JLabel("<CUSTOMER ID>");
		lblCustomerID.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustomerID, "4, 4");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblName, "2, 6");
		
		lblCustomerName = new JLabel("<CUSTOMER NAME>");
		lblCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustomerName, "4, 6");
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblContact, "2, 8");
		
		lblCustomerContact = new JLabel("<CUSTOMER CONTACT>");
		panel_2.add(lblCustomerContact, "4, 8");
		
		JLabel lblMembership = new JLabel("Membership:");
		lblMembership.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblMembership, "2, 10");
		
		lblCustMembership = new JLabel("<MEMBERSHIP>");
		lblCustMembership.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCustMembership, "4, 10");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 206, 784, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnRentVideo = new JButton("Rent Video");
		btnRentVideo.setBounds(656, 352, 128, 23);
		contentPane.add(btnRentVideo);
		btnRentVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentMovie rentObj = new RentMovie();
				rentObj.createRentMain(custID);
				
			}
		});
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(500, 352, 128, 23);
		contentPane.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnMovie Obj = new ReturnMovie();
				Obj.returnMain(custID);
				
			}
		});
		
		mntmAddCust.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddCustomer Obj = new AddCustomer();
				Obj.mainAdd();
				
			}
		});
		
		mntmSearchMovie.addActionListener(new ActionListener(){
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
		
		panel_2.setVisible(false);
		btnRentVideo.setVisible(false);
		scrollPane.setVisible(false);
		lblNotExistCust.setVisible(false);
		
	}
	
	private void populateTable()
	{
		scrollPane.setVisible(true);
		
		table.setModel(DbUtils.resultSetToTableModel(mainViewController.getRentalHistory(custID)));
		
	}
	
	private void populateCustomerDetails()
	{	
		panel_2.setVisible(true);
		CustomersObject custObj = mainViewController.getCustomerDetails(txtCustomerSearch.getText().trim());
		
		custID = custObj.getCustomer_ID();
		
		lblCustomerID.setText(String.valueOf(custObj.getCustomer_ID()));
		lblCustomerName.setText(custObj.getName());
		lblCustomerContact.setText(custObj.getContact());
		
		if(custObj.isMember())
		{
			lblCustMembership.setText("MEMBER");
			lblCustMembership.setForeground(Color.GREEN);
		}
		else
		{
			lblCustMembership.setText("NON-MEMBER");
			lblCustMembership.setForeground(Color.RED);			
		}
	}
}
