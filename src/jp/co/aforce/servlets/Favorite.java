package jp.co.aforce.servlets;

import java.io.IOException;

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
 * Servlet implementation class Favorite
 */
@WebServlet("/servlets/favorite")
public class Favorite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		FavoriteBean favoriteBean = new FavoriteBean();
		HttpSession session = request.getSession();
		String transitScreen = null;
		FavoriteDAO dao = new FavoriteDAO();

		if (session.getAttribute("login") == null) {
			request.setAttribute("nologin", "お気に入りを追加するにはログインしてください。");
			transitScreen = "getItem";
		} else {

			try {
				MemberBean memberBean = (MemberBean) session.getAttribute("login");
				favoriteBean.setMember_id(memberBean.getMember_id());
				favoriteBean.setProduct_id(request.getParameter("product_id"));
				favoriteBean.setProduct_name(request.getParameter("product_name"));
				favoriteBean.setPrice(request.getParameter("price"));
				favoriteBean.setContentType(request.getParameter("contentType"));
				favoriteBean.setBase64String(request.getParameter("base64String"));

				String product_id = favoriteBean.getProduct_id();
				String member_id = favoriteBean.getMember_id();

				FavoriteBean favoriteBean2;
				favoriteBean2 = dao.check(product_id, member_id);
				if (favoriteBean2 != null) {
					request.setAttribute("msg", request.getParameter("product_name") + "は既にお気に入りに追加されています。");
					transitScreen = "getFavorite";
				} else {
					int line = dao.insert(favoriteBean);
					if(line > 0) {
						request.setAttribute("msg", request.getParameter("product_name") + "がお気に入りに追加されました。");
						transitScreen = "getFavorite";
					}
					else {
						request.setAttribute("errmsg", "お気に入りの追加に失敗しました。");
						transitScreen = "getItem";
					}
				}
			} catch (Exception e) {
				transitScreen = "../views/favorite.jsp";
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher(transitScreen).forward(request, response);

	}

}
