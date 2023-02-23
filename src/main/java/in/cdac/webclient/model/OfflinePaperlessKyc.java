package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OfflinePaperlessKyc")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfflinePaperlessKyc
{
	
	@XmlElement(name = "Signature")
    private Signature Signature;

	@XmlElement(name = "UidData")
    private UidData UidData;

	@XmlAttribute(name="referenceId")
    private String referenceId;

    public Signature getSignature ()
    {
        return Signature;
    }

    public void setSignature (Signature Signature)
    {
        this.Signature = Signature;
    }

    public UidData getUidData ()
    {
        return UidData;
    }

    public void setUidData (UidData UidData)
    {
        this.UidData = UidData;
    }

    public String getReferenceId ()
    {
        return referenceId;
    }

    public void setReferenceId (String referenceId)
    {
        this.referenceId = referenceId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Signature = "+Signature+", UidData = "+UidData+", referenceId = "+referenceId+"]";
    }
}
	