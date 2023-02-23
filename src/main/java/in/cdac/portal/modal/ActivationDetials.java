package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ActivationDetials {

	@NotEmpty(message="Password should not be blank")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*_\\\\(\\\\)])[a-zA-Z0-9!@#$%^&*_\\\\(\\\\)]{6,16}$", message="Your password must be at least 6 characters, must contain letters, digits and special characters.")
	String newPassword;
	
	@NotEmpty(message="Password should not be blank")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*_\\\\(\\\\)])[a-zA-Z0-9!@#$%^&*_\\\\(\\\\)]{6,16}$", message="Your password must be at least 6 characters, must contain letters, digits and special characters.")
	String confirmPassword;
	
	int dept;
	
	String userName;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
