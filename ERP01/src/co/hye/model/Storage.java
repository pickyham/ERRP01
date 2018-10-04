package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.ItemBean;
import co.hye.bean.StorageBean;
import co.hye.dao.ItemDao;
import co.hye.dao.StorageDao;

public class Storage {
	StorageBean s;
	StorageDao sd;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	int n = 0;

	public void itemCall() throws ClassNotFoundException, SQLException{
		View();
		System.out.println("1.제품조회 2.제품입력 3.제품삭제 4.제품수정");
		n = Integer.parseInt(sc.nextLine());
		
		switch(n) {
		case 1:
			sbSearch();
			break;
		case 2:
			sbInsert();
			break;
		case 3:
			sbDelete();
			break;
		case 4:
			sbUpdate();
			break;			
		}			
	}

	public void sbDelete() throws ClassNotFoundException, SQLException {
		s = new StorageBean();
		sd = new StorageDao();
		
		System.out.println("삭제할 제품코드를 입력 하세요.");
		System.out.println("A-필기구 /B-용지 /C- 중 하나 입력, 공백없이 상품번호를 입력하세요");
			s.sethCode(sc.nextInt());
		sc.close();
		
		sd.DeleteStorage(s);
		sd.close();
		
	}

	public void sbInsert() throws ClassNotFoundException, SQLException {
		s = new StorageBean();
		sd = new StorageDao();

		System.out.println("창고코드를 입력하세요.");
		s.sethCode(sc.nextInt());
		System.out.println("창고이름을 입력하세요.");
		s.sethName(sc.nextLine());
		System.out.println("창고설명을 입력하세요.");
		s.sethExplain(sc.nextLine());
		
		sc.close();

		sd.InsertStorage(s);
		sd.close();
	}

	public void sbUpdate() throws ClassNotFoundException, SQLException {
		s = new StorageBean();
		sd = new StorageDao();
		int c = 0;
		String code;
		
		System.out.println("변경하고자 하는 창고코드를 입력하세요(하나씩만)");
		code = sc.nextLine();
		Search(code);
		
		System.out.println("수정하려는 항목에 대해 선택하세요");
		System.out.println("1)분류코드 2)상품코드 3)상품명 4)규격 5)단위 6)업체명");
		c = Integer.parseInt(sc.nextLine());
		EditSelectCol(c);
		
		//sc.close();
		sd.UpdateItem(s, code);
		sd.close();
	}
	
	public void sbSearch() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		
		sd.ViewStorage();
		System.out.println("조회할 상품코드를 입력하세요.");
		String n = sc.nextLine();
		Search(n);
		
		sc.close();
		sd.close();
	}
	public void View() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		rs = sd.ViewStorage();
		
		System.out.println("분류코드\t상품코드\t상품명\t규격\t단위\t업체명");
		while (rs.next()) {
			StorageBean s = new StorageBean();
			s.sethCode(rs.getInt("HCODE"));
			s.sethName(rs.getString("HNAME"));
			s.sethExplain(rs.getString("HEXPLAIN"));
			
			System.out.println(s.toString());
		}
		rs.close();
		sd.close();
	}

	private void EditSelectCol(int n) {
		switch(n) {
		case 1:
			System.out.println("창고코드를 입력하세요.");
			s.sethCode(sc.nextInt());
			break;
		case 2:
			System.out.println("창고이름을 입력하세요."); //위에도 제품명입력해야하는데 제품명이 2번 들어갈때도 괜찮을까?
			s.sethName(sc.nextLine());
			break;
		case 3:
			System.out.println("창고설명을 입력하세요.");
			s.sethExplain(sc.nextLine());
			break;
		
		}
	}
	private void Search(String n) throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		rs = sd.SelectStorage(n);
		try {
			while (rs.next()) {
				s.sethCode(rs.getInt("HCODE"));
				s.sethName(rs.getString("HNAME"));
				s.sethExplain(rs.getString("HEXPLAIN"));
				
				System.out.println(sd.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
}
