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
 * Servlet implementation class ItemSearch
 */
@WebServlet("/servlets/itemSearch")
public class ItemSearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppinSite/views/home.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		HttpSession session = request.getSession();
		String transitScreen = "../views/productAll.jsp";

		String key = request.getParameter("search");
		if(key == null) key = "";
		ProductDAO dao = new ProductDAO();

		try {
			List<ProductBean>list = dao.itemSearch(key);
			if(list.isEmpty()) {
				session.removeAttribute("list");
				request.setAttribute("errmsg", "入力された検索結果に一致する商品が見つかりませんでした。");
				request.setAttribute("key", key);

			}else {
				session.setAttribute("list", list);
				request.setAttribute("key", key);
			}
		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました。" + e);
			e.printStackTrace();
		}

		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
