package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

/**
 * This class is the implementation of the gui of main menu 
 *
 */
public class MainMenu implements ActionListener {
	
		//These are the declaration of the gui component used in main menu
		private JFrame frameMainMenu;
		private JPanel northPanel;
		private JPanel centerPanel;
		private JPanel eastPanel;
		private JPanel westPanel;
		private JPanel southPanel;
		private JLabel titleLabel;
		private JButton adminMenuBtn;
		private JButton payrollMenuBtn;
		private JButton employeeMenuBtn;
		private JButton logoutBtn;
		private JButton exitBtn;

		/**
		 * This is the constructor of class LoginMenu that initialize all the gui component
		 * and display the component to the screen inside a frame 
		 */
		public MainMenu()
		{
			frameMainMenu = new JFrame("Payroll Management System");
			
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
			centerPanel.setLayout(new GridLayout(3,1,0,90));
			centerPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLoweredBevelBorder(),
					"Main Menu",
					TitledBorder.CENTER,
					TitledBorder.DEFAULT_POSITION,
					new Font("Arial", Font.BOLD, 25)));

			adminMenuBtn = new JButton("Manage Admin");
			adminMenuBtn.setPreferredSize(new Dimension(70,30));
			adminMenuBtn.addActionListener(this);
			adminMenuBtn.setFont(new Font("Arial", Font.PLAIN, 20));
			adminMenuBtn.setFocusable(false);
			
			payrollMenuBtn = new JButton("Manage Payroll");
			payrollMenuBtn.setPreferredSize(new Dimension(70,30));
			payrollMenuBtn.addActionListener(this);
			payrollMenuBtn.setFont(new Font("Arial", Font.PLAIN, 20));
			payrollMenuBtn.setFocusable(false);
			
			employeeMenuBtn = new JButton("Manage Employee");
			employeeMenuBtn.setPreferredSize(new Dimension(70,30));
			employeeMenuBtn.addActionListener(this);
			employeeMenuBtn.setFont(new Font("Arial", Font.PLAIN, 20));
			employeeMenuBtn.setFocusable(false);
			
			centerPanel.add(employeeMenuBtn);
			centerPanel.add(payrollMenuBtn);
			centerPanel.add(adminMenuBtn);
		//***********************************************************************************
			
		//*************************Initializing East,West,South Panel************************
			logoutBtn = new JButton("Logout");
			logoutBtn.setPreferredSize(new Dimension(100,30));
			logoutBtn.addActionListener(this);
			logoutBtn.setFont(new Font("Arial", Font.PLAIN, 20));
			logoutBtn.setFocusable(false);
			
			exitBtn = new JButton("Exit");
			exitBtn.setPreferredSize(new Dimension(100,30));
			exitBtn.addActionListener(this);
			exitBtn.setFont(new Font("Arial", Font.PLAIN, 20));
			exitBtn.setFocusable(false);
			
			eastPanel = new JPanel();
			eastPanel.setPreferredSize(new Dimension(150,100));
			eastPanel.add(logoutBtn);
			eastPanel.add(exitBtn);
			
			westPanel = new JPanel();
			westPanel.setPreferredSize(new Dimension(150,100));
			southPanel = new JPanel();
		//***********************************************************************************
			
			//add all the component to the frame 
			frameMainMenu.setLayout(new BorderLayout(0,30));
			frameMainMenu.setSize(700,550);
			frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameMainMenu.add(northPanel, BorderLayout.NORTH);
			frameMainMenu.add(centerPanel, BorderLayout.CENTER);
			frameMainMenu.add(eastPanel, BorderLayout.EAST);
			frameMainMenu.add(westPanel, BorderLayout.WEST);
			frameMainMenu.add(southPanel, BorderLayout.SOUTH);
			frameMainMenu.setVisible(true);
		}
		
		/**
		 * This is the action performed when user click on the adminMenu, 
		 * employeeMenu, payrollMenu, logout or exit button
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == adminMenuBtn)
			{
				//Open admin menu
				frameMainMenu.dispose();
				AdminMenu adminMenu = new AdminMenu();
			}
			else if(e.getSource() == employeeMenuBtn)
			{
				//Open employee menu
				frameMainMenu.dispose();
				EmployeeMenu employeeMenu = new EmployeeMenu();
			}
			else if(e.getSource() == payrollMenuBtn)
			{
				//Open payroll menu
				frameMainMenu.dispose();
				PayrollMenu payrollMenu = new PayrollMenu();
			}
			else if(e.getSource() == logoutBtn)
			{
				//Open login menu
				frameMainMenu.dispose();
				LoginMenu login = new LoginMenu();
			}
			else if(e.getActionCommand().equals("Exit"))
			{
				System.exit(0);
			}
		}
}
