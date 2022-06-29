package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class GetStock
 */
@WebServlet("/servlets/getStock")
public class GetStock extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		String transitsCreen = null;
		HttpSession session = request.getSession();

		ProductDAO dao = new ProductDAO();

		try {
			List<ProductBean> list = dao.searchAll();
			transitsCreen = "../views/stock.jsp";
			session.setAttribute("list", list);

		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました" + e);
			transitsCreen = "../views/adminHome.jsp";
			e.printStackTrace();
		}

		request.getRequestDispatcher(transitsCreen).forward(request, response);
	}

}
