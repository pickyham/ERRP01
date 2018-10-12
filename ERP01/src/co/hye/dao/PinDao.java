package co.hye.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import co.hye.bean.PinBean;

public class PinDao {
	private Connection conn;
	private PreparedStatement psmt;
	private CallableStatement cstmt;
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
	
	public String InsertPin(PinBean p, int line) {
		sql = "insert into pin_t "
				+ "values(?, ?, ?, ?, ?, ?, sysdate, ?)";
		String pnum = null;
		try {
			cstmt = conn.prepareCall("call create_sales_no(?)");
			cstmt.registerOutParameter(1, Types.CHAR);
			cstmt.execute();
			pnum = (String)cstmt.getObject(1);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnum);
			psmt.setInt(2, line);
			psmt.setString(3, p.getPcode());
			psmt.setInt(4, p.getPea());
			psmt.setInt(5, p.getPprice());
			psmt.setInt(6, p.getPtotal());
			psmt.setString(7, Cname(p));
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("입고 내역 등록 실패");
			else System.out.println("입고 내역 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pnum;
	}
	public void InsertPin(PinBean p, int line, String pnum) {
		sql = "insert into pin_t "
				+ "values(?, ?, ?, ?, ?, ?, sysdate, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnum);
			psmt.setInt(2, line);
			psmt.setString(3, p.getPcode());
			psmt.setInt(4, p.getPea());
			psmt.setInt(5, p.getPprice());
			psmt.setInt(6, p.getPtotal());
			psmt.setString(7, Cname(p));
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("입고 내역 등록 실패");
			else System.out.println("입고 내역 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeletePin(String n, int line) {
		sql = "delete from pin_t where pnum = '" + n + "' and pline = " + line;
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

	public ResultSet SelectPin(String p, int line) {
		sql = "select p.pnum, p.pline, p.pcode, i.iname, p.pea, p.pprice, p.ptotal, p.pdate, p.cname "
			+ "from pin_t p join item_t i "
			+ "on p.pcode = i.icode "
			+ "where pnum = '" + p + "' and pline = " + line;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ViewPin() {
		sql = "select p.pnum, p.pline, p.pcode, i.iname, p.pea, p.pprice, p.ptotal, p.pdate, p.cname "
			+ "from pin_t p join item_t i "
			+ "on p.pcode = i.icode "
			+ "order by pnum, pline";
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
	public String Cname(PinBean p) {
		sql = "select distinct cname from item_t where icode = '" + p.getPcode() + "'";
		String cname = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				cname = rs.getString("CNAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cname;
	}
}
