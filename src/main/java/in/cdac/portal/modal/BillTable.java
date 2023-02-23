package in.cdac.portal.modal;

public class BillTable {

	String limit;
	String category;
	String rate;

	public BillTable() {
	}

	public BillTable(String limit, String category, String rate) {
		super();
		this.limit = limit;
		this.category = category;
		this.rate = rate;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}
