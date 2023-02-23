package in.cdac.portal.modal;

public class Activities {
	
	public String activity_id;
	public String activity;
	
		
	public Activities(String activity_id, String activity) {
		super();
		this.activity_id = activity_id;
		this.activity = activity;
	}
	
	public Activities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	@Override
	public String toString() {
		return "Activities [activity_id=" + activity_id + ", activity=" + activity + "]";
	}
	
	

}
