package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlets/logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		String transitScreen = "../views/home.jsp";
		HttpSession session = request.getSession();

		if(session.getAttribute("login") != null || session.getAttribute("welcome") != null) {
			request.setAttribute("logout", "ログアウトしました。");
			session.removeAttribute("login");
			session.removeAttribute("welcome");
			session.removeAttribute("cart");

		}else {
			request.setAttribute("logout", "既にログアウト済みです。");

		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
