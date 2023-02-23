package in.cdac.portal.modal;

public class AppDetailUpdate {

	public String email;
	public String desc;
	public String appname;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public AppDetailUpdate(String email, String desc, String appname) {
		super();
		this.email = email;
		this.desc = desc;
		this.appname = appname;
	}
	public AppDetailUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AppDetailUpdate [email=" + email + ", desc=" + desc + ", appname=" + appname + "]";
	}
	
	
	
	
}
