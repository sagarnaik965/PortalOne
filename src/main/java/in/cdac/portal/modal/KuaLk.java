package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class KuaLk {

	@NotEmpty(message = "Enter license key")
	@Pattern(regexp="(^([a-zA-Z0-9-_]){8,80}$)", message="Enter valid Licence key!")
	private String lk;

	@NotEmpty(message = "Enter expiry date")
	private String validTill;
	
	private LicenceType lkType;
	
	private boolean isServiceActivated;
	
	private String clk;



	public boolean isServiceActivated() {
		return isServiceActivated;
	}

	public void setServiceActivated(boolean isServiceActivated) {
		this.isServiceActivated = isServiceActivated;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String lk) {
		this.lk = lk;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public LicenceType getLkType() {
		return lkType;
	}

	public void setLkType(LicenceType lkType) {
		this.lkType = lkType;
	}

	public String getClk() {
		return clk;
	}

	public void setClk(String clk) {
		this.clk = clk;
	}

}
