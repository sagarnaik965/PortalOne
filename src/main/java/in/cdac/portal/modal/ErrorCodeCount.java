package in.cdac.portal.modal;

/**
 * @author Tushar
 *
 */
public class ErrorCodeCount {
	
	private String errorCode;
	private String errorDescription;
	private int count;
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	

}
