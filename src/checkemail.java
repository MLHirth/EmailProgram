import java.awt.BorderLayout;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class checkemail {


    public static void fetch(String pop3Host, String storeType, String user,
                             String password) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1920, 1080);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        JTextArea output1 = new JTextArea();
        frame.add(output1, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
        try {
            // create properties field
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "pop3");
            properties.put("mail.pop3.host", pop3Host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
            // emailSession.setDebug(true);

            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(pop3Host, user, password);

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            output1.append("messages.length---" + messages.length);

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                output1.append("---------------------------------");
                writePart(message, output1);
                String line = reader.readLine();
                if ("YES".equals(line)) {
                    message.writeTo(System.out);
                } else if ("QUIT".equals(line)) {
                    break;
                }
            }

            // close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

        //Call method fetch
        fetch(host, mailStoreType, username, password);

    }


    /*
     * This method checks for content-type
     * based on which, it processes and
     * fetches the content of the message
     */
    public static void writePart(Part p, JTextArea output1) throws Exception {
        if (p instanceof Message)
            //Call methods writeEnvelope
            writeEnvelope((Message) p, output1);

        output1.append("----------------------------");
        //System.out.println("CONTENT-TYPE: " + p.getContentType());

        //check if the content is plain text
        if (p.isMimeType("text/plain")) {
            output1.append("This is plain text");
            output1.append("---------------------------");
            output1.append((String) p.getContent());

        }
        //check if the content has attachment
        else if (p.isMimeType("multipart/*")) {
            output1.append("This is a Multipart");
            output1.append("---------------------------");
            Multipart mp = (Multipart) p.getContent();
            int count = mp.getCount();
            for (int i = 0; i < count; i++)
                writePart(mp.getBodyPart(i), output1);
        }
        //check if the content is a nested message
        else if (p.isMimeType("message/rfc822")) {
            output1.append("This is a Nested Message");
            output1.append("---------------------------");
            writePart((Part) p.getContent(), output1);
        }
        //check if the content is an inline image
        else if (p.isMimeType("image/jpeg")) {
            output1.append("--------> image/jpeg");
            Object o = p.getContent();

            InputStream x = (InputStream) o;
            // Construct the required byte array
            output1.append("x.length = " + x.available());
            int i;
            byte[] bArray = new byte[x.available()];
            while ((i = (int) ((InputStream) x).available()) > 0) {
                int result = (int) (((InputStream) x).read(bArray));
                if (result == -1)
                    i = 0;
                break;
            }
            FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
            f2.write(bArray);
        } else if (p.getContentType().contains("image/")) {
            output1.append("content type" + p.getContentType());
            File f = new File("image" + new Date().getTime() + ".jpg");
            DataOutputStream output = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(f)));
            com.sun.mail.util.BASE64DecoderStream test =
                    (com.sun.mail.util.BASE64DecoderStream) p
                            .getContent();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = test.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } else {
            Object o = p.getContent();
            if (o instanceof String) {
                output1.append("This is a string");
                output1.append("---------------------------");
                output1.append((String) o);
            } else if (o instanceof InputStream) {
                output1.append("This is just an input stream");
                output1.append("---------------------------");
                InputStream is = (InputStream) o;
                is = (InputStream) o;
                int c;
                while ((c = is.read()) != -1)
                    System.out.write(c);
            } else {
                output1.append("This is an unknown type");
                output1.append("---------------------------");
                output1.append(o.toString());
            }
        }

    }

    /*
     * This method would print FROM,TO and SUBJECT of the message
     */
    public static void writeEnvelope(Message m, JTextArea output1) throws Exception {
        output1.append("This is the message envelope");
        output1.append("---------------------------");
        Address[] a;

        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                output1.append("FROM: " + a[j].toString());
        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++)
                output1.append("TO: " + a[j].toString());
        }

        // SUBJECT
        if (m.getSubject() != null)
            output1.append("SUBJECT: " + m.getSubject());
    }

}