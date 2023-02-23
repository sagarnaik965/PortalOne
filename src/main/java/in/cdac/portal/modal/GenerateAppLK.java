package in.cdac.portal.modal;


import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class GenerateAppLK {
	
	
	public String app_code;
	public UUID lk;
	public String dept_code;
	
	@NotBlank(message = "Please enter Lk expiry date")
	public Date lkexpiry;
	
	public String getApp_code() {
		return app_code;
	}
	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}
	public UUID getLk() {
		return lk;
	}
	public void setLk(UUID lk) {
		this.lk = lk;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public Date getLkexpiry() {
		return lkexpiry;
	}
	public void setLkexpiry(Date lkexpiry) {
		this.lkexpiry = lkexpiry;
	}
	@Override
	public String toString() {
		return "GenerateAppLK [app_code=" + app_code + ", lk=" + lk + ", dept_code=" + dept_code + ", lkexpiry="
				+ lkexpiry + "]";
	} 

	
	
}
