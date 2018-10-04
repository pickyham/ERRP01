package co.hye.dao;

public class StorageDao {
	private int hCode;
	private String hName;
	private String hEx;
	
	public int gethCode() {
		return hCode;
	}
	public void sethCode(int hCode) {
		this.hCode = hCode;
	}
	
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	
	public String gethEx() {
		return hEx;
	}
	public void sethEx(String hEx) {
		this.hEx = hEx;
	}
	
	@Override
	public String toString() {
		return hCode + "\t" + hName + "\t" + hEx;
	}
}
