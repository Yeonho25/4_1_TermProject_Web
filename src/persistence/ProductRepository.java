package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Basket;
import domain.Product;
import domain.Review;

public class ProductRepository {

	String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/term?useSSL=false";
	static String user = "root";
	static String passwd = "yeonho5376!";

	
	public ProductRepository() {
		try {
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Product> findCategoryAll(String category) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE category=\'"+category+"\'";
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Product product = new Product(name,price,category);
				products.add(product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return products;
	}
	
	public ArrayList<Product> findProduct(Product product)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			// 검색
			sql = "SELECT * FROM product where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				Product posts = new Product();
				posts.setName(rs.getString(1));
				posts.setPrice(rs.getInt(2));
				posts.setCategory(rs.getString(3));
				
				
				
				products.add(posts);
				
//				System.out.println(posts.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return products;
	}
	
	public ArrayList<Review> findReview(Product product)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		ArrayList<Review> reviews = new ArrayList<Review>();
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql = "select product_name, content, rating, regdate from history, review where history.id=review.history_id and history.product_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				Review posts = new Review();
				posts.setProduct(rs.getString(1));
				posts.setContent(rs.getString(2));
				posts.setRating(rs.getFloat(3));
				posts.setRegdate(rs.getDate(4));
				
				reviews.add(posts);
				
//				System.out.println(posts.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return reviews;
	}
	
	public void insert_basket(Basket basket)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
	
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql = "insert into basket (quantity, product_name, member_Id,price) values (?, ?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, basket.getQuantity());
			pstmt.setString(2, basket.getProductName());
			pstmt.setString(3, basket.getMemberId());
			pstmt.setInt(4, basket.getPrice());
			
			pstmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	}

}
