package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class SelectProduct
 */
@WebServlet("/servlets/selectProduct")
public class SelectProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		ProductDAO dao = new ProductDAO();
		String product_id = request.getParameter("product_id");

		if (request.getParameter("search") != null) {
			try {
				ProductBean productBean = dao.search(product_id);
				if (productBean == null) {
					request.setAttribute("errmsg", "入力された商品番号の商品は存在しません。");
					request.setAttribute("product_id", product_id);
				} else {
					request.setAttribute("product", productBean);
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("../views/updateProduct.jsp").forward(request, response);
	}

}
