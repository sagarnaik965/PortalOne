package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UidData {
	
	
	@XmlElement(name = "Poi")
	 public Poi PoiObject;
	
	@XmlElement(name = "Poa")
	 public Poa PoaObject;
	
	@XmlElement(name="Pht")
	 private String Pht;
	 
	public Poi getPoiObject() {
		return PoiObject;
	}
	public void setPoiObject(Poi poiObject) {
		PoiObject = poiObject;
	}
	public Poa getPoaObject() {
		return PoaObject;
	}
	public void setPoaObject(Poa poaObject) {
		PoaObject = poaObject;
	}
	public String getPht() {
		return Pht;
	}
	public void setPht(String pht) {
		Pht = pht;
	}
	@Override
	public String toString() {
		return "UidData [PoiObject=" + PoiObject + ", PoaObject=" + PoaObject + ", Pht=" + Pht + "]";
	}
	 

}
