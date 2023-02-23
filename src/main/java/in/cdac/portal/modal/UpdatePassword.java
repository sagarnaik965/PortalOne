package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



/*@FieldMatch.List({
	@FieldMatch(first = "newPassword", second = "confirmPassword", message = "The password fields must match")
})*/
public class UpdatePassword {

	@NotEmpty(message="Enter old password")
	//@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$", message="Password should capital & small letter, digit and special character & should be of minimum length 6 ")
	private String oldPassword;
	

	@NotEmpty(message="Enter new Password")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[!@#$%^&*_\\(\\)])[a-zA-Z0-9!@#$%^&*_\\(\\)]{6,16}$", message="Your password must be at least 6 characters, must contain letters, digits and special characters. ")
	private String newPassword;
	
	@NotEmpty(message="Enter Confirm Password")
	private String confirmPassword;
	
	public UpdatePassword() {
		
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

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
	
	
}
