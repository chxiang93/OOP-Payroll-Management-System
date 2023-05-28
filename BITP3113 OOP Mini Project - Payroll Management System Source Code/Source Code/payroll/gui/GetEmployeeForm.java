package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

import payroll.api.*;
import payroll.bean.*;

/**
 * This class is the implementation of the gui of get employee form
 *
 */
public class GetEmployeeForm {
	
	//Declaration of the GUI component used in get employee form 
	private JFrame getEmployeeF;
	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JTable table;
	private JScrollPane sp;
	
	
	/**
	 * This is the constructor of class GetEmployeeForm
	 */
	public GetEmployeeForm()
	{
		getEmployeeF = new JFrame("Payroll Management System");
		
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
		
	//*************************Table*********************************
		table = new JTable(getData(), getColumns());
		table.setPreferredSize(new Dimension(460,350));
		table.setFillsViewportHeight(true);
		
		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(460,350));
		sp.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"View All Employee",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
	//***********************************************************************************
		
	//*****************************East,West,South Panel*********************************
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(50,100));
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(50,100));
		southPanel = new JPanel();
	//***********************************************************************************
		
		//add all component inside frame 
		getEmployeeF.setLayout(new BorderLayout(0,30));
		getEmployeeF.setSize(700,550);
		getEmployeeF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getEmployeeF.add(northPanel, BorderLayout.NORTH);
		getEmployeeF.add(sp, BorderLayout.CENTER);
		getEmployeeF.add(eastPanel, BorderLayout.EAST);
		getEmployeeF.add(westPanel, BorderLayout.WEST);
		getEmployeeF.add(southPanel, BorderLayout.SOUTH);
		getEmployeeF.setVisible(true);
	}

	/**
	 * This method get the columns that exist in the DBMS
	 * @return String[]
	 */
	public String[] getColumns()
	{
		String[] columns = {"Employee_Id", "Employee_Name", "Employee_Ic", "Employee_Gender", "Employee_Phone", "Employee_Address", "Employee_Email", "Employee_Basic_Salary", "Employee_DateHired", "Employee_OTRate"};
		
		return columns;
	}
	
	/**
	 * This method will get all the data of employee 
	 * @return String[][]
	 */
	public String[][] getData()
	{
		String[][] data = null;
		
		//using try method
		try
		{
			EmployeeApi employeeApi = new EmployeeApi();
			
			ArrayList<Employee> employeeList = employeeApi.getEmployee();
			int rows = employeeList.size();
			int columns = getColumns().length;
			data = new String[rows][columns];
			
			int index = 0;
			for(Employee employee: employeeList)
			{
				String employeeId = String.valueOf(employee.getEmployeeId());
				String employeeName = employee.getEmployeeName();
				String employeeIC = employee.getEmployeeIdentificationCardNo();
				String employeeGender = employee.getEmployeeGender();
				String employeePhone = employee.getEmployeePhoneNo();
				String employeeAddress = employee.getEmployeeAddress();
				String employeeEmail = employee.getEmployeeEmail();
				String employeeSalary = String.valueOf(employee.getEmployeeSalary());
				String employeeDateHired = String.valueOf(employee.getEmployeeDateHired());
				String employeeOTRate = String.valueOf(employee.getEmployeeOTRatePerHour());
				
				data[index][0] = employeeId;
				data[index][1] = employeeName;
				data[index][2] = employeeIC;
				data[index][3] = employeeGender;
				data[index][4] = employeePhone;
				data[index][5] = employeeAddress;
				data[index][6] = employeeEmail;
				data[index][7] = employeeSalary;
				data[index][8] = employeeDateHired;
				data[index][9] = employeeOTRate;
				
				index++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
}
