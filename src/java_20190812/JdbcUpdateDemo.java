package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//insert 와 delete 은 정확하게 반환해주는 반면에
//update 는 내용의 변경과는 상관없이 성공적으로 수행이 되면 1을 반환한다.

public class JdbcUpdateDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","kic1234");
			
			StringBuffer sql = new StringBuffer();
			sql.append("Update member "); 
			sql.append("set addr= ? , name = ? ");
			sql.append("where num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "미국");
			pstmt.setString(2, "조스");
			pstmt.setInt(3, 11);
			
			int resultCount = pstmt.executeUpdate();
			System.out.println("업데이트된 행의 수 : "+ resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}
}
