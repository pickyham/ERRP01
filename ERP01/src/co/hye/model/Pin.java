package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.PinBean;
import co.hye.dao.PinDao;
import co.hye.dao.StockDao;

public class Pin {
	PinDao dao;
	PinBean p;
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;

	public void pinCall() throws ClassNotFoundException, SQLException {
		View();
		System.out.println();
		System.out.println("1.입고내역 조회 2.입고내역 입력 3.입고내역 삭제 4.입고내역 수정");
		n = Integer.parseInt(sc.nextLine());
		
		switch(n) {
		case 1:
			psearch();
			break;
		case 2:
			pinsert();
			break;
		case 3:
			pdelete();
			break;
		case 4:
			//pupdate();
			break;
		}
	}

	public void pinsert() throws ClassNotFoundException, SQLException {
		p = new PinBean();
		dao = new PinDao();
		int line = 1;
		String pnum = null;
		
		System.out.println("상품코드를 입력하세요.");
		p.setPcode(sc.nextLine());
		System.out.println("수량을 입력하세요.");
		p.setPea(Integer.parseInt(sc.nextLine()));
		System.out.println("단가를 입력하세요.");
		p.setPprice(Integer.parseInt(sc.nextLine()));
		p.setPtotal(p.getPea(), p.getPprice());
		
		pnum = dao.InsertPin(p, line);

		while(true) {
			System.out.println("입고내역을 계속해서 입력하시겠습니까? (Y/N)");
			String input = sc.nextLine();
			if(input.equals("Y")||input.equals("y")) {
				line++;
				System.out.println("상품코드를 입력하세요.");
				p.setPcode(sc.nextLine());
				System.out.println("수량을 입력하세요.");
				p.setPea(Integer.parseInt(sc.nextLine()));
				System.out.println("단가를 입력하세요.");
				p.setPprice(Integer.parseInt(sc.nextLine()));
				p.setPtotal(p.getPea(), p.getPprice());
				
				dao.InsertPin(p, line, pnum);
			}
			else break;
		}
		dao.close();
	}

	public void pdelete() throws ClassNotFoundException, SQLException {
		dao = new PinDao();
		
		System.out.println("삭제할 구매번호와 라인번호를 입력 하세요.");
		String n = sc.nextLine();
		int line = Integer.parseInt(sc.nextLine());
		
		dao.DeletePin(n, line);
		dao.close();
	}
	public void psearch() throws ClassNotFoundException, SQLException {
		dao = new PinDao();
		
		dao.ViewPin();
		System.out.println("조회할 구매번호와 라인번호를 입력하세요.");
		String n = sc.nextLine();
		int line = Integer.parseInt(sc.nextLine());
		Search(n, line);
		
		dao.close();
	}
	public void View() throws ClassNotFoundException, SQLException {
		dao = new PinDao();
		rs = dao.ViewPin();

		System.out.println("구매번호\t\t라인번호\t품목코드\t품목명\t수량\t판매가\t금액\t입고일자\t\t\t업체명");
		while (rs.next()) {
			p = new PinBean();
			p.setPnum(rs.getString("PNUM"));
			p.setPline(rs.getInt("PLINE"));
			p.setPcode(rs.getString("PCODE"));
			p.setPname(rs.getString("INAME"));
			p.setPea(rs.getInt("PEA"));
			p.setPprice(rs.getInt("PPRICE"));
			p.setPtotal(rs.getInt("PEA"),rs.getInt("PPRICE"));
			p.setPdate(rs.getString("PDATE"));
			p.setcName(rs.getString("CNAME"));
			System.out.println(p.toString());
		}
		rs.close();
	}
	
	private void Search(String n, int line) throws ClassNotFoundException, SQLException {
		dao = new PinDao();
		p = new PinBean();
		
		rs = dao.SelectPin(n, line);
		try {
			while (rs.next()) {
				p.setPnum(rs.getString("PNUM"));
				p.setPline(rs.getInt("PLINE"));
				p.setPcode(rs.getString("PCODE"));
				p.setPname(rs.getString("INAME"));
				p.setPea(rs.getInt("PEA"));
				p.setPprice(rs.getInt("PPRICE"));
				p.setPtotal(rs.getInt("PEA"),rs.getInt("PPRICE"));
				p.setPdate(rs.getString("PDATE"));
				p.setcName(rs.getString("CNAME"));
				System.out.println(p.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
}
