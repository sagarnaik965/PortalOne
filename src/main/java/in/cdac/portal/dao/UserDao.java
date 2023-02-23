package in.cdac.portal.dao;

import java.util.List;
import java.util.Map;

import in.cdac.portal.entities.User;
import in.cdac.portal.modal.AllowedOpr;
import in.cdac.portal.modal.AppDetail;
import in.cdac.portal.modal.AppList;
import in.cdac.portal.modal.AppLk;
import in.cdac.portal.modal.DeptDetails;
import in.cdac.portal.modal.DeptList;
import in.cdac.portal.modal.UserStatus;

public interface UserDao {

	public int getHomePageSuccessCountR(String userName);

	public int getTotalErrorCountR(String userName);

	public Map<String, Integer> getMonthlyTotalTransR(String userName);

	public List<UserStatus> getAppcodeR(String username);

	public int getTotalAcCountDeptWiseR(String userName);

	public Map<String, Integer> acwiseTotaltransR(String[] acCode);

	String getDeptcodeFromUsernameforreport(String username);

	public Map<String, Integer> getTotalTransactionHomePageR(String userName);

	DeptList getDeptcodeFromUsername(String username);

	List<AppList> getAppListR(String deptcode);

	AppDetail getAppDetailR(String appcode);

	AppLk getAppLkR(String appcode);

	AllowedOpr getOprR(String appcode);

	public String getCurrentEmailId(String userName);

	public Map<String, DeptDetails> getrecordR(String deptcode);

	List<DeptList> getDeptListR();

	public Map<String, Long> getDataForChart(String Username);

	public List<User> getUser(String userName);

	public List<User> loadUserByUsernameAndTenantname(String username, String tenantName);

	public List<String> getActivityListByUsername(String username, String tenant);

	public String getRole(String principal);
}
