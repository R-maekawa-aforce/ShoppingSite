package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.tool.ConstNum;

public class MemberDAO extends DAO{
	public boolean checkMember (MemberBean memberBean)throws Exception{
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_M_CHECK);

		st.setString(1, memberBean.getLast_name());
		st.setString(2, memberBean.getFirst_name());
		st.setString(3, memberBean.getSex());
		st.setString(4, memberBean.getBirth_year());
		st.setString(5, memberBean.getBirth_month());
		st.setString(6, memberBean.getBirth_day());
		st.setString(7, memberBean.getPost_code());
		st.setString(8, memberBean.getPrefectures());
		st.setString(9, memberBean.getMunicipalities());
		st.setString(10, memberBean.getPhone_number());
		st.setString(11, memberBean.getMail_address());
		st.setString(12, memberBean.getPassword());

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

	public int insertMember(MemberBean memberBean)throws Exception{

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_M_INSERT);

		st.setString(1, memberBean.getMember_id());
		st.setString(2, memberBean.getLast_name());
		st.setString(3, memberBean.getFirst_name());
		st.setString(4, memberBean.getSex());
		st.setString(5, memberBean.getBirth_year());
		st.setString(6, memberBean.getBirth_month());
		st.setString(7, memberBean.getBirth_day());
		st.setString(8, memberBean.getPost_code());
		st.setString(9, memberBean.getPrefectures());
		st.setString(10, memberBean.getMunicipalities());
		st.setString(11, memberBean.getBuilding());
		st.setString(12, memberBean.getPhone_number());
		st.setString(13, memberBean.getMail_address());
		st.setString(14, memberBean.getPassword());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public MemberBean loginMember(String member_id, String password)throws Exception{
		MemberBean memberBean = null;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_M_SEARCH);

		st.setString(1, member_id);
		st.setString(2, password);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			memberBean = new MemberBean();
			memberBean.setMember_id(rs.getString("member_id"));
			memberBean.setLast_name(rs.getString("last_name"));
			memberBean.setFirst_name(rs.getString("first_name"));
			memberBean.setSex(rs.getString("sex"));
			memberBean.setBirth_year(rs.getString("birth_year"));
			memberBean.setBirth_month(rs.getString("birth_month"));
			memberBean.setBirth_day(rs.getString("birth_day"));
			memberBean.setPost_code(rs.getString("post_code"));
			memberBean.setPrefectures(rs.getString("prefectures"));
			memberBean.setMunicipalities(rs.getString("municipalities"));
			memberBean.setBuilding(rs.getString("building"));
			memberBean.setPhone_number(rs.getString("phone_number"));
			memberBean.setMail_address(rs.getString("mail_address"));
			memberBean.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return memberBean;
	}

	public int update(MemberBean memberBean)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_M_UPDATE);

		st.setString(1, memberBean.getLast_name());
		st.setString(2, memberBean.getFirst_name());
		st.setString(3, memberBean.getSex());
		st.setString(4, memberBean.getBirth_year());
		st.setString(5, memberBean.getBirth_month());
		st.setString(6, memberBean.getBirth_day());
		st.setString(7, memberBean.getPost_code());
		st.setString(8, memberBean.getPrefectures());
		st.setString(9, memberBean.getMunicipalities());
		st.setString(10, memberBean.getBuilding());
		st.setString(11, memberBean.getPhone_number());
		st.setString(12, memberBean.getMail_address());
		st.setString(13, memberBean.getMember_id());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public int delete(String member_id)throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(ConstNum.SQL_M_DELETE);

		st.setString(1, member_id);

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
