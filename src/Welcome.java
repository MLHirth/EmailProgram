import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Cursor;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Welcome {
	private static JTable table;

	public static void main(String[] args) {
		JFrame frame1 = new JFrame();
		frame1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 35));
		frame1.getContentPane().setBackground(new Color(51, 204, 204));
		JPanel panel1 = new JPanel();
		frame1.setSize(1920, 1080);
		frame1.getContentPane().add(panel1);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().add(panel1);
		
		frame1.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(0, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.setBounds(1304, 902, -896, -679);
		frame1.getContentPane().add(table);
	
		//JTextField welcometext = new JTextField();
		//frame1.getContentPane().add(welcometext);
		//welcometext.setBounds(33, 37, 269, 45);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 32));
		lblNewLabel.setBounds(701, 21, 388, 144);
		frame1.getContentPane().add(lblNewLabel);
		
		JMenu mnNewMenu = new JMenu("Emails");
		mnNewMenu.setBackground(new Color(0, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnNewMenu.setActionCommand("Emails");
		mnNewMenu.setBounds(49, 27, 178, 97);
		frame1.getContentPane().add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exchange Email");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gmail Email");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JButton btnNewButton = new JButton("Inbox");
		btnNewButton.setBounds(22, 160, 236, 45);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create new Email");
		btnNewButton_1.setBounds(22, 232, 236, 45);
		frame1.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add new Events to Calender");
		btnNewButton_2.setBounds(22, 301, 236, 45);
		frame1.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Outlook Email folder");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(22, 362, 236, 176);
		frame1.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exchange Email Folder");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(22, 550, 240, 237);
		frame1.getContentPane().add(btnNewButton_4);
		frame1.setVisible(true);
	}
}