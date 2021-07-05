package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/term?useSSL=false";
	static String user = "root";
	static String passwd = "yeonho5376!";
    
    public MemberRepository() {
		try {
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public int login(String id,String password) {
    	String sql = "select password from member where id = ?";
    	try {
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setNString(1, id);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			if(rs.getString(1).equals(password)) {
    				return 1; // 로그인 성공
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return -1;
    }
    
    
}
