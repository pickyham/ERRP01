package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.PinBean;
import co.hye.dao.PinDao;

public class Pin {
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;
	public void pinCall() throws ClassNotFoundException, SQLException {
		PinDao dao = new PinDao();
		PinBean p;
		rs = dao.SelectPin();
		
		System.out.println("구매번호\t\t라인번호\t품목코드\t품목명\t수량\t판매가\t금액\t입고일자\t\t\t업체명");
		while (rs.next()) {
			p = new PinBean();
			p.setPnum(rs.getString("PNUM"));
			p.setPline(rs.getInt("PLINE"));
			p.setPcode(rs.getString("PCODE"));
			p.setPname(rs.getString("INAME"));
			p.setPea(rs.getInt("PEA"));
			p.setPprice(rs.getInt("PPRICE"));
			p.setPtotal(rs.getInt("PTOTAL"));
			p.setPdate(rs.getString("PDATE"));
			p.setcName(rs.getString("CNAME"));
			System.out.println(p.toString());
		}
		rs.close();
	}
}
