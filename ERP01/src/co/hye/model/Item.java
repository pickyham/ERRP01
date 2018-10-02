package co.hye.model;

import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.ItemBean;
import co.hye.dao.ItemDao;

public class Item {
	Scanner sc = new Scanner(System.in);
	int n = 0;

	public void itemCall() throws ClassNotFoundException, SQLException{
		System.out.println("1.제품조회 2.제품입력 3.제품삭제 4.제품수정");
		n = sc.nextInt();
		sc.nextLine();
		ItemDao id = new ItemDao();
		switch(n) {
		case 1:

			break;
		case 2:
			//
			insert();
			break;
		case 3:
			//

			break;
		case 4:
			//
			iupdate();			
			break;			
		}			
	} 

	public void insert() throws ClassNotFoundException, SQLException {
		ItemBean i = new ItemBean();
		ItemDao id = new ItemDao();

		System.out.println("분류코드를 입력하세요.");
		i.setiClass(sc.next());
		System.out.println("제품코드를 입력하세요.");
		i.setiCode(sc.next());
		System.out.println("제품명을 입력하세요.");
		i.setiName(sc.next());
		System.out.println("규격을 입력하세요.");
		i.setiStandard(sc.next());
		System.out.println("단위를 입력하세요.");
		i.setiUnit(sc.next());
		System.out.println("업체명을 입력하세요.");
		i.setcName(sc.next());
		sc.close();

		id.InsertItem(i);
		id.close();
	}

	public void iupdate() throws ClassNotFoundException, SQLException {
		ItemBean i = new ItemBean();
		ItemDao id = new ItemDao();
		int c = 0;
		
		System.out.println("변경하고자 하는 상품코드를 입력하세요(하나씩만)");
		i.setiName(sc.nextLine());		
		System.out.println("수정하려는 항목에 대해 선택하세요");
		System.out.println("1)분류코드 2)상품코드 3)상품명 4)규격 5)단위 6)업체명");
		c = sc.nextInt();
		switch(c) {
		case 1:
			System.out.println("분류코드를 입력하세요.");
			i.setiClass(sc.next());			
			break;
		case 2:
			System.out.println("제품명을 입력하세요."); //위에도 제품명입력해야하는데 제품명이 2번 들어갈때도 괜찮을까?
			i.setiName(sc.next());
			break;			
		case 3:
			System.out.println("제품명을 입력하세요.");
			i.setiName(sc.next());
			break;			
		case 4:
			System.out.println("규격을 입력하세요.");
			i.setiStandard(sc.next());
			break;
		case 5:
			System.out.println("단위를 입력하세요.");
			i.setiUnit(sc.next());
			break;
		case 6:
			System.out.println("업체명을 입력하세요.");
			i.setcName(sc.next());
			break;						
		}
		sc.close();
	    
		id.UpdateItem(c, i);
		id.close();	
	}
}