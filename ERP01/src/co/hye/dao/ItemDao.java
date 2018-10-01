package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void InsertItem() {
		String sql = "insert into item_t (iclass, icode, iname, istandard, iunit, cname)"
				+ "values(?, ?, ?, ?, ?)";
	}
}
