package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class Poi {
	
	
	@XmlAttribute(name="dob")
	 private String dob;
	@XmlAttribute(name="e")
	 private String e;
	@XmlAttribute(name="gender")
	 private String gender;
	@XmlAttribute(name="m")
	 private String m;
	@XmlAttribute(name="name")
	 private String name;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Poi [dob=" + dob + ", e=" + e + ", gender=" + gender + ", m=" + m + ", name=" + name + "]";
	}
	 
	
}
