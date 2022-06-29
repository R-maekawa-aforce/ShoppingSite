package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlets/transition")
public class Transition extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("update") != null) request.getRequestDispatcher("../views/update.jsp").forward(request, response);
		if(request.getParameter("delete") != null) request.getRequestDispatcher("../views/delete.jsp").forward(request, response);
		if(request.getParameter("product") != null)	request.getRequestDispatcher("../views/productAll.jsp").forward(request, response);
		if(request.getParameter("regist") != null) request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
		if(request.getParameter("home") != null) request.getRequestDispatcher("../views/home.jsp").forward(request, response);

		if(request.getParameter("adminHome") != null)request.getRequestDispatcher("../views/adminHome.jsp").forward(request, response);
		if(request.getParameter("admin") != null) request.getRequestDispatcher("../views/adminLogin.jsp").forward(request, response);
		if(request.getParameter("insertProduct") != null) request.getRequestDispatcher("../views/insertProduct.jsp").forward(request, response);
		if(request.getParameter("deleteProduct") != null) request.getRequestDispatcher("../views/deleteProduct.jsp").forward(request, response);
		if(request.getParameter("purchaseLog") != null) request.getRequestDispatcher("../views/purchaseLog.jsp").forward(request, response);
		if(request.getParameter("updateProduct") != null) request.getRequestDispatcher("../views/updateProduct.jsp").forward(request, response);
	}

}
