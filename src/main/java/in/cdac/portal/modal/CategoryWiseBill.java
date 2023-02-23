package in.cdac.portal.modal;

public class CategoryWiseBill {
	public String applicationname;
	public int getrefnum;
	public int activate;
	public int struid;
	public int txncounts;
	public double amount;
	public String getApplicationname() {
		return applicationname;
	}
	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}
	public int getGetrefnum() {
		return getrefnum;
	}
	public void setGetrefnum(int getrefnum) {
		this.getrefnum = getrefnum;
	}
	public int getActivate() {
		return activate;
	}
	public void setActivate(int activate) {
		this.activate = activate;
	}
	public int getStruid() {
		return struid;
	}
	public void setStruid(int struid) {
		this.struid = struid;
	}
	public int getTxncounts() {
		return txncounts;
	}
	public void setTxncounts(int txncounts) {
		this.txncounts = txncounts;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CategoryWiseBill [applicationname=" + applicationname + ", getrefnum=" + getrefnum + ", activate="
				+ activate + ", struid=" + struid + ", txncounts=" + txncounts + ", amount=" + amount + "]";
	}
	public CategoryWiseBill(String applicationname, int getrefnum, int activate, int struid, int txncounts,
			double amount) {
		super();
		this.applicationname = applicationname;
		this.getrefnum = getrefnum;
		this.activate = activate;
		this.struid = struid;
		this.txncounts = txncounts;
		this.amount = amount;
	}
	public CategoryWiseBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
