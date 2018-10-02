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
		sc.close();
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
		i.setiClass(sc.nextLine());
		System.out.println("제품코드를 입력하세요.");
		i.setiCode(sc.nextLine());
		System.out.println("제품명을 입력하세요.");
		i.setcName(sc.nextLine());
		System.out.println("규격을 입력하세요.");
		i.setiStandard(sc.nextLine());
		System.out.println("단위를 입력하세요.");
		i.setiUnit(sc.nextLine());
		System.out.println("업체명을 입력하세요.");
		i.setcName(sc.nextLine());

		id.InsertItem(i);		
	}
}
