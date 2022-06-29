package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/servlets/adminLogout")
public class AdminLogout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		String transitScreen = null;

		HttpSession session = request.getSession();

			session.removeAttribute("login");
			session.removeAttribute("loginmsg");
			transitScreen = "../views/adminLogin.jsp";
			request.setAttribute("msg", "ログアウトしました。");

		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
