import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Committee2  extends JFrame{

	@SuppressWarnings("unused")

	/**
	 * This method creates the window.
	 */
	public void start(){
		setTitle("FOC_DB");
		
		pack();
		setVisible(true);
		initComponents();
		setSize(1025,725);
		
	}

	/**
	 *  Initializes components for the Twitter Interface.
	 */
	private void initComponents(){
		
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
	
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

		//main label
		Font m = new Font("SansSerif", Font.BOLD, 24);
		title = new JLabel("Committee Page");
		title.setBounds(30,0,1000, 100);
		title.setFont(m);
		panel.add(title);
		
		//prompt user label
		Font f = new Font("SansSerif", Font.BOLD, 16);
		start = new JLabel("Please select an option below to begin. ");
		start.setBounds(30,75,300,50);
		start.setFont(f);
		panel.add(start);
		
		addFaculty = new JRadioButton("Add Members");
		addFaculty.setMnemonic(KeyEvent.VK_C); 
	    addFaculty.setSelected(false);
	    addFaculty.setBounds(30,130,150,25);
	    addFaculty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				addMember();
			}
		});;
	    panel.add(addFaculty);
		
		
		addCommittee = new JRadioButton("Add New Committee");
		addCommittee.setMnemonic(KeyEvent.VK_C); 
		addCommittee.setSelected(false);
	    addCommittee.setBounds(185,130,150,25);
	    addCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				addComm();
			}
		});;
	    panel.add(addCommittee);
		
		
		searchCommittee = new JRadioButton("Search a Committee");
		searchCommittee.setMnemonic(KeyEvent.VK_C); 
		searchCommittee.setSelected(false);
	    searchCommittee.setBounds(340,130,150,25);
	    searchCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					searchComm();	
			}
		});;
	    panel.add(searchCommittee);
		
		
		removeCommittee = new JRadioButton("Remove a Committee");
		removeCommittee.setMnemonic(KeyEvent.VK_C); 
		removeCommittee.setSelected(false);
	    removeCommittee.setBounds(495,130,150,25);
	    removeCommittee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				removeComm();
			}
		});;
	    panel.add(removeCommittee);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(addFaculty);
	    group.add(addCommittee);
	    group.add(searchCommittee);
	    group.add(removeCommittee);

		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void addMember(){
		
	}
	
	public void removeComm(){
		
	}
	
	public void addComm(){
		
	}
	
	public void searchComm(){
		
	}

	//data members 
	private JLabel start, title;
	private JInternalFrame frame;
	
	private JRadioButton addFaculty, addCommittee, searchCommittee, removeCommittee;	
}

