package in.cdac.portal.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import in.cdac.portal.dao.UserDao;
import in.cdac.portal.filter.CaptchaCaptureFilter;

public class AuthenticationProviderImpl implements AuthenticationProvider {

	private final static Logger logger = Logger.getLogger(AuthenticationProviderImpl.class);

	@Autowired
	UserDao userDao;

	CaptchaCaptureFilter captchaCaptureFilter;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();

		logger.info("::UserName::" + userName + "::password::" + password);
		logger.info("::Captcha Value::" + captchaCaptureFilter.getCaptchaChallenge() + "::"+ captchaCaptureFilter.getResponseCaptcha());
		return new UsernamePasswordAuthenticationToken(userName, password, null);
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
