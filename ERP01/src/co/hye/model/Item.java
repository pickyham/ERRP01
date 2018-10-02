package co.hye.model;

import java.awt.event.ItemEvent;
import java.util.Scanner;

import co.hye.bean.ItemBean;
import co.hye.dao.ItemDao;

public class Item {
	Scanner sc = new Scanner(System.in);
	int n = 0;
	public void itemCall() throws ClassNotFoundException {
		System.out.println("1.제품조회 2.제품입력 3.제품삭제 4.제품수정");
		n = sc.nextInt();
		switch(n) {
		case 1:
			insert();
			break;
		case 2:
			//
			
			break;
		case 3:
			//
			
			break;
		case 4:
			//
			
			break;			
		}			
	} 
	
	 public void insert() throws ClassNotFoundException {
		ItemBean i = new ItemBean();
		ItemDao id = new ItemDao();
		
		System.out.println("분류코드를 입력하세요.");
		i.setiClass(sc.next());
		System.out.println("제품코드를 입력하세요.");
		i.setiCode(sc.next());
		System.out.println("제품명을 입력하세요.");
		i.setcName(sc.next());
		System.out.println("규격을 입력하세요.");
		i.setiStandard(sc.next());
		System.out.println("단위를 입력하세요.");
		i.setiUnit(sc.next());
		System.out.println("업체명을 입력하세요.");
		i.setcName(sc.next());

		id.InsertItem(i);		
	}
}
