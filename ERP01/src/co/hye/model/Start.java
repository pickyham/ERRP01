package co.hye.model;

import co.hye.bean.ItemBean;
import co.hye.dao.ItemDao;

public class Start {
	public static void main(String[] args) throws ClassNotFoundException {
		//ItemBean i = new ItemBean();
		ItemDao m = new ItemDao();
		m.InsertItem();
	}
}
