package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import payroll.bean.*;
import payroll.api.*;

/**
 * This class is the implementation of the gui of find admin form
 *
 */
public class FindAdminForm extends KeyAdapter implements ActionListener {
	
	//These are the declaration of the gui component used in find admin form 
	private JFrame findAdminF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JPanel centerNorthPanel;
	private JPanel centerDisplayPanel;
	private JPanel searchPanel;
	private JPanel searchTypePanel;
	private JLabel titleLabel;
	
	private JRadioButton searchIdRB;
	private JRadioButton searchNameRB;
	private JLabel searchTypeLabel;
	private JLabel searchLabel;
	private JLabel adminNameLabel;
	private JLabel adminIdLabel;
	private JLabel employeeIdLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JTextField searchTF;
	private JTextField adminNameTF;
	private JTextField adminIdTF;
	private JTextField employeeIdTF;
	private JTextField usernameTF;
	private JTextField passwordTF;
	
	private JButton searchBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton chgBtn;
	private JButton cancelBtn;
	
	/**
	 * This is the constructor of class FindAdminForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public FindAdminForm()
	{
		findAdminF = new JFrame("Payroll Management System");
		
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
		centerPanel.setLayout(new BorderLayout(0,15));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Search Admin",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		searchIdRB = new JRadioButton();
		searchIdRB.setText("Admin id");
		searchIdRB.addActionListener(this);
		searchIdRB.setFocusable(false);
		
		searchNameRB = new JRadioButton();
		searchNameRB.setText("Admin name");
		searchNameRB.addActionListener(this);
		searchNameRB.setFocusable(false);
		ButtonGroup searchGroup = new ButtonGroup();
		searchGroup.add(searchIdRB);
		searchGroup.add(searchNameRB);
		searchIdRB.setSelected(true);
		
		searchTypeLabel = new JLabel("Search by:");
		
		searchTypePanel = new JPanel();
		searchTypePanel.add(searchTypeLabel);
		searchTypePanel.add(searchIdRB);
		searchTypePanel.add(searchNameRB);
		
		searchBtn = new JButton();
		searchBtn.setText("Search");
		searchBtn.addActionListener(this);
		searchBtn.setPreferredSize(new Dimension(110,30));
		searchBtn.setFocusable(false);
		
		searchTF = new JTextField();
		searchTF.setPreferredSize(new Dimension(150,30));
		searchTF.addKeyListener(this);
		
		searchLabel = new JLabel("Admin ID:");
		
		searchPanel = new JPanel();
		searchPanel.add(searchLabel);
		searchPanel.add(searchTF);
		searchPanel.add(searchBtn);
		
		centerNorthPanel = new JPanel();
		centerNorthPanel.setLayout(new GridLayout(2,1));
		centerNorthPanel.add(searchTypePanel);
		centerNorthPanel.add(searchPanel);
		
		centerDisplayPanel = new JPanel();
		centerDisplayPanel.setLayout(new GridLayout(5,2,0,10));
		
		adminNameLabel = new JLabel("Admin Name:");
		adminIdLabel = new JLabel("Admin ID:");
		employeeIdLabel = new JLabel("Employee ID:");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		
		adminIdTF = new JTextField();
		adminIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		adminIdTF.setEditable(false);
		
		employeeIdTF = new JTextField();
		employeeIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIdTF.setEditable(false);
		
		adminNameTF = new JTextField();
		adminNameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		adminNameTF.setEditable(false);
		
		usernameTF = new JTextField();
		usernameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		usernameTF.setEditable(false);
		
		passwordTF = new JTextField();
		passwordTF.setBorder(BorderFactory.createLoweredBevelBorder());
		passwordTF.setEditable(false);
		
		centerDisplayPanel.add(adminIdLabel);
		centerDisplayPanel.add(adminIdTF);
		centerDisplayPanel.add(adminNameLabel);
		centerDisplayPanel.add(adminNameTF);
		centerDisplayPanel.add(employeeIdLabel);
		centerDisplayPanel.add(employeeIdTF);
		centerDisplayPanel.add(usernameLabel);
		centerDisplayPanel.add(usernameTF);
		centerDisplayPanel.add(passwordLabel);
		centerDisplayPanel.add(passwordTF);
		
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerPanel.add(centerDisplayPanel, BorderLayout.CENTER);
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		chgBtn = new JButton();
		chgBtn.setText("Change");
		chgBtn.addActionListener(this);
		chgBtn.setPreferredSize(new Dimension(100,30));
		chgBtn.setVisible(false);
		chgBtn.setFocusable(false);
		
		cancelBtn = new JButton();
		cancelBtn.setText("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setPreferredSize(new Dimension(100,30));
		cancelBtn.setVisible(false);
		cancelBtn.setFocusable(false);
		
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(120,100));
		eastPanel.add(chgBtn);
		eastPanel.add(cancelBtn);
		
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(110,100));
		
		updateBtn = new JButton();
		updateBtn.setText("Update Record");
		updateBtn.addActionListener(this);
		updateBtn.setFocusable(false);
		
		deleteBtn = new JButton();
		deleteBtn.setText("Delete Record");
		deleteBtn.addActionListener(this);
		deleteBtn.setFocusable(false);
		
		updateBtn.setPreferredSize(new Dimension(120,50));
		deleteBtn.setPreferredSize(new Dimension(120,50));
		
		southPanel = new JPanel();
		southPanel.add(updateBtn);
		southPanel.add(deleteBtn);
	//***********************************************************************************
		
		//add all the component to the frame 
		findAdminF.setLayout(new BorderLayout(0,10));
		findAdminF.setSize(700,550);
		findAdminF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		findAdminF.add(northPanel, BorderLayout.NORTH);
		findAdminF.add(centerPanel, BorderLayout.CENTER);
		findAdminF.add(eastPanel, BorderLayout.EAST);
		findAdminF.add(westPanel, BorderLayout.WEST);
		findAdminF.add(southPanel, BorderLayout.SOUTH);
		findAdminF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the search, 
	 * delete record, update record, change, cancel button or 
	 * searchId and searchName radio button
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Search"))
		{
			//call method searchAdmin to search the admin data
			searchAdmin();
		}
		else if(e.getActionCommand().equals("Delete Record"))
		{
			//call method deleteAdmin to delete the admin data
			deleteAdmin();
		}
		else if(e.getActionCommand().equals("Update Record"))
		{
			searchTF.setEditable(false);
			usernameTF.setEditable(true);
			passwordTF.setEditable(true);
			chgBtn.setVisible(true);
			cancelBtn.setVisible(true);
		}
		else if(e.getActionCommand().equals("Change"))
		{
			//call method updateAdmin to update the admin data
			updateAdmin();
			searchTF.setEditable(true);
			usernameTF.setEditable(false);
			passwordTF.setEditable(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			searchTF.setEditable(true);
			usernameTF.setEditable(false);
			passwordTF.setEditable(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
			
			//set the data back to original 
			searchAdmin();
		}
		else if(e.getSource() == searchIdRB)
		{
			searchLabel.setText("Admin ID:");
		}
		else if(e.getSource() == searchNameRB)
		{
			searchLabel.setText("Admin Name:");
		}
		else
		{
			//clear the text field
			adminIdTF.setText(null);
			employeeIdTF.setText(null);
			adminNameTF.setText(null);
			usernameTF.setText(null);
			passwordTF.setText(null);
		}
	}
	
	/**
	 * This is the action performed when user pressed the enter key
	 * on their keyboard
	 */
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			//search the admin
			searchAdmin();
		}
		else
		{
			//clear the text field
			adminIdTF.setText(null);
			employeeIdTF.setText(null);
			adminNameTF.setText(null);
			usernameTF.setText(null);
			passwordTF.setText(null);
		}
	}
	
	/**
	 * This method is to search the admin data from the DBMS using AdminApi and Admin class
	 */
	public void searchAdmin()
	{
		//if the user want to search admin by id
		if(searchIdRB.isSelected())
		{
			try
			{
				Admin admin = new Admin();
				AdminApi adminApi = new AdminApi();
				
				int searchId = 0;
				
				try 
				{
					searchId = Integer.parseInt(searchTF.getText());
				} 
				catch (NumberFormatException e1) 
				{
					String message = "Please enter number!!";
					JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				admin = adminApi.findAdmin(searchId);
				
				String adminId = String.valueOf(admin.getAdminId());
				String employeeId = String.valueOf(admin.getEmployeeId());
				String adminName = admin.getEmployeeName();
				String username = admin.getUsername();
				String password = admin.getPassword();
				
				adminIdTF.setText(adminId);
				employeeIdTF.setText(employeeId);
				adminNameTF.setText(adminName);
				usernameTF.setText(username);
				passwordTF.setText(password);
			}
			catch(AdminNotFoundException adminE)
			{
				String message = adminE.getMessage();
				
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex)
			{
				String message = ex.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
		//if the user want to search the admin by name
		else if(searchNameRB.isSelected())
		{
			try
			{
				Admin admin = new Admin();
				AdminApi adminApi = new AdminApi();
				
				admin = adminApi.findAdmin(searchTF.getText());
				
				String adminId = String.valueOf(admin.getAdminId());
				String employeeId = String.valueOf(admin.getEmployeeId());
				String adminName = admin.getEmployeeName();
				String username = admin.getUsername();
				String password = admin.getPassword();
				
				adminIdTF.setText(adminId);
				employeeIdTF.setText(employeeId);
				adminNameTF.setText(adminName);
				usernameTF.setText(username);
				passwordTF.setText(password);
			}
			catch(AdminNotFoundException adminE)
			{
				String message = adminE.getMessage();
				
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex)
			{
				String message = ex.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * This method is to delete the admin data from the DBMS using AdminApi class
	 */
	public void deleteAdmin()
	{
		try
		{
			AdminApi adminApi = new AdminApi();
			
			int adminId = 0;
			
			try 
			{
				adminId = Integer.parseInt(adminIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				String message = "Please enter number!!";
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
			//make sure that the user is really want to delete the dataq
			int delConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete Confirm", JOptionPane.YES_NO_OPTION);
			
			//if yes
			if(delConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = adminApi.deleteAdmin(adminId);
				
				JOptionPane.showMessageDialog(null, status+" record have been deleted");
				
				adminIdTF.setText(null);
				employeeIdTF.setText(null);
				adminNameTF.setText(null);
				usernameTF.setText(null);
				passwordTF.setText(null);
			}
			else if(delConfirm == JOptionPane.NO_OPTION) //if no
			{
				return;
			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method is to update the admin data in the DBMS using AdminApi and Admin class
	 */
	public void updateAdmin()
	{	
		try
		{
			Admin admin = new Admin();
			AdminApi adminApi = new AdminApi();
			
			int adminId = -1;
			int employeeId = -1;
			
			try 
			{
				adminId = Integer.parseInt(adminIdTF.getText());
				employeeId = Integer.parseInt(employeeIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			}
			
			String adminName = adminNameTF.getText();
			String username = usernameTF.getText();
			String password = passwordTF.getText();
			
			admin.setAdminId(adminId);
			admin.setEmployeeId(employeeId);
			admin.setEmployeeName(adminName);
			admin.setUsername(username);
			admin.setPassword(password);
			
			int updateConfirm = JOptionPane.showConfirmDialog(null, 
														"Are you sure you want to update this record?", 
														"Update Confirm", 
														JOptionPane.YES_NO_OPTION);
			
			if(updateConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = adminApi.updateAdmin(admin);
				
				JOptionPane.showMessageDialog(null, status+" record have been updated");
			}
			else if(updateConfirm == JOptionPane.NO_OPTION)
			{
				return;
			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
}
