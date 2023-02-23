package in.cdac.portal.modal;

public class SuccessCount {
	
	//private String deptName;
	/*
	 * private int demoauth; private int demootp; private int demofinger; private
	 * int demoiris; private int kycotp; private int kycfinger; private int kyciris;
	 * private int demototal; private int kyctotal; private int total; private int
	 * deptId; private int bfd;
	 */
	private String appName;
	private int  strUidCount;
	private int  getRefNumCount;
	private int  getUidCount;
	private int activateCount;
	private int deactivateCount;
	private int total;
	
	public SuccessCount()
	{
		strUidCount=0;
		getRefNumCount=0;
		getUidCount=0;
		activateCount=0;
		deactivateCount=0;
		setTotal(0);
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getStrUidCount() {
		return strUidCount;
	}

	public void setStrUidCount(int strUidCount) {
		this.strUidCount = strUidCount;
	}

	public int getGetRefNumCount() {
		return getRefNumCount;
	}

	public void setGetRefNumCount(int getRefNumCount) {
		this.getRefNumCount = getRefNumCount;
	}

	public int getGetUidCount() {
		return getUidCount;
	}

	public void setGetUidCount(int getUidCount) {
		this.getUidCount = getUidCount;
	}

	public int getActivateCount() {
		return activateCount;
	}

	public void setActivateCount(int activateCount) {
		this.activateCount = activateCount;
	}

	public int getDeactivateCount() {
		return deactivateCount;
	}

	public void setDeactivateCount(int deactivateCount) {
		this.deactivateCount = deactivateCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
