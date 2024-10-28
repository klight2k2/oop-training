package model;

public abstract class BaseModel {
	public abstract void print();
//	protected  static int countID=0;
	protected int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
//	public BaseModel() {
//		this.ID=++countID;
//	}
}
