package in.cdac.portal.modal;

public class Product {
	private int ID;
	private String NAME;
	private int COST;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getCOST() {
		return COST;
	}
	public void setCOST(int cOST) {
		COST = cOST;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", NAME=" + NAME + ", COST=" + COST + "]";
	}
	public Product(int iD, String nAME, int cOST) {
		super();
		ID = iD;
		NAME = nAME;
		COST = cOST;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
