package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AddUser {
	@Email(message="Enter Valid Email Id")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	
	@NotEmpty(message="Please Enter Department Name")
	private String deptName;
	
	private String appCode;
	private String desc;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
