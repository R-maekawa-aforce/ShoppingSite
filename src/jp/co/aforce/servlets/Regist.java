package jp.co.aforce.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.models.Model;
import jp.co.aforce.tool.ConstNum;

@WebServlet("/servlets/regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		Model model = new Model();
		MemberDAO dao = new MemberDAO();

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyMMddhhmmss");
		String date = fmt.format(calendar.getTime());
		String member_id = "A" + date;

		String transitScreen = "../views/regist.jsp";

		MemberBean memberBean = new MemberBean();
		memberBean.setMember_id(member_id);
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
		memberBean.setPassword(request.getParameter("password"));

		String message = model.nullMsg(memberBean);

		if (!message.isEmpty()) {
			request.setAttribute("member", memberBean);
			request.setAttribute("errmsg", message + ConstNum.W_MSG);

		} else {
			try {
				boolean result = dao.checkMember(memberBean);

				if (result) {
					request.setAttribute("member", memberBean);
					request.setAttribute("errmsg", "会員情報が既に登録されています。");
				} else {
					int line = dao.insertMember(memberBean);

					if (line > 0) {
						request.setAttribute("success", "会員情報が登録されました。"
								+ "会員番号は大切に保管しておいてください。" +
								"<br>" + "会員番号 : " + member_id);
					} else {
						request.setAttribute("member", memberBean);
						request.setAttribute("errmsg", "会員登録に失敗しました。やり直してください。");
					}
				}
			} catch (Exception e) {
				request.setAttribute("member", memberBean);
				request.setAttribute("errmsg", "エラーが発生しました。やり直してください。" + e);
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}
}
