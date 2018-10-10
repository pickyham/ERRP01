package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.ItemBean;
import co.hye.dao.ItemDao;

public class Item {
	ItemBean i;
	ItemDao id;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	int n = 0;

	public void itemCall() throws ClassNotFoundException, SQLException{
		View();
		System.out.println();
		System.out.println("1.제품조회 2.제품입력 3.제품삭제 4.제품수정");
		n = Integer.parseInt(sc.nextLine());
		
		switch(n) {
		case 1:
			isearch();
			break;
		case 2:
			insert();
			break;
		case 3:
			idelete();
			break;
		case 4:
			iupdate();
			break;			
		}			
	}

	public void insert() throws ClassNotFoundException, SQLException {
		i = new ItemBean();
		id = new ItemDao();

		System.out.println("분류코드를 입력하세요.");
		i.setiClass(sc.nextLine());
		System.out.println("제품코드를 입력하세요.");
		i.setiCode(sc.nextLine());
		System.out.println("제품명을 입력하세요.");
		i.setiName(sc.nextLine());
		System.out.println("규격을 입력하세요.");
		i.setiStandard(sc.nextLine());
		System.out.println("단위를 입력하세요.");
		i.setiUnit(sc.nextLine());
		System.out.println("업체명을 입력하세요.");
		i.setcName(sc.nextLine());
		System.out.println("창고명을 입력하세요.");
		i.setHname(sc.nextLine());
		sc.close();

		id.InsertItem(i);
		id.close();
	}
	
	public void idelete() throws ClassNotFoundException, SQLException {
		id = new ItemDao();
		
		System.out.println("삭제할 제품코드를 입력 하세요.");
		System.out.println("A-필기구 /B-용지 /C- 중 하나 입력, 공백없이 상품번호를 입력하세요.");
		
		id.DeleteItem(sc.nextLine());
		id.close();
	}

	public void iupdate() throws ClassNotFoundException, SQLException {
		id = new ItemDao();
		i = new ItemBean();
		int c = 0;
		String code;
		
		System.out.println("변경하고자 하는 상품코드를 입력하세요(하나씩만)");
		code = sc.nextLine();
		Search(code);
		
		System.out.println("수정하려는 항목에 대해 선택하세요");
		System.out.println("1)분류코드 2)상품코드 3)상품명 4)규격 5)단위 6)업체명 7)창고명");
		c = Integer.parseInt(sc.nextLine());
		EditSelectCol(c);
		
		id.UpdateItem(i, code);
		id.close();
	}
	
	public void isearch() throws ClassNotFoundException, SQLException {
		id = new ItemDao();
		
		id.ViewItem();
		System.out.println("조회할 상품코드를 입력하세요.");
		String n = sc.nextLine();
		Search(n);
		
		id.close();
	}
	public void View() throws ClassNotFoundException, SQLException {
		id = new ItemDao();
		rs = id.ViewItem();
		
		System.out.println("분류코드\t상품코드\t상품명\t규격\t단위\t업체명\t창고명");
		while (rs.next()) {
			ItemBean i = new ItemBean();
			i.setiClass(rs.getString("ICLASS"));
			i.setiCode(rs.getString("ICODE"));
			i.setiName(rs.getString("INAME"));
			i.setiStandard(rs.getString("ISTANDARD"));
			i.setiUnit(rs.getString("IUNIT"));
			i.setcName(rs.getString("CNAME"));
			i.setHname(rs.getString("HNAME"));
			System.out.println(i.toString());
		}
		rs.close();
		id.close();
	}

	private void EditSelectCol(int n) {
		switch(n) {
		case 1:
			System.out.println("분류코드를 입력하세요.");
			i.setiClass(sc.nextLine());
			break;
		case 2:
			System.out.println("상품코드를 입력하세요."); //위에도 제품명입력해야하는데 제품명이 2번 들어갈때도 괜찮을까?
			i.setiCode(sc.nextLine());
			break;
		case 3:
			System.out.println("제품명을 입력하세요.");
			i.setiName(sc.nextLine());
			break;
		case 4:
			System.out.println("규격을 입력하세요.");
			i.setiStandard(sc.nextLine());
			break;
		case 5:
			System.out.println("단위를 입력하세요.");
			i.setiUnit(sc.nextLine());
			break;
		case 6:
			System.out.println("업체명을 입력하세요.");
			i.setcName(sc.nextLine());
			break;
		case 7:
			System.out.println("창고명을 입력하세요");
			i.setHname(sc.nextLine());
		}
	}
	private void Search(String n) throws ClassNotFoundException, SQLException {
		id = new ItemDao();
		i = new ItemBean();
		
		rs = id.SelectItem(n);
		try {
			while (rs.next()) {
				i.setiClass(rs.getString("ICLASS"));
				i.setiCode(rs.getString("ICODE"));
				i.setiName(rs.getString("INAME"));
				i.setiStandard(rs.getString("ISTANDARD"));
				i.setiUnit(rs.getString("IUNIT"));
				i.setcName(rs.getString("CNAME"));
				i.setHname(rs.getString("HNAME"));
				System.out.println(i.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs.close();
	}
}