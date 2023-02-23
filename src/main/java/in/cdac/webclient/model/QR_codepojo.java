package in.cdac.webclient.model;

public class QR_codepojo {

	private String QRCodeData;
	private int email_mobile_value;
	private String referenceId;
	private String name;
	private String dateofbirth;
	private String gender;
	private String careof;
	private String district;
	private String landmark;
	private String house;
	private String location;
	private int pincode;
	private String postoffice;
	private String state;
	private String street;
	private String subdistrict;
	private String VTC;
	private String signatureHash;
	private String photo;

	// email and mobile is in hexdecimal
	private String emailIdHash;
	private String mobileNumberHash;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSignatureHash() {
		return signatureHash;
	}

	public void setSignatureHash(String signatureHash) {
		this.signatureHash = signatureHash;
	}

	public String getEmailIdHash() {
		return emailIdHash;
	}

	public void setEmailIdHash(String emailIdHash) {
		this.emailIdHash = emailIdHash;
	}

	public String getMobileNumberHash() {
		return mobileNumberHash;
	}

	public void setMobileNumberHash(String mobileNumberHash) {
		this.mobileNumberHash = mobileNumberHash;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCareof() {
		return careof;
	}

	public void setCareof(String careof) {
		this.careof = careof;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getVTC() {
		return VTC;
	}

	public void setVTC(String vTC) {
		VTC = vTC;
	}

	public String getQRCodeData() {
		return QRCodeData;
	}

	public void setQRCodeData(String qRCodeData) {
		QRCodeData = qRCodeData;
	}

	public int getEmail_mobile_value() {
		return email_mobile_value;
	}

	public void setEmail_mobile_value(int email_mobile_value) {
		this.email_mobile_value = email_mobile_value;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	@Override
	public String toString() {
		return "QR_codepojo [QRCodeData=" + QRCodeData + ", email_mobile_value=" + email_mobile_value + ", referenceId="
				+ referenceId + ", name=" + name + ", dateofbirth=" + dateofbirth + ", gender=" + gender + ", careof="
				+ careof + ", district=" + district + ", landmark=" + landmark + ", house=" + house + ", location="
				+ location + ", pincode=" + pincode + ", postoffice=" + postoffice + ", state=" + state + ", street="
				+ street + ", subdistrict=" + subdistrict + ", VTC=" + VTC + ", signatureHash=" + signatureHash
				+ ", emailIdHash=" + emailIdHash + ", mobileNumberHash=" + mobileNumberHash + "]";
	}

}
