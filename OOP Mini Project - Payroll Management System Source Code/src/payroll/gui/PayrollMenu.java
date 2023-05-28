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
 * This class is the implementation of the gui of payroll menu
 *
 */
public class PayrollMenu implements ActionListener {
	
	//These are the declaration of the gui component used in admin menu
	private JFrame payrollMenuF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JButton addPayrollBtn;
	private JButton findPayrollBtn;
	private JButton viewPayrollBtn;
	private JButton mainMenuBtn;
	private JButton exitBtn;
	
	/**
	 * This is the constructor of class PayrollMenu that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public PayrollMenu()
	{
		payrollMenuF = new JFrame("Payroll Management System");
		
	//*************************Initializing North Panel*********************************************
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
	//**********************************************************************************************
		
	//*************************Initializing Center Panel********************************************
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1,90,90));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
														BorderFactory.createLoweredBevelBorder(),
														"Payroll Menu",
														TitledBorder.CENTER,
														TitledBorder.DEFAULT_POSITION,
														new Font("Arial", Font.BOLD, 25)));
		
		addPayrollBtn = new JButton("Add Payroll");
		addPayrollBtn.setPreferredSize(new Dimension(70,30));
		addPayrollBtn.addActionListener(this);
		addPayrollBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		addPayrollBtn.setFocusable(false);
		findPayrollBtn = new JButton("Find Payroll");
		findPayrollBtn.setPreferredSize(new Dimension(70,30));
		findPayrollBtn.addActionListener(this);
		findPayrollBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		findPayrollBtn.setFocusable(false);
		viewPayrollBtn = new JButton("View All Payroll");
		viewPayrollBtn.setPreferredSize(new Dimension(70,30));
		viewPayrollBtn.addActionListener(this);
		viewPayrollBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		viewPayrollBtn.setFocusable(false);
		
		centerPanel.add(addPayrollBtn);
		centerPanel.add(findPayrollBtn);
		centerPanel.add(viewPayrollBtn);
	//**********************************************************************************************
		
	//*************************Initializing East,West,South Panel***********************************
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
	//**********************************************************************************************
		
		//add all the component to the frame 
		payrollMenuF.setLayout(new BorderLayout(0,20));
		payrollMenuF.setSize(700,550);
		payrollMenuF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		payrollMenuF.add(northPanel, BorderLayout.NORTH);
		payrollMenuF.add(centerPanel, BorderLayout.CENTER);
		payrollMenuF.add(eastPanel, BorderLayout.EAST);
		payrollMenuF.add(westPanel, BorderLayout.WEST);
		payrollMenuF.add(southPanel, BorderLayout.SOUTH);
		payrollMenuF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the add payroll, 
	 * find payroll, view all payroll, main menu or exit system button
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Add Payroll"))
		{
			//Open add payroll form
			AddPayrollForm addPayroll = new AddPayrollForm();
		}
		else if(e.getActionCommand().equals("Find Payroll"))
		{
			//Open find payroll form
			FindPayrollForm findPayroll = new FindPayrollForm();
		}
		else if(e.getActionCommand().equals("View All Payroll"))
		{
			//Open view all payroll
			GetPayrollForm getPayroll = new GetPayrollForm();
		}
		else if(e.getActionCommand().equals("Main Menu"))
		{
			//Open main menu
			payrollMenuF.dispose();
			MainMenu mainMenu = new MainMenu();
		}
		else if(e.getActionCommand().equals("Exit System"))
		{
			System.exit(0);
		}
	}
}
