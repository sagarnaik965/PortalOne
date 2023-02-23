package in.cdac.portal.modal;


import java.util.List;
import java.util.Map;

public class ConnectorParam {
	
	private List<LicensekeyDetails> lkDetails ;
	
	private String deptName;
	private String ac;
	private Map<Integer,String> udc;
	
	public List<LicensekeyDetails> getLkDetails() {
		return lkDetails;
	}
	public void setLkDetails(List<LicensekeyDetails> lkDetails) {
		this.lkDetails = lkDetails;
	}
	public Map<Integer, String> getUdc() {
		return udc;
	}
	public void setUdc(Map<Integer, String> udc) {
		this.udc = udc;
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
	
	
	
}
