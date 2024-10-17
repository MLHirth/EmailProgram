import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class outlookexchangefolder {

	/**
	 * @return 
	 * @wbp.parser.entryPoint
	 */
	public static void dosomething() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1042, 432);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Folders 1");
		btnNewButton.setBounds(325, 27, 230, 151);
		
		panel.add(btnNewButton);
		
		JButton button = new JButton();
		ImageIcon icon = new ImageIcon(outlookexchangefolder.class.getResource("resources/back_button.png"));
		Image image = icon.getImage();
		Image imagenew = image.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(imagenew);
		button.setIcon(icon);
		button.setBounds(33,22,280,156);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI.welcome();
				frame.dispose();
			}
		});
		panel.setLayout(null);
		//button
		panel.add(button);
		panel.add(btnNewButton);
		JLabel label = new JLabel("Folders");
		label.setBounds(546, 6, 102, 16);
		panel.add(label);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailfolder.doitpls();
				frame.dispose();
			}
		});
		
		JButton button_1 = new JButton("Folder 2");
		button_1.setBounds(557, 27, 230, 151);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Folder 3");
		button_2.setBounds(799, 27, 230, 151);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Folder 6");
		button_3.setBounds(799, 190, 230, 151);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Folder 5");
		button_4.setBounds(557, 190, 230, 151);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Folder 4");
		button_5.setBounds(325, 190, 230, 151);
		panel.add(button_5);
		
		JButton btnCloseApplication = new JButton("Close Application");
		btnCloseApplication.setBounds(62, 190, 230, 151);
		panel.add(btnCloseApplication);
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		
		});
		frame.setVisible(true);
	}
}