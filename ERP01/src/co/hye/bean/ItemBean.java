package co.hye.bean;

public class ItemBean {
   private String iClass;
   private String iCode;
   private String iName;
   private String iStandard;
   private String iUnit;
   private String cName;
   private String hname;
   private int iPrice;


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

   public String getHname() {
      return hname;
   }

   public void setHname(String hname) {
      this.hname = hname;
   }

   public int getiPrice() {
      return iPrice;
   }

   public void setiPrice(int iPrice) {
      this.iPrice = iPrice;
   }
   
   @Override
   public String toString() {
      return iClass + "\t" + iCode + "\t" + iName + "\t" + iStandard + "\t" + 
            iUnit + "\t" + cName + "\t" + hname + "\t" + iPrice;
   }
}