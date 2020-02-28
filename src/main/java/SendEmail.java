import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

public class SendEmail {
    public void sendDodanoKarte(Karta karta){
        final String username = "bibliotekajavatest@gmail.com";
        final String password = "biblioteka123";
        LocalDate date = LocalDate.now();



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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(karta.getKlient().getEmail()));
            message.setSubject("Karta bibioteczna");
            message.setText("Utworzyliśmy kartę bibioteczną o nr: "+karta.getNrKarty()+"\n"+"z dniem:"+date+" zostałeś pełno prawnym klientem naszej bibioteki, dziękuejmy!"
                    +"\n"+"Pozdawiamy!");
            Transport.send(message);

            System.out.println("Wyslano E-mail potwierdzający");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendDodanoKlienta(Klient klient){
        final String username = "bibliotekajavatest@gmail.com";
        final String password = "biblioteka123";
        LocalDate date = LocalDate.now();



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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(klient.getEmail()));
            message.setSubject("Witaj!");
            message.setText("Witamy w naszej Bibiotece!"+"\n"+"z dniem:"+date+" zostałeś dodany do naszej bazy klientów!"+"\n"+"Pozdawiamy!");
            Transport.send(message);

            System.out.println("Wyslano E-mail potwierdzający");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public void sendWypozycz(Ksiazka ksiazka,Karta karta) {
        final String username = "bibliotekajavatest@gmail.com";
        final String password = "biblioteka123";
        LocalDate date = LocalDate.now();
        LocalDate dataZwrotu = date.plusDays(20);


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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(karta.getKlient().getEmail()));
            message.setSubject("Operacja na karcie nr: "+karta.getNrKarty());
            message.setText("Kliencie,"+"\n"+"wypożyczyłeś książke o nr: "+ksiazka.getNrKsiazki()+"\n"+
                    "Autor: "+ksiazka.getAutorKsiazki()+"\n"+"Tytyuł: "+ksiazka.getTytulKsiazki()+"."+
                    "\n"+"Data zwrotu ksiązki przypada na: "+dataZwrotu);
            Transport.send(message);

            System.out.println("Wyslano E-mail potwierdzający");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
