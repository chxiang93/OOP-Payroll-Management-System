package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.regex.*;
import java.sql.Date;

import payroll.api.*;
import payroll.bean.*;

/**
 * This class is the implementation of the gui of add employee form
 *
 */
public class AddEmployeeForm implements ActionListener {
	
	//Declaration of the GUI component used in add employee form 
	private JFrame addEmployeeF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JPanel genderPanel;
	
	// declaration for label
	private JLabel titleLabel;
	private JLabel employeeNameLabel;
	private JLabel employeeIcLabel;
	private JLabel employeeGenderLabel;
	private JLabel employeePhoneLabel;
	private JLabel employeeAddressLabel;
	private JLabel employeeEmailLabel;
	private JLabel employeeSalaryLabel;
	private JLabel employeeDateHiredLabel;
	private JLabel employeeOTRateLabel;	
	
	//declaration for text field
	private JTextField employeeNameTF;
	private JTextField employeeIcTF;
	private JTextField employeePhoneTF;
	private JTextField employeeAddressTF;
	private JTextField employeeEmailTF;
	private JTextField employeeSalaryTF;
	private JTextField employeeDateHiredTF;
	private JTextField employeeOTRateTF;
	
	private JRadioButton maleRB;
	private JRadioButton femaleRB;
	
	private JButton resetBtn;
	private JButton saveBtn;
	
	
	/**
	 * This is the constructor of class AddEmployeeForm 	 
	 */
	public AddEmployeeForm()
	{	
		addEmployeeF = new JFrame("Payroll Management System");
				
	//*******************************North Panel**********************************
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
		
	//*******************************Center Panel****************************************
		centerPanel = new JPanel();
		
		employeeNameLabel = new JLabel("Employee Name:");
		employeeIcLabel = new JLabel("Employee IC:");
		employeeGenderLabel = new JLabel("Employee Gender:");
		employeePhoneLabel = new JLabel("Employee Phone No:");
		employeeAddressLabel = new JLabel("Employee Address:");
		employeeEmailLabel = new JLabel("Employee Email:");
		employeeSalaryLabel = new JLabel("Employee Basic Salary:");
		employeeDateHiredLabel = new JLabel("Date Hired (YYYY-MM-DD):");
		employeeOTRateLabel = new JLabel("OT Rate Per Hour:");
		
		//getAvailableEmployeeName()
		employeeNameTF = new JTextField();
		//employeeNameTF.addActionListener(this);
	//	employeeNameTF.setSelectedIndex(-1);
		employeeNameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeIcTF = new JTextField();
		employeeIcTF.setBorder(BorderFactory.createLoweredBevelBorder());
				
		employeePhoneTF = new JTextField();
		employeePhoneTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeAddressTF = new JTextField();
		employeeAddressTF.setBorder(BorderFactory.createLoweredBevelBorder());

		employeeEmailTF = new JTextField();
		employeeEmailTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeSalaryTF = new JTextField();
		employeeSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeDateHiredTF = new JTextField();
		employeeDateHiredTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeOTRateTF = new JTextField();
		employeeOTRateTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		maleRB = new JRadioButton();
		maleRB.setText("male");
		maleRB.setFocusable(false);
		femaleRB = new JRadioButton();
		femaleRB.setText("female");
		femaleRB.setFocusable(false);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleRB);
		genderGroup.add(femaleRB);
		
		genderPanel = new JPanel();
		genderPanel.add(maleRB);
		genderPanel.add(femaleRB);
		
		centerPanel.setLayout(new GridLayout(9,2));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Add Employee",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		centerPanel.add(employeeNameLabel);
		centerPanel.add(employeeNameTF);	
		
		centerPanel.add(employeeIcLabel);
		centerPanel.add(employeeIcTF);
		
		centerPanel.add(employeeGenderLabel);
		centerPanel.add(genderPanel);
				
		centerPanel.add(employeePhoneLabel);
		centerPanel.add(employeePhoneTF);
		
		centerPanel.add(employeeAddressLabel);
		centerPanel.add(employeeAddressTF);
		
		centerPanel.add(employeeEmailLabel);
		centerPanel.add(employeeEmailTF);
		
		centerPanel.add(employeeSalaryLabel);
		centerPanel.add(employeeSalaryTF);
		
		centerPanel.add(employeeDateHiredLabel);
		centerPanel.add(employeeDateHiredTF);
		
		centerPanel.add(employeeOTRateLabel);
		centerPanel.add(employeeOTRateTF);
		
	//***********************************************************************************
		
	//****************************East,West,South Panel**********************************
	
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(130,100));
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(130,100));
		
		resetBtn = new JButton();
		resetBtn.setText("Reset");
		resetBtn.addActionListener(this);
		resetBtn.setFocusable(false);
		
		saveBtn = new JButton();
		saveBtn.setText("Save Record");
		saveBtn.addActionListener(this);
		saveBtn.setFocusable(false);
		
		resetBtn.setPreferredSize(new Dimension(120,50));
		saveBtn.setPreferredSize(new Dimension(120,50));
		
		southPanel = new JPanel();
		southPanel.add(resetBtn);
		southPanel.add(saveBtn);
		
	//***********************************************************************************
		
		//add all component inside frame 
		addEmployeeF.setLayout(new BorderLayout(0,10));
		addEmployeeF.setSize(700,550);
		addEmployeeF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addEmployeeF.add(northPanel, BorderLayout.NORTH);
		addEmployeeF.add(centerPanel, BorderLayout.CENTER);
		addEmployeeF.add(eastPanel, BorderLayout.EAST);
		addEmployeeF.add(westPanel, BorderLayout.WEST);
		addEmployeeF.add(southPanel, BorderLayout.SOUTH);
		addEmployeeF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the reset and save
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Reset"))
		{
			employeeNameTF.setText(null);
			employeeIcTF.setText(null);
			employeePhoneTF.setText(null);
			employeeAddressTF.setText(null);
			employeeEmailTF.setText(null);
			employeeSalaryTF.setText(null);
			employeeDateHiredTF.setText(null);
			employeeOTRateTF.setText(null);
		}
		else if(e.getActionCommand().equals("Save Record"))
		{
			//call saveEmployee method to save the data
			saveEmployee();
		}
	}
	
	/**
	 * This method is to save the employee data to the DBMS 
	 */
	public void saveEmployee()
	{
		try
		{
			Employee employee = new Employee();
			EmployeeApi employeeApi = new EmployeeApi();
			
			//make sure the user want to save the data
			int saveConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to save this record?", "Save Confirm", JOptionPane.YES_NO_OPTION);
			
			if(saveConfirm == JOptionPane.YES_OPTION)
			{
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
				
				employee.setEmployeeName(employeeNameTF.getText());
				employee.setEmployeeIdentificationCardNo(employeeIcTF.getText());  
				employee.setEmployeePhoneNo(employeePhoneTF.getText());
				employee.setEmployeeAddress(employeeAddressTF.getText());
				employee.setEmployeeEmail(employeeEmailTF.getText());
				employee.setEmployeeSalary(Double.parseDouble(employeeSalaryTF.getText()));
				employee.setEmployeeDateHired(Date.valueOf(employeeDateHiredTF.getText()));
				employee.setEmployeeOTRatePerHour(Double.parseDouble(employeeOTRateTF.getText()));
				
				if(maleRB.isSelected())
				{
					employee.setEmployeeGender(maleRB.getText());
				}
				else if(femaleRB.isSelected())
				{
					employee.setEmployeeGender(femaleRB.getText());
				}
				
				int status = employeeApi.addEmployee(employee);
				
				JOptionPane.showMessageDialog(null, status+" record have been saved");
				
				employeeNameTF.setText(null);
				employeeIcTF.setText(null);
				employeePhoneTF.setText(null);
				employeeAddressTF.setText(null);
				employeeEmailTF.setText(null);
				employeeSalaryTF.setText(null);
				employeeDateHiredTF.setText(null);
				employeeOTRateTF.setText(null);
				
			}
			else if(saveConfirm == JOptionPane.NO_OPTION)
			{
				return;
			}
		}
		catch(Exception ex)
		{
			//show a pop up window that print the error message
			String message = ex.getMessage();
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
}