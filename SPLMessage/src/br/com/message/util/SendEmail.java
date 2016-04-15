/**
 * 
 */
package br.com.message.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author alsoares
 *
 */
public class SendEmail {
	
	private static final String CONFIG_MAIL = "resources/mail.properties";
	private static final String USERNAME = "mail.smtp.user";
	private static final String PASSWORD = "mail.password";
	
	// Get system properties
	private Properties properties;
	// Get the default Session object.
	private Session session;

	public SendEmail() {
		InputStream input = null;
		this.properties = new Properties();
		try {
			input = new FileInputStream(CONFIG_MAIL);
			this.properties.load(input);
			this.session = Session.getDefaultInstance(this.properties, new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(properties.getProperty(USERNAME), properties.getProperty(PASSWORD));
            }});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean send(Email email) {
		try {
		    
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(properties.getProperty(USERNAME)));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			// Set Subject: header field
			message.setSubject(email.getSubject());
			// Now set the actual message
			message.setText(email.getText());
			// Today
			message.setSentDate(new Date());
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}
}
