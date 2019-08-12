package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertDemo {
	public static void main(String[] args) {
		//jdbc driver 로드하기
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Load Success...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail...");
		}
		
		//DB에 연결하기
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kic? autoReconnect=true","kic12","kic12"); //url , user(사용자) , pw(패스워드)
			System.out.println("Connection Success...");
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(num, name, addr)");
			sql.append("values(?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 12);
			pstmt.setString(2, "주커버그");
			pstmt.setString(3, "이스라엘");
			
			//sql문 전송
			//executeUpdate() = > insert,update,delete 문일때 사용
			//반환값은 갱신된 행의 수이다.
			int resultCount = pstmt.executeUpdate();
			
			System.out.println("갱신된 행의 수 : " + resultCount);
			
		} catch (SQLException e) {
			System.out.println("Connection Fail...");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		
				
	}
}
