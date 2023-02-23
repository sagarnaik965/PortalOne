package in.cdac.portal.modal;

public class TransactionDetailReport {
	private String txn;
	private String timestamp;
	private String errorCode;
	private String ret;
	private String ac;
	private String ver;
	private String type;
	private String requestReceiptTime;
	private String responseReceiptTime;
	private String responseCode;
	@Override
	public String toString() {
		return "TransactionDetailReport [txn=" + txn + ", timestamp=" + timestamp + ", errorCode=" + errorCode
				+ ", ret=" + ret + ", ac=" + ac + ", ver=" + ver + ", type=" + type + ", requestReceiptTime="
				+ requestReceiptTime + ", responseReceiptTime=" + responseReceiptTime + ", responseCode=" + responseCode
				+ ", request_forward_time=" + request_forward_time + ", response_forward_time=" + response_forward_time
				+ ", packet_response_time=" + packet_response_time + ", packet_request_time=" + packet_request_time
				+ ", ch=" + ch + ", aua_code=" + aua_code + ", sa=" + sa + ", pi=" + pi + ", pa=" + pa + ", pfa=" + pfa
				+ ", bio=" + bio + ", bt=" + bt + ", pin=" + pin + ", otp=" + otp + ", rc=" + rc + ", actn=" + actn
				+ ", ra=" + ra + ", lr=" + lr + ", de=" + de + ", pfr=" + pfr + ", status=" + status + ", ko=" + ko
				+ ", code=" + code + ", ts=" + ts + ", auth_rc=" + auth_rc + ", auth_ver=" + auth_ver + ", auth_txn="
				+ auth_txn + ", response_time_cidr=" + response_time_cidr + ", auth_actn=" + auth_actn + ", kyc_ret="
				+ kyc_ret + ", kyc_err=" + kyc_err + ", auth_err=" + auth_err + ", ci=" + ci + ", auth_code="
				+ auth_code + ", success=" + success + ", unsuccess=" + unsuccess + ", total=" + total + "]";
	}
	private String request_forward_time;
	private String response_forward_time;
	private String packet_response_time;
	private String packet_request_time;
	private String ch;
	private String aua_code;
	private String sa;
	private String pi,pa,pfa,bio,bt,pin,otp,rc,actn,ra,lr,de,pfr,status,ko,code,ts,auth_rc,auth_ver,auth_txn,response_time_cidr,auth_actn,kyc_ret,kyc_err,auth_err,ci,auth_code;
	private String success;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getUnsuccess() {
		return unsuccess;
	}
	public void setUnsuccess(String unsuccess) {
		this.unsuccess = unsuccess;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	private String unsuccess;
	private String total;
	
	
	
	
	
	
	public String getRequest_forward_time() {
		return request_forward_time;
	}
	public void setRequest_forward_time(String request_forward_time) {
		this.request_forward_time = request_forward_time;
	}
	public String getResponse_forward_time() {
		return response_forward_time;
	}
	public void setResponse_forward_time(String response_forward_time) {
		this.response_forward_time = response_forward_time;
	}
	public String getPacket_response_time() {
		return packet_response_time;
	}
	public void setPacket_response_time(String packet_response_time) {
		this.packet_response_time = packet_response_time;
	}
	public String getPacket_request_time() {
		return packet_request_time;
	}
	public void setPacket_request_time(String packet_request_time) {
		this.packet_request_time = packet_request_time;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public String getAua_code() {
		return aua_code;
	}
	public void setAua_code(String aua_code) {
		this.aua_code = aua_code;
	}
	public String getSa() {
		return sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
	}
	public String getPi() {
		return pi;
	}
	public void setPi(String pi) {
		this.pi = pi;
	}
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
	}
	public String getPfa() {
		return pfa;
	}
	public void setPfa(String pfa) {
		this.pfa = pfa;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public String getActn() {
		return actn;
	}
	public void setActn(String actn) {
		this.actn = actn;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getLr() {
		return lr;
	}
	public void setLr(String lr) {
		this.lr = lr;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getPfr() {
		return pfr;
	}
	public void setPfr(String pfr) {
		this.pfr = pfr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKo() {
		return ko;
	}
	public void setKo(String ko) {
		this.ko = ko;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getAuth_rc() {
		return auth_rc;
	}
	public void setAuth_rc(String auth_rc) {
		this.auth_rc = auth_rc;
	}
	public String getAuth_ver() {
		return auth_ver;
	}
	public void setAuth_ver(String auth_ver) {
		this.auth_ver = auth_ver;
	}
	public String getAuth_txn() {
		return auth_txn;
	}
	public void setAuth_txn(String auth_txn) {
		this.auth_txn = auth_txn;
	}
	public String getResponse_time_cidr() {
		return response_time_cidr;
	}
	public void setResponse_time_cidr(String response_time_cidr) {
		this.response_time_cidr = response_time_cidr;
	}
	public String getAuth_actn() {
		return auth_actn;
	}
	public void setAuth_actn(String auth_actn) {
		this.auth_actn = auth_actn;
	}
	public String getKyc_ret() {
		return kyc_ret;
	}
	public void setKyc_ret(String kyc_ret) {
		this.kyc_ret = kyc_ret;
	}
	public String getKyc_err() {
		return kyc_err;
	}
	public void setKyc_err(String kyc_err) {
		this.kyc_err = kyc_err;
	}
	public String getAuth_err() {
		return auth_err;
	}
	public void setAuth_err(String auth_err) {
		this.auth_err = auth_err;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getTxn() {
		return txn;
	}
	public void setTxn(String txn) {
		this.txn = txn;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getRequestReceiptTime() {
		return requestReceiptTime;
	}
	public void setRequestReceiptTime(String requestReceiptTime) {
		this.requestReceiptTime = requestReceiptTime;
	}
	public String getResponseReceiptTime() {
		return responseReceiptTime;
	}
	public void setResponseReceiptTime(String responseReceiptTime) {
		this.responseReceiptTime = responseReceiptTime;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	
	

}
