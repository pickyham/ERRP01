package co.hye.model;

import java.awt.event.ItemEvent;
import java.util.Scanner;

import co.hye.bean.ItemBean;

public class Item {
	private ItemBean insert() {
		ItemBean i = new ItemBean();
		Scanner sc = new Scanner(System.in);
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
		return i;
	}
}
