package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.NotEmpty;

public class UpdateAuaLk {

	@NotEmpty(message="Enter license key")
	@Pattern(regexp="(^([a-zA-Z0-9-_]){8,80}$)", message="Enter valid Licence key!")
	private String auaLk;
	
	@NotEmpty(message="Enter expiry date")
	private String expiryDate;
	
	private Boolean is_dept_activated;
	
	private String clk;
	
	
	


	public Boolean getIs_dept_activated() {
		return is_dept_activated;
	}

	public void setIs_dept_activated(Boolean is_dept_activated) {
		this.is_dept_activated = is_dept_activated;
	}

	public UpdateAuaLk() {
		
	}

	public String getAuaLk() {
		return auaLk;
	}

	public void setAuaLk(String auaLk) {
		this.auaLk = auaLk;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getClk() {
		return clk;
	}

	public void setClk(String clk) {
		this.clk = clk;
	}

	
	
}
