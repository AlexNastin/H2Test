package by.st.h2_test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.st.h2_test.beans.Login;
import by.st.h2_test.beans.Order;
import by.st.h2_test.beans.Room;
import by.st.h2_test.dao.connection_pool.ConnectionPool;

public class H2Dao implements Ih2Dao {

	static ConnectionPool connectionPool = ConnectionPool.getInstance();

	final String SELECT_LOGIN = "SELECT * FROM login WHERE idLogin=";
	final String SELECT_LOGINS = "SELECT * FROM login";
	final String INSERT_LOGIN = "INSERT INTO login VALUES(?,?,?,?);";
	final String DELETE_LOGIN = "DELETE FROM login WHERE IDLOGIN=?";
	final String UPDATE_LOGIN = "UPDATE  login SET NAME=? ,EMAIL=? , PASSWORD=? WHERE IDLOGIN=?";

	final String SELECT_ORDER = "SELECT * FROM orders WHERE idOrder=";
	final String SELECT_ORDERS = "SELECT * FROM orders";
	final String INSERT_ORDER = "";
	final String DELETE_ORDER = "";

	final String SELECT_ROOM = "SELECT * FROM room WHERE idRoom=";
	final String SELECT_ROOMS = "SELECT * FROM room";
	final String INSERT_ROOM = "";
	final String DELETE_ROOM = "";

	private H2Dao() {
	}

	private static class Holder {
		private static final H2Dao INSTANCE = new H2Dao();
	}

	public static H2Dao getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public Login getLogin(int id) {
		Login login = null;
		Connection connection = connectionPool.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_LOGIN + id);

			if (resultSet.next()) {
				login = new Login(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}

	@Override
	public ArrayList<Login> getLogins() {

		ArrayList<Login> logins = new ArrayList<Login>();
		Login login = null;
		Connection connection = connectionPool.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_LOGINS);
			ResultSetMetaData rsmd = resultSet.getMetaData();
		
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnTypeName(1));
			System.out.println(rsmd.getColumnDisplaySize(1));
			
			while (resultSet.next()) {
				login = new Login(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(4));
				logins.add(login);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return logins;
	}

	@Override
	public void insertLogin(int idLogin, String name, String email, int pass) {
		Connection connection = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(INSERT_LOGIN);
			preparedStatement.setInt(1, idLogin);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, pass);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void deleteLogin(int id) {
		Connection connection = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_LOGIN);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateLogin(int idLogin, String name, String email, int pass)
			throws SQLException {
		Connection connection = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_LOGIN);
			preparedStatement.setInt(4, idLogin);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, pass);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Room getRoom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Room> getRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRoom(Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRoom(int id) {
		// TODO Auto-generated method stub

	}

}
