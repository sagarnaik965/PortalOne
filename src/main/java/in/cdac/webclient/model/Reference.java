package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Reference {

	
	@XmlElement(name = "Transforms")
	private Transforms Transforms;

	@XmlElement(name = "DigestMethod")
	private DigestMethod DigestMethod;

	@XmlAttribute(name="DigestValue")
	private String DigestValue;

	@XmlAttribute(name="URI")
	private String URI;

	public Transforms getTransforms() {
		return Transforms;
	}

	public void setTransforms(Transforms Transforms) {
		this.Transforms = Transforms;
	}

	public DigestMethod getDigestMethod() {
		return DigestMethod;
	}

	public void setDigestMethod(DigestMethod DigestMethod) {
		this.DigestMethod = DigestMethod;
	}

	public String getDigestValue() {
		return DigestValue;
	}

	public void setDigestValue(String DigestValue) {
		this.DigestValue = DigestValue;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

	@Override
	public String toString() {
		return "ClassPojo [Transforms = " + Transforms + ", DigestMethod = " + DigestMethod + ", DigestValue = "
				+ DigestValue + ", URI = " + URI + "]";
	}

}
