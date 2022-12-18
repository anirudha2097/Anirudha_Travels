package com.masai.usecases;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.main.AdminMenu;
import com.masai.main.Main;

public final class LogoutAdmin {

	public static void main(String[] args) {
		
		AdminDao admin = new AdminDaoImpl();
		
		try {
			String result = admin.logout();
			System.out.println(result);
			System.out.println("-----------------------------------------");
			System.out.println("");
			Main.main(args);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			AdminMenu.main(args);
		}

	}

}
