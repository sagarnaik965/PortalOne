package in.cdac.portal.modal;

import javax.validation.constraints.Pattern;

public class AcCode {
	
	@Pattern(regexp="(^([a-zA-Z0-9]){2,10}$)", message="Enter a valid AUA Code!")
	private String acCode;
	
	private String deptName;
	
	

	public String getAcCode() {
		return acCode;
	}
	
	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
