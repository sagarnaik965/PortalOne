package in.cdac.portal.modal;

import java.util.Date;
//import java.security.Timestamp;

import javax.validation.constraints.NotBlank;

public class AppLk {

	public String lk;

	@NotBlank(message = "Please enter Lk expiry date")
	public Date lkexpiry;
	public Boolean app_is_active;

	public Boolean getApp_is_active() {
		return app_is_active;
	}

	public void setApp_is_active(Boolean app_is_active) {
		this.app_is_active = app_is_active;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String lk) {
		this.lk = lk;
	}

	public Date getLkexpiry() {
		return lkexpiry;
	}

	public void setLkexpiry(Date lkexpiry) {
		this.lkexpiry = lkexpiry;
	}

	public AppLk(String lk, Date lkexpiry) {
		super();
		this.lk = lk;
		this.lkexpiry = lkexpiry;
	}

	public AppLk() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return lk + " " + lkexpiry + " " + app_is_active;
	}

}
