package in.cdac.portal.modal;

public enum LicenceType {
	
	ASA("ASA"),
	AUA("AUA"),
	KUA("KUA"),
	KSA("KSA");
	
	private String value;
	
	private LicenceType(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return this.value;
	}

}
