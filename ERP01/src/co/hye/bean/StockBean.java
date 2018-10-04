package co.hye.bean;

public class StockBean {
	private String iCode;
	private String iName;
	private int pPrice;
	private String cName;
	private String cNum;
	private String hName;
	private int pEa;
	
	public String getiCode() {
		return iCode;
	}
	public void setiCode(String iCode) {
		this.iCode = iCode;
	}
	
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	
	public int getpEa() {
		return pEa;
	}
	public void setpEa(int pEa) {
		this.pEa = pEa;
	}
	
	@Override
	public String toString() {
		return iCode + "\t" + iName + "\t" + pPrice + "\t" + cName + "\t" + 
				cNum + "\t" + hName + "\t" + pEa;
	}
}
