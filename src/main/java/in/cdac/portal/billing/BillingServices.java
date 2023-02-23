package in.cdac.portal.billing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;

import in.cdac.portal.modal.Summary;

@Service
public class BillingServices {

	private final static Logger logger = Logger.getLogger(BillingServices.class);

	static Map<String, String> apkCode_apk_name;
	public static Map<String, String> dept_code_dept_name;

	public static ArrayList<String> resAl;
	public static Map<String, HashSet<String>> dept_code_apk_code;
	public static JasperBill jasp;

	public static void pullData() {
		dept_code_apk_code = new HashMap<String, HashSet<String>>();
		apkCode_apk_name = new HashMap<String, String>();
		dept_code_dept_name = new HashMap<String, String>();
		for (String line : resAl) {

			String[] scData = line.split(",");
			apkCode_apk_name.put(scData[2], scData[1]);
			dept_code_dept_name.put(scData[10], scData[0]);
			dept_code_apk_code.put(scData[10], new HashSet<String>());

		}
		for (String line : resAl) {

			String[] scData = line.split(",");

			dept_code_apk_code.get(scData[10]).add(scData[2]);

		}
	}

	public ArrayList<Summary> getOprSummaryForJasper(String dept) {
		try {
			pullData();
			GetFileData.resAl = resAl;
			GetFileData.dept_code_apk_code = dept_code_apk_code;
			ArrayList<Summary> dataforsummary = new ArrayList<>();
			@SuppressWarnings("unused")
			String[] summaryColumn = { "  OPERATION", " ", "   COUNT" };
			ArrayList<Report> finalRepo = GetFileData.getAllOprSummaryForJasper(dept);
			jasp = new JasperBill();
			jasp.setTotalApkCount(0);
			jasp.setBreakup(new HashMap<>());
			for (Report rep : finalRepo) {
				Summary summaryobj = new Summary();
				summaryobj.setActivate_Incorrectattempt("0");
				summaryobj.setActivate_Retrievereferencenumber("0");
				summaryobj.setDeActivate_Incorrectattempt("0");
				summaryobj.setDeActivate_Retrievereferencenumber("0");
				summaryobj.setGetRef_Incorrectattempt("0");
				summaryobj.setGetRef_Retrievereferencenumber("0");
				summaryobj.setGetUid_Incorrectattempt("0");
				summaryobj.setGetUid_Retrievereferencenumber("0");
				summaryobj.setStrUid_Aadhaarduplicatecheck("0");
				summaryobj.setStrUid_Getexistingreferencenumber("0");
				summaryobj.setStrUid_StoreAadhaarNumber("0");
				summaryobj.setTotalCount("0");
				jasp.setDeptName(dept_code_dept_name.get(dept));
				jasp.setDc(dept);
				jasp.setTotalApkCount(jasp.getTotalApkCount() + rep.getApkCount());
				jasp.getBreakup().put(apkCode_apk_name.get(rep.getApkName()), String.valueOf(rep.getApkCount()));
				rep.setApkName(apkCode_apk_name.get(rep.getApkName()));

				summaryobj.setApplicationName(rep.getApkName());
				if (rep.getSummary().size() == 0) {
					throw new Exception("Data not found for request");
				}
				for (Map.Entry<String, HashMap<String, Integer>> sums : rep.getSummary().entrySet()) {
					Entry<String, HashMap<String, Integer>> entry = sums;
					for (Map.Entry<String, Integer> sum : rep.getSummary().get(entry.getKey()).entrySet()) {
						Entry<String, Integer> en = sum;
						if (entry.getKey().trim().equalsIgnoreCase("struid")) {
							if (en.getKey().trim().equalsIgnoreCase("false")) {
								summaryobj.setStrUid_Aadhaarduplicatecheck(Integer.toString(en.getValue()));

							} else if (en.getKey().trim().equalsIgnoreCase("true")) {
								summaryobj.setStrUid_Getexistingreferencenumber(Integer.toString(en.getValue()));

							} else if (en.getKey().trim().equalsIgnoreCase("null")) {
								summaryobj.setStrUid_StoreAadhaarNumber(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("getrefnum")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setGetRef_Retrievereferencenumber(Integer.toString(en.getValue()));

							} else {
								summaryobj.setGetRef_Incorrectattempt(Integer.toString(en.getValue()));

							}

						} else if (entry.getKey().trim().equalsIgnoreCase("getuid")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setGetUid_Retrievereferencenumber(Integer.toString(en.getValue()));

							} else {
								summaryobj.setGetUid_Incorrectattempt(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("activate")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setActivate_Retrievereferencenumber(Integer.toString(en.getValue()));
							} else {
								summaryobj.setActivate_Incorrectattempt(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("deactivate")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setDeActivate_Retrievereferencenumber(Integer.toString(en.getValue()));
							} else {
								summaryobj.setDeActivate_Incorrectattempt(Integer.toString(en.getValue()));
							}
						}
					}
				}

				summaryobj.setTotalCount(Integer.toString(rep.getApkCount()));
				dataforsummary.add(summaryobj);
			}
			return dataforsummary;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}

	}

	public ArrayList<Summary> getOprSummaryForJasperApkWise(String apk) {
		ArrayList<Summary> dataforsummary = new ArrayList<>();
		try {
			pullData();
			GetFileData.resAl = resAl;
			GetFileData.dept_code_apk_code = dept_code_apk_code;
			// @SuppressWarnings("unused")
			// String[] summaryColumn = { " OPERATION", " ", " COUNT" };
			ArrayList<Report> finalRepo = GetFileData.getAllOprSummaryForJasperApkWise(apk);
			jasp = new JasperBill();
			jasp.setTotalApkCount(0);
			jasp.setBreakup(new HashMap<>());
			for (Report rep : finalRepo) {
				Summary summaryobj = new Summary();
				summaryobj.setActivate_Incorrectattempt("0");
				summaryobj.setActivate_Retrievereferencenumber("0");
				summaryobj.setDeActivate_Incorrectattempt("0");
				summaryobj.setDeActivate_Retrievereferencenumber("0");
				summaryobj.setGetRef_Incorrectattempt("0");
				summaryobj.setGetRef_Retrievereferencenumber("0");
				summaryobj.setGetUid_Incorrectattempt("0");
				summaryobj.setGetUid_Retrievereferencenumber("0");
				summaryobj.setStrUid_Aadhaarduplicatecheck("0");
				summaryobj.setStrUid_Getexistingreferencenumber("0");
				summaryobj.setStrUid_StoreAadhaarNumber("0");
				summaryobj.setTotalCount("0");
				jasp.setDeptName(apk);
				jasp.setDc(apk);
				jasp.setTotalApkCount(jasp.getTotalApkCount() + rep.getApkCount());
				jasp.getBreakup().put(apkCode_apk_name.get(rep.getApkName()), String.valueOf(rep.getApkCount()));
				rep.setApkName(apkCode_apk_name.get(rep.getApkName()));
				summaryobj.setApplicationName(rep.getApkName());
				if (rep.getSummary().size() == 0) {
					throw new Exception("Data not found for request");
				}

				for (Map.Entry<String, HashMap<String, Integer>> sums : rep.getSummary().entrySet()) {
					Entry<String, HashMap<String, Integer>> entry = sums;
					for (Map.Entry<String, Integer> sum : rep.getSummary().get(entry.getKey()).entrySet()) {
						Entry<String, Integer> en = sum;
						if (entry.getKey().trim().equalsIgnoreCase("struid")) {
							if (en.getKey().trim().equalsIgnoreCase("false")) {
								summaryobj.setStrUid_Aadhaarduplicatecheck(Integer.toString(en.getValue()));

							} else if (en.getKey().trim().equalsIgnoreCase("true")) {
								summaryobj.setStrUid_Getexistingreferencenumber(Integer.toString(en.getValue()));

							} else if (en.getKey().trim().equalsIgnoreCase("null")) {
								summaryobj.setStrUid_StoreAadhaarNumber(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("getrefnum")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setGetRef_Retrievereferencenumber(Integer.toString(en.getValue()));

							} else {
								summaryobj.setGetRef_Incorrectattempt(Integer.toString(en.getValue()));

							}

						} else if (entry.getKey().trim().equalsIgnoreCase("getuid")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setGetUid_Retrievereferencenumber(Integer.toString(en.getValue()));

							} else {
								summaryobj.setGetUid_Incorrectattempt(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("activate")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setActivate_Retrievereferencenumber(Integer.toString(en.getValue()));
							} else {
								summaryobj.setActivate_Incorrectattempt(Integer.toString(en.getValue()));
							}

						} else if (entry.getKey().trim().equalsIgnoreCase("deactivate")) {
							if (en.getKey().trim().equalsIgnoreCase("y")) {
								summaryobj.setDeActivate_Retrievereferencenumber(Integer.toString(en.getValue()));
							} else {
								summaryobj.setDeActivate_Incorrectattempt(Integer.toString(en.getValue()));
							}
						}
					}
				}
				summaryobj.setTotalCount(Integer.toString(rep.getApkCount()));
				dataforsummary.add(summaryobj);
			}
			return dataforsummary;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return dataforsummary;
		}

	}
}
