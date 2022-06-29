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

/**
 * Servlet implementation class GetSum
 */
@WebServlet("/servlets/getSum")
public class GetSum extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite//views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		HttpSession session = request.getSession();
		List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");

		int total = 0;

		for(CartBean c : cart) {
			total =  total + c.getSemiTotal();
		}
		request.setAttribute("sum", total);
		request.getRequestDispatcher("../views/purchase.jsp").forward(request, response);
	}

}
