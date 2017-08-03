package org.aktin.dwh;

import java.io.IOException;
import java.util.Locale;

import javax.activation.DataSource;

/**
 * Send e-mails using the configuration of the AKTIN data warehouse
 *
 * @author R.W.Majeed
 *
 */
public interface EmailService {

	/**
	 * Get the language to use for the email
	 * @return language
	 */
	Locale getLocale();
	
	void sendEmail(String subject, String content) throws IOException;
	void sendEmail(String subject, String content, DataSource attachment) throws IOException;
}
