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
 * This class is the implementation of the gui of get admin form
 *
 */
public class GetPayrollForm {
	
	//These are the declaration of the gui component used in get admin form 
	private JFrame getPayrollF;
	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JTable table;
	private JScrollPane sp;
	
	/**
	 * This is the constructor of class GetPayrollForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public GetPayrollForm()
	{
		getPayrollF = new JFrame("Payroll Management System");
		
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
		
	//*************************Initializing Table****************************************
		table = new JTable(getData(), getColumns());
		table.setPreferredSize(new Dimension(460,350));
		table.setFillsViewportHeight(true);
		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(460,350));
		sp.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"View All Payroll",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(50,100));
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(50,100));
		southPanel = new JPanel();
	//***********************************************************************************
		
		//add all the component to the frame 
		getPayrollF.setLayout(new BorderLayout(0,30));
		getPayrollF.setSize(700,550);
		getPayrollF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getPayrollF.add(northPanel, BorderLayout.NORTH);
		getPayrollF.add(sp, BorderLayout.CENTER);
		getPayrollF.add(eastPanel, BorderLayout.EAST);
		getPayrollF.add(westPanel, BorderLayout.WEST);
		getPayrollF.add(southPanel, BorderLayout.SOUTH);
		getPayrollF.setVisible(true);
	}

	/**
	 * This method get the columns that exist in the DBMS
	 * @return String[]
	 */
	public String[] getColumns()
	{
		String[] columns = {"Payroll_Id", "Employee_Id", "Payroll Title", "Date", "Deduction(RM)", "Total OT", 
							"OT Salary(RM)", "Tax Paid(RM)", "Total Salary(RM)", };
		
		return columns;
	}
	
	/**
	 * This method get all the data of payroll in the form of 
	 * multidimensional array using PayrollApi and Payroll class
	 * @return String[][]
	 */
	public String[][] getData()
	{
		String[][] data = null;
		
		try
		{
			PayrollApi payrollApi = new PayrollApi();
			
			ArrayList<Payroll> payrollList = payrollApi.getPayroll();
			int rows = payrollList.size();
			int columns = getColumns().length;
			data = new String[rows][columns];
			
			int index = 0;
			for(Payroll payroll: payrollList)
			{
				String payrollId = String.valueOf(payroll.getPayroll_id());
				String employeeId = String.valueOf(payroll.getPayrollEmployeeId());
				String title = payroll.getPayrollTitle();
				String date = String.valueOf(payroll.getPayrollDate());
				String deduction = String.valueOf(payroll.getDeduction());
				String totalOT = String.valueOf(payroll.getTotalOverTime());
				String otSalary = String.valueOf(payroll.getOTSalary());
				String taxPaid = String.valueOf(payroll.getTaxPaid());
				String totalSalary = String.valueOf(payroll.getTotalSalary());
				
				data[index][0] = payrollId;
				data[index][1] = employeeId;
				data[index][2] = title;
				data[index][3] = date;
				data[index][4] = deduction;
				data[index][5] = totalOT;
				data[index][6] = otSalary;
				data[index][7] = taxPaid;
				data[index][8] = totalSalary;
				
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
