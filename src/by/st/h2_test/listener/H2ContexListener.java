package by.st.h2_test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import by.st.h2_test.dao.connection_pool.ConnectionPool;
@WebListener
public class H2ContexListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.dispose();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.initPoolData();

	}

}
