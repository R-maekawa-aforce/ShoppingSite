package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.MemberDAO;

@WebServlet("/servlets/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String transitScreen = null;

		MemberDAO dao = new MemberDAO();


		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");

		try {
			MemberBean memberBean = dao.loginMember(member_id, password);
			if(memberBean == null) {
				transitScreen = "../views/home.jsp";
				request.setAttribute("member_id" ,member_id);
				request.setAttribute("pssword", password);
				request.setAttribute("loginMiss", "IDもしくはパスワードが正しくありません。");

			}else {
				HttpSession session = request.getSession();
				session.setAttribute("login", memberBean);
				session.setAttribute("welcome", "ようこそ" + memberBean.getLast_name() + memberBean.getFirst_name() + "さん！");
				transitScreen = "getItem";
			}
		} catch (Exception e) {
			request.setAttribute("loginMiss", "エラーが発生しました。");

			e.printStackTrace();
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);

	}

}
