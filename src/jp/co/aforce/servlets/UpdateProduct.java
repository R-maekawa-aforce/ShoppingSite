package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/servlets/updateProduct")
public class UpdateProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		ProductDAO dao = new ProductDAO();
		String product_id = request.getParameter("product_id");
		String amount = request.getParameter("amount");
		String transitScreen = null;

		try {
			int line = dao.update(amount, product_id);
			if(line > 0) {
				request.setAttribute("msg", "商品ID : " + product_id + "の在庫数を更新しました。");
				transitScreen = "getStock";
			}
		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました。" + e);
			transitScreen = "../views/stock.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}


}
