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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import payroll.api.*;
import payroll.bean.*;

/**
 * This class is the implementation of the gui of find payroll form
 *
 */
public class FindPayrollForm extends KeyAdapter implements ActionListener {
	
	//These are the declaration of the gui component used in find payroll form 
	private JFrame findPayrollF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	private JPanel centerNorthPanel;
	private JPanel centerDisplayPanel;
	private JPanel searchPanel;

	private JLabel searchLabel;
	private JLabel payrollIdLabel;
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
	
	private JTextField searchTF;
	private JTextField payrollIdTF;
	private JTextField payrollTitleTF;
	private JTextField dateTF;
	private JTextField deductionTF;
	private JTextField totalOTTF;
	private JTextField otSalaryTF;
	private JTextField taxPaidTF;
	private JTextField totalSalaryTF;
	private JTextField employeeNameTF;
	private JTextField basicSalaryTF;
	private JTextField employeeIdTF;
	
	private JButton searchBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton chgBtn;
	private JButton cancelBtn;
	private JButton calculateBtn;
	
	/**
	 * This is the constructor of class FindPayrollForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public FindPayrollForm()
	{	
		findPayrollF = new JFrame("Payroll Management System");
		
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
		centerPanel.setLayout(new BorderLayout(0,5));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Search Payroll",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		searchBtn = new JButton();
		searchBtn.setText("Search");
		searchBtn.addActionListener(this);
		searchBtn.setPreferredSize(new Dimension(110,30));
		searchBtn.setFocusable(false);
		
		searchLabel = new JLabel("Payroll ID:");
		
		searchTF = new JTextField();
		searchTF.setPreferredSize(new Dimension(150,30));
		searchTF.addKeyListener(this);
		
		searchPanel = new JPanel();
		searchPanel.add(searchLabel);
		searchPanel.add(searchTF);
		searchPanel.add(searchBtn);
		
		centerNorthPanel = new JPanel();
		centerNorthPanel.add(searchPanel);
		
		centerDisplayPanel = new JPanel();
		centerDisplayPanel.setLayout(new GridLayout(11,2));
		
		payrollIdLabel = new JLabel("Payroll ID:");
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
		
		payrollIdTF = new JTextField();
		payrollIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		payrollIdTF.setEditable(false);
		payrollTitleTF = new JTextField();
		payrollTitleTF.setBorder(BorderFactory.createLoweredBevelBorder());
		payrollTitleTF.setEditable(false);
		dateTF = new JTextField();
		dateTF.setBorder(BorderFactory.createLoweredBevelBorder());
		dateTF.setEditable(false);
		deductionTF = new JTextField();
		deductionTF.setBorder(BorderFactory.createLoweredBevelBorder());
		deductionTF.setEditable(false);
		totalOTTF = new JTextField();
		totalOTTF.setBorder(BorderFactory.createLoweredBevelBorder());
		totalOTTF.setEditable(false);
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
		employeeIdTF = new JTextField();
		employeeIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIdTF.setEditable(false);
		basicSalaryTF = new JTextField();
		basicSalaryTF.setBorder(BorderFactory.createLoweredBevelBorder());
		basicSalaryTF.setEditable(false);
		
		centerDisplayPanel.add(payrollIdLabel);
		centerDisplayPanel.add(payrollIdTF);
		centerDisplayPanel.add(payrollTitleLabel);
		centerDisplayPanel.add(payrollTitleTF);
		centerDisplayPanel.add(employeeIdLabel);
		centerDisplayPanel.add(employeeIdTF);
		centerDisplayPanel.add(employeeNameLabel);
		centerDisplayPanel.add(employeeNameTF);
		centerDisplayPanel.add(basicSalaryLabel);
		centerDisplayPanel.add(basicSalaryTF);
		centerDisplayPanel.add(dateLabel);
		centerDisplayPanel.add(dateTF);
		centerDisplayPanel.add(deductionLabel);
		centerDisplayPanel.add(deductionTF);
		centerDisplayPanel.add(totalOTLabel);
		centerDisplayPanel.add(totalOTTF);
		centerDisplayPanel.add(otSalaryLabel);
		centerDisplayPanel.add(otSalaryTF);
		centerDisplayPanel.add(taxPaidLabel);
		centerDisplayPanel.add(taxPaidTF);
		centerDisplayPanel.add(totalSalaryLabel);
		centerDisplayPanel.add(totalSalaryTF);
		
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerPanel.add(centerDisplayPanel, BorderLayout.CENTER);
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		calculateBtn = new JButton();
		calculateBtn.setText("Calculate");
		calculateBtn.addActionListener(this);
		calculateBtn.setPreferredSize(new Dimension(100,30));
		calculateBtn.setVisible(false);
		calculateBtn.setFocusable(false);
		chgBtn = new JButton();
		chgBtn.setText("Change");
		chgBtn.addActionListener(this);
		chgBtn.setPreferredSize(new Dimension(100,30));
		chgBtn.setVisible(false);
		chgBtn.setEnabled(false);
		chgBtn.setFocusable(false);
		cancelBtn = new JButton();
		cancelBtn.setText("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setPreferredSize(new Dimension(100,30));
		cancelBtn.setVisible(false);
		cancelBtn.setFocusable(false);
		
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(120,100));
		eastPanel.add(calculateBtn);
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
		findPayrollF.setLayout(new BorderLayout(0,5));
		findPayrollF.setSize(700,600);
		findPayrollF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		findPayrollF.add(northPanel, BorderLayout.NORTH);
		findPayrollF.add(centerPanel, BorderLayout.CENTER);
		findPayrollF.add(eastPanel, BorderLayout.EAST);
		findPayrollF.add(westPanel, BorderLayout.WEST);
		findPayrollF.add(southPanel, BorderLayout.SOUTH);
		findPayrollF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the search, 
	 * delete record, update record, calculate, change or cancel button
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Search"))
		{
			//call method searchPayroll to search the payroll data
			searchPayroll();
		}
		else if(e.getActionCommand().equals("Delete Record"))
		{
			//call method deletePayroll to delete the payroll data
			deletePayroll();
		}
		else if(e.getActionCommand().equals("Update Record"))
		{
			searchTF.setEditable(false);
		
			payrollTitleTF.setEditable(true);
			dateTF.setEditable(true);
			deductionTF.setEditable(true);
			totalOTTF.setEditable(true);
			
			calculateBtn.setVisible(true);
			chgBtn.setVisible(true);
			cancelBtn.setVisible(true);
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
			int id = Integer.parseInt(employeeIdTF.getText());
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
			
			String otSalary = String.valueOf(payroll.calculateOTSalary(employee));
			String taxPaid = String.valueOf(payroll.calculateTax(employee));
			String totalSalary = String.valueOf(payroll.calculateTotalSalary(employee));
			
			otSalaryTF.setText(otSalary);
			taxPaidTF.setText(taxPaid);
			totalSalaryTF.setText(totalSalary);
			
			chgBtn.setEnabled(true);
		}
		else if(e.getActionCommand().equals("Change"))
		{
			//call method updatePayroll to update the payroll data
			updatePayroll();
			searchTF.setEditable(true);
			
			payrollTitleTF.setEditable(false);
			dateTF.setEditable(false);
			deductionTF.setEditable(false);
			totalOTTF.setEditable(false);
			
			chgBtn.setEnabled(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			searchTF.setEditable(true);
			
			payrollTitleTF.setEditable(false);
			dateTF.setEditable(false);
			deductionTF.setEditable(false);
			totalOTTF.setEditable(false);
			
			calculateBtn.setVisible(false);
			chgBtn.setVisible(false);
			cancelBtn.setVisible(false);
			
			//set the data back to original
			searchPayroll();
		}
		else
		{
			//clear the text field
			payrollIdTF.setText(null);
			payrollTitleTF.setText(null);
			dateTF.setText(null);
			deductionTF.setText(null);
			totalOTTF.setText(null);
			otSalaryTF.setText(null);
			taxPaidTF.setText(null);
			totalSalaryTF.setText(null);
			employeeNameTF.setText(null);
			employeeIdTF.setText(null);
			basicSalaryTF.setText(null);
		}
	}
	
	/**
	 * This is the action performed when user pressed the enter key
	 * on their keyboard
	 */
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			searchPayroll();
		}
		else
		{
			payrollIdTF.setText(null);
			payrollTitleTF.setText(null);
			dateTF.setText(null);
			deductionTF.setText(null);
			totalOTTF.setText(null);
			otSalaryTF.setText(null);
			taxPaidTF.setText(null);
			totalSalaryTF.setText(null);
			employeeNameTF.setText(null);
			employeeIdTF.setText(null);
			basicSalaryTF.setText(null);
		}
	}
	
	/**
	 * This method is to search the payroll data from the DBMS using PayrollApi and Payroll class
	 */
	public void searchPayroll()
	{
		try
		{
			Payroll payroll = new Payroll();
			PayrollApi payrollApi = new PayrollApi();
			
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
			
			payroll = payrollApi.findPayroll(searchId);
			
			int empId = payroll.getPayrollEmployeeId();
			Employee employee = new EmployeeApi().findEmployee(empId);
			
			String payrollId = String.valueOf(payroll.getPayroll_id());
			String title = payroll.getPayrollTitle();
			String employeeId = String.valueOf(empId);
			String employeeName = employee.getEmployeeName();
			String basicSalary = String.valueOf(employee.getEmployeeSalary());
			String date = String.valueOf(payroll.getPayrollDate());
			String deduction = String.valueOf(payroll.getDeduction());
			String totalOT = String.valueOf(payroll.getTotalOverTime());
			String otSalary = String.valueOf(payroll.getOTSalary());
			String taxPaid = String.valueOf(payroll.getTaxPaid());
			String totalSalary = String.valueOf(payroll.getTotalSalary());
			
			payrollIdTF.setText(payrollId);
			payrollTitleTF.setText(title);
			dateTF.setText(date);
			deductionTF.setText(deduction);
			totalOTTF.setText(totalOT);
			otSalaryTF.setText(otSalary);
			taxPaidTF.setText(taxPaid);
			totalSalaryTF.setText(totalSalary);
			employeeNameTF.setText(employeeName);
			employeeIdTF.setText(employeeId);
			basicSalaryTF.setText(basicSalary);
			
		}
		catch(PayrollNotFoundException payrollE)
		{
			String message = payrollE.getMessage();
			
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception ex)
		{
			String message = ex.getMessage();
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method is to delete the payroll data from the DBMS using PayrollApi class
	 */
	public void deletePayroll()
	{
		try
		{
			PayrollApi payrollApi = new PayrollApi();
			
			int payrollId = 0;
			
			try 
			{
				payrollId = Integer.parseInt(payrollIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			}
			
			//make sure that the user is really want to delete the data
			int delConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete Confirm", JOptionPane.YES_NO_OPTION);
			
			//if yes
			if(delConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = payrollApi.deletePayroll(payrollId);
				
				JOptionPane.showMessageDialog(null, status+" record have been deleted");
				
				payrollIdTF.setText(null);
				payrollTitleTF.setText(null);
				dateTF.setText(null);
				deductionTF.setText(null);
				totalOTTF.setText(null);
				otSalaryTF.setText(null);
				taxPaidTF.setText(null);
				totalSalaryTF.setText(null);
				employeeNameTF.setText(null);
				employeeIdTF.setText(null);
				basicSalaryTF.setText(null);
			}
			else if(delConfirm == JOptionPane.NO_OPTION)	//if no
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
	 * This method is to update the payroll data in the DBMS using PayrollApi and Payroll class
	 */
	public void updatePayroll()
	{
		try
		{
			Payroll payroll = new Payroll();
			PayrollApi payrollApi = new PayrollApi();

			int payrollId = -1;
			int employeeId = -1;
			
			try 
			{
				payrollId = Integer.parseInt(payrollIdTF.getText());
				employeeId = Integer.parseInt(employeeIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			}
			
			String regexDate = "^(\\d{4})-(\\d{1,2})-(\\d{1,2})$";
			Pattern patternDate = Pattern.compile(regexDate);
			Matcher matcherDate = patternDate.matcher(dateTF.getText());
			
			if(matcherDate.matches() == false)
			{
				String message = "The format of date is wrong!! Please enter the date in format (YYYY-MM-DD)";
				JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			payroll.setPayrollEmployeeId(employeeId);
			payroll.setPayroll_id(payrollId);
			payroll.setPayrollTitle(payrollTitleTF.getText());
			payroll.setPayrollDate(Date.valueOf(dateTF.getText()));
			payroll.setDeduction(Double.parseDouble(deductionTF.getText()));
			payroll.setTotalOverTime(Double.parseDouble(totalOTTF.getText()));
			payroll.setOTSalary(Double.parseDouble(otSalaryTF.getText()));
			payroll.setTaxPaid(Double.parseDouble(taxPaidTF.getText()));
			payroll.setTotalSalary(Double.parseDouble(totalSalaryTF.getText()));
			
			//make sure that the user is really want to update the data
			int updateConfirm = JOptionPane.showConfirmDialog(null, 
														"Are you sure you want to update this record?", 
														"Update Confirm", 
														JOptionPane.YES_NO_OPTION);
			
			//if yes
			if(updateConfirm == JOptionPane.YES_OPTION)
			{
				
				int status = payrollApi.updatePayroll(payroll);
				
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
			JOptionPane.showMessageDialog(null, message, "Error Message!!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

}
