package in.cdac.webclient.model;

import java.math.BigInteger;

public class KnowYourCustomer {
	private String aadharNumber;
	private String otpKYC;
	private String previousOTPKYCTransactionId;

	private String name;
	private String dob;
	private String gender;

	private String country;
	private String dist;
	private String house;
	private String lm;
	private String loc;
	private String po;
	private String subStreet;
	private String subDist;
	private BigInteger pc;
	private String vtc;

	private byte[] pht;
	private String base64Image;

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getOtpKYC() {
		return otpKYC;
	}

	public void setOtpKYC(String otpKYC) {
		this.otpKYC = otpKYC;
	}

	public String getPreviousOTPKYCTransactionId() {
		return previousOTPKYCTransactionId;
	}

	public void setPreviousOTPKYCTransactionId(String previousOTPKYCTransactionId) {
		this.previousOTPKYCTransactionId = previousOTPKYCTransactionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getSubStreet() {
		return subStreet;
	}

	public void setSubStreet(String subStreet) {
		this.subStreet = subStreet;
	}

	public String getSubDist() {
		return subDist;
	}

	public void setSubDist(String subDist) {
		this.subDist = subDist;
	}

	public String getVtc() {
		return vtc;
	}

	public void setVtc(String vtc) {
		this.vtc = vtc;
	}

	public BigInteger getPc() {
		return pc;
	}

	public void setPc(BigInteger pc) {
		this.pc = pc;
	}

	public byte[] getPht() {
		return pht;
	}

	public void setPht(byte[] bs) {
		this.pht = bs;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public String toString() {
		return "KnowYourCustomer [aadharNumber=" + aadharNumber + ", otpKYC=" + otpKYC
				+ ", previousOTPKYCTransactionId=" + previousOTPKYCTransactionId + ", name=" + name + ", dob=" + dob
				+ ", gender=" + gender + ", country=" + country + ", dist=" + dist + ", house=" + house + ", lm=" + lm
				+ ", loc=" + loc + ", po=" + po + ", subStreet=" + subStreet + ", subDist=" + subDist + ", pc=" + pc
				+ ", vtc=" + vtc + ", pht=" + pht + "]";
	}

}
