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
 * Servlet implementation class ChangeCart
 */
@WebServlet("/servlets/changeCart")
public class ChangeCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ShoppingSite/views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		HttpSession session = request.getSession();
		String transitScreen = "getCurrentSum";

		if(request.getParameter("delete") != null) {
			String product_name = request.getParameter("product_name");

			List<CartBean>cart =  (List<CartBean>) session.getAttribute("cart");
			for(CartBean c : cart) {
				if(c.getProductBean().getProduct_name().equals(product_name)) {
					cart.remove(c);
					break;
				}
			}
			request.setAttribute("changemsg", "カートから" + product_name + "を削除しました。");
			request.getRequestDispatcher(transitScreen).forward(request, response);
			return;
		}
		if(request.getParameter("update") != null) {
			String product_name = request.getParameter("product_name");
			int amount = Integer.parseInt(request.getParameter("amount"));

			List<CartBean>cart = (List<CartBean>) session.getAttribute("cart");
			for(CartBean c : cart) {
				if(c.getProductBean().getProduct_name().equals(product_name)) {
					c.setCount(amount);
					c.setSemiTotal(amount * Integer.parseInt(c.getProductBean().getPrice()));
					break;
				}

			}
			request.setAttribute("changemsg", product_name + "の個数を変更しました。");
			request.getRequestDispatcher(transitScreen).forward(request, response);
			return;
		}
	}

}
