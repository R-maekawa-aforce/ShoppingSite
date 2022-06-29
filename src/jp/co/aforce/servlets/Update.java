package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.models.Model;
import jp.co.aforce.tool.ConstNum;

/**
 * Servlet implementation class Update
 */
@WebServlet("/servlets/update")
public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		MemberDAO dao = new MemberDAO();
		String transitScreen = "../views/update.jsp";
		Model model = new Model();
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");

		if (request.getParameter("search") != null) {

			try {
				MemberBean memberBean = dao.loginMember(member_id, password);

				if (memberBean != null) {
					request.setAttribute("m", memberBean);
				} else {
					request.setAttribute("errmsg", "会員番号またはパスワードが正しくありません。");
					request.setAttribute("member_id", member_id);
					request.setAttribute("password", password);
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}
		if (request.getParameter("update") != null) {
			try {
				if (dao.loginMember(member_id, password) == null) {
					request.setAttribute("errmsg", "会員番号またはパスワードが正しくありません。");
					request.setAttribute("member_id", member_id);
					request.setAttribute("password", password);
				} else {
					MemberBean memberBean = new MemberBean();
					memberBean.setMember_id(request.getParameter("member_id"));
					memberBean.setPassword(request.getParameter("password"));
					memberBean.setLast_name(request.getParameter("last_name"));
					memberBean.setFirst_name(request.getParameter("first_name"));
					memberBean.setSex(request.getParameter("sex"));
					memberBean.setBirth_year(request.getParameter("birth_year"));
					memberBean.setBirth_month(request.getParameter("birth_month"));
					memberBean.setBirth_day(request.getParameter("birth_day"));
					memberBean.setPost_code(request.getParameter("post_code"));
					memberBean.setPrefectures(request.getParameter("prefectures"));
					memberBean.setMunicipalities(request.getParameter("municipalities"));
					memberBean.setBuilding(request.getParameter("building"));
					memberBean.setPhone_number(request.getParameter("phone_number"));
					memberBean.setMail_address(request.getParameter("mail_address"));

					String message = model.nullMsg2(memberBean);
					if (!message.isEmpty()) {
						request.setAttribute("m", memberBean);
						request.setAttribute("errmsg", message + ConstNum.W_MSG);
					} else {

						int line = dao.update(memberBean);
						if (line > 0) {
							request.setAttribute("success", "会員情報が更新されました。");
							request.setAttribute("m", memberBean);
						} else {
							request.setAttribute("errmsg", "会員番号またはパスワードが正しくありません。");
							request.setAttribute("member_id", member_id);
							request.setAttribute("password", password);
						}
					}
				}
			} catch (Exception e1) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e1);
				e1.printStackTrace();
			}
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
