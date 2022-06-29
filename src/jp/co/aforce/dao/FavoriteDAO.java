package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.FavoriteBean;
import jp.co.aforce.tool.ConstNum;

public class FavoriteDAO extends DAO{

	public FavoriteBean check(String product_id, String member_id)throws Exception{
		FavoriteBean favoriteBean = null;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_F_CHECK);

		st.setString(1, product_id);
		st.setString(2, member_id);

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			favoriteBean = new FavoriteBean();
			favoriteBean.setFavorite_id(rs.getString("favorite_id"));
			favoriteBean.setMember_id(rs.getString("member_id"));
			favoriteBean.setProduct_id(rs.getString("product_id"));
			favoriteBean.setPrice(rs.getString("price"));
			favoriteBean.setContentType(rs.getString("contentType"));
			favoriteBean.setBase64String(rs.getString("base64String"));
		}

		st.close();
		con.close();

		return favoriteBean;
	}
	public List<FavoriteBean> search(String member_id)throws Exception{
		List<FavoriteBean>list = new ArrayList<FavoriteBean>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_F_SEARCH);

		st.setString(1, member_id);

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			FavoriteBean favoriteBean = new FavoriteBean();
			favoriteBean.setFavorite_id(rs.getString("favorite_id"));
			favoriteBean.setMember_id(rs.getString("member_id"));
			favoriteBean.setProduct_id(rs.getString("product_id"));
			favoriteBean.setProduct_name(rs.getString("product_name"));
			favoriteBean.setPrice(rs.getString("price"));
			favoriteBean.setContentType(rs.getString("contentType"));
			favoriteBean.setBase64String(rs.getString("base64String"));
			list.add(favoriteBean);
		}

		st.close();
		con.close();

		return list;
	}
	public int insert(FavoriteBean favoriteBean)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_F_INSERT);

		st.setString(1, favoriteBean.getMember_id());
		st.setString(2, favoriteBean.getProduct_id());
		st.setString(3, favoriteBean.getProduct_name());
		st.setString(4, favoriteBean.getPrice());
		st.setString(5, favoriteBean.getContentType());
		st.setString(6, favoriteBean.getBase64String());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	public int delete(String product_id, String member_id)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_F_DELETE);

		st.setString(1, product_id);
		st.setString(2, member_id);

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
