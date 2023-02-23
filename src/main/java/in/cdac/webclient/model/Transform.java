package in.cdac.webclient.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Transform {
	
	@XmlAttribute(name="Algorithm")
	 private String Algorithm;

	    public String getAlgorithm ()
	    {
	        return Algorithm;
	    }

	    public void setAlgorithm (String Algorithm)
	    {
	        this.Algorithm = Algorithm;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Algorithm = "+Algorithm+"]";
	    }

}
