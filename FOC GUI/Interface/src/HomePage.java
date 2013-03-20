import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;


/**
 * This class creates a JFrame to display home page.
 */

@SuppressWarnings("serial")
public class HomePage  extends JFrame{

	public void start(){
		pack();
		setVisible(true);
		initComponents();
		setSize(1025,725);
		this.setTitle("FOC_DB");
		JTabbedPane();
	}

	/**
	 * This initializes the JFrame 
	 * @param 
	 */
	
	private void initComponents(){
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
		add(panel);
		setSize(1025,725);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/**
	 * @author javabeginner.com
	 * @description The tabbed template was gotten from javabeginner.com.
	 */
	public void JTabbedPane() {
		ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");
		JTabbedPane jtbExample = new JTabbedPane();
		JPanel jplInnerPanel1 = createInnerPanelHome();
		jtbExample.addTab("Home", icon, jplInnerPanel1, "Home Page");
		//jtbExample.setSelectedIndex(0);
		JPanel jplInnerPanel2 = createInnerPanelCommittee();
		jtbExample.addTab("Committees", icon, jplInnerPanel2,"Commitees");
		JPanel jplInnerPanel3 = createInnerPanelFaculty();
		jtbExample.addTab("Faculty", icon, jplInnerPanel3, "Faculty");
		//setLayout(new GridLayout(1, 1));
		add(jtbExample);
	}
	/**
	 * @author javabeginner.com
	 * @description Some of the tabbed template was gotten from javabeginner.com
	 */
	protected JPanel createInnerPanelHome() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
		add(panel);
		setSize(950,725);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		results1 = new JTextArea("");
		results1.setBounds(20,80,700,700);
		results1.append("All results will be displayed here.");
		panel.add(results1);
		
		JButton close = new JButton("Exit System");
		close.setBounds(800,0,125,30);
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});;
		panel.add(close);
		
		findMembers = new JButton("Find Members");
		findMembers.setBounds(20,10,150,50);
		findMembers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//access database
			}
		});;
		panel.add(findMembers);
	
		return panel;
	}
	
	protected JPanel createInnerPanelCommittee() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
		add(panel);
		setSize(950,725);
		
		results2 = new JTextArea("");
		results2.setBounds(20,160,700,700);
		//results2.append("All results will be displayed here.");
		panel.add(results2);
		
		JButton viewResults = new JButton("View Results");
		viewResults.setBounds(20,130,150,25);
		panel.add(viewResults);
		
		JButton close = new JButton("Exit System");
		close.setBounds(800,0,125,30);
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});;
		panel.add(close);

		Font f = new Font("SansSerif", Font.BOLD, 16);
		start = new JLabel("Please select an option below to begin. ");
		start.setBounds(30,25,300,50);
		start.setFont(f);
		panel.add(start);
		
		addMembers = new JButton("Add Members");
		addMembers.setMnemonic(KeyEvent.VK_C); 
	    addMembers.setBounds(30,80,150,25);
	    addMembers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results2.removeAll();
				results2.append(myCommittee.start("add members"));
			}
		});;
	    panel.add(addMembers);
		
		addCommittee = new JButton("Add New Committee");
		addCommittee.setMnemonic(KeyEvent.VK_C); 
	    addCommittee.setBounds(185,80,150,25);
	    addCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results2.append(myCommittee.start("add new committee"));
			}
		});;
	    panel.add(addCommittee);
		
		searchCommittee = new JButton("Search a Committee");
		searchCommittee.setMnemonic(KeyEvent.VK_C); 
	    searchCommittee.setBounds(340,80,150,25);
	    searchCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results2.removeAll();
				results2.append(myCommittee.start("search committee"));
			}
		});;
	    panel.add(searchCommittee);
		
		removeCommittee = new JButton("Remove a Committee");
		removeCommittee.setMnemonic(KeyEvent.VK_C); 
	    removeCommittee.setBounds(495,80,175,25);
	    removeCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results2.removeAll();
				results2.append(myCommittee.start("remove committee"));
			}
		});;
	    panel.add(removeCommittee);
	    
		return panel;
	}
	
	protected JPanel createInnerPanelFaculty() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
		add(panel);
		setSize(950,725);
		
		results3 = new JTextArea("");
		results3.setBounds(20,160,700,700);
		//results3.append("All results will be displayed here.");
		panel.add(results3);
		
		JButton viewResults = new JButton("View Results");
		viewResults.setBounds(20,130,150,25);
		panel.add(viewResults);
		
		Font f = new Font("SansSerif", Font.BOLD, 16);
		start = new JLabel("Please select an option below to begin. ");
		start.setBounds(30,25,300,50);
		start.setFont(f);
		panel.add(start);
		
		JButton close = new JButton("Exit System");
		close.setBounds(800,0,125,30);
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});;
		panel.add(close);
		
		addFaculty = new JButton("Add Faculty");
		addFaculty.setMnemonic(KeyEvent.VK_C); 
	    addFaculty.setBounds(30,80,150,25);
	    addFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results3.removeAll();
				results3.append(myFaculty.start("add new faculty"));
			}
		});;
	    panel.add(addFaculty);
		
		pastCommittee = new JButton("Past Committees");
		pastCommittee.setMnemonic(KeyEvent.VK_C); 
	    pastCommittee.setBounds(185,80,150,25);
	    pastCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results3.append(myFaculty.start("view past committees"));
			}
		});;
	    panel.add(pastCommittee);
		
		searchFaculty = new JButton("Search Faculty");
		searchFaculty.setMnemonic(KeyEvent.VK_C); 
	    searchFaculty.setBounds(340,80,150,25);
	    searchFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results3.removeAll();
				results3.append(myFaculty.start("search faculty"));
			}
		});;
	    panel.add(searchFaculty);
		
		removeFaculty = new JButton("Remove Faculty");
		removeFaculty.setMnemonic(KeyEvent.VK_C); 
	    removeFaculty.setBounds(495,80,150,25);
	    removeFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				results3.removeAll();
				results3.append(myFaculty.start("remove faculty"));
			}
		});;
	    panel.add(removeFaculty);
	
		return panel;
	}

	//data members
	private JLabel start;
	private JInternalFrame frame;
	private JPanel panel;
	private JButton addFaculty, pastCommittee, searchFaculty, removeFaculty, findMembers;
	private JButton addMembers, addCommittee, searchCommittee, removeCommittee;	
	private JTextArea results1, results2, results3;
	private FacultyPage myFaculty = new FacultyPage();
	private CommitteePage myCommittee = new CommitteePage();
}