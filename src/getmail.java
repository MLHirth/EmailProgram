

import java.awt.BorderLayout;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class getmail {


   public static void check(String host, String storeType, String user,
      String password) 
   {
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
         output1.append("---------------------------------"+ "\n");
         output1.append("Email Number " + (i + 1)+ "\n");
         output1.append("Subject: " + message.getSubject() + "\n");
         output1.append("From: " + message.getFrom()[0]+ "\n");
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
	
   public static void main(String[] args) {

       String host = "pop.gmail.com";// change accordingly
       String mailStoreType = "pop3";
       String username = ""; //add username (email)
       String password = ""; //Password needs to be set
       //further implementation to set up account separately

      check(host, mailStoreType, username, password);

   }

}
