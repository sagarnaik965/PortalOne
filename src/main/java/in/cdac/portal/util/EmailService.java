package in.cdac.portal.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import in.cdac.portal.service.UserService;

@Service
@Configuration
@PropertySources(value = {@PropertySource("classpath:email_config.properties")})
public class EmailService {
	static String username = "";
	static String password = "";

	@Autowired
	UserService userService;

	@Autowired
	Environment env;
	private static String enviroment;


	private final static Logger logger = Logger.getLogger(EmailService.class);

}
