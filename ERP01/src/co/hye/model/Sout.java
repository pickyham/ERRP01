package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.SoutBean;
import co.hye.dao.SoutDao;


public class Sout {
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;
	public void soutCall() throws ClassNotFoundException, SQLException {
		SoutDao dao = new SoutDao();
		SoutBean s;
		rs = dao.SelectSout();
		
		System.out.println("구매번호\t\t라인번호\t품목코드\t품목명\t수량\t판매가\t금액\t입고일자\t\t\t업체명");
		while (rs.next()) {
			s = new SoutBean();
			s.setSnum(rs.getString("SNUM"));
			s.setSline(rs.getInt("SLINE"));
			s.setScode(rs.getString("SCODE"));
			s.setSname(rs.getString("INAME"));
			s.setSea(rs.getInt("SEA"));
			s.setSprice(rs.getInt("SPRICE"));
			s.setStotal(rs.getInt("STOTAL"));
			s.setSdate(rs.getString("SDATE"));
			s.setcName(rs.getString("CNAME"));
			System.out.println(s.toString());
		}
		rs.close();
	}

}
