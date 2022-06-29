package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;


@WebServlet("/servlets/purchase")
public class Purchase extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ShoppingSite/views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		String transitScreen = null;

		HttpSession session = request.getSession();
		List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");


		if(session.getAttribute("login") == null) {
			request.setAttribute("nologin", "購入するにはログインしてください。");
			transitScreen = "../views/home.jsp";
		}else if(cart == null || cart.size() == 0) {
			transitScreen = "../views/cart.jsp";
		}else {
			transitScreen = "/servlets/getSum";
		}

		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
