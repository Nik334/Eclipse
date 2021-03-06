package forgetPassword;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility
{
	public static void sendEmail(String host, String port, final String senderEmail, String senderName, final String password,
            String recipientEmail, String subject, String message) 
	{
		try {
			Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        Authenticator auth = new Authenticator() {
	        	public PasswordAuthentication getPasswordAuthentication()
	        	{
	        		return new PasswordAuthentication(senderEmail, password);
	        	}
			};
			
			Session session = Session.getInstance(properties,auth);
			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderEmail,senderName));
			
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(message);
			Transport.send(msg);
			System.out.println("alert 8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
