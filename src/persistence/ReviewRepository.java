package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import domain.Review;

public class ReviewRepository {
	
	String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/term?useSSL=false";
	static String user = "root";
	static String passwd = "yeonho5376!";
    
	public ReviewRepository() {
		try {
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void insertReview(Review review)
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
			
			// 검색
			sql = "insert into review(content, regdate, history_id, rating) values(?,now(), ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getContent());
			pstmt.setInt(2, review.getHistory_id());
			pstmt.setFloat(3, review.getRating());
			
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
