package in.cdac.portal.modal;

public class SigningDetails {
	
	SigningType requestSignType;//HARD SOFT
	SignBy requestSignDoneAt; // ASA AUA
	SignBy decrypeKycDoneAt; //ASA AUA
	boolean eKycPacketSign; //TRUE FALSE
	SigningType decrypType; //HARD SOFT
	SigningType encrypType; //HARD SOFT
	private String ac;
	private String deptName;
	private String symencrypType;
	
	public SigningType getRequestSignType() {
		return requestSignType;
	}
	public void setRequestSignType(SigningType requestSignType) {
		this.requestSignType = requestSignType;
	}
	public SignBy getRequestSignDoneAt() {
		return requestSignDoneAt;
	}
	public void setRequestSignDoneAt(SignBy requestSignDoneAt) {
		this.requestSignDoneAt = requestSignDoneAt;
	}
	public SignBy getDecrypeKycDoneAt() {
		return decrypeKycDoneAt;
	}
	public void setDecrypeKycDoneAt(SignBy decrypeKycDoneAt) {
		this.decrypeKycDoneAt = decrypeKycDoneAt;
	}
	public boolean iseKycPacketSign() {
		return eKycPacketSign;
	}
	public void seteKycPacketSign(boolean eKycPacketSign) {
		this.eKycPacketSign = eKycPacketSign;
	}
	public SigningType getDecrypType() {
		return decrypType;
	}
	public void setDecrypType(SigningType decrypType) {
		this.decrypType = decrypType;
	}
	public SigningType getEncrypType() {
		return encrypType;
	}
	public void setEncrypType(SigningType encrypType) {
		this.encrypType = encrypType;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSymencrypType() {
		return symencrypType;
	}
	public void setSymencrypType(String symencrypType) {
		this.symencrypType = symencrypType;
	}
	
	
	
	
	
}
