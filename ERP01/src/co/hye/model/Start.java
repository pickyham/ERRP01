package co.hye.model;

import java.sql.SQLException;
import java.util.Scanner;

//
public class Start {
   static int sel=0;
   static int n=0;
   static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      while (true) {
         System.out.println();
         System.out.println("┌───────────────재고관리 프로그램───────────────┐");
         System.out.println("│  1. 기초정보 관리 2. 입출고 정보 3. 재고 정보  4. 종료   │");
         System.out.println("└─────────────────────────────────────────┘");
         sel = Integer.parseInt(sc.nextLine());
         
         if (sel==1) info();
         else if (sel==2) spinfo();
         else if (sel==3) stinfo();
         else {
            System.out.println("재고관리 프로그램을 종료합니다.");
            break;
         }
      }
   }

   private static void info() throws ClassNotFoundException, SQLException {
      System.out.println("*************** 기초정보 관리 화면 ***************");
      System.out.println("1) 품목 정보  2) 창고 정보  3) 구매업체 관리  4) 판매업체 관리");
      n = Integer.parseInt(sc.nextLine());
      switch (n) {
      case 1:
         System.out.println("< 품목 정보 >");
         Item i = new Item();
         i.itemCall();
         break;
      case 2:
         System.out.println("< 창고 정보 >");
         Storage h = new Storage();
         h.storageCall();
         break;
      case 3:
         System.out.println("< 구매 업체 >");
         PCompany p = new PCompany();
         p.pcompanyCall();
         break;
      case 4:
         System.out.println("< 판매 업체 >");
         Company s = new Company();
         s.companyCall();
         break;
      }
   }
   private static void spinfo() throws ClassNotFoundException, SQLException {
      System.out.println("**************** 입출고정보 화면 ****************");
      System.out.println("1)입고 정보  2) 출고 정보  3)입출고 내역");
      n = Integer.parseInt(sc.nextLine());
      switch (n) {
      case 1:
         System.out.println("< 입고 정보 >");
         Pin p = new Pin();
         p.pinCall();
         break;
      case 2:
         System.out.println("< 출고 정보 >");
         Sout s = new Sout();
         s.soutCall();
         break;
      case 3:
         System.out.println("< 입출고 내역 >");
         Inout io = new Inout();
         io.inoutCall();
         break;
      }
   }
   private static void stinfo() throws ClassNotFoundException, SQLException {
      System.out.println("***************** 재고정보 화면 *****************");
      System.out.println("< 현재고 >");
      Stock s = new Stock();
      s.stockCall();
   }
}