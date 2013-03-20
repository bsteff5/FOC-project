//******************************************************************************
	// This is assignment 2         by DAN NGUYEN
	//******************************************************************************
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	 
	//******************************************************************************
	// This is the creating of the main tabs in the panel
	//******************************************************************************
	public class TabPanel extends JTabbedPane
	{   
	  {
	    //This is for the First tab that includes buttons
	    JPanel panel1 = new JPanel(new GridLayout(1,3));
	         
	        panel1.add(new JButton("Button 1"));
	        panel1.add(new JButton("Button 2"));
	        panel1.add(new JButton("Button 3"));
	        add("Personal Information", panel1);
	         
	    //This is for the Second tab that includes check boxes
	    JPanel panel2 = new JPanel(new GridLayout(1,3));
	         
	 
	        add("Some Of My Favorite Things", panel2);  
	         
	         
	    //This is for the third tab that includes radio buttons   
	    JPanel panel3 = new JPanel(new GridLayout(1,3));
	         
	 
	        add("Some Of My Favorite Things", panel3);       
	         
	  }
	}