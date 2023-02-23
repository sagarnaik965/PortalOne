package in.cdac.portal.modal;

public enum Cert_types {

	sign("sign"), 
	decrypt("decrypt"),
	symmetric_encrypt("symmetric_encrypt");
	
	private String value;
	
	private Cert_types(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return this.value;
	}
}
