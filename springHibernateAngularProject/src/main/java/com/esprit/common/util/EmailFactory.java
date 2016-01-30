package com.esprit.common.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author KoffiMawuli adjoda
 * 
 */
public final class EmailFactory {
	private static final String AUTHENTICATE_USER = "koffimawuli.adjoda@gmail.com";
	private static final String PASSWORD = "#EB169191.";
	private static final String USER_NAME = "ADJODA";

	private static final String LIEN_CONFIG_AUTHORISATION_CONNECTION = "https://www.google.com/settings/security/lesssecureapps";

	private static final Logger LOGGER = Logger.getLogger(EmailFactory.class.getName());

	/**
	 * Cette methode permer d'envoyer des e-mails
	 * 
	 * @param to
	 * @param subject
	 * @param body
	 * @param fileToAttach
	 * @return
	 */
	public void sendEmail(List<String> recipientAdresses, String subject, String body, List<String> filesToAttach) {

		if (recipientAdresses != null && !recipientAdresses.isEmpty()) {

			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");

			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.transport.protocol", "smtp");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.debug", "true");

			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(AUTHENTICATE_USER, PASSWORD);
				}
			});
			boolean errorOccured=false;
			try {

				MimeMessage message = new MimeMessage(session);
				InternetAddress from = null;
				try {
					from = new InternetAddress(AUTHENTICATE_USER, USER_NAME);
				} catch (UnsupportedEncodingException e) {
					LOGGER.log(Level.SEVERE, "Error while try to authenticate whith" + AUTHENTICATE_USER, e);
				}
				message.setFrom(from);

				List<String> validRecipientAdresses = new ArrayList<String>();
				for (String email : recipientAdresses) {
					if (isValid(email)) {
						validRecipientAdresses.add(email);
					} else {
						LOGGER.log(Level.SEVERE, "email address" + email + "is not valid");
					}
				}

				InternetAddress[] address = new InternetAddress[validRecipientAdresses.size()];

				if (validRecipientAdresses != null && !validRecipientAdresses.isEmpty()) {

					for (int i = 0; i < validRecipientAdresses.size(); i++) {
						address[i] = new InternetAddress(validRecipientAdresses.get(i));
					}

					message.setRecipients(Message.RecipientType.TO, address);
					message.setSubject(subject);
					message.setSentDate(new Date());

					if (filesToAttach != null && !filesToAttach.isEmpty()) {

						MimeBodyPart messagePart = new MimeBodyPart();
						messagePart.setContent(body, "text/html; charset=utf-8");
						Multipart multipart = new MimeMultipart();
						multipart.addBodyPart(messagePart);

						for (String fileToAttach : filesToAttach) {
							FileDataSource fileDataSource = new FileDataSource(fileToAttach) {
								@Override
								public String getContentType() {
									return "application/octet-stream";
								}
							};
							MimeBodyPart attachmentPart = new MimeBodyPart();
							attachmentPart.setDataHandler(new DataHandler(fileDataSource));
							attachmentPart.setFileName(fileDataSource.getName());
							multipart.addBodyPart(attachmentPart);

						}
						message.setContent(multipart);
					} else {
						message.setContent(body, "text/html; charset=utf-8");
					}
					message.saveChanges();
					Transport.send(message);
				}
			} catch (MessagingException e) {
				errorOccured=true;
				LOGGER.log(Level.SEVERE, "Error occured", e);
			} finally {
				if (isValid(AUTHENTICATE_USER) && errorOccured) {
					LOGGER.log(Level.SEVERE,
							"check is authentication is enabled from " + LIEN_CONFIG_AUTHORISATION_CONNECTION);
				}
			}
		}
	}

	public boolean isValid(String email) {
		Pattern pattern = Pattern.compile(
				"^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		if (!pattern.matcher(email).matches()) {
			LOGGER.log(Level.SEVERE, email + "is not valid");
			return false;
		}
		return true;
	}

//	public static void main(String[] args) {
//
//		String[] to = { "alefort@adaming.fr", "koffimawuli.adjoda@gmail.com" };
//
//		String subject = "Test mail";
//
//		String body = "Test body";
//
//		String filenamePath = "C:/Users/KoffiMawuli/Documents/Chistie/CV_Christie_EN.pdf";
//		List<String> files = new ArrayList<>();
//		files.add(filenamePath);
//		EmailFactory emailFactory = new EmailFactory();
//		emailFactory.sendEmail(Arrays.asList(to), subject, body, files);
//	}

}