package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.tool.ConstNum;

public class ProductDAO extends DAO {
	public boolean checkProduct(ProductBean producBean)throws Exception{
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_CHECK);

		st.setString(1, producBean.getProduct_name());
		st.setString(2, producBean.getPrice());

		ResultSet rs = st.executeQuery();

		int count = 0;
		while(rs.next()) {
			count = rs.getInt(1);
		}
		if(count > 0) {
			result = true;
		}

		st.close();
		con.close();

		return result;
	}


	public int insert(ProductBean productBean)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_INSERT);

		st.setString(1, productBean.getProduct_name());
		st.setString(2, productBean.getPrice());
		st.setString(3, productBean.getAmount());
		st.setString(4, productBean.getContentType());
		st.setString(5, productBean.getBase64String());
		st.setString(6, productBean.getInfo());

		int line = st.executeUpdate();

		return line;
	}

	public ProductBean search(String product_id)throws Exception {
		ProductBean productBean = null;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_SEARCH);

		st.setString(1, product_id);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			productBean = new ProductBean();
			productBean.setProduct_id(product_id);
			productBean.setProduct_name(rs.getString("product_name"));
			productBean.setPrice(rs.getString("price"));
			productBean.setAmount(rs.getString("amount"));
			productBean.setInfo(rs.getString("info"));
		}

		st.close();
		con.close();

		return productBean;
	}

	public List<ProductBean> searchAll()throws Exception {
		List<ProductBean>list = new ArrayList<>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_SEARCHALL);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setProduct_id(rs.getString("product_id"));
			productBean.setProduct_name(rs.getString("product_name"));
			productBean.setPrice(rs.getString("price"));
			productBean.setAmount(rs.getString("amount"));
			productBean.setContentType(rs.getString("contentType"));
			productBean.setBase64String(rs.getString("base64String"));
			productBean.setInfo(rs.getString("info"));
			list.add(productBean);
		}

		st.close();
		con.close();

		return list;
	}

	public int delete(String product_id)throws Exception{

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_DELETE);

		st.setString(1, product_id);

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public int update(String amount, String product_id)throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_UPDATE);

		st.setString(1, amount);
		st.setString(2, product_id);

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public List<ProductBean> itemSearch(String key)throws Exception{
		List<ProductBean>list = new ArrayList<ProductBean>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_KEY);

		st.setString(1, "%" + key + "%");

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setProduct_id(rs.getString("product_id"));
			productBean.setProduct_name(rs.getString("product_name"));
			productBean.setPrice(rs.getString("price"));
			productBean.setAmount(rs.getString("amount"));
			productBean.setContentType(rs.getString("contentType"));
			productBean.setBase64String(rs.getString("base64String"));
			productBean.setInfo(rs.getString("info"));
			list.add(productBean);
		}

		st.close();
		con.close();

		return list;
	}

	public List<ProductBean>expensive()throws Exception{
		List<ProductBean>list = new ArrayList<ProductBean>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_EXPENSIVE);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setProduct_id(rs.getString("product_id"));
			productBean.setProduct_name(rs.getString("product_name"));
			productBean.setPrice(rs.getString("price"));
			productBean.setAmount(rs.getString("amount"));
			productBean.setContentType(rs.getString("contentType"));
			productBean.setBase64String(rs.getString("base64String"));
			productBean.setInfo(rs.getString("info"));
			list.add(productBean);
		}
		st.close();
		con.close();

		return list;
	}
	public List<ProductBean>reasnable()throws Exception{
		List<ProductBean>list = new ArrayList<ProductBean>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_REASNABLE);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setProduct_id(rs.getString("product_id"));
			productBean.setProduct_name(rs.getString("product_name"));
			productBean.setPrice(rs.getString("price"));
			productBean.setAmount(rs.getString("amount"));
			productBean.setContentType(rs.getString("contentType"));
			productBean.setBase64String(rs.getString("base64String"));
			productBean.setInfo(rs.getString("info"));
			list.add(productBean);
		}
		st.close();
		con.close();

		return list;
	}
	public int change(ProductBean productBean)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_P_CHANGE);

		st.setString(1, productBean.getProduct_name());
		st.setString(2, productBean.getPrice());
		st.setString(3, productBean.getAmount());
		st.setString(4, productBean.getContentType());
		st.setString(5, productBean.getBase64String());
		st.setString(6, productBean.getInfo());
		st.setString(7, productBean.getProduct_id());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	// 2023ここを変更したよ

}
