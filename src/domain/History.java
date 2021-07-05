package domain;

import java.util.Date;

public class History {
	private int id;
	private int quantity;
	private Date buydate;
	private String product_name;
	private String member_id;
	private int price;
	private int reviewed;
	
	
	public History()
	{
		
	}
	public History(int id, int quantity, Date buydate, String product_name, String member_id, int price, int reviewed) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.buydate = buydate;
		this.product_name = product_name;
		this.member_id = member_id;
		this.price = price;
		this.reviewed = reviewed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", quantity=" + quantity + ", buydate=" + buydate + ", product_name="
				+ product_name + ", member_id=" + member_id + ", price=" + price + ", isReviewd=" + reviewed + "]";
	}
	public int getReviewed() {
		return reviewed;
	}
	public void setReviewed(int reviewed) {
		this.reviewed = reviewed;
	}
	
	
}
