package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.StorageBean;
import co.hye.dao.StorageDao;

public class Storage {
	StorageBean s;
	StorageDao sd;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	int n = 0;

	public void storageCall() throws ClassNotFoundException, SQLException{
		View();
		System.out.println("1.창고조회 2.창고입력 3.창고삭제 4.창고수정");
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
		s = new StorageBean();
		sd = new StorageDao();

		System.out.println("창고코드를 입력하세요.");
		s.sethCode(Integer.parseInt(sc.nextLine()));
		System.out.println("창고명을 입력하세요.");
		s.sethName(sc.nextLine());
		System.out.println("창고정보를 입력하세요.");
		s.sethExplain(sc.nextLine());
		sc.close();

		sd.InsertStorage(s);
		sd.close();
	}
	
	public void sdelete() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		
		System.out.println("삭제할 창고코드를 입력 하세요.");
		
		sd.DeleteStorage(Integer.parseInt(sc.nextLine()));
		sd.close();
	}

	public void supdate() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		s = new StorageBean();
		int c = 0;
		int code;
		
		System.out.println("변경하고자 하는 창고코드를 입력하세요.");
		code = Integer.parseInt(sc.nextLine());
		Search(code);
		
		System.out.println("수정하려는 항목에 대해 선택하세요");
		System.out.println("1)창고코드 2)창고명 3)창고정보");
		c = Integer.parseInt(sc.nextLine());
		EditSelectCol(c);
		
		//sc.close();
		sd.UpdateStorage(s, code);
		sd.close();
	}
	
	public void ssearch() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		
		sd.ViewStorage();
		System.out.println("조회할 창고코드를 입력하세요.");
		int n = Integer.parseInt(sc.nextLine());
		Search(n);
		
		sc.close();
		sd.close();
	}
	public void View() throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		rs = sd.ViewStorage();
		
		System.out.println("창고코드\t창고명\t창고정보");
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
			s.sethCode(Integer.parseInt(sc.nextLine()));
			break;
		case 2:
			System.out.println("창고명을 입력하세요.");
			s.sethName(sc.nextLine());
			break;
		case 3:
			System.out.println("창고정보를 입력하세요.");
			s.sethExplain(sc.nextLine());
			break;
		}
	}
	private void Search(int n) throws ClassNotFoundException, SQLException {
		sd = new StorageDao();
		s = new StorageBean();
		
		rs = sd.SelectStorage(n);
		try {
			while (rs.next()) {
				s.sethCode(rs.getInt("HCODE"));
				s.sethName(rs.getString("HNAME"));
				s.sethExplain(rs.getString("HEXPLAIN"));
				System.out.println(s.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
}