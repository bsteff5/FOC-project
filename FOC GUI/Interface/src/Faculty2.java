import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;

public class Faculty2  extends JFrame{

	/**
	 * This method creates the window.
	 */
	public void start(){
		setTitle("Faculty");
		
		pack();
		setVisible(true);
		initComponents();
		setSize(1025,725);
	}

	private void initComponents(){
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
	
		//main label
		Font m = new Font("SansSerif", Font.BOLD, 24);
		title = new JLabel("Faculty Page");
		title.setBounds(30,0,1000, 100);
		title.setFont(m);
		panel.add(title);
		
		//prompt user label
		Font f = new Font("SansSerif", Font.BOLD, 16);
		start = new JLabel("Please select an option below to begin. ");
		start.setBounds(30,75,300,50);
		start.setFont(f);
		panel.add(start);
		
		JButton close = new JButton("Close Window");
		close.setBounds(875,0,125,30);
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});;
		panel.add(close);
		
		addFaculty = new JRadioButton("Add Faculty");
		addFaculty.setMnemonic(KeyEvent.VK_C); 
	    addFaculty.setSelected(false);
	    addFaculty.setBounds(30,130,150,25);
	    addFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				addFaculty();
			}
		});;
	    panel.add(addFaculty);
		
		
		pastCommittee = new JRadioButton("Past Committees");
		pastCommittee.setMnemonic(KeyEvent.VK_C); 
		pastCommittee.setSelected(false);
	    pastCommittee.setBounds(185,130,150,25);
	    pastCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				pastComm();
			}
		});;
	    panel.add(pastCommittee);
		
		
		searchFaculty = new JRadioButton("Search Faculty");
		searchFaculty.setMnemonic(KeyEvent.VK_C); 
		searchFaculty.setSelected(false);
	    searchFaculty.setBounds(340,130,150,25);
	    searchFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				searchFaculty();
			}
		});;
	    panel.add(searchFaculty);
		
		
		removeFaculty = new JRadioButton("Remove Faculty");
		removeFaculty.setMnemonic(KeyEvent.VK_C); 
		removeFaculty.setSelected(false);
	    removeFaculty.setBounds(495,130,150,25);
	    removeFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				removeFaculty();
			}
		});;
	    panel.add(removeFaculty);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(addFaculty);
	    group.add(pastCommittee);
	    group.add(searchFaculty);
	    group.add(removeFaculty);

	    add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addFaculty(){
		JLabel name = new JLabel("Name:");
		Font f = new Font("SansSerif", Font.BOLD, 16);
		name.setBounds(300,300,300,300);
		name.setFont(f);
		panel.add(name);
		
	}
	
	public void removeFaculty(){
		
	}
	
	public void searchFaculty(){
		
	}
	
	public void pastComm(){
		
	}

	//data members 
	private JLabel start, title;
	private JInternalFrame frame;
	private JPanel panel;
	
	private JRadioButton addFaculty, pastCommittee, searchFaculty, removeFaculty;	
}