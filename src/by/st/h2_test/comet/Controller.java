package by.st.h2_test.comet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.st.h2_test.beans.Login;
import by.st.h2_test.dao.impl.H2Dao;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static H2Dao dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = H2Dao.getInstance();

	}

	@Override
	public void destroy() {
		super.destroy();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String path = "";
		String command = request.getParameter("command");
		if (command.equalsIgnoreCase("getLogins")) {
			ArrayList<Login> logins = dao.getLogins();
			request.setAttribute("Logins", logins);
			path = "indexH2.jsp";
		} else if (command.equalsIgnoreCase("getLogin")) {
			String id = request.getParameter("id");
			Login login = dao.getLogin(Integer.valueOf(id));
			request.setAttribute("Login", login);
			path = "indexH2.jsp";
		}
		{

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
