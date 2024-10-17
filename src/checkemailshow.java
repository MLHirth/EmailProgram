

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class checkemailshow {

	public static void showemail(String content) {
		JFrame frame = new JFrame();
   	   JPanel panel = new JPanel(); 
		frame.setSize(1920, 1080);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		JLabel label = new JLabel(content);
		label.setBounds(217, 303, 471, 473);
		frame.setVisible(true);
	}

}
