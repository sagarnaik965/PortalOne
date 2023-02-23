package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ForgetPassword {
	
	@Email(message="Valid Email Id")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	
	@NotEmpty(message="Enter username")
	private String userName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
