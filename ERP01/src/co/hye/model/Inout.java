package co.hye.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.hye.bean.InoutBean;
import co.hye.dao.InoutDao;

public class Inout {
	Scanner sc = new Scanner(System.in);
	ResultSet rs;
	int n = 0;
	public void inoutCall() throws ClassNotFoundException, SQLException {
		InoutDao dao = new InoutDao();
		InoutBean io;
		rs = dao.SelectInout();
		
		System.out.println("입출고 번호\t품목코드\t품목명\t입고수량\t출고수량\t재고수량\t창고명");
		while (rs.next()) {
			io = new InoutBean();
			io.setIoSeq(rs.getInt("IOSEQ"));
			io.setiCode(rs.getString("ICODE"));
			io.setiName(rs.getString("INAME"));
			io.setPea(rs.getInt("PEA"));
			io.setSea(rs.getInt("SEA"));
			io.setEa(rs.getInt("EA"));
			io.sethName(rs.getString("HNAME"));
			System.out.println(io.toString());
		}
		rs.close();
	}

}
