package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.FavoriteDAO;

/**
 * Servlet implementation class DeleteFavorite
 */
@WebServlet("/servlets/deleteFavorite")
public class DeleteFavorite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		FavoriteDAO dao = new FavoriteDAO();

		String product_id = request.getParameter("product_id");
		String member_id = request.getParameter("member_id");
		String product_name = request.getParameter("product_name");


		try {
			int line = dao.delete(product_id,member_id);
			if(line > 0) {
				request.setAttribute("msg", product_name + "をお気に入りから削除しました");
			}else {
				request.setAttribute("errmsg", "削除に失敗しました。");
			}
		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました。" + e);
			e.printStackTrace();
		}

		request.getRequestDispatcher("getFavorite").forward(request, response);

	}

}
