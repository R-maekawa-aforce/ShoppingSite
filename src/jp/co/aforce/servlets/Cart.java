package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.ProductBean;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/servlets/cart")
public class Cart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		HttpSession session = request.getSession();
		String transitScreen = "getCurrentSum";

		if(request.getParameter("addCart")  != null) {
			String product_name = request.getParameter("product_name");
			if(request.getParameter("amount") == null) {
				request.setAttribute("errmsg", "個数を選択してください");
				request.getRequestDispatcher("../views/productAll.jsp").forward(request, response);
				return;
			}
			int amount = Integer.parseInt(request.getParameter("amount"));

			List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");

			if (cart == null) {
				cart = new ArrayList<CartBean>();
				session.setAttribute("cart", cart);
			}

			for (CartBean c : cart) {
				if (c.getProductBean().getProduct_name().equals(product_name)) {
					c.setCount(c.getCount() + amount);
					c.setSemiTotal(c.getCount() * Integer.parseInt(c.getProductBean().getPrice()));
					request.getRequestDispatcher(transitScreen).forward(request, response);
					return;
				}
			}
			List<ProductBean> list = (List<ProductBean>) session.getAttribute("list");
			for (ProductBean p : list) {
				if (p.getProduct_name().equals(product_name)) {
					CartBean cartBean = new CartBean();
					cartBean.setProductBean(p);
					cartBean.setCount(amount);
					cartBean.setSemiTotal(amount * Integer.parseInt(p.getPrice()));
					cart.add(cartBean);
				}
			}

			request.getRequestDispatcher(transitScreen).forward(request, response);
		}
		if(request.getParameter("getCart") != null) {
			session.getAttribute("cart");
			request.getRequestDispatcher(transitScreen).forward(request, response);
		}
	}
}
