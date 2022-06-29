package jp.co.aforce.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.beans.PurchaseLog;
import jp.co.aforce.dao.PurchaseDAO;
import jp.co.aforce.models.Model;
import jp.co.aforce.tool.ConstNum;

@WebServlet("/servlets/decide")
public class Decide extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		PurchaseDAO dao = new PurchaseDAO();
		Model model = new Model();

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd/hh/mm");
		String purchase_date = fmt.format(calendar.getTime());
		String transitScreen = "../views/comit.jsp";

		HttpSession session = request.getSession();
		List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");
		MemberBean memberBean = (MemberBean) session.getAttribute("login");

		ArrayList<String> information = new ArrayList<String>();
		information.add(request.getParameter("postCode"));
		information.add(request.getParameter("prefectures"));
		information.add(request.getParameter("municipalities"));
		information.add(request.getParameter("building"));
		information.add(request.getParameter("pay"));
		information.add(request.getParameter("transport"));

		String message = model.nullMsg(information);
		if (!message.isEmpty()) {
			request.setAttribute("information", information);
			request.setAttribute("errmsg", message + ConstNum.W_MSG);
			transitScreen = "../views/purchase.jsp";
		} else {

			try {

				List<PurchaseLog> purchaseLog = new ArrayList<PurchaseLog>();
				for (CartBean c : cart) {
					PurchaseLog log = new PurchaseLog();
					log.setMember_id(memberBean.getMember_id());
					log.setProduct_id(c.getProductBean().getProduct_id());
					log.setPurchase_number(c.getCount());
					log.setPurchase_price(c.getSemiTotal());
					log.setPurchase_date(purchase_date);
					dao.insertLog(log);
					purchaseLog.add(log);
				}
				int total = 0;

				for(CartBean c : cart) {
					total =  total + c.getSemiTotal();
					dao.change(c);
				}


				request.setAttribute("sum", total);
				request.setAttribute("purchaseLog", purchaseLog);
				request.setAttribute("information", information);

			} catch (Exception e) {
				request.setAttribute("errmsg", "購入履歴の登録に失敗しました。" + e);
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(transitScreen).forward(request, response);
	}

}
