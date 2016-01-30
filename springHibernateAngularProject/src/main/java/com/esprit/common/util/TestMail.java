package com.esprit.common.util;

import java.util.ArrayList;
import java.util.List;

public class TestMail {

	public static void main(String[] args) {
		String[] recipientsAddresses = { "test@test.com", "chirackymundadi@gmail.com" };

		String subject = "Test envoie de mail";

		String body = "<p>Bonjour cher ami,<p>"
				     +"<br></br>"+
				      "<p>Ceci est un test d'envoi de mail via une application java.</p>"
				      +"<br></br>"
				      +"<br></br>"
				      +"<p>Salut,<p>"
					  +"<p>Mawuli Koffi ADJODA</p>";
	

		String filenamePath = "C:/Users/KoffiMawuli/Documents/Conception-et-Realisation-d.docx";
		List<String> files = new ArrayList<String>();
		files.add(filenamePath);
		
		ThreadMail threadMail=new ThreadMail(recipientsAddresses, subject, body, files);
		threadMail.start();
	}

}
