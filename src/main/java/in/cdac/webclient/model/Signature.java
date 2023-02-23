package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Signature {
	
	
	@XmlAttribute(name="xmlns")
    private String xmlns;

	@XmlElement(name="SignatureValue")
    private String SignatureValue;

    @XmlElement(name = "SignedInfo")
    private SignedInfo SignedInfo;
    

    public String getXmlns ()
    {
        return xmlns;
    }

    public void setXmlns (String xmlns)
    {
        this.xmlns = xmlns;
    }

    public String getSignatureValue ()
    {
        return SignatureValue;
    }

    public void setSignatureValue (String SignatureValue)
    {
        this.SignatureValue = SignatureValue;
    }

    public SignedInfo getSignedInfo ()
    {
        return SignedInfo;
    }

    public void setSignedInfo (SignedInfo SignedInfo)
    {
        this.SignedInfo = SignedInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [xmlns = "+xmlns+", SignatureValue = "+SignatureValue+", SignedInfo = "+SignedInfo+"]";
    }
}
			
			
