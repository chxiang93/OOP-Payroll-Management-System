package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import payroll.api.AdminApi;

/**
 * This class is the implementation of the gui of login menu 
 *
 */
public class LoginMenu extends KeyAdapter implements ActionListener {

		//These are the declaration of the gui component used in login menu
		private JFrame loginFrame;
		private JPanel northPanel;
		private JPanel centerPanel;
		private JPanel eastPanel;
		private JPanel westPanel;
		private JPanel southPanel;
		private JPanel loginPanel;
		private JPanel btnPanel;
		private JLabel titleLabel;
		private JLabel label;
		private JLabel usernameLabel;
		private JLabel passwordLabel;
		private JLabel invalidLabel;
		private JTextField usernameTF;
		private JPasswordField passwordTF;
		private JButton loginBtn;
		
		/**
		 * This is the constructor of class LoginMenu that initialize all the gui component 
		 * and display the component to the screen inside a frame
		 */
		public LoginMenu()
		{
			loginFrame = new JFrame("Payroll Management System");
		
		//*************************Initializing North Panel*****************************
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
		//******************************************************************************
			
		//*************************Initializing Center Panel****************************
			centerPanel = new JPanel();
			centerPanel.setLayout(new GridLayout(3,1,0,15));
			
			label = new JLabel();
			label.setText("Please enter your username and password:");
			label.setVerticalAlignment(JLabel.BOTTOM);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(new Font(null, Font.BOLD, 18));
			
			usernameLabel = new JLabel();
			usernameLabel.setText("Username:");
			passwordLabel = new JLabel();
			passwordLabel.setText("Password:");
			
			loginBtn = new JButton("Login");
			loginBtn.setPreferredSize(new Dimension(100,50));
			loginBtn.addActionListener(this);
			loginBtn.setFocusable(false);
			
			invalidLabel = new JLabel();
			invalidLabel.setText("Your username or password is incorrect!!");
			invalidLabel.setForeground(Color.red);
			invalidLabel.setVisible(false);
			
			btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			btnPanel.add(invalidLabel);
			btnPanel.add(loginBtn);
			
			passwordTF = new JPasswordField();
			passwordTF.addKeyListener(this);
			passwordTF.setBorder(BorderFactory.createLoweredBevelBorder());
			usernameTF = new JTextField();
			usernameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
			loginPanel = new JPanel();
			loginPanel.setLayout(new GridLayout(2,2,0,10));
			loginPanel.add(usernameLabel);
			loginPanel.add(usernameTF);
			loginPanel.add(passwordLabel);
			loginPanel.add(passwordTF);
			
			centerPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLoweredBevelBorder(),
					"Login Menu",
					TitledBorder.CENTER,
					TitledBorder.DEFAULT_POSITION,
					new Font("Arial", Font.BOLD, 25)));
			centerPanel.setPreferredSize(new Dimension(500,500));
			centerPanel.add(label);
			centerPanel.add(loginPanel);
			centerPanel.add(btnPanel);
		//******************************************************************************
			
		//*************************Initializing East,West,South Panel*******************
			eastPanel = new JPanel();
			eastPanel.setPreferredSize(new Dimension(150,100));
			westPanel = new JPanel();
			westPanel.setPreferredSize(new Dimension(150,100));
			southPanel = new JPanel();
		//******************************************************************************
			
			//add all the component to the frame 
			loginFrame.setLayout(new BorderLayout(0,40));
			loginFrame.setSize(700,550);
			loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginFrame.add(northPanel, BorderLayout.NORTH);
			loginFrame.add(centerPanel, BorderLayout.CENTER);
			loginFrame.add(eastPanel, BorderLayout.EAST);
			loginFrame.add(westPanel, BorderLayout.WEST);
			loginFrame.add(southPanel, BorderLayout.SOUTH);
			loginFrame.setVisible(true);
		}
		
		/**
		 * This is the action when user click on login button
		 * The system will check if the username and password is correct
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Login"))
			{
				String username = usernameTF.getText();	//get the username from text field
				String password = String.valueOf(passwordTF.getPassword());	//get the password from text field
				
				try
				{
					AdminApi adminApi = new AdminApi();
					
					if(adminApi.login(username, password))
					{
						loginFrame.dispose();
						MainMenu mainMenu = new MainMenu();
					}
					else
					{
						invalidLabel.setVisible(true);
						usernameTF.setText(null);
						passwordTF.setText(null);
					}
				}
				catch(Exception ex)	//catch the exception that may occur
				{
					//show a pop up window that print the error message
					String message = ex.getMessage();
					JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		}
		
		/**
		 * This is the action when user press on enter button on their keyboard
		 * The system will check if the username and password is correct
		 */
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				String username = usernameTF.getText();	//get the username from text field
				String password = String.valueOf(passwordTF.getPassword());	//get the password from text field
				
				try
				{
					AdminApi adminApi = new AdminApi();
					
					//if username and password is correct with one of the admin
					//then open main menu
					if(adminApi.login(username, password))
					{
						loginFrame.dispose();
						MainMenu mainMenu = new MainMenu();
					}
					else
					{
						invalidLabel.setVisible(true);
						usernameTF.setText(null);
						passwordTF.setText(null);
					}
				}
				catch(Exception ex)	//catch the exception that may occur
				{
					//show a pop up window that print the error message
					String message = ex.getMessage();
					JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		}
}
