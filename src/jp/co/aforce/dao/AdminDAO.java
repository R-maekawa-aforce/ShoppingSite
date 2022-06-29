package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.AdminBean;
import jp.co.aforce.tool.ConstNum;

public class AdminDAO extends DAO {

	public AdminBean searchAdmin(String admin_id, String password)throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_A_SEARCH);

		AdminBean adminBean = null;

		st.setString(1, admin_id);
		st.setString(2, password);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			adminBean = new AdminBean();
			adminBean.setAdmin_id(rs.getString("admin_id"));
			adminBean.setLast_name(rs.getString("last_name"));
			adminBean.setFirst_name(rs.getString("first_name"));
			adminBean.setPassword(rs.getString("password"));
		}

		return adminBean;
	}
}
