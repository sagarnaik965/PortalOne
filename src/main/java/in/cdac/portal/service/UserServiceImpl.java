package in.cdac.portal.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import in.cdac.portal.billing.BillingServices;
import in.cdac.portal.dao.ReadDao;
import in.cdac.portal.dao.UserDao;
import in.cdac.portal.modal.AllowedOpr;
import in.cdac.portal.modal.AppDetail;
import in.cdac.portal.modal.AppList;
import in.cdac.portal.modal.AppLk;
import in.cdac.portal.modal.Billing;
import in.cdac.portal.modal.BillingDetails;
import in.cdac.portal.modal.ChartData;
import in.cdac.portal.modal.Count;
import in.cdac.portal.modal.Count1;
import in.cdac.portal.modal.DeptDetails;
import in.cdac.portal.modal.DeptList;
import in.cdac.portal.modal.Summary;
import in.cdac.portal.modal.SummaryReportTotals;
import in.cdac.portal.modal.UserStatus;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UserServiceImpl implements UserService {

	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Autowired
	ReadDao rdao;

	@Autowired
	PasswordEncoder encoder;

	@Autowired(required = true)
	BillingServices billSer;

	@Autowired
	Environment env;

	static HttpSession sess;

	@Override
	public int getHomePageSuccessCountR(String username) {
		// TODO Auto-generated method stub
		return userDao.getHomePageSuccessCountR(username);
	}

	@Override
	public int getTotalErrorCountR(String username) {
		// TODO Auto-generated method stub
		return userDao.getTotalErrorCountR(username);
	}

	@Override
	public Map<String, Integer> getMonthlyTotalTransR(String userName) {
		return userDao.getMonthlyTotalTransR(userName);
	}

	@Override
	public int getTotalAcCountDeptWiseR(String userName) {
		// TODO Auto-generated method stub
		return userDao.getTotalAcCountDeptWiseR(userName);
	}

	@Override
	public List<UserStatus> getAppcodeR(String username) {
		List<UserStatus> us = userDao.getAppcodeR(username);
		return us;
	}

	@Override
	public List<Count> acwiseTotaltransR(String[] acCode) {
		List<Count> l1 = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		map = userDao.acwiseTotaltransR(acCode);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Count c1 = new Count();
			c1.setY(entry.getValue());
			c1.setLabel(entry.getKey());
			l1.add(c1);
		}
		return l1;
	}

	
	private SummaryReportTotals getTotalCountsForSummary(List<Summary> summaryReport) {
		// TODO Auto-generated method stub
		
		 Long total_strUid_StoreAadhaarNumber=(long) 0;
		 Long total_strUid_Getexistingreferencenumber=(long) 0;
		 Long total_strUid_Aadhaarduplicatecheck=(long) 0;
		 Long total_getRef_Retrievereferencenumber=(long) 0;
		 Long total_getRef_Incorrectattempt=(long) 0;
		 Long total_getUid_Retrievereferencenumber=(long) 0;
		 Long total_getUid_Incorrectattempt=(long) 0;
		 Long total_activate_Retrievereferencenumber=(long) 0;
		 Long total_activate_Incorrectattempt=(long) 0;
		 Long total_deActivate_Retrievereferencenumber=(long) 0;
		 Long total_deActivate_Incorrectattempt=(long) 0;
		 Long total_totalCount=(long) 0;
		SummaryReportTotals sumtotcnt = new SummaryReportTotals();
		for (Iterator<Summary> iterator = summaryReport.iterator(); iterator.hasNext();) {
			Summary summary = iterator.next();
			
			  total_strUid_StoreAadhaarNumber= total_strUid_StoreAadhaarNumber + Long.parseLong(summary.getStrUid_StoreAadhaarNumber());
			  total_strUid_Getexistingreferencenumber += Long.parseLong(summary.getStrUid_Getexistingreferencenumber());
			  total_strUid_Aadhaarduplicatecheck += Long.parseLong(summary.getStrUid_Aadhaarduplicatecheck());
			  total_getRef_Retrievereferencenumber += Long.parseLong(summary.getGetRef_Retrievereferencenumber());
			  total_getRef_Incorrectattempt += Long.parseLong(summary.getGetRef_Incorrectattempt());
			  total_getUid_Retrievereferencenumber += Long.parseLong(summary.getGetUid_Retrievereferencenumber());
			  total_getUid_Incorrectattempt += Long.parseLong(summary.getGetUid_Incorrectattempt());
			  total_activate_Retrievereferencenumber += Long.parseLong(summary.getActivate_Retrievereferencenumber());
			  total_activate_Incorrectattempt +=  Long.parseLong(summary.getActivate_Incorrectattempt());
			  total_deActivate_Retrievereferencenumber +=  Long.parseLong(summary.getDeActivate_Retrievereferencenumber());
			  total_deActivate_Incorrectattempt +=  Long.parseLong(summary.getDeActivate_Incorrectattempt());
			  total_totalCount +=  Long.parseLong(summary.getTotalCount());
			
		}
		sumtotcnt.setTotal_strUid_StoreAadhaarNumber(total_strUid_StoreAadhaarNumber);
		sumtotcnt.setTotal_strUid_Getexistingreferencenumber(total_strUid_Getexistingreferencenumber);
		sumtotcnt.setTotal_strUid_Aadhaarduplicatecheck(total_strUid_Aadhaarduplicatecheck); 
		sumtotcnt.setTotal_getRef_Retrievereferencenumber(total_getRef_Retrievereferencenumber);
		sumtotcnt.setTotal_getRef_Incorrectattempt(total_getRef_Incorrectattempt);
		sumtotcnt.setTotal_getUid_Retrievereferencenumber(total_getUid_Retrievereferencenumber);
		sumtotcnt.setTotal_getUid_Incorrectattempt(total_getUid_Incorrectattempt);
		sumtotcnt.setTotal_activate_Retrievereferencenumber(total_activate_Retrievereferencenumber);
		sumtotcnt.setTotal_activate_Incorrectattempt(total_activate_Incorrectattempt);
		sumtotcnt.setTotal_deActivate_Retrievereferencenumber(total_deActivate_Retrievereferencenumber);
		sumtotcnt.setTotal_deActivate_Incorrectattempt(total_deActivate_Incorrectattempt);
		sumtotcnt.setTotal_totalCount(total_totalCount);
		return sumtotcnt;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<byte[]> getSummaryForJasperIgnite(String[] datedata, String username) {
		String[] dates = getStartandLastDate(datedata);
		String startDate = dates[0];
		String lastDate = dates[1];
		logger.info("StartDate: " + startDate + " lastDate: " + lastDate + " User: " + username);
		try {
			String nameandcode = userDao.getDeptcodeFromUsernameforreport(username);
			String[] deptnamenadcode = nameandcode.split(",");
			String deptCode =deptnamenadcode[0];
			String deptName =deptnamenadcode[1];
			logger.info( "username: " + username + "deptCode: " + deptCode
					+ "deptName: " + deptName);
			String url = env.getProperty("igniteapiforreports");
			RestTemplate rt = new RestTemplate();
			String[] arr = { deptCode, startDate, lastDate };
			byte[] bdata = rt.postForObject(url, arr, byte[].class);
			ArrayList<String> resAl = new ArrayList<String>();
			resAl = (ArrayList<String>) SerializationUtils.deserialize(bdata);
			BillingServices.resAl = resAl;
			List<Summary> summaryReport = new ArrayList<>();
			summaryReport = billSer.getOprSummaryForJasper(deptCode);			
			if (summaryReport == null) {
				throw new Exception("Data not found for request");
			}			
			SummaryReportTotals sumtotcnt =  getTotalCountsForSummary(summaryReport);
			Map<String, Object> empParams = new HashMap<String, Object>();
			empParams.put("CollectionParamBean", new JRBeanCollectionDataSource(summaryReport));
			empParams.put("DeptName", deptName);
			empParams.put("startDate", startDate);
			empParams.put("lastDate", lastDate);
			empParams.put("struid_san", sumtotcnt.getTotal_strUid_StoreAadhaarNumber());
			empParams.put("struid_ger", sumtotcnt.getTotal_strUid_Getexistingreferencenumber());
			empParams.put("struid_adc", sumtotcnt.getTotal_strUid_Aadhaarduplicatecheck());
			empParams.put("getref_rr", sumtotcnt.getTotal_getRef_Retrievereferencenumber());
			empParams.put("getref_ie", sumtotcnt.getTotal_getRef_Incorrectattempt());
			empParams.put("getuid_rr", sumtotcnt.getTotal_getUid_Retrievereferencenumber());
			empParams.put("getuid_ie", sumtotcnt.getTotal_getUid_Incorrectattempt());
			empParams.put("activate_rr", sumtotcnt.getTotal_activate_Retrievereferencenumber());
			empParams.put("activate_ie", sumtotcnt.getTotal_getUid_Incorrectattempt());
			empParams.put("deactivate_rr", sumtotcnt.getTotal_deActivate_Retrievereferencenumber());
			empParams.put("deactivate_ie", sumtotcnt.getTotal_deActivate_Incorrectattempt());
			empParams.put("totcnt", sumtotcnt.getTotal_totalCount());
			JasperPrint Report = JasperFillManager.fillReport(JasperCompileManager
					.compileReport(ResourceUtils.getFile("classpath:"+env.getProperty("jasper.summary.dept")).getAbsolutePath()), empParams // dynamic
																														// parameters
					, new JREmptyDataSource());
			HttpHeaders headers = new HttpHeaders();
			// set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			// create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(Report), headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Exception " + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<byte[]> getBillingDataForPdf(String[] datedata, String username) {
		String[] dates = getStartandLastDate(datedata);
		String first = dates[0];
		String last = dates[1];
		int totalcounts = 0;
		double value = 0;
		double totalamt = 0;
		String Quarter = "";
		int quarterNo;
		LocalDate localDate = LocalDate.parse(first);
		quarterNo = localDate.get(IsoFields.QUARTER_OF_YEAR);
		try {
			in.cdac.portal.billing.JasperBill js = BillingServices.jasp;
			if (js.getTotalApkCount() == 0) {
				throw new Exception("TotalCount is Zero ");
			}
			Integer count = js.getTotalApkCount();
			String deptcode = js.getDc();
			logger.info("totalcount: " + count + " deptcode: " + deptcode + " Username: " + username);
			String url = env.getProperty("igniteapiforbiling");
			RestTemplate rt = new RestTemplate();
			String[] arr = { String.valueOf(count), deptcode };
			String[] billingDetails = rt.postForObject(url, arr, String[].class);
			js.setSlab(billingDetails[0]);
			js.setQuarter(Integer.toString(quarterNo));
			totalamt = Double.parseDouble(new DecimalFormat("##.##").format(
					Double.parseDouble(Integer.toString(js.getTotalApkCount())) * Double.parseDouble(js.getSlab())));

			List<Billing> billData = new ArrayList<Billing>();
			for (Map.Entry<String, String> entry : js.getBreakup().entrySet()) {
				totalcounts = totalcounts + Integer.parseInt(entry.getValue());
				value = Double.parseDouble(new DecimalFormat("##.##")
						.format(Double.parseDouble(entry.getValue()) * Double.parseDouble(js.getSlab())));
				billData.add(new Billing(entry.getKey(), Integer.parseInt(entry.getValue()), value));
			}
			
			Quarter = getQuarterForReport(js.getQuarter());			

			List<BillingDetails> summaryReport = new ArrayList<>();
			summaryReport.add(new BillingDetails("Department Name ", js.getDeptName()));
			summaryReport.add(new BillingDetails("Bill To", billingDetails[2]));
			summaryReport.add(new BillingDetails("Address", billingDetails[3]));
			summaryReport.add(new BillingDetails("GST", billingDetails[1]));
			summaryReport.add(new BillingDetails("Total Transaction", Integer.toString(js.getTotalApkCount())));
			summaryReport.add(new BillingDetails("Slab Rate", billingDetails[0]));
			summaryReport.add(new BillingDetails("Total Amount", Double.toString(totalamt)));

			List<BillingDetails> Billdataforbelow2500 = new ArrayList<>();
			Billdataforbelow2500.add(new BillingDetails("Department Name ", js.getDeptName()));
			Billdataforbelow2500.add(new BillingDetails("Total Counts", Integer.toString(totalcounts)));
			Billdataforbelow2500.add(new BillingDetails("Total Amount", "2500.00"));
			Map<String, Object> BillParamBelow2500 = new HashMap<String, Object>();
			BillParamBelow2500.put("CollectionForDetails", new JRBeanCollectionDataSource(Billdataforbelow2500));
			BillParamBelow2500.put("Quarter", Quarter);
			BillParamBelow2500.put("startDate", first);
			BillParamBelow2500.put("lastDate", last);

			Map<String, Object> BillParam = new HashMap<String, Object>();
			BillParam.put("CollectionBeanParam", new JRBeanCollectionDataSource(billData));
			BillParam.put("CollectionForDetails", new JRBeanCollectionDataSource(summaryReport));
			BillParam.put("Quarter", Quarter);
			BillParam.put("TotalCount", Integer.toString(totalcounts));
			BillParam.put("TotalAmount", Double.toString(totalamt));
			BillParam.put("startDate", first);
			BillParam.put("lastDate", last);
			JasperPrint NormalReport = JasperFillManager.fillReport(JasperCompileManager
					.compileReport(ResourceUtils.getFile("classpath:"+env.getProperty("jasper.bill.dept")).getAbsolutePath()), BillParam // dynamic
																														// parameters
					, new JREmptyDataSource());

			JasperPrint ReportBelow2500 = JasperFillManager.fillReport(
					JasperCompileManager.compileReport(
							ResourceUtils.getFile("classpath:"+env.getProperty("jasper.summary.dept.2500")).getAbsolutePath()),
					BillParamBelow2500 // dynamic parameters
					, new JREmptyDataSource());

			HttpHeaders headers = new HttpHeaders();
			// set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Billing.pdf");
			// create the report in PDF format
			if (totalamt <= 2500) {
				return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(ReportBelow2500), headers,
						HttpStatus.OK);

			} else {
				return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(NormalReport), headers,
						HttpStatus.OK);
			}

		} catch (Exception e) {
			logger.info("getBillingDataForPdf data not found  total count zero " + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}}

	
	
	
	private String getQuarterForReport(String quarter) {
		if (quarter.trim().equalsIgnoreCase("1")) {

			quarter = env.getProperty("billing.quarter.4");
		} else if (quarter.trim().equalsIgnoreCase("2")) {

			quarter = env.getProperty("billing.quarter.1");
		} else if (quarter.trim().equalsIgnoreCase("3")) {

			quarter = env.getProperty("billing.quarter.2");

		} else if (quarter.trim().equalsIgnoreCase("4")) {

			quarter = env.getProperty("billing.quarter.3");
		}
		return quarter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<byte[]> getSummaryForJasperIgniteapp(String[] datedata, String username) {
		String[] dates = getStartandLastDate(datedata);
		String first = dates[0];
		String last = dates[1];
		logger.info("StartDate: " + first + " lastDate: " + last);
		try {
			String url = env.getProperty("igniteapiforappwisereport");
			RestTemplate rt = new RestTemplate();
			String[] arr = { "A100006", first, last };
			byte[] bdata = rt.postForObject(url, arr, byte[].class);
			ArrayList<String> resAl = new ArrayList<String>();
			resAl = (ArrayList<String>) SerializationUtils.deserialize(bdata);
			BillingServices.resAl = resAl;
			List<Summary> summaryReport = new ArrayList<>();
			summaryReport = billSer.getOprSummaryForJasperApkWise("A100006");
			if (summaryReport == null) {
				throw new Exception("Data not found for request");
			}
			Map<String, Object> empParams = new HashMap<String, Object>();
			empParams.put("CollectionParamBean", new JRBeanCollectionDataSource(summaryReport));
			System.out.println("File Generated");
			JasperPrint empReport = JasperFillManager.fillReport(JasperCompileManager
					.compileReport(ResourceUtils.getFile("classpath:SummaryApp.jrxml").getAbsolutePath()), empParams // dynamic
																														// parameters
					, new JREmptyDataSource());

			HttpHeaders headers = new HttpHeaders();
			// set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Summary.pdf");
			// create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("getSummaryForJasperIgniteapp exception " + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<byte[]> getBillingDataForPdfapp(String[] datedata, String username) {
		// TODO Auto-generated method stub
		String[] dates = getStartandLastDate(datedata);
		String first = dates[0];
		String last = dates[0];
		int totalcounts = 0;
		double value = 0;
		double totalamt = 0;
		String Quarter = "";
		int quarterNo;
		LocalDate localDate = LocalDate.parse(first);
		quarterNo = localDate.get(IsoFields.QUARTER_OF_YEAR);
		logger.info("Quarter: " + quarterNo);
		logger.info("StartDate: " + first + " lastDate: " + last);
		try {
			in.cdac.portal.billing.JasperBill js = BillingServices.jasp;
			if (js.getTotalApkCount() == 0) {
				throw new Exception("TotalCount is Zero");
			}
			String url = env.getProperty("igniteapiforappwisebill");
			RestTemplate rt = new RestTemplate();
//			String[] arr = {String.valueOf(js.getTotalApkCount()), "A100006" };
			String[] arr = { "A100006", first, last };
			String[] billingDetails = rt.postForObject(url, arr, String[].class);

			js.setSlab(billingDetails[0]);
			js.setQuarter(Integer.toString(quarterNo));
			totalamt = Double.parseDouble(new DecimalFormat("##.##").format(
					Double.parseDouble(Integer.toString(js.getTotalApkCount())) * Double.parseDouble(js.getSlab())));

			List<Billing> billData = new ArrayList<Billing>();
			for (Map.Entry<String, String> entry : js.getBreakup().entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
				entry.getKey();
				entry.getValue();
				totalcounts = totalcounts + Integer.parseInt(entry.getValue());
				value = Double.parseDouble(new DecimalFormat("##.##")
						.format(Double.parseDouble(entry.getValue()) * Double.parseDouble(js.getSlab())));
				billData.add(new Billing(entry.getKey(), Integer.parseInt(entry.getValue()), value));
			}

			Quarter = getQuarterForReport(js.getQuarter());		
			List<BillingDetails> summaryReport = new ArrayList<>();
//			summaryReport.add(new BillingDetails("Department Name ",js.getDeptName()));			
			summaryReport.add(new BillingDetails("Bill To", billingDetails[2]));
			summaryReport.add(new BillingDetails("Address", billingDetails[3]));
			summaryReport.add(new BillingDetails("GST", billingDetails[1]));
			summaryReport.add(new BillingDetails("Total Transaction", Integer.toString(js.getTotalApkCount())));
			summaryReport.add(new BillingDetails("Slab Rate", billingDetails[0]));
			summaryReport.add(new BillingDetails("Total Amount", Double.toString(totalamt)));

			Map<String, Object> empParams = new HashMap<String, Object>();
			empParams.put("CollectionBeanParam", new JRBeanCollectionDataSource(billData));
			empParams.put("CollectionForDetails", new JRBeanCollectionDataSource(summaryReport));
			empParams.put("Quarter", Quarter);
			empParams.put("TotalCount", Integer.toString(totalcounts));
			empParams.put("TotalAmount", Double.toString(totalamt));
			System.out.println("File Generated");
			JasperPrint empReport = JasperFillManager.fillReport(JasperCompileManager.compileReport(
					ResourceUtils.getFile("classpath:BillWithSumAppwise.jrxml").getAbsolutePath()), empParams // dynamic
																												// parameters
					, new JREmptyDataSource());

			HttpHeaders headers = new HttpHeaders();
			// set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "Billing.pdf");
			// create the report in PDF format
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Count1> getTotalTransactionHomePageR(String userName) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = null;
		List<Count1> l1 = new ArrayList<>();
		try {
			map = userDao.getTotalTransactionHomePageR(userName);
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				Count1 c1 = new Count1();
				c1.setY(entry.getValue());
				c1.setName(entry.getKey());
				l1.add(c1);
			}
			return l1;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return l1;
		}
	}

	private String[] getStartandLastDate(String[] datedata) {
		String[] StartandLastDates = { "", "" };
		logger.info("getStartandLastDate  " + datedata[0] + "=" + datedata[1] + "=" + datedata[2]);
		try {
			if (datedata[0].contentEquals("month")) {
				YearMonth yearMonth = YearMonth.of(Integer.parseInt(datedata[2]), Integer.parseInt(datedata[1]));
				LocalDate firstOfMonth = yearMonth.atDay(1);
				LocalDate lastOfMonth = yearMonth.atEndOfMonth();
				String first = firstOfMonth.toString();
				String last = lastOfMonth.toString();
				StartandLastDates[0] = first;
				StartandLastDates[1] = last;
				return StartandLastDates;
			} else if (datedata[0].contentEquals("quarter")) {
				YearMonth quaterfirstyearMonth = YearMonth.of(Integer.parseInt(datedata[2]),
						Integer.parseInt(datedata[1]));
				LocalDate firstOfMonth = quaterfirstyearMonth.atDay(1);
				YearMonth quaterlastyearMonth = YearMonth.of(Integer.parseInt(datedata[2]),
						Integer.parseInt(datedata[1]) + 2);
				LocalDate lastOfMonth = quaterlastyearMonth.atEndOfMonth();
				String first = firstOfMonth.toString();
				String last = lastOfMonth.toString();
				StartandLastDates[0] = first;
				StartandLastDates[1] = last;
				logger.info(StartandLastDates[0] + "==" + StartandLastDates[1]);
				return StartandLastDates;
			}
			if (datedata[0].contentEquals("year")) {
				String first = datedata[1] + "-" + "01" + "-" + "01";
				String last = datedata[1] + "-" + "12" + "-" + "31";
				StartandLastDates[0] = first;
				StartandLastDates[1] = last;
				return StartandLastDates;

			}
			if (datedata[0].contentEquals("custom")) {
				StartandLastDates[0] = datedata[1];
				StartandLastDates[1] = datedata[2];
				return StartandLastDates;
			} else if (datedata[0].contentEquals("bill")) {
				YearMonth quaterfirstyearMonth = YearMonth.of(Integer.parseInt(datedata[2]),
						Integer.parseInt(datedata[1]));
				LocalDate firstOfMonth = quaterfirstyearMonth.atDay(1);
				YearMonth quaterlastyearMonth = YearMonth.of(Integer.parseInt(datedata[2]),
						Integer.parseInt(datedata[1]) + 2);
				LocalDate lastOfMonth = quaterlastyearMonth.atEndOfMonth();
				String first = firstOfMonth.toString();
				String last = lastOfMonth.toString();
				StartandLastDates[0] = first;
				StartandLastDates[1] = last;
				return StartandLastDates;
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return null;
	}

	@Override
	public DeptList getDeptcodeFromUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getDeptcodeFromUsername(username);
	}

	@Override
	public List<AppList> getAppListR(String deptcode) {
		// TODO Auto-generated method stub
		return userDao.getAppListR(deptcode);
	}

	@Override
	public AppDetail getAppDetailR(String appcode) {
		// TODO Auto-generated method stub
		return userDao.getAppDetailR(appcode);
	}

	@Override
	public AppLk getAppLkR(String appcode) {
		// TODO Auto-generated method stub
		return userDao.getAppLkR(appcode);
	}

	@Override
	public AllowedOpr getOprR(String appcode) {
		// TODO Auto-generated method stub
		return userDao.getOprR(appcode);
	}

	@Override
	public String getCurrentEmailId(String userName) {
		return userDao.getCurrentEmailId(userName);
	}

	@Override
	public Map<String, DeptDetails> getDeptServiceDetailsR(String deptcode) {
		// TODO Auto-generated method stub
		return userDao.getrecordR(deptcode);
	}

	@Override
	public List<DeptList> getDeptListR() {
		// TODO Auto-generated method stub
		return userDao.getDeptListR();
	}

	@Override
	public ChartData getDataForChart(String Username) {
		ChartData chartData = new ChartData();
		String label[] = new String[7];
		try {
			Map<String,Long> chartDatawithdate =  userDao.getDataForChart(Username);
			long[] arr = new long[7];
			chartData.setData(arr);
			chartData.setLabels(label);
			LocalDate localdate = LocalDate.now();
			String date = localdate.toString();			
			label[6] = date;
			arr[6] = chartDatawithdate.get(date)!=null ? chartDatawithdate.get(date) : 0 ;

			String dateforchart = findPrevDay(1);
			label[5] = dateforchart;
			arr[5] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			dateforchart = findPrevDay(2);
			label[4] = dateforchart;
			arr[4] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			dateforchart = findPrevDay(3);
			label[3] = dateforchart;
			arr[3] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			dateforchart = findPrevDay(4);
			label[2] = dateforchart;
			arr[2] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			dateforchart = findPrevDay(5);
			label[1] = dateforchart;
			arr[1] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			dateforchart = findPrevDay(6);
			label[0] = dateforchart;
			arr[0] = chartDatawithdate.get(dateforchart)!=null ? chartDatawithdate.get(dateforchart) : 0 ;

			chartData.setData(arr);
			return chartData;
		} catch (Exception e) {
			logger.info("Exception chart data not found " + e.getMessage());
			return null;
		}
	}

	private String findPrevDay(int days) {
		LocalDate localdate = LocalDate.now();
		return localdate.minusDays(days).toString();
	}


}