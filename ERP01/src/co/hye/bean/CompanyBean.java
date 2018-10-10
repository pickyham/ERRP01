package co.hye.bean;

public class CompanyBean {
	   private String cNum;
	   private String cCode;
	   private String cName;
	   private String cAddress;
	   private String cContact;
	   private String cBoss;
	   ////
	   public String getcNum() {
	      return cNum;
	   }
	   public void setcNum(String cNum) {
	      this.cNum = cNum;
	   }
	   
	   public String getcCode() {
	      return cCode;
	   }
	   public void setcCode(String cCode) {
	      this.cCode = cCode;
	   }
	   
	   public String getcName() {
	      return cName;
	   }
	   public void setcName(String cName) {
	      this.cName = cName;
	   }
	   
	   public String getcAddress() {
	      return cAddress;
	   }
	   public void setcAddress(String cAddress) {
	      this.cAddress = cAddress;
	   }
	   
	   public String getcContact() {
	      return cContact;
	   }
	   public void setcContact(String cContact) {
	      this.cContact = cContact;
	   }
	   
	   public String getcBoss() {
	      return cBoss;
	   }
	   public void setcBoss(String cBoss) {
	      this.cBoss = cBoss;
	   }
	   
	   public String toString() {
	      return cCode + "\t" + cName + "\t" + cAddress
	    		  + "\t" + cContact + "\t" + cBoss;
	   }
}