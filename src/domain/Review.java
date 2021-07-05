package domain;

import java.util.Date;

public class Review {
	private int id;
	private String product_name;
	private String content;
	private Date regdate;
	private float rating;
	private int history_id;
	
	public Review()
	{
		
	}
	
	public Review(int id, String product_name, String content, Date regdate, float rating) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.content = content;
		this.regdate = regdate;
		this.rating = rating;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product_name;
	}
	public void setProduct(String product_name) {
		this.product_name = product_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", product=" + product_name + ", content=" + content + ", regdate=" + regdate
				+ ", rating=" + rating + ", history_id=" + history_id + "]";
	}

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	
	

}
