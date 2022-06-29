package jp.co.aforce.models;

import java.util.ArrayList;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.beans.ProductBean;

public class Model {

	public String nullMsg(MemberBean memberBean){
		String message;
		ArrayList<String> list = new ArrayList<String>();

		if(memberBean.getLast_name().isEmpty()) list.add("名前_性");
		if(memberBean.getFirst_name().isEmpty()) list.add("名前_名");
		if(memberBean.getSex() == null) list.add("性別");
		if(memberBean.getBirth_year() == null) list.add("生年月日_年");
		if(memberBean.getBirth_month() == null) list.add("生年月日_月");
		if(memberBean.getBirth_day() == null) list.add("生年月日_日");
		if(memberBean.getPost_code().isEmpty()) list.add("郵便番号");
		if(memberBean.getPrefectures().isEmpty()) list.add("都道府県");
		if(memberBean.getMunicipalities().isEmpty()) list.add("市区町村");
		if(memberBean.getPhone_number().isEmpty()) list.add("電話番号");
		if(memberBean.getMail_address().isEmpty()) list.add("メールアドレス");
		if(memberBean.getPassword().isEmpty()) list.add("パスワード");

		message = String.join(",", list);

		return message;

	}

	public String nullMsg(ProductBean productBean) {
		String message;
		ArrayList<String>list = new ArrayList<String>();

		if(productBean.getProduct_name().isEmpty()) list.add("商品名");
		if(productBean.getPrice().isEmpty()) list.add("値段");
		if(productBean.getAmount() == null) list.add("個数");

		message = String.join(",", list);
		return message;
	}

	public String nullMsg(ArrayList<String> information) {
		String message;
		ArrayList<String>list = new ArrayList<String>();

		if(information.get(0).isEmpty()) list.add("郵便番号");
		if(information.get(1).isEmpty()) list.add("都道府県");
		if(information.get(2).isEmpty()) list.add("市区町村");
		if(information.get(3).isEmpty()) list.add("建物名");
		if(information.get(4) == null) list.add("購入方法");
		if(information.get(5) == null) list.add("配送方法");

		message = String.join(",", list);
		return message;
	}
	public String nullMsg2(MemberBean memberBean){
		String message;
		ArrayList<String> list = new ArrayList<String>();

		if(memberBean.getLast_name().isEmpty()) list.add("名前_性");
		if(memberBean.getFirst_name().isEmpty()) list.add("名前_名");
		if(memberBean.getSex() == null) list.add("性別");
		if(memberBean.getBirth_year() == null) list.add("生年月日_年");
		if(memberBean.getBirth_month() == null) list.add("生年月日_月");
		if(memberBean.getBirth_day() == null) list.add("生年月日_日");
		if(memberBean.getPost_code().isEmpty()) list.add("郵便番号");
		if(memberBean.getPrefectures().isEmpty()) list.add("都道府県");
		if(memberBean.getMunicipalities().isEmpty()) list.add("市区町村");
		if(memberBean.getPhone_number().isEmpty()) list.add("電話番号");
		if(memberBean.getMail_address().isEmpty()) list.add("メールアドレス");

		message = String.join(",", list);

		return message;

	}
}
