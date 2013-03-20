import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Interface  extends JFrame{
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
	 *  Initializes components for the FOC DBInterface.
	 */
	private void initComponents(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);   
	
		//main label
		Font m = new Font("SansSerif", Font.BOLD, 32);
		title = new JLabel("Welcome to the Faculty Oranization Committee Planning Tool");
		title.setBounds(30, 15, 1000, 100);
		title.setFont(m);
		panel.add(title);
		
		//prompt user label
		Font f = new Font("SansSerif", Font.BOLD, 16);
		start = new JLabel("Press \"OK\" to start the system: ");
		start.setBounds(375, 250, 300, 100);
		start.setFont(f);
		panel.add(start);
		
		//OK button
		ok = new JButton("OK");
		ok.setBounds(455,320,75,25);
		ok.setBackground(Color.LIGHT_GRAY);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				mypage.start();
				dispose();
			}
		});;
		panel.add(ok);
		
		add(panel);
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//data members 
	private JButton ok;
	private JLabel start, title;	
	private HomePage mypage = new HomePage();	
}