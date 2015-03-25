package by.st.h2_test.dao.connection_pool;

import java.util.ArrayList;

import by.st.h2_test.beans.Login;
import by.st.h2_test.dao.impl.H2Dao;


public class MainTest {

	public static void main(String[] args) {

		H2Dao dao = H2Dao.getInstance();
		
		System.out.println(dao.getLogin(3));
		ArrayList<Login> logins = dao.getLogins();
		
		for (int i = 0; i < logins.size(); i++) {
			System.out.println(logins.get(i));
		}
		
	}

}
