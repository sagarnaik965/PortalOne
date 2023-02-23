package in.cdac.portal.modal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation {

	public Validation() {
		super();
	}

	public boolean isEmailValid(String email) {
		String emailRegex="^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		//String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		// regular expression provided by OWASP Validation Regex repository.
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isUsernameValid(String username) {
		String usernameRegex = "^[A-Za-z][A-Za-z0-9_]{7,}$";
		Pattern pat = Pattern.compile(usernameRegex);
		if (username == null)
			return false;
		return pat.matcher(username).matches();
	}

	public boolean isPasswordValid(String password) {
		String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,12}$";
		Pattern pat = Pattern.compile(passwordRegex);
		if (password == null)
			return false;
		return pat.matcher(password).matches();
	}
	
	public boolean isAddressLineValid(String addressLine){
		String addressRegex = "^([a-zA-Z0-9-;,@/ ]){5,120}$";
		Pattern pat = Pattern.compile(addressRegex);
		if (addressLine==null) {
			return false;
		}
		return pat.matcher(addressLine).matches();
	}
	
	public boolean isLicenceKeyValid(String lkey) 
	{
		String licenceKeyRegex = "^([a-zA-Z0-9-_]){8,64}$";
		Pattern pat = Pattern.compile(licenceKeyRegex);
		if (lkey == null)
			return false;
		return pat.matcher(lkey).matches();
	}
	
	public boolean isFutureDate(String date) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try 
		{
			Date futureDate = sdf.parse(date);
			if(futureDate.compareTo(new Date())>0)
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public  long getDaysBetweenTwoDate(String startdate,String LastDate) {
		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date11=LocalDate.parse(LocalDate.parse(startdate, formatter).format(formatter2));
		LocalDate date22=LocalDate.parse(LocalDate.parse(LastDate, formatter).format(formatter2));
		long days=ChronoUnit.DAYS.between(date11, date22);
		return days;
	}
	
	public boolean isFutureDate1(String date) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try 
		{
			Date futureDate = sdf.parse(date);
			if(futureDate.compareTo(new Date())>0)
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isDepartmentValid(String dept) {
		String deptRegex = "^[A-Za-z][A-Za-z 0-9]{5,30}$";
		Pattern pat = Pattern.compile(deptRegex);
		if (dept == null)
			return false;
		return pat.matcher(dept).matches();
	}
	
	public boolean isAUACodeValid(String auaCode) {
		String auaCodeRegex = "^[A-Za-z][A-Za-z 0-9]{9}$";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (auaCode == null)
			return false;
		return pat.matcher(auaCode).matches();
	}
	
	public boolean isPersonNameValid(String name) {
		String auaCodeRegex = "(^([a-zA-Z ]){5,30}$)";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
	}
	public boolean isDesignationValid(String name) {


		String auaCodeRegex = "(^[a-zA-Z]+[a-zA-Z .0-9]+$)";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
	
		
	
	}
	public boolean isMobileNumberValid(String name) {

		String auaCodeRegex = "^[6-9][0-9]{9}$";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
	
		
	}
	public boolean isTelphoneValid(String name) {
		String auaCodeRegex = "^[0-9]{10,11}$";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
		
	}
	public boolean isCityValid(String name) {
		String auaCodeRegex = "(^([a-zA-Z ]){3,50}$)";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
		
	}
	public boolean isPincodeValid(String name) {
		String auaCodeRegex = "(^[0-9][0-9]{5}$)";
		Pattern pat = Pattern.compile(auaCodeRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
		
	}
	
}
