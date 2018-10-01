package co.hye.bean;

public class StorageBean {
	private int hCode;
	private String hName;
	private String hExplain;

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

	public String gethExplain() {
		return hExplain;
	}
	public void sethExplain(String hExplain) {
		this.hExplain = hExplain;
	}

	@Override
	public String toString() {
		return "창고 정보 [창고 코드 : " + hCode + ", 창고명 : " + hName + ", 창고 정보  : " + hExplain + "]";
	}
}