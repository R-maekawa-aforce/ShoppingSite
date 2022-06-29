package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.AdminBean;
import jp.co.aforce.dao.AdminDAO;


@WebServlet("/servlets/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		String transitScreen = null;
		AdminDAO dao = new AdminDAO();

		String admin_id = request.getParameter("admin_id");
		String password = request.getParameter("password");

		try {
			AdminBean adminBean = dao.searchAdmin(admin_id, password);
			if(adminBean == null) {
				request.setAttribute("errmsg", "IDもしくはパスワードが正しくありません。");
				request.setAttribute("admin_id", admin_id);
				request.setAttribute("password", password);
				transitScreen = "../views/adminLogin.jsp";
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("login", adminBean);
				session.setAttribute("loginmsg", "管理者 : " + adminBean.getLast_name() + adminBean.getFirst_name());
				transitScreen = "../views/adminHome.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました。やり直してください。" + e);
			transitScreen = "../views/adminLogin.jsp";
			e.printStackTrace();
		}

		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
