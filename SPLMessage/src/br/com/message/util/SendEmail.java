/**
 * 
 */
package br.com.message.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author alsoares
 *
 */
public class SendEmail {

	private static final String HOST_DEFAULT = "localhost";
	private static final String HOST_SMTP = "mail.smtp.host";
	private static final String MAIL_USER = "mail.user";
	private static final String MAIL_PASSWORD = "mail.password";
	private static final String EMAIL_DEFAULT = "alansansoa@gmail.com";
	// Get system properties
	private Properties properties;
	// Get the default Session object.
	private Session session;

	public SendEmail() {
		this.properties = System.getProperties();
		this.properties.setProperty(HOST_SMTP, HOST_DEFAULT);
		this.properties.setProperty(MAIL_USER, "myuser");
		this.properties.setProperty(MAIL_PASSWORD, "mypwd");
		this.session = Session.getDefaultInstance(this.properties);
	}

	public boolean send(Email email) {
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			if(email.getFrom() == null){
				message.setFrom(new InternetAddress(EMAIL_DEFAULT));
			} else {
				message.setFrom(new InternetAddress(email.getFrom()));
			}
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			// Set Subject: header field
			message.setSubject(email.getSubject());
			// Now set the actual message
			message.setText(email.getText());
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			return false;
		}

		return true;
	}
}
