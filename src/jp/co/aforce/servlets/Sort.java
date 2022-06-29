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
 * Servlet implementation class Sort
 */
@WebServlet("/servlets/sort")
public class Sort extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		ProductDAO dao = new ProductDAO();
		HttpSession session = request.getSession();

		if(request.getParameter("reasnable") != null) {
			List<ProductBean> list;
			try {
				list = dao.reasnable();
				session.setAttribute("list", list);
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		if(request.getParameter("expensive") != null) {
			List<ProductBean> list;
			try {
				list = dao.expensive();
				session.setAttribute("list", list);
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("../views/productAll.jsp").forward(request, response);
	}

}
