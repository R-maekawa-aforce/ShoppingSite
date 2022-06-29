package jp.co.aforce.servlets;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.models.Model;
import jp.co.aforce.tool.ConstNum;

@WebServlet("/servlets/insertProduct")
@MultipartConfig
public class InsertProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		Model model = new Model();
		ProductDAO dao = new ProductDAO();
		String transitScreen = "../views/insertProduct.jsp";

		try {

			Part part = request.getPart("image");
			String contentType = part.getContentType();
			InputStream fileContent = part.getInputStream();
			byte[] byteArray;
			byteArray = getByteArray(fileContent);
			String base64String = java.util.Base64.getEncoder().encodeToString(byteArray);

			ProductBean productBean = new ProductBean();
			productBean.setProduct_name(request.getParameter("product_name"));
			productBean.setPrice(request.getParameter("price"));
			productBean.setAmount(request.getParameter("amount"));
			productBean.setContentType(contentType);
			productBean.setBase64String(base64String);
			productBean.setInfo(request.getParameter("info"));

			String message = model.nullMsg(productBean);

			if (!message.isEmpty()) {
				request.setAttribute("product", productBean);
				request.setAttribute("errmsg", message + ConstNum.W_MSG);
			} else {
				boolean result = dao.checkProduct(productBean);

				if (result) {
					request.setAttribute("product", productBean);
					request.setAttribute("errmsg", "商品情報が既に登録されています。");
				} else {

					int line = dao.insert(productBean);

					if (line > 0) {
						request.setAttribute("success", "商品情報が登録されました。");
						request.setAttribute("success2", productBean);

					} else {
						request.setAttribute("product", productBean);
						request.setAttribute("errmsg", "商品情報の登録に失敗しました。やり直してください。");
					}
				}
			}
		} catch (Exception e) {
			request.setAttribute("errmsg", "エラーが発生しました。やり直してください。" + e);
			e.printStackTrace();
		}

		request.getRequestDispatcher(transitScreen).forward(request, response);

	}

	private static byte[] getByteArray(InputStream is) throws Exception {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		BufferedOutputStream os = new BufferedOutputStream(b);
		while (true) {
			int i = is.read();
			if (i == -1)
				break;
			os.write(i);
		}
		os.flush();
		os.close();
		return b.toByteArray();
	}

}
