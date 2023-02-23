package in.cdac.portal.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cdac.portal.dao.UserDaoImpl;
import in.cdac.portal.modal.Constant;

@Service
public class Util {

	@Autowired
	PasswordEncoder encoder;

	private final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public String generateSchemaName(int deptId, String deptName) {
		String schemaName = new String();
		schemaName = Constant.SCHEMANAME_PREFIX + Constant.SCHEMANAME_DELIMITER + deptName.substring(0, 4).toLowerCase()
				+ Constant.SCHEMANAME_DELIMITER + getDeptId4d(deptId);
		logger.info("schemaName::" + schemaName);
		return schemaName;
	}

	public String generateUserName(int deptId, String username_prefix) {
		// String userName = Constant.USERNAME_PREFIX +Constant.SCHEMANAME_DELIMITER +
		// getDeptId(deptId);
		String userName;
		if (username_prefix.equalsIgnoreCase("aua"))
			userName = username_prefix + Constant.SCHEMANAME_DELIMITER + getDeptId4d(deptId);
		else
			userName = username_prefix + Constant.SCHEMANAME_DELIMITER + getDeptId3d(deptId);
		logger.info("userName::" + userName);
		return userName;
	}

	private String getDeptId4d(int deptId) {
		return String.format("%04d", deptId);
	}

	private String getDeptId3d(int deptId) {
		return String.format("%03d", deptId);
	}

	public String generatePassword() {
		return encoder.encode(Constant.DEFAULT_PASSWORD);
	}

	public String generateHashForLink(String parameterToBeHashed) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			logger.info("Error while creating hash :", e);
		}
		md.update(parameterToBeHashed.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		logger.info("Hex format : " + sb.toString());

		return sb.toString();
	}

	public static String trimValues(String data) {
		if (data == null) {
			return null;
		} else {
			return data.trim();
		}

	}
	public String generateAuaCode(String username) {
		return "SA0" + username.substring(username.length() - 3);
	}
}
