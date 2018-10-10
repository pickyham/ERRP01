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

	public ItemDao() throws SQLException, ClassNotFoundException {
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
	
	public void InsertItem(ItemBean i) {
		String sql = "insert into item_t (iclass, icode, iname, istandard, iunit, cname, hname)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i.getiClass());//
			psmt.setString(2, i.getiCode());//
			psmt.setString(3, i.getiName()); //
			psmt.setString(4, i.getiStandard()); //
			psmt.setString(5, i.getiUnit()); //
			psmt.setString(6, i.getcName());
			psmt.setString(7, i.getHname());//
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("품목 정보 등록 실패");
			else System.out.println("품목 정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteItem(String code) {
		String sql = "delete from item_t where icode = '" + code + "'";
		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("삭제 실패");
			else System.out.println("삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateItem(ItemBean i, String code) {
		String sql = "update item_t "
					+ "set iclass = ?, icode = ?, iname = ?, istandard = ?, iunit = ?, cname = ? "
					+ "where icode = '" + code + "'";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i.getiClass());
			psmt.setString(2, i.getiCode());
			psmt.setString(3, i.getiName());
			psmt.setString(4, i.getiStandard());
			psmt.setString(5, i.getiUnit());
			psmt.setString(6, i.getcName());
			psmt.setString(7, i.getHname());
			
			int n = psmt.executeUpdate();
			if (n ==0) System.out.println("변경 실패");
			else System.out.println("변경 성공");			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

	public ResultSet SelectItem(String i) {
		sql = "select * from item_t where icode = '" + i + "'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ViewItem() {
		sql = "select * from item_t order by icode";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void close() throws SQLException {
		psmt.close();
		conn.close();
	}
}
