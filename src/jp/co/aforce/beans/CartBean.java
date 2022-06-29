package jp.co.aforce.beans;

public class CartBean {
	private ProductBean productBean;
	private int count;
	private int semiTotal;

	public int getSemiTotal() {
		return semiTotal;
	}
	public void setSemiTotal(int semiTotal) {
		this.semiTotal = semiTotal;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
