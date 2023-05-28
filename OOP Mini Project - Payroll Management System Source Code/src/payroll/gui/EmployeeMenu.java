package payroll.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * This class is the implementation of the gui of employee menu
 *
 */
public class EmployeeMenu implements ActionListener{
	
	//These are the declaration of the gui component used in employee menu
	private JFrame employeeMenuF;
	private JPanel centerP, northP, southP, westP, eastP;
	private JLabel titleL;
	private JButton addEmployeeBtn, findEmployeeBtn, viewEmployeeBtn, mainMenuBtn, exitBtn;
	
	/**
	 * This is the constructor of class EmployeeMenu that initialize all the gui component 
	 * and display the component to the screen inside a frame
	 */
	public EmployeeMenu(){
		employeeMenuF = new JFrame("Payroll Management System");
		
		//Initializing north panel
		northP = new JPanel();
		northP.setBackground(new Color(0x3399FF));
		northP.setPreferredSize(new Dimension(100,100));
        northP.setLayout(new BorderLayout());
        northP.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));
        
        titleL = new JLabel();
        titleL.setText("PAYROLL MANAGEMENT SYSTEM");
        titleL.setForeground(Color.black);
        titleL.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleL.setHorizontalAlignment(JLabel.CENTER);
        
        northP.add(titleL, BorderLayout.CENTER);
        
        //Initializing center panel
        centerP = new JPanel();
        centerP.setLayout(new GridLayout(3, 1, 90, 90));
        centerP.setBorder(BorderFactory.createTitledBorder(
        		BorderFactory.createLoweredBevelBorder(),
        		"Employee Menu",
        		TitledBorder.CENTER,
        		TitledBorder.DEFAULT_POSITION,
        		new Font("Arial", Font.BOLD, 25)));
        
        addEmployeeBtn = new JButton("Add Employee");
        addEmployeeBtn.setPreferredSize(new Dimension(70, 30));
        addEmployeeBtn.addActionListener(this);
        addEmployeeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        addEmployeeBtn.setFocusable(false);
        
        findEmployeeBtn = new JButton("Find Employee");
        findEmployeeBtn.setPreferredSize(new Dimension(70, 30));
        findEmployeeBtn.addActionListener(this);
        findEmployeeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        findEmployeeBtn.setFocusable(false);
        
        viewEmployeeBtn = new JButton("View All Employee");
        viewEmployeeBtn.setPreferredSize(new Dimension(70, 30));
        viewEmployeeBtn.addActionListener(this);
        viewEmployeeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        viewEmployeeBtn.setFocusable(false);
        
        centerP.add(addEmployeeBtn);
        centerP.add(findEmployeeBtn);
        centerP.add(viewEmployeeBtn);
        
        //Initializing east, west and south panel
		eastP = new JPanel();
		eastP.setPreferredSize(new Dimension(150,100));
		westP = new JPanel();
		westP.setPreferredSize(new Dimension(150,100));
		
		westP.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Navigation",
				TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Arial", Font.BOLD, 16)));
		
		mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setPreferredSize(new Dimension(125,30));
		mainMenuBtn.addActionListener(this);
		mainMenuBtn.setFocusable(false);

		exitBtn = new JButton("Exit System");
		exitBtn.setPreferredSize(new Dimension(125,30));
		exitBtn.addActionListener(this);
		exitBtn.setFocusable(false);
		
		westP.add(mainMenuBtn);
		westP.add(exitBtn);
		
		southP = new JPanel();
		
		//Add all the component to the frame
		employeeMenuF.setLayout(new BorderLayout(0,20));
		employeeMenuF.setSize(700,550);
		employeeMenuF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		employeeMenuF.add(northP, BorderLayout.NORTH);
		employeeMenuF.add(centerP, BorderLayout.CENTER);
		employeeMenuF.add(eastP, BorderLayout.EAST);
		employeeMenuF.add(westP, BorderLayout.WEST);
		employeeMenuF.add(southP, BorderLayout.SOUTH);
		employeeMenuF.setVisible(true);
	}
	
	/**
	 * This is the action performed when user click on the add employee, 
	 * find employee, view all employee button, main menu or exit system button
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add Employee")){
			//Open add employee form
			AddEmployeeForm addEmployee = new AddEmployeeForm();
		}
		else if(e.getActionCommand().equals("Find Employee")){
			//Open find employee form
			FindEmployeeForm findEmployee = new FindEmployeeForm();
		}
		else if(e.getActionCommand().equals("View All Employee")){
			//Open view all employee
			GetEmployeeForm getEmployee = new GetEmployeeForm();
		}
		else if(e.getActionCommand().equals("Main Menu"))
		{
			//Open main menu
			employeeMenuF.dispose();
			MainMenu mainMenu = new MainMenu();
		}
		else if(e.getActionCommand().equals("Exit System"))
		{
			System.exit(0);
		}

	}
}


