package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.ItemBean;
import co.hye.model.Item;

public class ItemDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	public ItemDao() throws ClassNotFoundException {
		try {
			String user = "ham";
			String pw = "ham";
			String url = "jdbc:oracle:thin:@192.168.0.95:1521:xe";
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ItemBean i
	public void InsertItem(ItemBean i) {
		String sql = "insert into item_t (iclass, icode, iname, istandard, iunit, cname)"
				+ "values(?, ?, ?, ?, ?, ?)";
		Item j = new Item();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i.getiClass());//
			psmt.setString(2, i.getiCode());//
			psmt.setString(3, i.getiName()); //
			psmt.setString(4, i.getiStandard()); //
			psmt.setString(5, i.getiUnit()); //
			psmt.setString(6, i.getcName()); //
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("품목 정보 등록 실패");
			else System.out.println("품목 정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//작업필요
	//파라메터 : ItemBean i
	public void DeleteItem(ItemBean i) {
		String sql = "delete from item_t where icode = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 제품코드를 입력 하세요.");
		System.out.println("A-필기구 /B-용지 /C- 중 하나 입력, 공백없이 상품번호를 입력하세요");
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
	
	public void UpdateItem(int c, ItemBean i) throws SQLException, ClassNotFoundException {
		String qeury;			
		//m = Item.iupdate(null);
		
		String sql = "update item_t set $col = ? where icode=?";		
		try {
			psmt.setString(2, i.getiName());
			switch(c) {
			case 1:
				qeury = sql.replace("$col", "iclass");
				psmt.setString(1, i.getiClass());
				psmt = conn.prepareStatement(qeury);
				break;	
			case 2:
				qeury = sql.replace("$col", "icode");
				psmt.setString(1, i.getiCode());
				psmt = conn.prepareStatement(qeury);
				break;	
			case 3:
				qeury = sql.replace("$col", "iname");
				psmt.setString(1, i.getiName());
				psmt = conn.prepareStatement(qeury);
				break;	
			case 4:
				qeury = sql.replace("$col", "istandard");
				psmt.setString(1, i.getiStandard());
				psmt = conn.prepareStatement(qeury);
				break;	
			case 5:
				qeury = sql.replace("$col", "iunit");
				psmt.setString(1, i.getiUnit());
				psmt = conn.prepareStatement(qeury);
				break;	
			case 6:
				qeury = sql.replace("$col", "cname");
				psmt.setString(1, i.getcName());
				psmt = conn.prepareStatement(qeury);
				break;
			}
			psmt = conn.prepareStatement(sql);
			int n = psmt.executeUpdate();
			if (n ==0) System.out.println("변경 실패");
			else System.out.println("변경 성공");			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public void SelectItem() {
		String sql = "";

	}
	public void close() throws SQLException {
		psmt.close();
		conn.close();
	}
	
	
}
