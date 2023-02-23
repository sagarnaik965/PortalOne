package in.cdac.portal.modal;



import javax.validation.constraints.Pattern;


import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ProfileDetail {
	 
	//@NotEmpty(message="Name cannot be left empty!")
	@Pattern.List({
	@Pattern(regexp="(^([a-zA-Z ]){5,30}$)", message="Enter a valid name,Special character and numbers not allowed(Minimum 5 chatacters required)!"),
	//@Pattern(regexp="\\S", message="Enter valid name!")
	})
	//@Length(max=30,min=5,message="Enter a valid Name between 5 to 30 characters!")
	private String cd_name;
	
	
//^[0-9a-zA-Z\s,-]+$
	//@Pattern.List({
	//@Pattern(regexp="(^([a-z\nA-Z0-9 )(-[],@){5,120})+$", message="Enter valid address, Special characters are not allowed excluding -,@ []")
	//@Pattern(regexp="^[0-9a-zA-Z\\s\\(#\\)-]+$", message="Enter valid address, Special characters are not allowed excluding Braces,Hash and Hyphen"),
	//})
	private String addressLine;
	
	
	//@NotEmpty(message="Enter City Name ")
	@Pattern.List({
	@Pattern(regexp="(^([a-zA-Z ]){3,60}$)", message="Enter a valid city,special characters not allowed!"),
	//@Pattern(regexp="\\S", message="Enter valid city!"),
	})
	private String city;
	private String state_code;
	//@NotEmpty(message="Enter Pin code")
	@Pattern.List({
		@Pattern(regexp="^[0-9][0-9]{5}$", message="Enter a valid Pincode!"),
	})
	
	private String pincode;
	
	//@Length(max=10,min=10,message="Phone number is not valid!")
	
	@Pattern.List({
	@Pattern(regexp="^[0-9][0-9]{5}$", message="Enter a valid Phone Number!"),
	})
	private String phone;
	
	
	
	//@NotEmpty(message="Enter designation ")
	//@Length(max=10,min=3,message="Enter a valid designation between 3 to 10 chracters!")
	@Pattern.List({
	@Pattern(regexp="(^([a-zA-Z0-9 ]){3,100}$)", message="Enter a valid designation!,should start with alphabet and special characters  are not allowed"),
	//@Pattern(regexp="\\S", message="Enter valid designation!"),
	//@Pattern(regexp="[a-zA-z](?=(([a-zA-Z0-9 -]){3,100}$))", message="xEnter a valid designation!,special characters excluding '-' not allowed"),
	})
	private String cd_designation;
	
	
	@NumberFormat(style=Style.NUMBER)
	@Pattern(regexp="^[6-9][0-9]{9}$", message="Please enter valid mobile number")
	private String cd_mobile;
	
	
	@NumberFormat(style=Style.NUMBER)
	@Pattern(regexp="^[0-9]{10,11}$", message="Please enter valid phone number")
	private String cd_phone ;

	private String emailId;

	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		
		this.addressLine = addressLine;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState_code() {
		return state_code;
	}


	public void setState_code(String state_code) {
		this.state_code = state_code;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCd_name() {
		return cd_name;
	}


	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}


	public String getCd_designation() {
		return cd_designation;
	}


	public void setCd_designation(String cd_designation) {
		this.cd_designation = cd_designation;
	}


	public String getCd_mobile() {
		return cd_mobile;
	}


	public void setCd_mobile(String cd_mobile) {
		this.cd_mobile = cd_mobile;
	}


	public String getCd_phone() {
		return cd_phone;
	}


	public void setCd_phone(String cd_phone) {
		this.cd_phone = cd_phone;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
