package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.hye.bean.StorageBean;

public class StorageDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	public StorageDao() throws SQLException, ClassNotFoundException {
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
	
	public void InsertStorage(StorageBean sb) {
		String sql = "insert into storage_t values(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sb.gethCode());
			psmt.setString(2, sb.gethName());
			psmt.setString(3, sb.gethExplain());
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("창고 정보 등록 실패");
			else System.out.println("창고 정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteStorage(StorageBean sb) {
		String sql = "delete from storage_t where hcode = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sb.gethCode());
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("창고정보 삭제 실패");
			else System.out.println("창고정보 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateItem(StorageBean sb, String hcode) {
		String sql = "update storage_t "
					+ "set hcode = ?, hname = ?, hexplain = ? "
					+ "where hcode = '" + hcode + "'";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sb.gethCode());
			psmt.setString(2, sb.gethName());
			psmt.setString(3, sb.gethExplain());
			
			int n = psmt.executeUpdate();
			if (n ==0) System.out.println("창고정보 변경 실패");
			else System.out.println("창고정보 변경 성공");			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

	public ResultSet SelectStorage(String h) {
		sql = "select * from storage_t where hcode = '" + h + "' order by hcode";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ViewStorage() {
		sql = "select * from storage_t order by hcode";
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
