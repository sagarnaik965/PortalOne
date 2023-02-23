package in.cdac.portal.modal;

public class KeyMapping {
	
	public int keyinfoid;
	public String deptcode;
	public String appcode;
	public int getkeyinfoid() {
		return keyinfoid;
	}
	public void setkeyinfoid(int keyinfoid) {
		this.keyinfoid = keyinfoid;
	}
	public String getdeptcode() {
		return deptcode;
	}
	public void setdeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	public String getappcode() {
		return appcode;
	}
	public void setappcode(String appcode) {
		this.appcode = appcode;
	}
	@Override
	public String toString() {
		return "KeyMapping [keyinfoid=" + keyinfoid + ", deptcode=" + deptcode + ", appcode=" + appcode + "]";
	}
	
	

}
