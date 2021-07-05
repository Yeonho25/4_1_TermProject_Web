package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import domain.History;
import domain.Member;
import domain.Paging;

public class HistoryRepository {
	String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/term?useSSL=false";
	static String user = "root";
	static String passwd = "yeonho5376!";
	
	public HistoryRepository() {
		try {
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<History> findHistory(Member member, Paging page)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		int startNum = page.getStartNum();
		int endNum = page.getEndNum();
		
		System.out.println(startNum + " " + endNum);
		
		ArrayList<History> historys = new ArrayList<History>();
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			// 검색
			sql = "select history.id, history.quantity, history.buydate, history.product_name, product.price, case when review.history_id=history.id then '1' else '0' end as 후기, @ROWNUM:=@ROWNUM+1 as rowNum from (select @ROWNUM:=0) R, history Left outer join review on history.id = review.history_id, product  where member_id=? and history.product_name=product.name limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			
	
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				History posts = new History();
				posts.setId(rs.getInt(1));
				posts.setQuantity(rs.getInt(2));
				posts.setBuydate(rs.getDate(3));
				posts.setProduct_name(rs.getString(4));
				posts.setPrice(rs.getInt(5));
				posts.setReviewed(rs.getInt(6));
				
				historys.add(posts);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return historys;
	}
	
	public int getTotalCount()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalPage = 0;
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			// 검색
			String sql = "select count(*) from history";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				totalPage = rs.getInt(1);
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
		
		return totalPage;
	}
}
