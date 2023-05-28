package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.sql.Date;
import java.util.regex.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import payroll.bean.*;
import payroll.api.*;

/**
 * Implementation of the gui of find employee form
 *
 */
public class FindEmployeeForm extends KeyAdapter implements ActionListener {
	
	//Declaration of the GUI component that used in find employee form 
	private JFrame findEmployeeF;
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
	
	//declaration of JRbutton
	private JRadioButton searchIdRB;
	private JRadioButton searchNameRB;
	
	//declaration of label
	private JLabel searchTypeLabel;
	private JLabel searchLabel;
	private JLabel employeeIdLabel;
	private JLabel employeeNameLabel;
	private JLabel employeeIcLabel;
	private JLabel employeeGenderLabel;
	private JLabel employeePhoneLabel;
	private JLabel employeeAddressLabel;
	private JLabel employeeEmailLabel;
	private JLabel employeeSalaryLabel;
	private JLabel employeeDateHiredLabel;
	private JLabel employeeOTRateLabel;

	//declaration of Text Field
	private JTextField searchTF;
	private JTextField employeeIdTF;
	private JTextField employeeNameTF;
	private JTextField employeeIcTF;
	private JTextField employeeGenderTF;
	private JTextField employeePhoneTF;
	private JTextField employeeAddressTF;
	private JTextField employeeEmailTF;
	private JTextField employeeSalaryTF;
	private JTextField employeeDateHiredTF;
	private JTextField employeeOTRateTF;

	//declaration of Jbutton
	private JButton searchBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton chgBtn;
	private JButton cancelBtn;
	

	/**
	 * This is the constructor of class FindEmployeeForm
	 */
	public FindEmployeeForm()
	{
		findEmployeeF = new JFrame("Payroll Management System");
		
	//*************************North Panel**********************************
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
		
	//*************************Center Panel*********************************
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout(0,5));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Search Employee",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		searchIdRB = new JRadioButton();
		searchIdRB.setText("Employee id");
		searchIdRB.addActionListener(this);
		searchIdRB.setFocusable(false);
		
		searchNameRB = new JRadioButton();
		searchNameRB.setText("Employee name");
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
		
		searchLabel = new JLabel("Employee ID:");
		
		searchPanel = new JPanel();
		searchPanel.add(searchLabel);
		searchPanel.add(searchTF);
		searchPanel.add(searchBtn);
		
		centerNorthPanel = new JPanel();
		centerNorthPanel.setLayout(new GridLayout(2,1));
		centerNorthPanel.add(searchTypePanel);
		centerNorthPanel.add(searchPanel);
		
		centerDisplayPanel = new JPanel();
		centerDisplayPanel.setLayout(new GridLayout(10,2));
		
		employeeIdLabel = new JLabel("Employee ID:");
		employeeNameLabel = new JLabel("Employee Name:");
		employeeIcLabel = new JLabel("Employee IC:");
		employeeGenderLabel = new JLabel("Employee Gender:");
		employeePhoneLabel = new JLabel("Employee Phone No:");
		employeeAddressLabel = new JLabel("Employee Address:");
		employeeEmailLabel = new JLabel("Employee Email:");
		employeeSalaryLabel = new JLabel("Employee Basic Salary:");
		employeeDateHiredLabel = new JLabel("Date Hired (YYYY-MM-DD):");
		employeeOTRateLabel = new JLabel("OT Rate Per Hour:");
		
		employeeIdTF = new JTextField();
		employeeIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIdTF.setEditable(false);
		
		employeeNameTF = new JTextField();
		employeeNameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeNameTF.setEditable(false);
		
		employeeIcTF = new JTextField();
		employeeIcTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIcTF.setEditable(false);
		
		employeeGenderTF = new JTextField();
		employeeGenderTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeGenderTF.setEditable(false);
		
		employeePhoneTF = new JTextField();
		employeePhoneTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeePhoneTF.setEditable(false);
		
		employeeAddressTF = new JTextField();
		employeeAddressTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeAddressTF.setEditable(false);

		employeeEmailTF = new JTextField();
		employeeEmailTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeEmailTF.setEditable(false);
		
		employeeSalaryTF = new JTextField();
		employeeSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeSalaryTF.setEditable(false);
		
		employeeDateHiredTF = new JTextField();
		employeeDateHiredTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeDateHiredTF.setEditable(false);
		
		employeeOTRateTF = new JTextField();
		employeeOTRateTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeOTRateTF.setEditable(false);
		
		centerDisplayPanel.add(employeeIdLabel);
		centerDisplayPanel.add(employeeIdTF);
		
		centerDisplayPanel.add(employeeNameLabel);
		centerDisplayPanel.add(employeeNameTF);	
		
		centerDisplayPanel.add(employeeIcLabel);
		centerDisplayPanel.add(employeeIcTF);
		
		centerDisplayPanel.add(employeeGenderLabel);
		centerDisplayPanel.add(employeeGenderTF);
				
		centerDisplayPanel.add(employeePhoneLabel);
		centerDisplayPanel.add(employeePhoneTF);
		
		centerDisplayPanel.add(employeeAddressLabel);
		centerDisplayPanel.add(employeeAddressTF);
		
		centerDisplayPanel.add(employeeEmailLabel);
		centerDisplayPanel.add(employeeEmailTF);
		
		centerDisplayPanel.add(employeeSalaryLabel);
		centerDisplayPanel.add(employeeSalaryTF);
		
		centerDisplayPanel.add(employeeDateHiredLabel);
		centerDisplayPanel.add(employeeDateHiredTF);
		
		centerDisplayPanel.add(employeeOTRateLabel);
		centerDisplayPanel.add(employeeOTRateTF);
		
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerPanel.add(centerDisplayPanel, BorderLayout.CENTER);
	//***********************************************************************************
		
	//*****************************East,West,South Panel*********************************
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
		findEmployeeF.setLayout(new BorderLayout(0,5));
		findEmployeeF.setSize(700,600);
		findEmployeeF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		findEmployeeF.add(northPanel, BorderLayout.NORTH);
		findEmployeeF.add(centerPanel, BorderLayout.CENTER);
		findEmployeeF.add(eastPanel, BorderLayout.EAST);
		findEmployeeF.add(westPanel, BorderLayout.WEST);
		findEmployeeF.add(southPanel, BorderLayout.SOUTH);
		findEmployeeF.setVisible(true);
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
			//call method searchEmployee to search data
			searchEmployee();
		}
		else if(e.getActionCommand().equals("Delete Record"))
		{
			//call method deleteEmployee to delete data
			deleteEmployee();
		}
		else if(e.getActionCommand().equals("Update Record"))
		{
			searchTF.setEditable(false);
			employeeNameTF.setEditable(true);
			employeePhoneTF.setEditable(true);
			employeeAddressTF.setEditable(true);
			employeeEmailTF.setEditable(true);
			employeeSalaryTF.setEditable(true);
			employeeDateHiredTF.setEditable(true);
			employeeOTRateTF.setEditable(true);
			chgBtn.setVisible(true);
			cancelBtn.setVisible(true);
		}
		else if(e.getActionCommand().equals("Change"))
		{
			//call method updateEmployee to update data
			updateEmployee();
			searchTF.setEditable(true);
			employeeNameTF.setEditable(false);
			employeePhoneTF.setEditable(false);
			employeeAddressTF.setEditable(false);
			employeeEmailTF.setEditable(false);
			employeeSalaryTF.setEditable(false);
			employeeDateHiredTF.setEditable(false);
			employeeOTRateTF.setEditable(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			searchTF.setEditable(true);
			employeeNameTF.setEditable(false);
			employeePhoneTF.setEditable(false);
			employeeAddressTF.setEditable(false);
			employeeEmailTF.setEditable(false);
			employeeSalaryTF.setEditable(false);
			employeeDateHiredTF.setEditable(false);
			employeeOTRateTF.setEditable(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
			
			//set the data back to original 
			searchEmployee();
		}
		else if(e.getSource() == searchIdRB)
		{
			searchLabel.setText("Employee ID:");
		}
		else if(e.getSource() == searchNameRB)
		{
			searchLabel.setText("Employee Name:");
		}
		else
		{
			//clear the text field
			employeeIdTF.setText(null);
			employeeNameTF.setText(null);
			employeeIcTF.setText(null);
			employeeGenderTF.setText(null);
			employeePhoneTF.setText(null);
			employeeAddressTF.setText(null);
			employeeEmailTF.setText(null);
			employeeSalaryTF.setText(null);
			employeeDateHiredTF.setText(null);
			employeeOTRateTF.setText(null);
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
			//search employee
			searchEmployee();
		}
		else
		{
			//clear the text field
			employeeIdTF.setText(null);
			employeeNameTF.setText(null);
			employeeIcTF.setText(null);
			employeeGenderTF.setText(null);
			employeePhoneTF.setText(null);
			employeeAddressTF.setText(null);
			employeeEmailTF.setText(null);
			employeeSalaryTF.setText(null);
			employeeDateHiredTF.setText(null);
			employeeOTRateTF.setText(null);
		}
	}
	
	/**
	 * This method is to search the employee data from the DBMS 
	 */
	public void searchEmployee()
	{
		//if the user want to search employee by id
		if(searchIdRB.isSelected())
		{
			try
			{
				Employee employee = new Employee();
				EmployeeApi employeeApi = new EmployeeApi();
				
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
				
				employee= employeeApi.findEmployee(searchId);
				
				String employeeId = String.valueOf(employee.getEmployeeId());
				String employeeName = employee.getEmployeeName();
				String employeeIc = employee.getEmployeeIdentificationCardNo();
				String employeeGender = employee.getEmployeeGender();
				String employeePhone = employee.getEmployeePhoneNo();
				String employeeAddress = employee.getEmployeeAddress();
				String employeeEmail = employee.getEmployeeEmail();
				String employeeSalary = String.valueOf(employee.getEmployeeSalary());
				String employeeDateHired = String.valueOf(employee.getEmployeeDateHired());
				String employeeOTRate = String.valueOf(employee.getEmployeeOTRatePerHour());
				
				employeeIdTF.setText(employeeId);
				employeeNameTF.setText(employeeName);
				employeeIcTF.setText(employeeIc);
				employeeGenderTF.setText(employeeGender);
				employeePhoneTF.setText(employeePhone);
				employeeAddressTF.setText(employeeAddress);
				employeeEmailTF.setText(employeeEmail);
				employeeSalaryTF.setText(employeeSalary);
				employeeDateHiredTF.setText(employeeDateHired);
				employeeOTRateTF.setText(employeeOTRate);
			}
			catch(EmployeeNotFoundException employeeE)
			{
				String message = employeeE.getMessage();
				
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex)
			{
				String message = ex.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
		//if the user want to search the employee by name
		else if(searchNameRB.isSelected())
		{
			try
			{
				Employee employee = new Employee();
				EmployeeApi employeeApi = new EmployeeApi();
				
				employee = employeeApi.findEmployee(searchTF.getText());
				
				String employeeId = String.valueOf(employee.getEmployeeId());
				String employeeName = employee.getEmployeeName();
				String employeeIc = employee.getEmployeeIdentificationCardNo();
				String employeeGender = employee.getEmployeeGender();
				String employeePhone = employee.getEmployeePhoneNo();
				String employeeAddress = employee.getEmployeeAddress();
				String employeeEmail = employee.getEmployeeEmail();
				String employeeSalary = String.valueOf(employee.getEmployeeSalary());
				String employeeDateHired = String.valueOf(employee.getEmployeeDateHired());
				String employeeOTRate = String.valueOf(employee.getEmployeeOTRatePerHour());
				
				employeeIdTF.setText(employeeId);
				employeeNameTF.setText(employeeName);
				employeeIcTF.setText(employeeIc);
				employeeGenderTF.setText(employeeGender);
				employeePhoneTF.setText(employeePhone);
				employeeAddressTF.setText(employeeAddress);
				employeeEmailTF.setText(employeeEmail);
				employeeSalaryTF.setText(employeeSalary);
				employeeDateHiredTF.setText(employeeDateHired);
				employeeOTRateTF.setText(employeeOTRate);
			}
			catch(EmployeeNotFoundException employeeE)
			{
				String message = employeeE.getMessage();
				
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
	 * This method is to delete employee data from the DBMS 
	 */
	public void deleteEmployee()
	{
		try
		{
			EmployeeApi employeeApi = new EmployeeApi();
			
			int employeeId = 0;
			
			try 
			{
				employeeId = Integer.parseInt(employeeIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				String message = "Please enter number!!";
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
			//double make sure that the user want to delete the data
			int delConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete Confirm", JOptionPane.YES_NO_OPTION);
			
			//if choose yes
			if(delConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = employeeApi.deleteEmployee(employeeId);
				
				JOptionPane.showMessageDialog(null, status+" record have been deleted");
				
				employeeIdTF.setText(null);
				employeeNameTF.setText(null);
				employeeIcTF.setText(null);
				employeeGenderTF.setText(null);
				employeePhoneTF.setText(null);
				employeeAddressTF.setText(null);
				employeeEmailTF.setText(null);
				employeeSalaryTF.setText(null);
				employeeDateHiredTF.setText(null);
				employeeOTRateTF.setText(null);
			}
			else if(delConfirm == JOptionPane.NO_OPTION) //if choose no
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
	 * This method is to update the employee data in the DBMS 
	 */
	public void updateEmployee()
	{	
		try
		{
			Employee employee = new Employee();
			EmployeeApi employeeApi = new EmployeeApi();
			
			int employeeId = -1;
			
			try 
			{
				employeeId = Integer.parseInt(employeeIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			}
			
			//this is function used to check if a email is valid
			String regex = "^\\w(.+)@(.+)\\.(.+)$";
			Pattern patternEmail = Pattern.compile(regex);
			Matcher matcher = patternEmail.matcher(employeeEmailTF.getText());
			
			if(matcher.matches() == false)
			{
				String message = "The email is invalid!!";
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			//this is the function to check if the date is valid 
			String regexDate = "^(\\d{4})-(\\d{1,2})-(\\d{1,2})$";
			Pattern patternDate = Pattern.compile(regexDate);
			Matcher matcherDate = patternDate.matcher(employeeDateHiredTF.getText());
			
			if(matcherDate.matches() == false)
			{
				String message = "The format of date is wrong!! Please enter the date in format (YYYY-MM-DD)";
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			employee.setEmployeeId(employeeId);
			employee.setEmployeeName(employeeNameTF.getText());
			employee.setEmployeeIdentificationCardNo(employeeIcTF.getText());
			employee.setEmployeeGender(employeeGenderTF.getText());
			employee.setEmployeePhoneNo(employeePhoneTF.getText());
			employee.setEmployeeAddress(employeeAddressTF.getText());
			employee.setEmployeeEmail(employeeEmailTF.getText());
			employee.setEmployeeSalary(Double.parseDouble(employeeSalaryTF.getText()));
			employee.setEmployeeDateHired(Date.valueOf(employeeDateHiredTF.getText()));
			employee.setEmployeeOTRatePerHour(Double.parseDouble(employeeOTRateTF.getText()));
								
			//make sure user want to update the data
			int updateConfirm = JOptionPane.showConfirmDialog(null, 
														"Are you sure you want to update this record?", 
														"Update Confirm", 
														JOptionPane.YES_NO_OPTION);
			
			//if yes
			if(updateConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = employeeApi.updateEmployee(employee);
				
				JOptionPane.showMessageDialog(null, status+" record have been updated");
			}
			else if(updateConfirm == JOptionPane.NO_OPTION)	//if no
			{
				return;
			}
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
			JOptionPane.showMessageDialog(null, message, "Error !!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
}
