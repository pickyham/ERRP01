package co.hye.bean;

public class InoutBean {
	private int ioSeq;
	private String iCode;
	private String iName;
	private int pea;
	private int sea;
	private int ea;
	private String ioDate;
	private String hName;
	
	public int getIoSeq() {
		return ioSeq;
	}
	public void setIoSeq(int ioSeq) {
		this.ioSeq = ioSeq;
	}
	
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
	
	public int getPea() {
		return pea;
	}
	public void setPea(int pea) {
		this.pea = pea;
	}
	
	public int getSea() {
		return sea;
	}
	public void setSea(int sea) {
		this.sea = sea;
	}
	
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}

	public String getIoDate() {
		return ioDate;
	}
	public void setIoDate(String ioDate) {
		this.ioDate = ioDate;
	}

	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	
	@Override
	public String toString() {
		return ioSeq + "\t" + iCode + "\t" + iName + "\t" + pea + "\t" + sea + "\t" + ea
				+ "\t" + ioDate + "\t" + hName;
	}
}
