package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


public class LicensekeyDetails {

	@NotEmpty(message = "Enter license key")
	@Pattern(regexp="(^([a-zA-Z0-9-_]){8,80}$)", message="Enter valid Licence key!")
	private String licenseKey;

	@NotEmpty(message = "Enter valid date")
	private String validTill;

	private LicenceType licenseKeyType;

	private boolean deptActivated;
	
	private String clientLicensekey;

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public LicenceType getLicenseKeyType() {
		return licenseKeyType;
	}

	public void setLicenseKeyType(LicenceType licenseKeyType) {
		this.licenseKeyType = licenseKeyType;
	}

	

	public boolean isDeptActivated() {
		return deptActivated;
	}

	public void setDeptActivated(boolean deptActivated) {
		this.deptActivated = deptActivated;
	}

	public String getClientLicensekey() {
		return clientLicensekey;
	}

	public void setClientLicensekey(String clientLicensekey) {
		this.clientLicensekey = clientLicensekey;
	}
		
	private boolean isActive;
	private boolean isAuthActive;
	private boolean isKycActive;
	private boolean isOtpActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAuthActive() {
		return isAuthActive;
	}

	public void setAuthActive(boolean isAuthActive) {
		this.isAuthActive = isAuthActive;
	}

	public boolean isKycActive() {
		return isKycActive;
	}

	public void setKycActive(boolean isKycActive) {
		this.isKycActive = isKycActive;
	}

	public boolean isOtpActive() {
		return isOtpActive;
	}

	public void setOtpActive(boolean isOtpActive) {
		this.isOtpActive = isOtpActive;
	}

	@Override
	public String toString() {
		return "LicensekeyDetails [licenseKey=" + licenseKey + ", validTill=" + validTill + ", licenseKeyType="
				+ licenseKeyType + ", deptActivated=" + deptActivated + ", clientLicensekey=" + clientLicensekey
				+ ", isActive=" + isActive + ", isAuthActive=" + isAuthActive + ", isKycActive=" + isKycActive
				+ ", isOtpActive=" + isOtpActive + "]";
	}

	
	
	

	

}
