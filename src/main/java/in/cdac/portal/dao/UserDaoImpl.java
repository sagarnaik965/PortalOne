package in.cdac.portal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cdac.dbswitch.CustomeUserDetails;
import in.cdac.portal.entities.User;
import in.cdac.portal.modal.AllowedOpr;
import in.cdac.portal.modal.AppDetail;
import in.cdac.portal.modal.AppList;
import in.cdac.portal.modal.AppLk;
import in.cdac.portal.modal.DeptDetails;
import in.cdac.portal.modal.DeptList;
import in.cdac.portal.modal.UserStatus;

@Service
public class UserDaoImpl implements UserDao {

	private final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	@Qualifier("test_ds")
	DataSource ds1;

	@Autowired
	@Qualifier("preproduction_ds")
	DataSource ds2;

	@Autowired
	@Qualifier("production_ds")
	DataSource ds3;

	@Autowired
	PasswordEncoder encoder;

	private JdbcTemplate jdbcTemplate(String tenantName) {
		logger.info("tenant name in getJDBCTemp::" + tenantName);
		if (tenantName.equalsIgnoreCase("test")) {
			JdbcTemplate temp = new JdbcTemplate(ds1);
			logger.info("return DS " + ds1.toString());
			return temp;
		} else if (tenantName.equalsIgnoreCase("preproduction")) {
			JdbcTemplate temp = new JdbcTemplate(ds2);
			logger.info("return DS " + ds2.toString());
			return temp;
		} else if (tenantName.equals("production")) {
			JdbcTemplate temp = new JdbcTemplate(ds3);
			logger.info("return DS " + ds3.toString());
			return temp;
		}
		logger.info("return DS NULL");
		return null;
	}

	@Override
	public int getHomePageSuccessCountR(String userName) {
		JdbcTemplate select = jdbcTemplate("test");
		int count = 0;
		try {
			count = select.queryForObject(
					"SELECT  sum(t.txn_count)  from dept_details  as d inner join application_details as a on d.dept_code=a.dept_code left join trans_stats as t  on a.app_code=t.ac where d.username=? and t.status='y'  ;",
					new Object[] { userName }, Integer.class);
		} catch (DataAccessException ex) {
			logger.info(ex.getMessage());
			count = 0;
		} catch (Exception e) {
			logger.info(e.getMessage());
			count = 0;
		}
		return count;
	}

	@Override
	public int getTotalErrorCountR(String userName) {
		int count = 0;
		try {
			JdbcTemplate select = jdbcTemplate("test");
			count = select.queryForObject(
					"SELECT  sum(t.txn_count)  from dept_details  as d inner join application_details as a on d.dept_code=a.dept_code left join trans_stats as t  on a.app_code=t.ac where d.username=? and t.status='n';",
					new Object[] { userName }, Integer.class);

		} catch (DataAccessException ex) {
			logger.info(ex.getMessage());
			return 0;
		} catch (Exception e) {
			logger.info(e.getMessage());
			count = 0;
		}
		return count;
	}

	public Map<String, Integer> getMonthlyTotalTransR(String userName) {
		logger.info("getMonthlyTotalTrans userName::" + userName);
		JdbcTemplate select = jdbcTemplate("test");
		try {
			return select.query(
					"select to_char(date,'month') as month,sum(txn_count) as count from public.trans_stats   group by 1,1 order by month desc limit 12  ",
					new ResultSetExtractor<Map<String, Integer>>() {
						public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
							Map<String, Integer> map = new LinkedHashMap<String, Integer>();
							String month = null;
							int count = 0;
							while (rs.next()) {
								month = rs.getString("month");
								count = rs.getInt("count");
								map.put(month, count);
							}
							return map;
						}
					});
		} catch (DataAccessException ex) {
			logger.info(ex.getMessage());
			return null;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public int getTotalAcCountDeptWiseR(String userName) {
		JdbcTemplate select = jdbcTemplate("test");
		int count = 0;
		try {
			if (getRole(userName).equalsIgnoreCase("1")) {
				count = select.queryForObject("select count(app_code) as total_ac from application_details;",
						Integer.class);
			} else {
				count = select.queryForObject(
						"select count(app_code) as total_ac from application_details where  dept_code in (select dept_code from dept_details where  username =? );",
						new Object[] { userName }, Integer.class);
			}

		} catch (DataAccessException ex) {
			logger.info(ex.getMessage());
			count = 0;
		} catch (Exception e) {
			logger.info(e.getMessage());
			count = 0;
		}

		return count;
	}

	public Map<String, Integer> getTotalTransactionHomePageR(String userName) {
		JdbcTemplate select = jdbcTemplate("test");
		return select.query(
				"SELECT  sum(t.txn_count)  ,opr from dept_details  as d inner join application_details as a on d.dept_code=a.dept_code left join trans_stats as t  on a.app_code=t.ac where d.username=?  group by t.opr;",
				new Object[] { userName }, new ResultSetExtractor<Map<String, Integer>>() {
					public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
						Map<String, Integer> map = new HashMap<String, Integer>();
						map.put("struid", 0);
						map.put("getuid", 0);
						map.put("getrefnum", 0);
						map.put("activate", 0);
						map.put("deactivate", 0);
						while (rs.next()) {
							if (rs.getString("opr") != null) {

								if (rs.getString("opr").equals("struid")) {
									map.put("struid", rs.getInt("sum"));
								}

								if (rs.getString("opr").equals("getuid")) {
									map.put("getuid", rs.getInt("sum"));
								}
								if (rs.getString("opr").equals("getrefnum")) {
									map.put("getrefnum", rs.getInt("sum"));
								}

								if (rs.getString("opr").equals("activate")) {
									map.put("activate", rs.getInt("sum"));
								}
								if (rs.getString("opr").equals("deactivate")) {
									map.put("deactivate", rs.getInt("sum"));
								}

							}
						}
						return map;
					}
				});
	}

	public List<UserStatus> getAppcodeR(String Username) {
		JdbcTemplate select = jdbcTemplate("test");
		try {
			return select.query(
					" SELECT app_code , app_name FROm application_details where dept_code in (select dept_code from dept_details where username=?) ;",
					new Object[] { Username }, new RowMapper<UserStatus>() {
						public UserStatus mapRow(ResultSet rs, int arg1) throws SQLException {
							UserStatus us = new UserStatus();
							us.setAuaCode(rs.getString("app_code"));
							us.setAppName(rs.getString("app_name"));
							return us;
						}
					});

		} catch (DataAccessException ex) {
			logger.info(ex.getMessage());
			return null;

		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	@Override
	public Map<String, Integer> acwiseTotaltransR(String[] acCode) {
		// TODO Auto-generated method stub
		JdbcTemplate select = jdbcTemplate("test");
		String url = "";
		if (acCode[1].contentEquals("Total")) {
			url = "SELECT  sum(txn_count),opr FROM public.trans_stats where ac=? and status in ('y', 'n') group by opr order by  opr;";

		} else if (acCode[1].contentEquals("Yes")) {
			url = "SELECT  sum(txn_count),opr FROM public.trans_stats where ac=? and status='y' group by opr order by  opr;";
		} else if (acCode[1].contentEquals("No")) {
			url = "SELECT  sum(txn_count),opr FROM public.trans_stats where ac=? and status='n' group by opr order by  opr;";
		}
		return select.query(url, new Object[] { acCode[0] }, new ResultSetExtractor<Map<String, Integer>>() {
			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("struid", 0);
				map.put("getuid", 0);
				map.put("getrefnum", 0);
				map.put("activate", 0);
				map.put("deactivate", 0);
				while (rs.next()) {
					if (rs.getString("opr").equals("struid")) {
						map.put("struid", rs.getInt("sum"));
					}
					if (rs.getString("opr").equals("getuid")) {
						map.put("getuid", rs.getInt("sum"));
					}
					if (rs.getString("opr").equals("getrefnum")) {
						map.put("getrefnum", rs.getInt("sum"));
					}

					if (rs.getString("opr").equals("activate")) {
						map.put("activate", rs.getInt("sum"));
					}
					if (rs.getString("opr").equals("deactivate")) {
						map.put("deactivate", rs.getInt("sum"));
					}
				}
				return map;
			}
		});
	}

	public Map<String, DeptDetails> getrecordR(String deptcode) {
		JdbcTemplate select = jdbcTemplate("test");
		return select.query(
				"  select * from(select d.dept_name as name, d.dept_code as deptcode ,a.app_name as appname from dept_details as d, application_details as a where d.dept_code = a.dept_code) as new  where new.deptcode=?;",
				new Object[] { deptcode }, new ResultSetExtractor<Map<String, DeptDetails>>() {
					public Map<String, DeptDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
						Map<String, DeptDetails> map = new HashMap<String, DeptDetails>();
						while (rs.next()) {
							DeptDetails dept = new DeptDetails();
							dept.setDept_name(rs.getString("name"));
							dept.setApp_name(rs.getString("appname"));
							map.put(rs.getString("appname"), dept);
						}
						return map;
					}
				});
	}

	@Override
	public Map<String,Long> getDataForChart(String userName) {
		JdbcTemplate select = jdbcTemplate("test");
		return select.query(
				"select date,sum(txn_count) from trans_stats where ac in (select app_code from application_details where dept_code in (select dept_code from dept_details where username = '?')) and date >= (now()-interval '7 days') group by date;",
				new ResultSetExtractor<Map<String,Long>>() {
					public Map<String,Long> extractData(ResultSet rs) throws SQLException, DataAccessException {
						Map<String,Long> chartdata = new HashMap<>();
						while (rs.next()) {
							if (rs.getString("txn_count") != null)
								chartdata.put(rs.getString("date"), Long.parseLong(rs.getString("date")));
								
						}
						return chartdata;
					}
				});
	}
	
	

	@Override
	public String getDeptcodeFromUsernameforreport(String username) {
		// TODO Auto-generated method stub
		try {

			JdbcTemplate select = jdbcTemplate("test");
			String url = "select dept_name,  dept_code from dept_details where username =" + "'" + username + "' ;";
			return select.query(url, new ResultSetExtractor<String>() {
				public String extractData(ResultSet rs) throws SQLException, DataAccessException {
					String deptcode = "";
					while (rs.next()) {
						deptcode = rs.getString("dept_code") + "," + rs.getString("dept_name");
					}
					return deptcode;
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}

	@Override
	public DeptList getDeptcodeFromUsername(String username) {
		// TODO Auto-generated method stub
		JdbcTemplate select = jdbcTemplate("test");

		String url = "select dept_code , dept_name from dept_details where username =" + "'" + username + "' ;";

		return select.query(url, new ResultSetExtractor<DeptList>() {
			public DeptList extractData(ResultSet rs) throws SQLException, DataAccessException {
				DeptList dept = new DeptList();

				while (rs.next()) {
					dept.setDept_code(rs.getString("dept_code"));
					dept.setDept_name(rs.getString("dept_name"));

				}
				return dept;
			}
		});
	}

	@Override
	public List<AppList> getAppListR(String deptcode) {
		// TODO Auto-generated method stub

		JdbcTemplate select = jdbcTemplate("test");

		return select.query(
				"select app_name,app_code from application_details where dept_Code='" + deptcode + "'" + ";",
				new ResultSetExtractor<List<AppList>>() {

					public List<AppList> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<AppList> applist = new ArrayList<>();
						while (rs.next()) {
							AppList appl = new AppList();
							appl.setAppname(rs.getString("app_name"));
							appl.setAppcode(rs.getString("app_code"));

							applist.add(appl);
						}
						return applist;
					}
				});

	}

	@Override
	public AppDetail getAppDetailR(String appcode) {
		// TODO Auto-generated method stub

		JdbcTemplate select = jdbcTemplate("test");

		return select.query(
				"select app_name,email,description from application_details where app_code='" + appcode + "'" + ";",
				new ResultSetExtractor<AppDetail>() {

					public AppDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
						AppDetail appd = new AppDetail();
						while (rs.next()) {

							appd.setAppname(rs.getString("app_name"));
							appd.setEmail(rs.getString("email"));
							appd.setDesc(rs.getString("description"));

						}
						return appd;
					}
				});

	}

	@Override
	public AppLk getAppLkR(String appcode) {
		// TODO Auto-generated method stub

		JdbcTemplate select = jdbcTemplate("test");

		return select.query("select lk,lk_expiry_date::date,app_is_active from application_lk where app_code='"
				+ appcode + "'" + ";", new ResultSetExtractor<AppLk>() {

					public AppLk extractData(ResultSet rs) throws SQLException, DataAccessException {
						AppLk appl = new AppLk();

						while (rs.next()) {

							String masklk = String.valueOf(rs.getString("lk"));
							char[] ch = new char[masklk.length()];
							for (int i = 0; i < 36; i++) {
								ch[i] = masklk.charAt(i);
							}

							for (int i = 0; i < 28; i++) {
								ch[i] = '*';
							}

							String finallk = String.valueOf(ch);

							appl.setLk(finallk);

							appl.setLkexpiry(rs.getDate("lk_expiry_date"));

							appl.setApp_is_active(rs.getBoolean("app_is_active"));

						}
						return appl;
					}
				});

	}

	@Override
	public AllowedOpr getOprR(String appcode) {
		// TODO Auto-generated method stub
		JdbcTemplate select = jdbcTemplate("test");

		return select.query(
//				" select state_code as codes, state_name as statenames from m_state;",
				"select is_struid,is_getrefnum,is_getuid,is_activate,is_deactivate,is_dupcheck,app_code from application_lk where app_code='"
						+ appcode + "'" + ";",
				new ResultSetExtractor<AllowedOpr>() {

					public AllowedOpr extractData(ResultSet rs) throws SQLException, DataAccessException {
//						Map<String, String> map = new HashMap<String, String>();
//						List<AllowedOpr> opr = new ArrayList<>();
						AllowedOpr opra = new AllowedOpr();
						while (rs.next()) {
							opra.setis_Struid(rs.getBoolean("is_struid"));
							opra.setis_Getrefnum(rs.getBoolean("is_getrefnum"));
							opra.setis_Getuid(rs.getBoolean("is_getuid"));
							opra.setis_Activate(rs.getBoolean("is_activate"));
							opra.setis_Deactivate(rs.getBoolean("is_deactivate"));
							opra.setIs_dupcheck(rs.getBoolean("is_dupcheck"));
							opra.setApplicode(rs.getString("app_code"));
//							opr.add(opra);

						}
						return opra;
					}
				});

	}

	public String getCurrentEmailId(String userName) {
		JdbcTemplate select = jdbcTemplate(getTenantName());
		String email = null;
		try {
			email = select.queryForObject("SELECT email FROM public.dept_details where username= ?",
					new Object[] { userName }, String.class);

		} catch (DataAccessException ex) {
			logger.info(ex);
			return null;

		} catch (Exception e) {
			logger.info(e);
			return null;
		}

		return email;
	}

	@Override
	public List<DeptList> getDeptListR() {
		JdbcTemplate select = jdbcTemplate("test");
//		int count = 0;
		return select.query(
//				" select state_code as codes, state_name as statenames from m_state;",
				"select dept_name,dept_code,username from dept_details", new ResultSetExtractor<List<DeptList>>() {
					public List<DeptList> extractData(ResultSet rs) throws SQLException, DataAccessException {
//						Map<String, String> map = new HashMap<String, String>();
						List<DeptList> deptlist = new ArrayList<>();
						while (rs.next()) {
							DeptList dept = new DeptList();
							dept.setDept_name(rs.getString("dept_name"));
							dept.setDept_code(rs.getString("dept_code"));
							dept.setUsername(rs.getString("username"));
							deptlist.add(dept);

						}
						return deptlist;
					}
				});
	}

//	------------------------------------line     ------Methods for react-----------------------------------------------------------------------------------------

	@Override
	public String getRole(String principal) {
		// TODO Auto-generated method stub
		try {

			JdbcTemplate select = jdbcTemplate("test");

			String url = "select role_id from user_roles where username = " + "'" + principal + "'" + ";";
			return select.query(url, new ResultSetExtractor<String>() {
				public String extractData(ResultSet rs) throws SQLException, DataAccessException {

					String r = "";
					while (rs.next()) {
						r = rs.getString("role_id");

					}
					return r;
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<String> getActivityListByUsername(String username, String tenant) {
		JdbcTemplate select = jdbcTemplate(tenant);
		logger.info("username " + username);

		return select.query(
				"select a.activity from activities a join role_activities ra on a.activity_id = ra.activity_id join  user_roles ur on ra.role_id = ur.role_id  where ur.username = ?; ",
				new Object[] { username }, new RowMapper<String>() {

					public String mapRow(ResultSet rs, int arg1) throws SQLException {
						return rs.getString(1);
					}
				});
	}

//
	public List<String> getUsernameList(long dept_id) {
		JdbcTemplate select = jdbcTemplate(getTenantName());
		logger.info("dept_id " + dept_id);
		return select.query("select username from public.users  where dept_id = ? ", new Object[] { dept_id },
				new RowMapper<String>() {

					public String mapRow(ResultSet rs, int arg1) throws SQLException {
						return rs.getString(1);
					}
				});
	}

	private String getTenantName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tenantName = null;
		if (auth != null && !auth.getClass().equals(AnonymousAuthenticationToken.class)) {
			// User user = (User) auth.getPrincipal();
			CustomeUserDetails userDetails = (CustomeUserDetails) auth.getPrincipal();
			tenantName = userDetails.getTenant();
		}
		return tenantName;
	}

	public List<User> getUser(String userName) {
		JdbcTemplate select = jdbcTemplate(getTenantName());
		logger.info("getUser UserName::" + userName);
		// return select.query("select u.username, u.passwd, u.is_active from
		// public.users as u where u.username = ?",
		return select.query(
				"select u.username, u.passwd,u.dept_is_active from public.dept_details as u  where  u.username = ?",
				new Object[] { userName }, new RowMapper<User>() {
					public User mapRow(ResultSet rs, int arg1) throws SQLException {
						User user = new User();
						user.setUsername(rs.getString(1));
						user.setPasswd(rs.getString(2));
						user.setActive(rs.getBoolean(3));
						return user;
					}
				});
	}

	public List<User> loadUserByUsernameAndTenantname(String username, String tenantName) {
		logger.info("UserName ::" + username + " ::tenant name::" + tenantName);
		JdbcTemplate jdbcTemp = jdbcTemplate(tenantName);
		// String q="select u.username, u.passwd, u.is_active ,m.para_desc from
		// public.users as u,m_config_para m where m.para_value=? and u.username = ?";
		String q = "select u.username, u.passwd,u.dept_is_active ,m.para_desc from public.dept_details as u,m_config_para m where m.para_value=? and u.username = ?";
		List<User> user = jdbcTemp.query(q, new Object[] { tenantName, username }, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPasswd(rs.getString(2));
				user.setActive(rs.getBoolean(3));
				user.setTenantname(rs.getString(4));
				return user;
			}
		});
		return user;
	}

}
