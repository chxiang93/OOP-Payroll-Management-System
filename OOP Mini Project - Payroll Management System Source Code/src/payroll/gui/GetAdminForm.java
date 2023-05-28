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
public class GetAdminForm {
	
	//These are the declaration of the gui component used in get admin form 
	private JFrame getAdminF;
	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JTable table;
	private JScrollPane sp;
	
	/**
	 * This is the constructor of class GetAdminForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public GetAdminForm()
	{
		getAdminF = new JFrame("Payroll Management System");
		
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
				"View All Admin",
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
		getAdminF.setLayout(new BorderLayout(0,30));
		getAdminF.setSize(700,550);
		getAdminF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getAdminF.add(northPanel, BorderLayout.NORTH);
		getAdminF.add(sp, BorderLayout.CENTER);
		getAdminF.add(eastPanel, BorderLayout.EAST);
		getAdminF.add(westPanel, BorderLayout.WEST);
		getAdminF.add(southPanel, BorderLayout.SOUTH);
		getAdminF.setVisible(true);
	}

	/**
	 * This method get the columns that exist in the DBMS
	 * @return String[]
	 */
	public String[] getColumns()
	{
		String[] columns = {"Admin_Id", "Employee_Id", "Admin_Name", "Username", "Password"};
		
		return columns;
	}
	
	/**
	 * This method get all the data of admin in the form of 
	 * multidimensional array using AdminApi and Admin class
	 * @return String[][]
	 */
	public String[][] getData()
	{
		String[][] data = null;
		
		try
		{
			AdminApi adminApi = new AdminApi();
			
			ArrayList<Admin> adminList = adminApi.getAdmin();
			int rows = adminList.size();
			int columns = getColumns().length;
			data = new String[rows][columns];
			
			int index = 0;
			for(Admin admin: adminList)
			{
				String adminId = String.valueOf(admin.getAdminId());
				String employeeId = String.valueOf(admin.getEmployeeId());
				String adminName = admin.getEmployeeName();
				String username = admin.getUsername();
				String password = admin.getPassword();
				
				data[index][0] = adminId;
				data[index][1] = employeeId;
				data[index][2] = adminName;
				data[index][3] = username;
				data[index][4] = password;
				
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
