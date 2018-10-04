package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.StockBean;
import co.hye.dao.StockDao;

public class Stock {
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;
	public void stockCall() throws ClassNotFoundException, SQLException {
		StockDao dao = new StockDao();
		StockBean s;
		rs = dao.SelectStock();
		
		System.out.println("상품코드\t상품명\t단가\t업체명\t업체분류\t창고명\t재고수량");
		while (rs.next()) {
			s = new StockBean();
			s.setiCode(rs.getString("ICODE"));
			s.setiName(rs.getString("INAME"));
			s.setpPrice(rs.getInt("PPRICE"));
			s.setcName(rs.getString("CNAME"));
			s.setcNum(rs.getString("CNUM"));
			s.sethName(rs.getString("HNAME"));
			s.setpEa(rs.getInt("PEA"));
			System.out.println(s.toString());
		}
		rs.close();
	}
}
