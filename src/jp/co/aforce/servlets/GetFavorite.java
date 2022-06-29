package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.FavoriteBean;
import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.FavoriteDAO;

/**
 * Servlet implementation class GetFavorite
 */
@WebServlet("/servlets/getFavorite")
public class GetFavorite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		FavoriteDAO dao = new FavoriteDAO();
		HttpSession session = request.getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("login");
		String transitScreen = "../views/favorite.jsp";

		if (memberBean == null) {
			request.setAttribute("nologin", "お気に入りを見るにはログインしてください。");
			transitScreen = "getItem";
		} else {

			try {
				List<FavoriteBean> list = dao.search(memberBean.getMember_id());
				if (list.isEmpty()) {
					request.setAttribute("msg", "お気に入りに追加された商品はございません。");
				} else {
					request.setAttribute("favorite", list);
				}

			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
}
