package in.cdac.portal.modal;

public enum SigningType {
	HARD("HARD"),
	SOFT("SOFT");
	
	
	private String value;
	
	private SigningType(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return this.value;
	}

}
