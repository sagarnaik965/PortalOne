package in.cdac.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import in.cdac.portal.modal.AllowedOpr;
import in.cdac.portal.modal.AppDetail;
import in.cdac.portal.modal.AppList;
import in.cdac.portal.modal.AppLk;
import in.cdac.portal.modal.ChartData;
import in.cdac.portal.modal.Count;
import in.cdac.portal.modal.Count1;
import in.cdac.portal.modal.DeptDetails;
import in.cdac.portal.modal.DeptList;
import in.cdac.portal.modal.UserStatus;

public interface UserService {

	public int getHomePageSuccessCountR(String username);

	public int getTotalErrorCountR(String username);

	public Map<String, Integer> getMonthlyTotalTransR(String principal);

	public int getTotalAcCountDeptWiseR(String string);

	public List<Count1> getTotalTransactionHomePageR(String string);

	public List<UserStatus> getAppcodeR(String username);

	public List<Count> acwiseTotaltransR(String[] appcodedata);

	
	public ResponseEntity<?> getSummaryForJasperIgnite(String[] datedata, String username);

	public ResponseEntity<byte[]> getBillingDataForPdf(String[] datedata, String username);

	public ResponseEntity<byte[]> getSummaryForJasperIgniteapp(String[] datedata, String username);

	public ResponseEntity<byte[]> getBillingDataForPdfapp(String[] datedata, String username);

	DeptList getDeptcodeFromUsername(String username);

	public List<AppList> getAppListR(String deptcode);

	public AppDetail getAppDetailR(String appcode);

	public AppLk getAppLkR(String appcode);

	public AllowedOpr getOprR(String appcode);

	public ChartData getDataForChart(String username);

	public String getCurrentEmailId(String userName);

	public Map<String, DeptDetails> getDeptServiceDetailsR(String string);

	public List<DeptList> getDeptListR();

}
