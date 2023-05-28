package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * This class is the implementation of the gui of admin menu
 *
 */
public class AdminMenu implements ActionListener {
	
	//These are the declaration of the gui component used in admin menu
	private JFrame adminMenuF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JButton addAdminBtn;
	private JButton findAdminBtn;
	private JButton viewAdminBtn;
	private JButton mainMenuBtn;
	private JButton exitBtn;
	
	/**
	 * This is the constructor of class AdminMenu that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public AdminMenu()
	{
		adminMenuF = new JFrame("Payroll Management System");
		
	//*************************Initializing North Panel**********************************
		northPanel = new JPanel();
		northPanel.setBackground(new Color(0x3399FF));
		northPanel.setPreferredSize(new Dimension(700,100));
		northPanel.setLayout(new BorderLayout());
		northPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));
		
		titleLabel = new JLabel();
		titleLabel.setText("PAYROLL MANAGEMENT SYSTEM");
		titleLabel.setForeground(Color.black);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		northPanel.add(titleLabel, BorderLayout.CENTER);
	//***********************************************************************************
		
	//*************************Initializing Center Panel*********************************
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1,90,90));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
														BorderFactory.createLoweredBevelBorder(),
														"Admin Menu",
														TitledBorder.CENTER,
														TitledBorder.DEFAULT_POSITION,
														new Font("Arial", Font.BOLD, 25)));
		
		addAdminBtn = new JButton("Add Admin");
		addAdminBtn.setPreferredSize(new Dimension(70,30));
		addAdminBtn.addActionListener(this);
		addAdminBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		addAdminBtn.setFocusable(false);
		
		findAdminBtn = new JButton("Find Admin");
		findAdminBtn.setPreferredSize(new Dimension(70,30));
		findAdminBtn.addActionListener(this);
		findAdminBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		findAdminBtn.setFocusable(false);
		
		viewAdminBtn = new JButton("View All Admin");
		viewAdminBtn.setPreferredSize(new Dimension(70,30));
		viewAdminBtn.addActionListener(this);
		viewAdminBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		viewAdminBtn.setFocusable(false);
		
		centerPanel.add(addAdminBtn);
		centerPanel.add(findAdminBtn);
		centerPanel.add(viewAdminBtn);
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(150,100));
		
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(150,100));
		
		westPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Navigation",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 16)));
		
		mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setPreferredSize(new Dimension(125,30));
		mainMenuBtn.addActionListener(this);
		mainMenuBtn.setFocusable(false);

		exitBtn = new JButton("Exit System");
		exitBtn.setPreferredSize(new Dimension(125,30));
		exitBtn.addActionListener(this);
		exitBtn.setFocusable(false);
		
		westPanel.add(mainMenuBtn);
		westPanel.add(exitBtn);
		
		southPanel = new JPanel();
	//***********************************************************************************
		
		//add all the component to the frame 
		adminMenuF.setLayout(new BorderLayout(5,20));
		adminMenuF.setSize(700,550);
		adminMenuF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminMenuF.add(northPanel, BorderLayout.NORTH);
		adminMenuF.add(centerPanel, BorderLayout.CENTER);
		adminMenuF.add(eastPanel, BorderLayout.EAST);
		adminMenuF.add(westPanel, BorderLayout.WEST);
		adminMenuF.add(southPanel, BorderLayout.SOUTH);
		adminMenuF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the add admin, 
	 * find admin, view all admin, main menu or exit system button
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Add Admin"))
		{
			//Open add admin form
			AddAdminForm addAdmin = new AddAdminForm();
		}
		else if(e.getActionCommand().equals("Find Admin"))
		{
			//Open find admin form
			FindAdminForm findAdmin = new FindAdminForm();
		}
		else if(e.getActionCommand().equals("View All Admin"))
		{
			//Open view all admin
			GetAdminForm getAdmin = new GetAdminForm();
		}
		else if(e.getActionCommand().equals("Main Menu"))
		{
			//Open main menu
			adminMenuF.dispose();
			MainMenu mainMenu = new MainMenu();
		}
		else if(e.getActionCommand().equals("Exit System"))
		{
			System.exit(0);
		}
	}
}
