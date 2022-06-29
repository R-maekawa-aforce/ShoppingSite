package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.PurchaseLog;
import jp.co.aforce.dao.PurchaseDAO;

/**
 * Servlet implementation class GetLog
 */
@WebServlet("/servlets/getLog")
public class GetLog extends HttpServlet {

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.sendRedirect("/ShoppingSite/views/home.jsp");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; UTF-8");
			String transitScreen = "../views/purchaseLog.jsp";

			PurchaseDAO dao = new PurchaseDAO();

			try {
				List<PurchaseLog>list = dao.search();
				if(!list.isEmpty()) {
				request.setAttribute("log", list);
			}else {
				request.setAttribute("errmsg", "購入履歴は存在しません。");
			}
			} catch (Exception e) {
				request.setAttribute("errmsg", "購入履歴の取得に失敗しました。");
				e.printStackTrace();
			}
			request.getRequestDispatcher(transitScreen).forward(request, response);

		}
	}
