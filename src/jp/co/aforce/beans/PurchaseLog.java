package jp.co.aforce.beans;

public class PurchaseLog {
	private String history_number;
	private String member_id;
	private String product_id;
	private int purchase_number;
	private int purchase_price;
	private String purchase_date;

	public String getHistory_number() {
		return history_number;
	}
	public void setHistory_number(String history_number) {
		this.history_number = history_number;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getPurchase_number() {
		return purchase_number;
	}
	public void setPurchase_number(int purchase_number) {
		this.purchase_number = purchase_number;
	}
	public int getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

}
