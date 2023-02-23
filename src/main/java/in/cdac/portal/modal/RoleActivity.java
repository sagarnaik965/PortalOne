package in.cdac.portal.modal;

public class RoleActivity {

	public String role_id;
	public String activity_id;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public RoleActivity(String role_id, String activity_id) {
		super();
		this.role_id = role_id;
		this.activity_id = activity_id;
	}
	public RoleActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RoleActivity [role_id=" + role_id + ", activity_id=" + activity_id + "]";
	}
	
	
}
