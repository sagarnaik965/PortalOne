package in.cdac.portal.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.portal.billing.BillingServices;
import in.cdac.portal.modal.AllowedOpr;
import in.cdac.portal.modal.AppDetail;
import in.cdac.portal.modal.AppList;
import in.cdac.portal.modal.AppLk;
import in.cdac.portal.modal.ChartData;
import in.cdac.portal.modal.Count;
import in.cdac.portal.modal.Count1;
import in.cdac.portal.modal.DeptList;
import in.cdac.portal.modal.PortalConstant;
import in.cdac.portal.modal.UserStatus;
import in.cdac.portal.service.UserService;

@CrossOrigin(origins = { PortalConstant.BASEURL + PortalConstant.PORT, "http://localhost:8080" })
@RequestMapping("/dept")
@RestController
public class DeptController {

	@Autowired
	UserService service;

	@Autowired(required = true)
	BillingServices billSer;

	static HttpSession sess;

	private final static Logger logger = Logger.getLogger(DeptController.class);

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@PostMapping("/getDeptcodeandName")
	public DeptList getDeptcodeFromUsername(@RequestBody String username) {
		try {
			return service.getDeptcodeFromUsername(username);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}

	}

	// p
	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@PostMapping("/applist")
	public List<AppList> applistprint(@RequestBody String deptcode) {
		List<AppList> appList = service.getAppListR(deptcode);
		if (appList != null) {
			return appList;
		}
		return null;
	}

	// p
	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@PostMapping("/appdetail")
	public AppDetail appdetailprint(@RequestBody String appcode) {
		AppDetail appdetail = service.getAppDetailR(appcode);
		if (appdetail != null) {
			return appdetail;
		}
		return null;
	}

	// p
	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@PostMapping("/applk")
	public AppLk applkprint(@RequestBody String appcode) {
		AppLk applk = service.getAppLkR(appcode);
		if (applk != null) {
			return applk;
		}
		return null;
	}

//p
	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@PostMapping("/opr")
	public AllowedOpr oprprint(@RequestBody String appcode) {
		AllowedOpr opr = service.getOprR(appcode);
		if (opr != null) {
			return opr;
		}
		return null;
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@GetMapping(value = "/homepagesuccesscount")
	public int getHomePageSuccessCountR() {
		int count = 0;
		try {
			if (sess != null)
				count = service.getHomePageSuccessCountR((String) sess.getAttribute("username"));
			return count;
		} catch (Exception e) {
			logger.info("Exception Data for Success count not found " + e.getMessage());
			return count;
		}

	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@GetMapping(value = "totalerrorcount")
	public int totalErrorCountR() {
		int count = 0;
		try {
			if (sess != null) {
				count = service.getTotalErrorCountR((String) sess.getAttribute("username"));
			}
			return count;
		} catch (Exception e) {
			logger.info("Exception Data for unsuccessful count not found " + e.getMessage());
			return 0;
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@RequestMapping(value = "/totalaccountdeptwise", method = RequestMethod.GET)
	public int getTotalAcCountDeptWiseR() {
		int count = 0;
		try {
			if (sess != null) {
				count = service.getTotalAcCountDeptWiseR((String) sess.getAttribute("username"));
			}
			return count;
		} catch (Exception e) {
			logger.info("Exception Data for application count  not found " + e.getMessage());
			return count;
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@RequestMapping(value = "homepagetranstable", method = RequestMethod.GET)
	public List<Count1> homePageTransTableR() {
		List<Count1> coundata = new ArrayList<>();
		try {
			if (sess != null) {
				coundata = service.getTotalTransactionHomePageR((String) sess.getAttribute("username"));
			}
			return coundata;
		} catch (Exception e) {
			logger.info("Exception Data for home page chart txn count  not found " + e.getMessage());
			return coundata;
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@ResponseBody
	@GetMapping("/appcodedetails")
	public List<UserStatus> appcodeDetailsR() {
		List<UserStatus> userlist = new ArrayList<>();
		try {
			if (sess != null) {
				userlist = service.getAppcodeR((String) sess.getAttribute("username"));
			}
			return userlist;
		} catch (Exception e) {
			logger.info("Exception Data for list of application not found " + e.getMessage());
			return userlist;
		}

	}

	@RequestMapping(value = "/applicationwisedata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public List<Count> acwiseTotaltransR(@RequestBody String[] appcodedata) {
		List<Count> countData = new ArrayList<>();
		try {
			countData = service.acwiseTotaltransR(appcodedata);
			return countData;
		} catch (Exception e) {
			logger.info("Exception Data for opr wise chart not found " + e.getMessage());
			return countData;
		}
	}


	@RequestMapping(value = "/billDeptCategpdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<byte[]> getBillDeptLevelCategorypdf(@RequestBody String[] datedata) {
		try {
			String username = "";
			if (sess != null) {
				username = (String) sess.getAttribute("username");
			}
			service.getSummaryForJasperIgnite(datedata, username);
			return service.getBillingDataForPdf(datedata, username);
		} catch (Exception e) {
			logger.info("Failed to fetch billing data " + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/summaryreport", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<?> monthlyReportpdf(@RequestBody String[] datedata) {
		try {
			String username = "";
			if (sess != null) {
				username = (String) sess.getAttribute("username");
			}
			return service.getSummaryForJasperIgnite(datedata, username);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>( "Failed to get data ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/summaryreportappwise", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<byte[]> monthlyReportpdfApp(@RequestBody String[] datedata) {
		try {

			String username = "";
			if (sess != null) {
				username = (String) sess.getAttribute("username");
			}
			return service.getSummaryForJasperIgniteapp(datedata, username);
		} catch (Exception e) {

			logger.info("monthly report failed to get data" + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/billAppCategpdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<byte[]> getBillAppLevelCategorypdf(@RequestBody String[] datedata) {
		try {
			String username = "";
			if (sess != null) {
				username = (String) sess.getAttribute("username");
			}
			service.getSummaryForJasperIgniteapp(datedata, username);
			return service.getBillingDataForPdfapp(datedata, username);
		} catch (Exception e) {
			logger.info("Failed to fetch billing data " + e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@RequestMapping(path = "/getusername")
	@GetMapping
	public String getusername() {
		try {
			String username = "";
			if (sess != null)
				if ((String) sess.getAttribute("username") != null) {
					try {
						username = (String) sess.getAttribute("username");
					} catch (Exception e) {
						sess = null;
					}
					return username;
				} else {
					username = "f";
					return "f";
				}
			return "f";
		} catch (Exception e) {
			logger.info("Problem in fetching username " + e.getMessage());
			return "f";
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@RequestMapping("/deptlist")
	@GetMapping
	public List<DeptList> deptlistprint() {
		List<DeptList> deptList = service.getDeptListR();
		if (deptList != null) {
			return deptList;
		}
		return null;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/chartfordays")
	public ChartData countsforchartdatwise(Model model) {
		try {
			if (sess != null) {
				return service.getDataForChart((String) sess.getAttribute("username"));
			}
		} catch (Exception e) {
			logger.info("Exception chart data not found " + e.getMessage());
		}
		return null;

	}

	

}
