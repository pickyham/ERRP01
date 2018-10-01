package co.hye.bean;

public class ItemBean {
	private String iClass;
	private String iCode;
	private String iName;
	private String iStandard;
	private String iUnit;
	private String cName;

	public String getiClass() {
		return iClass;
	}

	public void setiClass(String iClass) {
		this.iClass = iClass;
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

	public String getiStandard() {
		return iStandard;
	}

	public void setiStandard(String iStandard) {
		this.iStandard = iStandard;
	}

	public String getiUnit() {
		return iUnit;
	}

	public void setiUnit(String iUnit) {
		this.iUnit = iUnit;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "품목 정보 [분류코드 : " + iClass + ", 상품코드 : " + iCode + ", 상품명 : " + iName + ", 규격 : " + iStandard + ", 단위 : "
				+ iUnit + ", 업체명 : " + cName + "]";
	}
}
