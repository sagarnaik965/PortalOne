package in.cdac.portal.modal;

public class UserRolesforUserManagement {

	public String username;
	public String role_id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public UserRolesforUserManagement(String username, String role_id) {
		super();
		this.username = username;
		this.role_id = role_id;
	}
	public UserRolesforUserManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRolesforUserManagement [username=" + username + ", role_id=" + role_id + "]";
	}
	
	
}
