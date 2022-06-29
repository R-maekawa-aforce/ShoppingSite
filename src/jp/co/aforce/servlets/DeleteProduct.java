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
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/servlets/deleteProduct")
public class DeleteProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		ProductDAO dao = new ProductDAO();
		String transitScreen = "../views/deleteProduct.jsp";
		String product_id = request.getParameter("product_id");

		if (request.getParameter("search_product") != null) {
			try {
				ProductBean productBean = dao.search(product_id);
				if (productBean == null) {
					request.setAttribute("errmsg", "入力された商品番号の商品は存在しません。");
					request.setAttribute("product_id", product_id);
				} else {
					request.setAttribute("product", productBean);
					request.setAttribute("product_id", product_id);
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		if (request.getParameter("delete_product") != null) {
			try {
				int line = dao.delete(product_id);
				if (line > 0) {
					request.setAttribute("success", "商品を一つ削除しました。");
				} else {
					request.setAttribute("errmsg", "既存の商品番号を入力して下さい。");
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
