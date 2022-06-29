package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.MemberDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/servlets/delete")
public class Delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		MemberDAO dao = new MemberDAO();
		String transitScreen = "../views/delete.jsp";


		if(request.getParameter("search") != null) {
			String member_id = request.getParameter("member_id");
			String password = request.getParameter("password");

			try {
				MemberBean memberBean = dao.loginMember(member_id, password);

				if(memberBean != null) {
					request.setAttribute("m", memberBean);
				}else {
					request.setAttribute("errmsg", "会員番号またはパスワードが正しくありません。");
					request.setAttribute("member_id", member_id);
					request.setAttribute("password", password);
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		if(request.getParameter("delete") != null) {
			String member_id = request.getParameter("member_id");
			try {
				int line = dao.delete(member_id);
				if(line > 0) {
					request.setAttribute("success", "会員情報が削除されました");
				}else {
					request.setAttribute("errmsg", "会員番号またはパスワードが正しくありません。");
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
}

