import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
		public static void sendMail(String recepient, String subject, String realmessage) throws Exception {
			System.out.println("Preparing to send email");
			Properties properties = new Properties();
			
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String myAccountEmail = ""; //email
			String password = ""; //password
			
			Session session = Session.getInstance(properties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail, password);
				}
			});
			
			Message message = prepareMessage(session, myAccountEmail, recepient, realmessage, subject);
			
			Transport.send(message);
			System.out.println("Message sent successfully");
		}

		private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String realmessage, String subject) {
			try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(realmessage);
			message.setText(subject);
			return message;
			} catch (Exception e) {
				Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, e);			
			}
			return null;
		}
}