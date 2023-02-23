package in.cdac.webclient.model;


import javax.xml.bind.annotation.XmlElement;

public class Transforms {
	
	@XmlElement(name = "Transform")
	private Transform Transform;

    public Transform getTransform ()
    {
        return Transform;
    }

    public void setTransform (Transform Transform)
    {
        this.Transform = Transform;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Transform = "+Transform+"]";
    }
}
