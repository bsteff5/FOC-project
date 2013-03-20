import javax.swing.JFrame;
public class AboutMeFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  JFrame frame = new JFrame ("About Me");
		  	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		  	                
		  	            frame.add(new TabPanel());
		  	            frame.pack();
		  	            frame.setVisible(true);
	}

}
