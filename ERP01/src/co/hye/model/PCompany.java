package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.CompanyBean;
import co.hye.dao.PCompanyDao;
////
public class PCompany {
	CompanyBean c;
	PCompanyDao pcd;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	int n = 0;

	public void pcompanyCall() throws ClassNotFoundException, SQLException{
		View();
		System.out.println("1.업체조회 2.업체입력 3.업체삭제 4.업체수정");
		n = Integer.parseInt(sc.nextLine());
		
		switch(n) {
		case 1:
			cSearch();
			break;
		case 2:
			cInsert();
			break;
		case 3:
			cDelete();
			break;
		case 4:
			cUpdate();
			break;			
		}			
	}

	public void cInsert() throws ClassNotFoundException, SQLException {
		c = new CompanyBean();
		pcd = new PCompanyDao();

		System.out.println("업체코드를 입력하세요.");
		c.setcCode(sc.nextInt());
		System.out.println("업체명을 입력하세요.");
		c.setcName(sc.nextLine());
		System.out.println("업체주소을 입력하세요.");
		c.setcAddress(sc.nextLine());
		System.out.println("업체연락처를 입력하세요.");
		c.setcContact(sc.nextLine());
		System.out.println("대표자명을 입력하세요.");
		c.setcBoss(sc.nextLine());
		sc.close();

		pcd.InsertCompany(c);
		pcd.close();
	}
	
	public void cDelete() throws ClassNotFoundException, SQLException {
		pcd = new PCompanyDao();
		
		System.out.println("삭제할 업체코드를 입력 하세요.");
		System.out.println("공백없이");
		
		pcd.DeleteCompany(sc.nextLine());
		pcd.close();
	}

	public void cUpdate() throws ClassNotFoundException, SQLException {
		pcd = new PCompanyDao();
		c = new CompanyBean();
		int m = 0;
		String code;
		
		System.out.println("변경하고자 하는 업체코드를 입력하세요(하나씩만)");
		code = sc.nextLine();
		Search(code);
		
		System.out.println("수정하려는 항목에 대해 선택하세요");
		System.out.println("1)업체코드 2)업체명 3)업체주소 4)업체연락처 5)대표자명");
		m = Integer.parseInt(sc.nextLine());
		EditSelectCol(m);
		
		
		pcd.UpdateCompany(c, code);
		pcd.close();
	}
	
	public void cSearch() throws ClassNotFoundException, SQLException {
		pcd = new PCompanyDao();
		
		pcd.ViewCompany();
		System.out.println("조회할 업체코드를 입력하세요.");
		String n = sc.nextLine();
		Search(n);
		
		sc.close();
		pcd.close();
	}
	
	public void View() throws ClassNotFoundException, SQLException {
		pcd = new PCompanyDao();
		rs = pcd.ViewCompany();
		
		System.out.println("분류코드\t업체코드\t업체명\t업체주소\t업체번호\t\t대표자명");
		while (rs.next()) {
			CompanyBean c = new CompanyBean();
			c.setcNum(rs.getString("CNUM"));
			c.setcCode(rs.getInt("CCODE"));
			c.setcName(rs.getString("CNAME"));
			c.setcAddress(rs.getString("CADDRESS"));
			c.setcContact(rs.getString("CCONTACT"));
			c.setcBoss(rs.getString("CBOSS"));
			System.out.println(c.toString());
		}
		rs.close();
		pcd.close();
	}

	private void EditSelectCol(int n) {
		switch(n) {
		
		case 1:
			System.out.println("업체코드를 입력하세요."); //위에도 제품명입력해야하는데 제품명이 2번 들어갈때도 괜찮을까?
			c.setcCode(sc.nextInt());
			break;
		case 2:
			System.out.println("업체명을 입력하세요.");
			c.setcName(sc.nextLine());
			break;
		case 3:
			System.out.println("업체주소를 입력하세요.");
			c.setcAddress(sc.nextLine());
			break;
		case 4:
			System.out.println("업체연락처를 입력하세요.");
			c.setcContact(sc.nextLine());
			break;
		case 5:
			System.out.println("업체대표자명을 입력하세요.");
			c.setcBoss(sc.nextLine());
			break;
		}
	}
	
	private void Search(String n) throws ClassNotFoundException, SQLException {
		pcd = new PCompanyDao();
		c = new CompanyBean();
		
		rs = pcd.SelectCompany(n);
		try {
			while (rs.next()) {
				c.setcNum(rs.getString("CNUM"));
				c.setcCode(rs.getInt("CCODE"));
				c.setcName(rs.getString("CNAME"));
				c.setcAddress(rs.getString("CADDRESS"));
				c.setcContact(rs.getString("CCONTACT"));
				c.setcBoss(rs.getString("CBOSS"));
				System.out.println(c.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
}
