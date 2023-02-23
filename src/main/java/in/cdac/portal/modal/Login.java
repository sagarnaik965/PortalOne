package in.cdac.portal.modal;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	@Size(min = 3, max = 30, message = "Enter username")
	private String username;
	
	@NotEmpty(message="Enter Password")
	private String password;
	
	private String captcha;
	
	public Login() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}
