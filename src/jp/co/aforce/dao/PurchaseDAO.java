package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.PurchaseLog;
import jp.co.aforce.tool.ConstNum;

public class PurchaseDAO extends DAO {

	public int insertLog(PurchaseLog purchaseLog) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_D_INSERT);

		st.setString(1, purchaseLog.getMember_id());
		st.setString(2, purchaseLog.getProduct_id());
		st.setInt(3, purchaseLog.getPurchase_number());
		st.setInt(4, purchaseLog.getPurchase_price());
		st.setString(5, purchaseLog.getPurchase_date());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}


	public List<PurchaseLog> search()throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_D_SEARCH);
		List<PurchaseLog>list = new ArrayList<PurchaseLog>();

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			PurchaseLog p = new PurchaseLog();
			p.setHistory_number(rs.getString("history_number"));
			p.setMember_id(rs.getString("member_id"));
			p.setProduct_id(rs.getString("product_id"));
			p.setPurchase_number( Integer.parseInt(rs.getString("purchase_number")));
			p.setPurchase_price(Integer.parseInt(rs.getString("purchase_price")));
			p.setPurchase_date(rs.getString("purchase_date"));
			list.add(p);
		}
		st.close();
		con.close();

		return list;
	}
	public int change(CartBean cartBean)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_D_CHANGE);

		st.setInt(1, cartBean.getCount());
		st.setString(2, cartBean.getProductBean().getProduct_id());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
