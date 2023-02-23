package in.cdac.portal.modal;


public class StateList {
	private String stateCode;
	public StateList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateList(String stateCode, String stateName) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "StateList [stateCode=" + stateCode + ", stateName=" + stateName + "]";
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	private String stateName;
	

}
