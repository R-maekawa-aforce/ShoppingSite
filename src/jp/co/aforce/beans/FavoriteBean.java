package jp.co.aforce.beans;

public class FavoriteBean {
	private String favorite_id;
	private String member_id;
	private String product_id;
	private String product_name;
	private String price;
	private String contentType;
	private String base64String;
	public String getFavorite_id() {
		return favorite_id;
	}
	public void setFavorite_id(String favorite_id) {
		this.favorite_id = favorite_id;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBase64String() {
		return base64String;
	}
	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}


}
