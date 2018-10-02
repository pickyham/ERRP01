package co.hye.bean;

public class SoutBean {
	private String snum;
	private int sline;
	private String scode;
	private String sname;
	private int sea;
	private int sprice;
	private int stotal;
	private String sdate;
	private String cName;
		
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public int getSline() {
		return sline;
	}
	public void setSline(int sline) {
		this.sline = sline;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSea() {
		return sea;
	}
	public void setSea(int sea) {
		this.sea = sea;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	public int getStotal() {
		return stotal;
	}
	public void setStotal(int stotal) {
		this.stotal = stotal;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	@Override
	public String toString() {
		return snum + "\t" + sline + "\t" + scode + "\t" + sname + "\t" + sea + "\t" + sprice + "\t" + stotal + "\t"+ sdate + "\t" + cName;
	}
}
