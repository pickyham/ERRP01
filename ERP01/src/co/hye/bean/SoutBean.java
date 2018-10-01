package co.hye.bean;

public class SoutBean {
	private int snum;
	private int sline;
	private int scode;
	private int sea;
	private int sprice;
	private int stotal;
	private String sdate;
	private String cName;
		
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getSline() {
		return sline;
	}
	public void setSline(int sline) {
		this.sline = sline;
	}
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
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
		return " 입고화면[구매번호: "+snum +"입고라인릴리즈" + sline 
				+ ", 상품코드 : " + scode 
				+ ", 수 량 : " + sea+ ", 단가 : " + sprice
				+ ", 입고일자 : " + sdate + ", 업체명 : " + cName + "]";
	}
}
