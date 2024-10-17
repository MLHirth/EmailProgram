
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class LoginGUI implements ActionListener {

    private static JLabel userlabel;
    private static JButton button;
    private static JLabel passlabel;
    private static JTextField userText;
    private static JLabel successlabel;
    private static JPasswordField passText;
    private static String usercode = "Max";
    private static String passcode = "ehm";
    private static String Max = "Max";
    private static String passwords = "Test";
    private static JFrame frame;


    public static void main(String[] args) {


        JPanel panel = new JPanel();
        button = new JButton("Log in");
        userlabel = new JLabel("User");
        userlabel.setBounds(10, 20, 80, 25);
        //x y width height
        panel.add(userlabel);
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        passlabel = new JLabel("Password");
        passlabel.setBounds(10, 50, 80, 25);
        panel.add(passlabel);
        passText = new JPasswordField();
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setBounds(100, 80, 80, 25);
        button.addActionListener(new LoginGUI());
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setTitle("Life");
        successlabel = new JLabel("");
        successlabel.setBounds(10, 110, 300, 25);
        panel.add(successlabel);
        panel.setLayout(null);
        frame.setVisible(true);
        if (successlabel.equals("sucess")) {
            frame.dispose();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passText.getText();

        if (Max.equals(user) && (passwords.equals(password))) {
            char[] input = passText.getPassword();
            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(successlabel,
                        "Success");
            }
            LoginGUI.welcome();
        }
    }

    public static void welcome() {
        JFrame frame1 = new JFrame();
        frame1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 35));
        frame1.getContentPane().setBackground(new Color(0, 95, 106));
        JPanel panel1 = new JPanel();
        frame1.setSize(1920, 1080);
        frame1.getContentPane().add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().add(panel1);
        frame1.getContentPane().setLayout(null);

        JTable table = new JTable();
        table.setBackground(new Color(0, 255, 255));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[]{
                        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
                }
        ) {
            Class[] columnTypes = new Class[]{
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
        JButton btnNewButton = new JButton("Inbox");
        btnNewButton.setBounds(22, 129, 236, 45);
        frame1.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String host = "pop.gmail.com";// change accordingly
                String mailStoreType = "pop3";
                String username = "javatimburner@gmail.com";
                String password = "Toad2003";// change accordingly

                check(host, mailStoreType, username, password);
                frame1.dispose();
            }

            public void check(String host, String storeType, String user, String password) {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                frame.setSize(1920, 1080);
                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel.setLayout(null);
                JTextArea output1 = new JTextArea();
                JScrollPane scrollpane = new JScrollPane(output1);
                output1.setCaretPosition(output1.getDocument().getLength());
                frame.add(output1, BorderLayout.CENTER);
                frame.add(panel, BorderLayout.SOUTH);
                frame.setVisible(true);

                JButton button = new JButton();
                frame.add(button);
                ImageIcon icon = new ImageIcon(outlookexchangefolder.class.getResource("resources/back_button.png"));
                Image image = icon.getImage();
                Image imagenew = image.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(imagenew);
                button.setIcon(icon);
                button.setBounds(200, 222, 280, 156);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        LoginGUI.welcome();
                        frame.dispose();
                    }
                });
                try {

                    //create properties field
                    Properties properties = new Properties();

                    properties.put("mail.pop3.host", host);
                    properties.put("mail.pop3.port", "995");
                    properties.put("mail.pop3.starttls.enable", "true");
                    Session emailSession = Session.getDefaultInstance(properties);

                    //create the POP3 store object and connect with the pop server
                    Store store = emailSession.getStore("pop3s");

                    store.connect(host, user, password);

                    //create the folder object and open it
                    Folder emailFolder = store.getFolder("INBOX");
                    emailFolder.open(Folder.READ_ONLY);

                    // retrieve the messages from the folder in an array and print it
                    Message[] messages = emailFolder.getMessages();
                    output1.append("messages.length---" + messages.length);

                    for (int i = 0, n = messages.length; i < n; i++) {
                        Message message = messages[i];
                        output1.append("---------------------------------" + "\n");
                        output1.append("Email Number " + (i + 1) + "\n");
                        output1.append("Subject: " + message.getSubject() + "\n");
                        output1.append("From: " + message.getFrom()[0] + "\n");
                        output1.append("Text: " + message.getContent().toString() + "\n");
                    }
                    //close the store and folder objects
                    emailFolder.close(false);
                    store.close();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        JButton btnNewButton_1 = new JButton("Create new Email");
        btnNewButton_1.setBounds(22, 186, 236, 45);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emaileditor.realemaileditor();
            }
        });

        frame1.getContentPane().add(btnNewButton_1);
        JButton btnNewButton_2 = new JButton("To-do list");
        btnNewButton_2.setBounds(22, 255, 236, 45);
        frame1.getContentPane().add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                todolist.TodoList(null);
                frame1.dispose();
            }
        });

        JButton btnNewButton_3 = new JButton("Outlook Email folder");
        btnNewButton_3.setBounds(22, 324, 236, 218);
        frame1.getContentPane().add(btnNewButton_3);
        frame1.getContentPane().add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outlookexchangefolder.dosomething();
                frame1.dispose();
            }
        });

        JButton btnNewButton_4 = new JButton("Exchange Email Folder");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emailfolder.doitpls();
                frame1.dispose();
            }
        });
        btnNewButton_4.setBounds(22, 571, 240, 237);
        frame1.getContentPane().add(btnNewButton_4);

        JCalendar calendar = new JCalendar();
        calendar.setBounds(373, 181, 1004, 629);
        frame1.getContentPane().add(calendar);

        JLabel lblNewLabel_1 = new JLabel("Todo list");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(1708, 256, 114, 45);
        frame1.getContentPane().add(lblNewLabel_1);

        JTextField textField = new JTextField();
        textField.setBounds(1628, 324, 248, 420);
        frame1.getContentPane().add(textField);
        textField.setColumns(10);
        frame1.setVisible(true);


    }

    //if (user.equalsIgnoreCase(usercode) && password.equalsIgnoreCase(passcode));
    //if(user.equals("Max") && password.equals("Password"));
    //successlabel.setText("Log in works");

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {'T', 'e', 's', 't'};

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, correctPassword);
        }
        return isCorrect;
    }
}
