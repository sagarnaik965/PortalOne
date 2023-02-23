package in.cdac.portal.modal;

import java.util.ArrayList;
import java.util.Map;

public class FetchData {

	String apkCode;
	String category;
	String billType;
	String isConsolidated;
	String apkcount;
	String date;
	Map<String, Integer> mapOfCountsAndCategory;
	String apkCountInDept;
	String dept;
	String deptCategory;

	public FetchData() {
	}

	public FetchData(String apkCode, String category, String billType, String isConsolidated, String apkcount,
			String date, Map<String, Integer> mapOfCountsAndCategory, String apkCountInDept, String dept,
			String deptCategory) {
		super();
		this.apkCode = apkCode;
		this.category = category;
		this.billType = billType;
		this.isConsolidated = isConsolidated;
		this.apkcount = apkcount;
		this.date = date;
		this.mapOfCountsAndCategory = mapOfCountsAndCategory;
		this.apkCountInDept = apkCountInDept;
		this.dept = dept;
		this.deptCategory = deptCategory;
	}

	public String getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(String deptCategory) {
		this.deptCategory = deptCategory;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getApkCountInDept() {
		return apkCountInDept;
	}

	public void setApkCountInDept(String apkCountInDept) {
		this.apkCountInDept = apkCountInDept;
	}

	public String getApkCode() {
		return apkCode;
	}

	public String getApkcount() {
		return apkcount;
	}

	public void setApkcount(String apkcount) {
		this.apkcount = apkcount;
	}

	public Map<String, Integer> getMapOfCountsAndCategory() {
		return mapOfCountsAndCategory;
	}

	public void setMapOfCountsAndCategory(Map<String, Integer> mapOfCountsAndCategory) {
		this.mapOfCountsAndCategory = mapOfCountsAndCategory;
	}

	public void setApkCode(String apkCode) {
		this.apkCode = apkCode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getIsConsolidated() {
		return isConsolidated;
	}

	public void setIsConsolidated(String isConsolidated) {
		this.isConsolidated = isConsolidated;
	}

}
