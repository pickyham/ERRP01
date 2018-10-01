package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.ItemBean;

public class ItemDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	public ItemDao() throws ClassNotFoundException {
		try {
			String user = "ham";
			String pw = "ham";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void InsertItem(ItemBean i) {
		String sql = "insert into item_t (iclass, icode, iname, istandard, iunit, cname)"
				+ "values(?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i.getiClass());
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("품목 정보 등록 실패");
			else System.out.println("품목 정보가 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteItem(ItemBean i) {
		String sql = "delete from item_t where icode = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 코드를 입력 하세요.");
		System.out.println("A-필기구/B-용지/C-");
		String n = sc.nextLine();
		sc.close();
		
		try {			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, n);
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("삭제 실패");
			else System.out.println("삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
