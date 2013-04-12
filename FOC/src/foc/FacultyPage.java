/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foc;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class FacultyPage  extends JFrame{
	/**
	 * This method creates the window.
	 */
	public String start(String decision){
		setTitle("Faculty");
		decideFunction = decision;
		pack();
		setVisible(true);
		String value = initComponents();
		setSize(1025,650);
		return value;
	}

	private String initComponents(){
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);   
	
		//main label
		Font m = new Font("SansSerif", Font.BOLD, 24);
		title = new JLabel("Faculty Page");
		title.setBounds(30,0,1000, 100);
		title.setFont(m);
		panel.add(title);
		
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
		
		JLabel enterName =  new JLabel("Please enter the first and last name of the faculty member");
		enterName.setBounds(30,75,500,25);
		panel.add(enterName);
		
		JLabel enterName2 = new JLabel("First Name:");
		enterName2.setBounds(30,100,100,25);
		panel.add(enterName2);
		
		final JTextField enterName3 = new JTextField();
		enterName3.setBounds(140,100,300,25);
		enterName3.setText("");
		panel.add(enterName3);
                
		
		JLabel enterLastName2 = new JLabel("Last Name:");
		enterLastName2.setBounds(30,125,100,25);
		panel.add(enterLastName2);
		
		final JTextField enterLastName3 = new JTextField();
		enterLastName3.setBounds(140,125,300,25);
		enterLastName3.setText("");
		panel.add(enterLastName3);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(365,155,75,25);
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				facultyFirstName = enterName3.getText();
				facultyLastName = enterLastName3.getText();
                                facultyName = facultyFirstName + " " + facultyLastName;
                                
				if(facultyFirstName.equals("") || facultyLastName.equals("")){
					JOptionPane.showMessageDialog(frame,"Please enter the first and last name of the member.",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
				}
				else{
					//check to see if member is eligible first\\
					
					if(decideFunction == "add new faculty"){
						returnValue = addFaculty();
					}
					
					else if(decideFunction == "view past committees"){
						returnValue = viewComm();
					}
					else if(decideFunction == "search faculty"){
						returnValue = searchFaculty();
					}
					else if(decideFunction == "remove faculty"){
						returnValue = removeFaculty();
					}
                                        else if(decideFunction == "add depart"){
						returnValue = addDepart();
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
	
	private String addFaculty(){
                boolean exists = mydb.verifyFac(facultyName);
                if(exists){
                    JOptionPane.showMessageDialog(frame,facultyName + " has already been added",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                    return null;
                }
                else{
                    String facultyEmail =  JOptionPane.showInputDialog("Enter " + facultyName + "'s email:");

                    returnAddFaculty = "You added " + facultyName + " and " + facultyEmail + " as their email address.";
                    mydb.addFaculty(facultyFirstName, facultyLastName);
                    return returnAddFaculty;
                }
		
	}
	private String viewComm(){
		returnViewComm = "find all past committees in the database";
		return returnViewComm;
	}
	private String searchFaculty(){
            boolean exists = mydb.verifyFac(facultyName);
                if(!exists){
                    JOptionPane.showMessageDialog(frame,facultyName + " has not been added",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                    return null;
                }
                else{
                    returnSearchFaculty = mydb.searchFac(facultyName);
                    return returnSearchFaculty;
                }
	}
	private String removeFaculty(){
             boolean exists = mydb.verifyFac(facultyName);

             if(!exists){
                    JOptionPane.showMessageDialog(frame,facultyName + " has not been added or has been removed already",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                    return null;
                }
                else{
		int n = JOptionPane.showConfirmDialog(
				frame,
				"Are you sure you want to remove " + facultyName + " from eligible members?",
				"Log out confirmation",
				JOptionPane.YES_NO_OPTION);;
				if(n == 0){
					JOptionPane.showMessageDialog(frame,facultyName + " has been removed from eligible members",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
				}
                returnRemoveFaculty = "You removed " + facultyName + " from eligible members.";
                mydb.removeFaculty(facultyName);
		return returnRemoveFaculty;
             }
                
	}
        private String addDepart(){
                boolean exists = mydb.verifyFac(facultyName);
                if(!exists){
                    JOptionPane.showMessageDialog(frame,facultyName + " has not been added",
							"Attention!",
							JOptionPane.WARNING_MESSAGE);
                   return null;
                }
                else{
                    String facultyDepart =  JOptionPane.showInputDialog("Enter " + facultyName + "'s department:");

                    returnAddFaculty = "You added " + facultyDepart + " as " + facultyName + "'s department.";
                    mydb.addDepartment(facultyName, facultyDepart);
                    return returnAddFaculty;
                }
		
	}
	//data members 
	private JLabel title;
	private JInternalFrame frame;
	private JPanel panel;
	private String returnValue, returnAddFaculty, returnSearchFaculty, returnRemoveFaculty, returnViewComm;
	private String decideFunction,facultyName, facultyFirstName, facultyLastName;
        private DatabaseFunctions mydb = new DatabaseFunctions();
}
