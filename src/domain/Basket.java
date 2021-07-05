package domain;

public class Basket {
	private int quantity;
	private String productName;
	private int price;
	private String memberId;

	public Basket() {
		
	}
		
	public Basket(int quantity, String productName, int price) {
		this.quantity = quantity;
		this.productName = productName;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
}
