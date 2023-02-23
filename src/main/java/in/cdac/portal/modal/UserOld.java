package in.cdac.portal.modal;

import java.util.List;



public class UserOld {

	private String userName;
	
	private String password;
	
	private boolean active;
	
	private List<String> role;
	
		
	
	public UserOld() {
		
	}
	
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<String> getRole() {
		return role;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}


	
	
	
}
