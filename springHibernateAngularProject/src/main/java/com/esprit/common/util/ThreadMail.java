package com.esprit.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author lefort
 * @description Tread d'envoie de mail
 */
public class ThreadMail extends Thread {
	private String[] recipientsAddresses;

	private String subject;

	private String body;

	List<String> filesPaths;

	public ThreadMail(String[] recipientsAddresses, String subject, String body, List<String> filesPaths) {
		super();
		this.recipientsAddresses = recipientsAddresses;
		this.subject = subject;
		this.body = body;
		this.filesPaths = filesPaths;
	}

	public void run() {

		EmailFactory emailFactory = new EmailFactory();
		emailFactory.sendEmail(Arrays.asList(recipientsAddresses), subject, body, filesPaths);

	}
}
