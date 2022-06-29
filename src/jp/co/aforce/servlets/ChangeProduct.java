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

/**
 * Servlet implementation class ChangeProduct
 */
@WebServlet("/servlets/changeProduct")
@MultipartConfig
public class ChangeProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		ProductDAO dao = new ProductDAO();
		String transitScreen = "../views/updateProduct.jsp";
		Model model = new Model();
		String product_id = request.getParameter("product_id");

		if(request.getParameter("search") != null) {
			try {
				ProductBean productBean = dao.search(product_id);
				if (productBean == null) {
					request.setAttribute("errmsg", "入力された商品番号の商品は存在しません。");
					request.setAttribute("product_id", product_id);
				} else {
					request.setAttribute("product", productBean);
				}
			} catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。" + e);
				e.printStackTrace();
			}
		}

		if(request.getParameter("update_product") != null) {
			try {
				if(dao.search(product_id) == null) {
					request.setAttribute("errmsg", "商品番号が正しくありません");
					request.setAttribute("product_id", product_id);
				}else {

				Part part = request.getPart("image");
				String contentType = part.getContentType();
				InputStream fileContent = part.getInputStream();
				byte[] byteArray;
				byteArray = getByteArray(fileContent);
				String base64String = java.util.Base64.getEncoder().encodeToString(byteArray);

				ProductBean productBean = new ProductBean();
				productBean.setProduct_id(request.getParameter("product_id"));
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
						int line = dao.change(productBean);

						if (line > 0) {
							request.setAttribute("success", "商品情報が更新されました。");
							request.setAttribute("product", productBean);

						} else {
							request.setAttribute("product", productBean);
							request.setAttribute("errmsg", "商品番号が正しくありません。");
						}
					}
				}
			}
			catch (Exception e) {
				request.setAttribute("errmsg", "エラーが発生しました。やり直してください。" + e);
				e.printStackTrace();
			}
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
