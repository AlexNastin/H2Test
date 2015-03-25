package by.st.h2_test.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import by.st.h2_test.beans.Login;
import by.st.h2_test.beans.Order;
import by.st.h2_test.beans.Room;

public interface Ih2Dao {

	public Login getLogin(int id) ;
	public ArrayList<Login> getLogins();
	public void insertLogin(int idLogin, String name, String email, int pass)throws SQLException;
	public void deleteLogin(int id);
	public void updateLogin(int idLogin, String name, String email, int pass)throws SQLException;
	
	
	
	
	public Order getOrder(int id);
	public ArrayList<Order> getOrders();
	public void insertOrder(Order order);
	public void deleteOrder(int id);
	
	public Room getRoom(int id);
	public ArrayList<Room> getRooms();
	public void insertRoom(Room room);
	public void deleteRoom(int id);
	
	
	
}
