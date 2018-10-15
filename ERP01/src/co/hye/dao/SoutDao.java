package co.hye.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import co.hye.bean.PinBean;
import co.hye.bean.SoutBean;

public class SoutDao {
	private Connection conn;
	private PreparedStatement psmt;
	private CallableStatement cstmt;
	private ResultSet rs;
	private String sql;

	public SoutDao() throws ClassNotFoundException {
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
	
	public String InsertSout(SoutBean s, int line) {
		sql = "insert into sout_t "
				+ "values(?, ?, ?, ?, ?, ?, sysdate, ?)";
		String snum = null;
		try {
			cstmt = conn.prepareCall("call create_sell_no(?)");
			cstmt.registerOutParameter(1, Types.CHAR);
			cstmt.execute();
			snum = (String)cstmt.getObject(1);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, snum);
			psmt.setInt(2, line);
			psmt.setString(3, s.getScode());
			psmt.setInt(4, s.getSea());
			psmt.setInt(5, s.getSprice());
			psmt.setInt(6, s.getStotal());
			psmt.setString(7, getItem(s).getcName());
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("입고 내역 등록 실패");
			else System.out.println("입고 내역 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return snum;
	}
	public void InsertSout(SoutBean s, int line, String snum) {
		int k = 1;
		sql = "insert into sout_t "//표 확인 
				+ "values(?, ?, ?, ?, ?, ?, sysdate, ?)";
	
		try {		
			psmt = conn.prepareStatement(sql);
			psmt.setString(k++, snum);
			psmt.setInt(k++, line);
			psmt.setString(k++, s.getScode());
			psmt.setInt(k++, s.getSea());
			psmt.setInt(k++, getItem(s).getSprice());
			s.setStotal(s.getSea(), s.getSprice());
			psmt.setInt(k++, s.getStotal());
			psmt.setString(k++, getItem(s).getcName());//밑에 cname없애도 될듯
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("입고 내역 등록 실패");
			else System.out.println("입고 내역 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteSout(String snum, int line) {
		sql = "delete from sout_t where snum = '" + snum + "' and sline = " + line;
		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("삭제 실패");
			else {
				System.out.println("삭제 성공");
				cstmt = conn.prepareCall("call create_receipt_onhand(?)");
	            cstmt.setString(1, Scode(snum, line));
	            cstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateSout(SoutBean s, String sn, int sl) {
		int t = 1;
		sql = "update sout_t set snum=nvl(?,snum),sline=nvl(?,sline),scode=nvl(?,scode),"
				+ "sea=nvl(?,sea),sprice=nvl(?,sprice), cname=nvl(?,cname)"
				+ "where snum='" + sn + "'" + "and sline= '" + sl + "'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(t++, s.getSnum());
			psmt.setInt(t++, s.getSline());
			psmt.setString(t++, s.getScode());
			psmt.setInt(t++, s.getSea());
			psmt.setInt(t++, s.getSprice());
			//psmt.setInt(t++, s.getStotal());
			psmt.setString(t++, s.getcName());
			int n = psmt.executeUpdate();
			
			if (n == 0) System.out.println("출고 내역 수정 실패");
			else {
				System.out.println("출고 내역 수정 성공");
				cstmt = conn.prepareCall("call create_receipt_onhand(?)");
	            cstmt.setString(1, s.getScode());
	            cstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ResultSet SelectSout(String snum, int line) {
		sql = "select s.snum, s.sline, s.scode, i.iname, s.sea, s.sprice, s.stotal, s.sdate, s.cname"  
				 + "from sout_t s join item_t i " 
				 + "on s.scode = i.icode "  
				 + "where snum = '" + snum + "' and sline = " + line;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ViewSout() {
		sql = "select s.snum, s.sline, s.scode, i.iname, s.sea, s.sprice, s.stotal, s.sdate, s.cname "
			+ "from sout_t s join item_t i "
			+ "on s.scode = i.icode "
			+ "order by snum, sline";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public String Scode(String snum, int line) {
	      sql = "select distinct scode from sout_t where snum = '" + snum + "' and sline = " + line;
	      String scode = null;
	      try {
	         PreparedStatement ps = conn.prepareStatement(sql);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            scode = rs.getString("SCODE");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return scode;
	   }
	
	public SoutBean getItem(SoutBean s) {
	      sql = "select distinct iprice, cname from item_t where icode = '" + s.getScode() + "'";
	      try {
	         PreparedStatement ps = conn.prepareStatement(sql);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            s.setcName(rs.getString("CNAME"));
	            s.setSprice(rs.getInt("IPRICE"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return s;
	   }
	
	public void close() throws SQLException {
		psmt.close();
		conn.close();
	}
}
