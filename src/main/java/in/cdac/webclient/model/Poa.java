package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Poa {
	
	@XmlAttribute(name="careof")
	 private String careof;
	@XmlAttribute(name="country")
	 private String country;
	@XmlAttribute(name="dist")
	 private String dist;
	@XmlAttribute(name="house")
	 private String house;
	@XmlAttribute(name="landmark")
	 private String landmark;
	@XmlAttribute(name="loc")
	 private String loc;
	@XmlAttribute(name="pc")
	 private String pc;
	@XmlAttribute(name="po")
	 private String po;
	@XmlAttribute(name="state")
	 private String state;
	@XmlAttribute(name="street")
	 private String street;
	@XmlAttribute(name="subdist")
	 private String subdist;
	@XmlAttribute(name="vtc")
	 private String vtc;
	
	public String getCareof() {
		return careof;
	}
	public void setCareof(String careof) {
		this.careof = careof;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getPc() {
		return pc;
	}
	public void setPc(String pc) {
		this.pc = pc;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSubdist() {
		return subdist;
	}
	public void setSubdist(String subdist) {
		this.subdist = subdist;
	}
	public String getVtc() {
		return vtc;
	}
	public void setVtc(String vtc) {
		this.vtc = vtc;
	}
	@Override
	public String toString() {
		return "Poa [careof=" + careof + ", country=" + country + ", dist=" + dist + ", house=" + house + ", landmark="
				+ landmark + ", loc=" + loc + ", pc=" + pc + ", po=" + po + ", state=" + state + ", street=" + street
				+ ", subdist=" + subdist + ", vtc=" + vtc + "]";
	}
	 
	

}
