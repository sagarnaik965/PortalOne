package in.cdac.portal.modal;

public enum SignBy {

	ASA("ASA"),
	AUA("AUA");
	
	
	private String value;
	
	private SignBy(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return this.value;
	}

}
