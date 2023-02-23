package in.cdac.portal.modal;

public class ReportInput {
	private String type;
	private String fDate;
	private String selectMonthlyMonth;
	private String selectMonthlyYear;
	private String selectQuarterlyQuarter;
	private String selectQuarterlyYear;	
	private String selectYearlyYear;
	private String tdate;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	public String getSelectMonthlyMonth() {
		return selectMonthlyMonth;
	}
	public void setSelectMonthlyMonth(String selectMonthlyMonth) {
		this.selectMonthlyMonth = selectMonthlyMonth;
	}
	public String getSelectMonthlyYear() {
		return selectMonthlyYear;
	}
	public void setSelectMonthlyYear(String selectMonthlyYear) {
		this.selectMonthlyYear = selectMonthlyYear;
	}
	public String getSelectQuarterlyQuarter() {
		return selectQuarterlyQuarter;
	}
	public void setSelectQuarterlyQuarter(String selectQuarterlyQuarter) {
		this.selectQuarterlyQuarter = selectQuarterlyQuarter;
	}
	public String getSelectQuarterlyYear() {
		return selectQuarterlyYear;
	}
	public void setSelectQuarterlyYear(String selectQuarterlyYear) {
		this.selectQuarterlyYear = selectQuarterlyYear;
	}
	public String getSelectYearlyYear() {
		return selectYearlyYear;
	}
	public void setSelectYearlyYear(String selectYearlyYear) {
		this.selectYearlyYear = selectYearlyYear;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public ReportInput(String type, String fDate, String selectMonthlyMonth, String selectMonthlyYear,
			String selectQuarterlyQuarter, String selectQuarterlyYear, String selectYearlyYear, String tdate) {
		super();
		this.type = type;
		this.fDate = fDate;
		this.selectMonthlyMonth = selectMonthlyMonth;
		this.selectMonthlyYear = selectMonthlyYear;
		this.selectQuarterlyQuarter = selectQuarterlyQuarter;
		this.selectQuarterlyYear = selectQuarterlyYear;
		this.selectYearlyYear = selectYearlyYear;
		this.tdate = tdate;
	}
	public ReportInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReportInput [type=" + type + ", fDate=" + fDate + ", selectMonthlyMonth=" + selectMonthlyMonth
				+ ", selectMonthlyYear=" + selectMonthlyYear + ", selectQuarterlyQuarter=" + selectQuarterlyQuarter
				+ ", selectQuarterlyYear=" + selectQuarterlyYear + ", selectYearlyYear=" + selectYearlyYear + ", tdate="
				+ tdate + "]";
	}
	
	

}
