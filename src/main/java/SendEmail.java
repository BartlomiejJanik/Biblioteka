import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        final String username = "bibliotekajavatest@gmail.com";
        final String password = "biblioteka123";


        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bibliotekajavatest@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yanekk1990@gmai.com"));
            message.setSubject("Wypożyczenie");
            message.setText("wypożyczyłeś książke");
            Transport.send(message);

            System.out.println("wyslano");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
