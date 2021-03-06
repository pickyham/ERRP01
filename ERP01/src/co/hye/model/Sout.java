package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.SoutBean;
import co.hye.dao.SoutDao;

public class Sout {
	SoutDao dao;
	SoutBean s;
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;

	public void soutCall() throws ClassNotFoundException, SQLException {
		View();
		System.out.println();
		System.out.println("1.출고내역 조회 2.출고내역 입력 3.출고내역 삭제 4.출고내역 수정");
		n = Integer.parseInt(sc.nextLine());

		switch(n) {
		case 1:
			ssearch();
			break;
		case 2:
			sinsert();
			break;
		case 3:
			sdelete();
			break;
		case 4:
			supdate();
			break;
		}
	}

	public void sinsert() throws ClassNotFoundException, SQLException {
		s = new SoutBean();
		dao = new SoutDao();
		int line = 1;
		String snum = null;

		System.out.println("상품코드를 입력하세요.");
		s.setScode(sc.nextLine());
		System.out.println("수량을 입력하세요.");
		s.setSea(Integer.parseInt(sc.nextLine()));
		System.out.println("단가를 입력하세요.");
		s.setSprice(Integer.parseInt(sc.nextLine()));
		s.setStotal(s.getSea(), s.getSprice());
		//snum = dao.InsertSout(s, line);

		while(true) {
			System.out.println("출고내역을 계속해서 입력하시겠습니까? (Y/N)");
			String input = sc.nextLine();
			if(input.equals("Y")||input.equals("y")) {
				line++;
				System.out.println("상품코드를 입력하세요.");
				s.setScode(sc.nextLine());
				System.out.println("수량을 입력하세요.");
				s.setSea(Integer.parseInt(sc.nextLine()));
				System.out.println("단가를 입력하세요.");
				s.setSprice(Integer.parseInt(sc.nextLine()));
				s.setStotal(s.getSea(), s.getSprice());

				dao.InsertSout(s, line, snum);
				//dao.InsertPin(s, line, snum);
			}
			else break;
		}
		dao.close();
	}

	public void sdelete() throws ClassNotFoundException, SQLException {
		dao = new SoutDao();

		System.out.println("삭제할 구매번호와 라인번호를 입력 하세요.");
		String n = sc.nextLine();
		int line = Integer.parseInt(sc.nextLine());

		dao.DeleteSout(n, line);
		dao.close();
	}
	public void ssearch() throws ClassNotFoundException, SQLException {
		dao = new SoutDao();

		dao.ViewSout();
		System.out.println("조회할 구매번호와 라인번호를 입력하세요.");
		String n = sc.nextLine();
		int line = Integer.parseInt(sc.nextLine());
		Search(n, line);

		dao.close();
	}
	public void supdate() throws ClassNotFoundException, SQLException {
		dao = new SoutDao();
		s = new SoutBean();
		int n = 0;
		
		dao.ViewSout();
			
		System.out.println("수정할 snum과 sline를 입력하시오");
		System.out.println("sum:");
		String sn = sc.nextLine();
		System.out.println("라인번호:");
		int sl = Integer.parseInt(sc.nextLine());
		Search(sn, sl);
		
		System.out.println("수정할 항목을 선택하시오");
		System.out.println("1)제품명 2)개수 3)출고업체명");
		n = Integer.parseInt(sc.nextLine());
		EditSelectCol(n);
	
		dao.UpdateSout(s, sn, sl);
		dao.close();

	}
	public void View() throws ClassNotFoundException, SQLException {
		dao = new SoutDao();
		rs = dao.ViewSout();

		System.out.println("구매번호\t\t라인번호\t품목코드\t품목명\t수량\t판매가\t금액\t입고일자\t\t\t업체명");
		while (rs.next()) {
			s = new SoutBean();
			s.setSnum(rs.getString("SNUM"));
			s.setSline(rs.getInt("SLINE"));
			s.setScode(rs.getString("SCODE"));
			s.setSname(rs.getString("INAME"));
			s.setSea(rs.getInt("SEA"));
			s.setSprice(rs.getInt("SPRICE"));
			s.setStotal(rs.getInt("SEA"),rs.getInt("SPRICE"));
			s.setSdate(rs.getString("SDATE"));
			s.setcName(rs.getString("CNAME"));
			System.out.println(s.toString());
		}
		rs.close();
	}



	private void Search(String n, int line) throws ClassNotFoundException, SQLException {
		dao = new SoutDao();
		s = new SoutBean();

		rs = dao.SelectSout(n, line);
		try {
			while (rs.next()) {

				s.setSnum(rs.getString("SNUM"));
				s.setSline(rs.getInt("SLINE"));
				s.setScode(rs.getString("SCODE"));
				s.setSea(rs.getInt("SEA"));
				s.setSprice(rs.getInt("SPRICE"));
				s.setStotal(rs.getInt("SEA"),rs.getInt("SPRICE"));
				s.setSdate(rs.getString("SDATE"));
				s.setcName(rs.getString("CNAME"));				
				System.out.println(s.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
	private void EditSelectCol(int n) {
		switch(n) {
//		case 1:
//			System.out.println("snum을 입력하세요.");
//			s.setSnum(sc.nextLine());
//			break;
//		case 2:
//			System.out.println("라인번호를 입력하세요."); 
//			s.setSline(sc.nextInt());
//			break;
		case 1:
			System.out.println("제품코드을 입력하세요.");
			s.setScode(sc.nextLine());
			break;
		case 2:
			System.out.println("개수을 입력하세요.");
			s.setSea(sc.nextInt());
			break;
//		case 4:
//			System.out.println("가격을 입력하세요.");
//			s.setSprice(sc.nextInt());
//			break;
		case 3:
			System.out.println("업체명을 입력하세요.");
			s.setcName(sc.nextLine());
			break;
		}
	}
}
