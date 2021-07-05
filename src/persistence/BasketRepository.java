package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Basket;

public class BasketRepository {

	String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/term?useSSL=false";
	static String user = "root";
	static String passwd = "yeonho5376!";

	public BasketRepository() {
		try {
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean calculator(String id, int price) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("계산진입");

			// Column
			// PK , name , email , password
			String sql = "INSERT INTO basket_calculation VALUES (null,?, ?);";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, String.valueOf(id));
			pstmt.setInt(2, price);
			int count = pstmt.executeUpdate();

			if (count != 0)
				System.out.println("계산 성공!");
			else
				System.out.println("계산 실패!");
			result = (count == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static ArrayList<Basket> serachData(String id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Basket> datas = new ArrayList<Basket>();

		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String sql = "select * from basket where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String productName = rs.getString("product_name");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");

				datas.add(new Basket(quantity, productName, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datas;
	}

	public static ArrayList<Basket> deleteData(String id, String name) throws ClassNotFoundException, SQLException {
		System.out.println("삭제 진입");
		Connection conn = null;
		ArrayList<Basket> datas = new ArrayList<Basket>();

		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "delete from basket where member_id = ? AND product_name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "" + id + "");
		pstmt.setString(2, name);
		int rs = pstmt.executeUpdate();

		if (rs == 0)
			System.out.println("삭제성공!");

		else
			System.out.println("삭제실패!");

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		return datas;
	}

}