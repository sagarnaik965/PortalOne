package in.cdac.webclient.model;

import java.math.BigInteger;
import java.util.Arrays;

import javax.xml.datatype.XMLGregorianCalendar;

public class DemographicAauthentication {
	private String aadhaarHolderName;
	private String aadharNumber;
	private String virtualID;
	private String maskedAadhaarNumber;
	private String maskedVirtualID;
	private String Result;
	private String errorCode;
	private String errorMessage;
	private String statusMessage;
	private XMLGregorianCalendar timeStamp;

	private String personalAddressDist;
	private String personalFullAddress;

	private String transactionID;

	private String otp;
	private String pinvalue;

	private String previousOTPAuthTransactionId;

	private String env;
	private String biometricType;
	private String fCount;
	private String biometricPosition;

	// Kyc
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

	private String encodedAadhaarNumber;
	private String udc;

	public String getAadhaarHolderName() {
		return aadhaarHolderName;
	}

	public void setAadhaarHolderName(String aadhaarHolderName) {
		this.aadhaarHolderName = aadhaarHolderName;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber2) {
		this.aadharNumber = aadharNumber2;
	}

	public String getVirtualID() {
		return virtualID;
	}

	public void setVirtualID(String virtualID) {
		this.virtualID = virtualID;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getPersonalAddressDist() {
		return personalAddressDist;
	}

	public void setPersonalAddressDist(String personalAddressDist) {
		this.personalAddressDist = personalAddressDist;
	}

	public String getPersonalFullAddress() {
		return personalFullAddress;
	}

	public void setPersonalFullAddress(String personalFullAddress) {
		this.personalFullAddress = personalFullAddress;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public XMLGregorianCalendar getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(XMLGregorianCalendar timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPinvalue() {
		return pinvalue;
	}

	public void setPinvalue(String pinvalue) {
		this.pinvalue = pinvalue;
	}

	public String getPreviousOTPAuthTransactionId() {
		return previousOTPAuthTransactionId;
	}

	public void setPreviousOTPAuthTransactionId(String previousOTPAuthTransactionId) {
		this.previousOTPAuthTransactionId = previousOTPAuthTransactionId;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getBiometricType() {
		return biometricType;
	}

	public void setBiometricType(String biometricType) {
		this.biometricType = biometricType;
	}

	public String getfCount() {
		return fCount;
	}

	public void setfCount(String fCount) {
		this.fCount = fCount;
	}

	public String getBiometricPosition() {
		return biometricPosition;
	}

	public void setBiometricPosition(String biometricPosition) {
		this.biometricPosition = biometricPosition;
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

	public BigInteger getPc() {
		return pc;
	}

	public void setPc(BigInteger pc) {
		this.pc = pc;
	}

	public String getVtc() {
		return vtc;
	}

	public void setVtc(String vtc) {
		this.vtc = vtc;
	}

	public byte[] getPht() {
		return pht;
	}

	public void setPht(byte[] pht) {
		this.pht = pht;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getEncodedAadhaarNumber() {
		return encodedAadhaarNumber;
	}

	public void setEncodedAadhaarNumber(String encodedAadhaarNumber) {
		this.encodedAadhaarNumber = encodedAadhaarNumber;
	}

	public String getMaskedAadhaarNumber() {
		return maskedAadhaarNumber;
	}

	public void setMaskedAadhaarNumber(String maskedAadhaarNumber) {
		this.maskedAadhaarNumber = maskedAadhaarNumber;
	}

	public String getMaskedVirtualID() {
		return maskedVirtualID;
	}

	public void setMaskedVirtualID(String maskedVirtualID) {
		this.maskedVirtualID = maskedVirtualID;
	}

	public String getUdc() {
		return udc;
	}

	public void setUdc(String udc) {
		this.udc = udc;
	}

	@Override
	public String toString() {
		return "DemographicAauthentication [aadhaarHolderName=" + aadhaarHolderName + ", aadharNumber=" + aadharNumber
				+ ", Result=" + Result + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", statusMessage=" + statusMessage + ", timeStamp=" + timeStamp + ", personalAddressDist="
				+ personalAddressDist + ", personalFullAddress=" + personalFullAddress + ", transactionID="
				+ transactionID + ", otp=" + otp + ", pinvalue=" + pinvalue + ", previousOTPAuthTransactionId="
				+ previousOTPAuthTransactionId + ", env=" + env + ", biometricType=" + biometricType + ", fCount="
				+ fCount + ", biometricPosition=" + biometricPosition + ", name=" + name + ", dob=" + dob + ", gender="
				+ gender + ", country=" + country + ", dist=" + dist + ", house=" + house + ", lm=" + lm + ", loc="
				+ loc + ", po=" + po + ", subStreet=" + subStreet + ", subDist=" + subDist + ", pc=" + pc + ", vtc="
				+ vtc + ", pht=" + Arrays.toString(pht) + ", base64Image=" + base64Image + ", encodedAadhaarNumber="
				+ encodedAadhaarNumber + "]";
	}

}
