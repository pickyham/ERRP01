package co.hye.bean;

public class PinBean {
	private String pnum;
	private int pline;
	private String pcode;
	private int pea;
	private int pprice;
	private int ptotal;
	private String pdate;
	private String cName;

	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public int getPline() {
		return pline;
	}
	public void setPline(int pline) {
		this.pline = pline;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getPea() {
		return pea;
	}
	public void setPea(int pea) {
		this.pea = pea;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPtotal() {
		return ptotal;
	}
	public void setPtotal(int ptotal) {
		this.ptotal = ptotal;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return " 입고화면[구매번호: "+pnum +"입고라인릴리즈" + pline 
				+ ", 상품코드 : " + pcode 
				+ ", 수 량 : " + pea + ", 단가 : " + pprice
				+ ", 입고일자 : " + pdate + ", 업체명 : " + cName + "]";
	}
}
