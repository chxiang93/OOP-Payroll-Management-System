package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.regex.*;

import payroll.api.*;
import payroll.bean.*;

/**
 * This class is the implementation of the gui of add payroll form
 *
 */
public class AddPayrollForm extends KeyAdapter implements ActionListener {
	
	//These are the declaration of the gui component used in add admin form 
	private JFrame addPayrollF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JLabel payrollTitleLabel;
	private JLabel dateLabel;
	private JLabel deductionLabel;
	private JLabel totalOTLabel;
	private JLabel otSalaryLabel;
	private JLabel taxPaidLabel;
	private JLabel totalSalaryLabel;
	private JLabel employeeIdLabel;
	private JLabel employeeNameLabel;
	private JLabel basicSalaryLabel;
	private JComboBox<Integer> employeeIdCB;
	
	private JTextField payrollTitleTF;
	private JTextField dateTF;
	private JTextField deductionTF;
	private JTextField totalOTTF;
	private JTextField otSalaryTF;
	private JTextField taxPaidTF;
	private JTextField totalSalaryTF;
	private JTextField employeeNameTF;
	private JTextField basicSalaryTF;
	
	private JButton resetBtn;
	private JButton saveBtn;
	private JButton calculateBtn;
	
	/**
	 * This is the constructor of class AddPayrollForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public AddPayrollForm()
	{	
		addPayrollF = new JFrame("Payroll Management System");
		
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
		centerPanel.setLayout(new GridLayout(10,2));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Add Payroll",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		payrollTitleLabel = new JLabel("Payroll Title:");
		dateLabel = new JLabel("Payroll Date (YYYY-MM-DD):");
		deductionLabel = new JLabel("Deduction(RM):");
		totalOTLabel = new JLabel("Total Over Time:");
		otSalaryLabel = new JLabel("OT Salary(RM):");
		taxPaidLabel = new JLabel("Tax Paid(RM):");
		totalSalaryLabel = new JLabel("Total Salary(RM):");
		employeeIdLabel = new JLabel("Employee ID:");
		employeeNameLabel = new JLabel("Employee Name:");
		basicSalaryLabel = new JLabel("Basic Salary(RM):");
		
		payrollTitleTF = new JTextField();
		payrollTitleTF.setBorder(BorderFactory.createLoweredBevelBorder());
		dateTF = new JTextField();
		dateTF.setBorder(BorderFactory.createLoweredBevelBorder());
		deductionTF = new JTextField();
		deductionTF.setBorder(BorderFactory.createLoweredBevelBorder());
		totalOTTF = new JTextField();
		totalOTTF.setBorder(BorderFactory.createLoweredBevelBorder());
		otSalaryTF = new JTextField();
		otSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		otSalaryTF.setEditable(false);
		taxPaidTF = new JTextField();
		taxPaidTF.setBorder(BorderFactory.createLoweredBevelBorder());
		taxPaidTF.setEditable(false);
		totalSalaryTF = new JTextField();
		totalSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		totalSalaryTF.setEditable(false);
		employeeNameTF = new JTextField();
		employeeNameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeNameTF.setEditable(false);
		employeeIdCB = new JComboBox<Integer>(getAvailableEmployeeId());
		employeeIdCB.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIdCB.setSelectedIndex(-1);
		employeeIdCB.addActionListener(this);
		basicSalaryTF = new JTextField();
		basicSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		basicSalaryTF.setEditable(false);
		
		centerPanel.add(payrollTitleLabel);
		centerPanel.add(payrollTitleTF);
		centerPanel.add(employeeIdLabel);
		centerPanel.add(employeeIdCB);
		centerPanel.add(employeeNameLabel);
		centerPanel.add(employeeNameTF);
		centerPanel.add(basicSalaryLabel);
		centerPanel.add(basicSalaryTF);
		centerPanel.add(dateLabel);
		centerPanel.add(dateTF);
		centerPanel.add(deductionLabel);
		centerPanel.add(deductionTF);
		centerPanel.add(totalOTLabel);
		centerPanel.add(totalOTTF);
		centerPanel.add(otSalaryLabel);
		centerPanel.add(otSalaryTF);
		centerPanel.add(taxPaidLabel);
		centerPanel.add(taxPaidTF);
		centerPanel.add(totalSalaryLabel);
		centerPanel.add(totalSalaryTF);
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		calculateBtn = new JButton();
		calculateBtn.setText("Calculate");
		calculateBtn.addActionListener(this);
		calculateBtn.setPreferredSize(new Dimension(100,30));
		calculateBtn.setFocusable(false);
		
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(150,100));
		eastPanel.add(calculateBtn);
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(150,100));
		
		resetBtn = new JButton();
		resetBtn.setText("Reset");
		resetBtn.addActionListener(this);
		resetBtn.setFocusable(false);
		saveBtn = new JButton();
		saveBtn.setText("Save Record");
		saveBtn.addActionListener(this);
		saveBtn.setEnabled(false);
		saveBtn.setFocusable(false);
		
		resetBtn.setPreferredSize(new Dimension(120,50));
		saveBtn.setPreferredSize(new Dimension(120,50));
		
		southPanel = new JPanel();
		southPanel.add(resetBtn);
		southPanel.add(saveBtn);
	//***********************************************************************************
		
		//add all the component to the frame
		addPayrollF.setLayout(new BorderLayout(0,10));
		addPayrollF.setSize(700,550);
		addPayrollF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addPayrollF.add(northPanel, BorderLayout.NORTH);
		addPayrollF.add(centerPanel, BorderLayout.CENTER);
		addPayrollF.add(eastPanel, BorderLayout.EAST);
		addPayrollF.add(westPanel, BorderLayout.WEST);
		addPayrollF.add(southPanel, BorderLayout.SOUTH);
		addPayrollF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the reset, 
	 * save record, calculate button or employeeId combo box
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Reset"))
		{
			payrollTitleTF.setText(null);
			dateTF.setText(null);
			deductionTF.setText(null);
			totalOTTF.setText(null);
			basicSalaryTF.setText(null);
			otSalaryTF.setText(null);
			taxPaidTF.setText(null);
			totalSalaryTF.setText(null);
			employeeNameTF.setText(null);
			employeeNameTF.setText(null);
			basicSalaryTF.setText(null);
		}
		else if(e.getActionCommand().equals("Save Record"))
		{
			//call saveAdmin method to save the payroll data
			savePayroll();
			saveBtn.setEnabled(false);
		}
		else if(e.getActionCommand().equals("Calculate"))
		{
			double deduction = 0;
			double totalOT = 0;
			
			deduction = Double.parseDouble(deductionTF.getText());
			totalOT = Double.parseDouble(totalOTTF.getText());
			
			Payroll payroll = new Payroll();
			payroll.setDeduction(deduction);
			payroll.setTotalOverTime(totalOT);
			
			EmployeeApi employeeApi = new EmployeeApi();
			int id = (int)employeeIdCB.getSelectedItem();
			Employee employee = null;
			
			try
			{
				employee = employeeApi.findEmployee(id);
				
			}
			catch(Exception ex)
			{
				String message = ex.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			
			//calculate the ot salary, tax paid and total salary
			String otSalary = String.valueOf(payroll.calculateOTSalary(employee));
			String taxPaid = String.valueOf(payroll.calculateTax(employee));
			String totalSalary = String.valueOf(payroll.calculateTotalSalary(employee));
			
			otSalaryTF.setText(otSalary);
			taxPaidTF.setText(taxPaid);
			totalSalaryTF.setText(totalSalary);
			
			//the salary that needed to save the data is calculated
			//user can now save the data
			saveBtn.setEnabled(true);
		}
		else if(e.getSource() == employeeIdCB)
		{
			//the pair of data of employee id refer to employee name is retrieved
			HashMap<Integer,String> employeeIdName = getEmployeeIdName();
			
			//get the id selected from the combo box
			int id = (int)employeeIdCB.getSelectedItem();
			//get name
			String name = employeeIdName.get(id);
			
			try
			{
				Employee employee = new EmployeeApi().findEmployee(id);
				
				//show basic salary
				basicSalaryTF.setText(String.valueOf(employee.getEmployeeSalary()));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			//show name
			employeeNameTF.setText(name);
		}
	}
	
	/**
	 * This method is to save the payroll data to the DBMS using PayrollApi and Payroll class
	 */
	public void savePayroll()
	{
		try
		{
			Payroll payroll = new Payroll();
			PayrollApi payrollApi = new PayrollApi();
			
			int saveConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to save this record?", "Delete Confirm", JOptionPane.YES_NO_OPTION);
			
			if(saveConfirm == JOptionPane.YES_OPTION)
			{
				String regexDate = "^(\\d{4})-(\\d{1,2})-(\\d{1,2})$";
				Pattern patternDate = Pattern.compile(regexDate);
				Matcher matcherDate = patternDate.matcher(dateTF.getText());
				
				if(matcherDate.matches() == false)
				{
					String message = "The format of date is wrong!! Please enter the date in format (YYYY-MM-DD)";
					JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String employeeId = String.valueOf(employeeIdCB.getSelectedItem());
				
				payroll.setPayrollTitle(payrollTitleTF.getText());
				payroll.setPayrollEmployeeId(Integer.parseInt(employeeId));
				payroll.setPayrollDate(Date.valueOf(dateTF.getText()));
				payroll.setDeduction(Double.parseDouble(deductionTF.getText()));
				payroll.setTotalOverTime(Double.parseDouble(totalOTTF.getText()));
				payroll.setOTSalary(Double.parseDouble(otSalaryTF.getText()));
				payroll.setTaxPaid(Double.parseDouble(taxPaidTF.getText()));
				payroll.setTotalSalary(Double.parseDouble(totalSalaryTF.getText()));
				
				int status = payrollApi.addPayroll(payroll);
				
				JOptionPane.showMessageDialog(null, status+" record have been saved");
				
				payrollTitleTF.setText(null);
				dateTF.setText(null);
				deductionTF.setText(null);
				totalOTTF.setText(null);
				basicSalaryTF.setText(null);
				otSalaryTF.setText(null);
				taxPaidTF.setText(null);
				totalSalaryTF.setText(null);
				employeeNameTF.setText(null);
				employeeNameTF.setText(null);
				basicSalaryTF.setText(null);
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
	
	/**
	 * This method will return the array of employee id available in the DBMS
	 * @return Integer[]
	 */
	public Integer[] getAvailableEmployeeId()
	{
		Integer[] employeeId = null;
		HashMap<Integer,String> employeeIdName = null;
		
		try
		{
			employeeIdName = getEmployeeIdName();
			
			employeeId = new Integer[employeeIdName.size()];
			
			int index = 0;
			for(int id: employeeIdName.keySet())
			{
				employeeId[index] = id;
				index++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return employeeId;
	}
	
	/**
	 * This method will return the pair of data that contain the key value data set 
	 * that the employee name is defined by their employee id
	 * @return HashMap<Integer,String>
	 */
	public HashMap<Integer,String> getEmployeeIdName()
	{
		HashMap<Integer,String> employeeIdName = null;
		
		try
		{
			EmployeeApi api = new EmployeeApi();
			employeeIdName = api.getEmployeeIdName();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return employeeIdName;
	}
}
