package co.hye.model;

import java.sql.SQLException;
import java.util.Scanner;

public class Start {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int sel;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 기초정보 관리 2. 입출고 정보 3. 재고 정보");
		sel = Integer.parseInt(sc.nextLine());
		
		if(sel==1) {
			System.out.println("=============== 기초정보 관리 화면 ===============");
			System.out.println("1) 품목 정보  2) 창고 정보  3) 구매업체 관리  4) 판매업체 관리");
			n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1:
				System.out.println("< 품목 정보 >");
				Item i = new Item();
				i.itemCall();
				break;
			case 2:
				System.out.println("< 창고 정보 >");
				break;
			case 3:
				System.out.println("< 구매 업체 >");
				break;
			case 4:
				System.out.println("< 판매 업체 >");
				break;
			}
		}
		else if(sel==2) {
			System.out.println("============ 입출고정보 관리 화면 ============");
			System.out.println("1)입고 정보  2) 출고 정보");
			n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1:
				System.out.println("< 입고 정보 >");
				break;
			case 2:
				System.out.println("< 출고 정보 >");
				break;
			}
		}
		else if(sel==3) {
			System.out.println("============ 재고정보 관리 화면 ============");
			System.out.println("< 현재고 >");
		}
		else System.out.println("재고관리 프로그램을 종료합니다.");
	}
}
