import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class emaileditor {
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static JTextArea textarea;

    /**
     * @wbp.parser.entryPoint
     */
    public static void realemaileditor() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1042, 432);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);


        textarea = new JTextArea();
        textarea.setBounds(37, 121, 847, 189);
        panel.add(textarea);


        textField_1 = new JTextField();
        textField_1.setBounds(37, 62, 130, 36);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(190, 62, 215, 36);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblTextForEmail = new JLabel("Text for Email");
        lblTextForEmail.setBounds(68, 103, 113, 16);
        panel.add(lblTextForEmail);

        JLabel lblSubject = new JLabel("Subject");
        lblSubject.setBounds(68, 44, 61, 16);
        panel.add(lblSubject);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setBounds(257, 44, 96, 16);
        panel.add(lblEmailAddress);


        JButton button = new JButton();
        panel.add(button);
        ImageIcon icon = new ImageIcon(outlookexchangefolder.class.getResource("resources/back_button.png"));
        Image image = icon.getImage();
        Image imagenew = image.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(imagenew);
        button.setIcon(icon);
        button.setBounds(6, 6, 280, 36);

        JButton btnDone = new JButton("Done");
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textField_2.getText();
                String realmessage = textarea.getText();
                String subject = textField_1.getText();
                System.out.println(email);
                System.out.println(realmessage);
                try {
                    SendEmail.sendMail(email, realmessage, subject);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnDone.setBounds(446, 67, 117, 29);
        panel.add(btnDone);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginGUI.welcome();
                frame.dispose();
            }
        });

    }
}

