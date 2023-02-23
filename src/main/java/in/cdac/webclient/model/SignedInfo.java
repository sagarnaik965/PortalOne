package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlElement;

public class SignedInfo
{
	@XmlElement(name = "Reference")
    private Reference Reference;

	@XmlElement(name = "CanonicalizationMethod")
    private CanonicalizationMethod CanonicalizationMethod;

	@XmlElement(name = "SignatureMethod")
    private SignatureMethod SignatureMethod;

    public Reference getReference ()
    {
        return Reference;
    }

    public void setReference (Reference Reference)
    {
        this.Reference = Reference;
    }

    public CanonicalizationMethod getCanonicalizationMethod ()
    {
        return CanonicalizationMethod;
    }

    public void setCanonicalizationMethod (CanonicalizationMethod CanonicalizationMethod)
    {
        this.CanonicalizationMethod = CanonicalizationMethod;
    }

    public SignatureMethod getSignatureMethod ()
    {
        return SignatureMethod;
    }

    public void setSignatureMethod (SignatureMethod SignatureMethod)
    {
        this.SignatureMethod = SignatureMethod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Reference = "+Reference+", CanonicalizationMethod = "+CanonicalizationMethod+", SignatureMethod = "+SignatureMethod+"]";
    }
}
			
			
			