package co.hye.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.hye.bean.CompanyBean;
//
public class PCompanyDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	public PCompanyDao() throws SQLException, ClassNotFoundException {
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
	
	//등록
	public void InsertCompany(CompanyBean c) {
		String sql = "insert into company_t"
				+ "values('P', ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			//psmt.setString(1, c.getcNum());
			psmt.setInt(1, c.getcCode());
			psmt.setString(2, c.getcName()); 
			psmt.setString(3, c.getcAddress()); 
			psmt.setString(4, c.getcContact()); 
			psmt.setString(5, c.getcBoss());
			int n = psmt.executeUpdate();

			if (n == 0) System.out.println("업체 정보 등록 실패");
			else System.out.println("업체 정보 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//삭제
	public void DeleteCompany(String code) {
		String sql = "delete from company_t where cnum = 'P' and ccode = '" + code + "'";
		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			
			if (r == 0) System.out.println("업체 정보 삭제 실패");
			else System.out.println("업체 정보 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//수정
	public void UpdateCompany(CompanyBean c, String code) {
		String sql = "update company_t "
					+ "set ccode = ?, cname = ?, caddress = ?, ccontact = ?, cboss = ? "
					+ "where cnum = 'P'and ccode = '" + code + "'";		
		try {
			psmt = conn.prepareStatement(sql);
			//psmt.setString(1, c.getcNum());
			psmt.setInt(1, c.getcCode());
			psmt.setString(2, c.getcName()); 
			psmt.setString(3, c.getcAddress()); 
			psmt.setString(4, c.getcContact()); 
			psmt.setString(5, c.getcBoss());
			
			int n = psmt.executeUpdate();
			if (n ==0) System.out.println("변경 실패");
			else System.out.println("변경 성공");			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

	//하나조회
	public ResultSet SelectCompany(String i) {
		sql = "select * from company_t where cnum = 'P' and ccode = '" + i + "'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//전체조회
	public ResultSet ViewCompany() {
		sql = "select * from company_t where cnum= 'P' order by ccode";
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
