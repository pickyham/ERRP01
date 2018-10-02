package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.hye.bean.PinBean;

public class PinDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	public PinDao() throws ClassNotFoundException {
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
	
	public void InsertPin(PinBean p) {
		sql = "insert into pin_t "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getPnum());
			psmt.setInt(2, p.getPline());
			psmt.setString(3, p.getPcode());
			psmt.setInt(4, p.getPea());
			psmt.setInt(5, p.getPprice());
			psmt.setInt(6, p.getPtotal());
			psmt.setString(7, p.getPdate());
			psmt.setString(8, p.getcName());
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("품목 정보 등록 실패");
			else System.out.println("품목 정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeletePin(int id) {
		sql = "delete from pint_t where pnum = " + id;
		try {			
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("삭제 실패");
			else System.out.println("삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdatePin() {
		sql = "";
	}
	
	public ResultSet SelectPin() {
		sql = "select p.pnum, p.pline, p.pcode, i.iname, p.pea, p.pprice, p.ptotal, p.pdate, p.cname "
			+ "from pin_t p join item_t i "
			+ "on p.pcode = i.icode "
			+ "order by pnum";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
