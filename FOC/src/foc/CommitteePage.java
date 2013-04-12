/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foc;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class CommitteePage  extends JFrame{
	/**
	 * This method creates the window.
	 */
	public String start(String decision){
		setTitle("FOC_DB");
		decideFunction = decision;
		pack();
		setVisible(true);
		String value = initComponents();
		setSize(1025,650);
		return value;
	}

	/**
	 *  
	 */
	private String initComponents(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
	
		JButton close = new JButton("Back");
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
		
		
		JLabel enterName =  new JLabel("Please enter name of the committee");
		enterName.setBounds(30,75,500,25);
                
		panel.add(enterName);
		
		JLabel enterName2 = new JLabel("Name:");
		enterName2.setBounds(30,100,50,25);
		panel.add(enterName2);
		
		final JTextField enterName3 = new JTextField();
		enterName3.setBounds(75,100,300,25);
		enterName3.setText("");
		panel.add(enterName3);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(300,125,75,25);
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CommitteeName = enterName3.getText();
				
				if(CommitteeName.equals("")){
					JOptionPane.showMessageDialog(frame,"Please enter the name of the committee.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
				}
				else{
					//check to see if committee exists\\
					
					if(decideFunction == "add new committee"){
						returnValue = addComm();
					}
					
					else if(decideFunction == "add members"){
						returnValue = addMembers();
					}
					else if(decideFunction == "search committee"){
						returnValue = searchComm();
					}
					else if(decideFunction == "remove committee"){
						returnValue = removeComm();
					}
                                        else if(decideFunction == "add chair"){
						returnValue = addChair();
					}
					else{
						//do nothing
					}
				}
			}
		});;
		panel.add(enter);
		
	    add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		return returnValue;
	}
	
	private String addComm(){
            boolean exists = mydb.verifyFac(CommitteeName);
                if(exists){
                    JOptionPane.showMessageDialog(frame,CommitteeName + " already exists",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                    return null;
                }
                else{
                    returnAddComm = "You created " + CommitteeName + " as a new committee.";
                    mydb.addCommittee(CommitteeName);
                    return returnAddComm;
                }
	}
	private String addMembers(){
                boolean exists = mydb.verifyComm(CommitteeName);
                
                if(exists){
		String numberMembers =  JOptionPane.showInputDialog("Enter the number of members to add to " + CommitteeName + ":");
		int memberNumber = Integer.parseInt(numberMembers);
		int i = 0, counter = 0;
		
		String members[] = new String[memberNumber];
		String allMembers = "";
		while(i < memberNumber){
			members[i] = JOptionPane.showInputDialog("Enter the name of member #" + (i + 1) + ":");
			if(counter == 0){
				allMembers += members[i];
				counter++;
			}
			else{
				allMembers += ", " + members[i];
			}
			i++;
		}
		returnAddMembers = "You added members " + allMembers + " to " + CommitteeName;
                mydb.addMembers(allMembers,CommitteeName);
		return returnAddMembers;
                }
                else{
                    JOptionPane.showMessageDialog(frame,CommitteeName + " does not exist.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                    return null;
                }

	}
	private String searchComm(){
            boolean exists = mydb.verifyComm(CommitteeName);
            if(exists){
		returnSearchComm =  mydb.searchComm(CommitteeName);
                
		return returnSearchComm;
            }
            else{
                JOptionPane.showMessageDialog(frame,CommitteeName + " does not exist.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                return null;
            }
                
	}
	private String removeComm(){
            boolean exists = mydb.verifyComm(CommitteeName);
            if(exists){
		int n = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to remove " + CommitteeName + " from committees?",
				"Log out confirmation",
				JOptionPane.YES_NO_OPTION);;
				if(n == 0){
					JOptionPane.showMessageDialog(frame,CommitteeName + " has been removed from the committee list.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
				}
		returnRemoveComm = CommitteeName + " has been removed from the committee list.";
                mydb.removeComm(CommitteeName);
		return returnRemoveComm;
            }
            else{
                JOptionPane.showMessageDialog(frame,CommitteeName + " does not exist.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                return null;
            }
	}

        private String addChair(){
            boolean exists = mydb.verifyComm(CommitteeName);
            if(exists){
                String chair = JOptionPane.showInputDialog("Enter the committee chair:");
                
                while(chair.equals("")){
                    chair = JOptionPane.showInputDialog("Enter the committee chair:");
                }
                returnAddComm = "You inserted: " + chair + " as the chair of " + CommitteeName;
                return returnAddComm;
            }
            else{
                JOptionPane.showMessageDialog(frame,CommitteeName + " does not exists.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                return null;
            }
            
        }

	//data members 
	private JLabel title;
	private JInternalFrame frame;
	private JPanel panel;
	private String returnValue, returnAddComm, returnAddMembers, returnSearchComm, returnRemoveComm;
	private String decideFunction, CommitteeName;
        private DatabaseFunctions mydb = new DatabaseFunctions();
}