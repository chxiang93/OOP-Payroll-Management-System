package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.HashMap;

import payroll.api.*;
import payroll.bean.*;

/**
 * This class is the implementation of the gui of add admin form
 *
 */
public class AddAdminForm implements ActionListener {
	
	//These are the declaration of the gui component used in add admin form 
	private JFrame addAdminF;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;
	private JLabel titleLabel;
	
	private JLabel employeeNameLabel;
	private JLabel employeeIdLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JComboBox<String> empNameCB;
	private JTextField employeeIdTF;
	private JTextField usernameTF;
	private JTextField passwordTF;
	private JButton resetBtn;
	private JButton saveBtn;
	
	/**
	 * This is the constructor of class AddAdminForm
	 * that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public AddAdminForm()
	{	
		addAdminF = new JFrame("Payroll Management System");
				
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
		
		employeeNameLabel = new JLabel("Employee Name:");
		employeeIdLabel = new JLabel("Employee ID:");
		usernameLabel = new JLabel("Set Username:");
		passwordLabel = new JLabel("Set Password:");
		
		empNameCB = new JComboBox<String>(getAvailableEmployeeName());
		empNameCB.addActionListener(this);
		empNameCB.setSelectedIndex(-1);
		empNameCB.setBorder(BorderFactory.createLoweredBevelBorder());
		
		employeeIdTF = new JTextField();
		employeeIdTF.setBorder(BorderFactory.createLoweredBevelBorder());
		employeeIdTF.setEditable(false);
		
		usernameTF = new JTextField();
		usernameTF.setBorder(BorderFactory.createLoweredBevelBorder());
		passwordTF = new JTextField();
		passwordTF.setBorder(BorderFactory.createLoweredBevelBorder());
		
		centerPanel.setLayout(new GridLayout(4,2,0,50));
		centerPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Add Admin",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 25)));
		
		centerPanel.add(employeeNameLabel);
		centerPanel.add(empNameCB);
		centerPanel.add(employeeIdLabel);
		centerPanel.add(employeeIdTF);
		centerPanel.add(usernameLabel);
		centerPanel.add(usernameTF);
		centerPanel.add(passwordLabel);
		centerPanel.add(passwordTF);
	//***********************************************************************************
		
	//*************************Initializing East,West,South Panel************************
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(150,100));
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(150,100));
		
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
		
		//add all the component to the frame 
		addAdminF.setLayout(new BorderLayout(0,30));
		addAdminF.setSize(700,550);
		addAdminF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addAdminF.add(northPanel, BorderLayout.NORTH);
		addAdminF.add(centerPanel, BorderLayout.CENTER);
		addAdminF.add(eastPanel, BorderLayout.EAST);
		addAdminF.add(westPanel, BorderLayout.WEST);
		addAdminF.add(southPanel, BorderLayout.SOUTH);
		addAdminF.setVisible(true);
	}
	
	/**
	 * This method will return the array of employee name available in the DBMS
	 * @return String[]
	 */
	public String[] getAvailableEmployeeName()
	{
		String[] employeeName = null;
		//A map is used to store the employee id for each employee name 
		HashMap<Integer,String> employeeIdName = null;
		
		try
		{
			employeeIdName = getEmployeeIdName();
			
			employeeName = new String[employeeIdName.size()];
			
			int index = 0;
			for(int id: employeeIdName.keySet())
			{
				employeeName[index] = employeeIdName.get(id);
				index++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return employeeName;
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
	
	/**
	 * This is the action performed when user click on the reset, 
	 * save record button or empName combo box
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Reset"))
		{
			empNameCB.setSelectedIndex(-1);
			employeeIdTF.setText(null);
			usernameTF.setText(null);
			passwordTF.setText(null);
		}
		else if(e.getActionCommand().equals("Save Record"))
		{
			//call saveAdmin method to save the admin data
			saveAdmin();
		}
		else if(e.getSource() == empNameCB)
		{
			//the pair of data of employee id refer to employee name is retrieved
			HashMap<Integer,String> employeeIdName = getEmployeeIdName();
			
			String name = String.valueOf(empNameCB.getSelectedItem());
			
			//if the id is same with the name that user selected,display the id
			for(int id:employeeIdName.keySet())
			{
				if(employeeIdName.get(id).equals(name))
				{
					employeeIdTF.setText(String.valueOf(id));
				}
			}
		}
	}
	
	/**
	 * This method is to save the admin data to the DBMS using AdminApi and Admin class
	 */
	public void saveAdmin()
	{
		try
		{
			Admin admin = new Admin();
			AdminApi adminApi = new AdminApi();
			
			int employeeId = 0;
			
			try 
			{
				employeeId = Integer.parseInt(employeeIdTF.getText());
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			}
			
			int saveConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to save this record?", "Delete Confirm", JOptionPane.YES_NO_OPTION);
			
			if(saveConfirm == JOptionPane.YES_OPTION)
			{
				admin.setEmployeeId(employeeId);
				admin.setUsername(usernameTF.getText());
				admin.setPassword(passwordTF.getText());
				
				int status = adminApi.addAdmin(admin);
				
				JOptionPane.showMessageDialog(null, status+" record have been saved");
				
				employeeIdTF.setText(null);
				usernameTF.setText(null);
				passwordTF.setText(null);
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
