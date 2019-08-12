package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForJdbcInsertDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(num,name,addr) ");
			sql.append("values (?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			for(int i = 12; i<20; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "test");
				pstmt.setString(3, "test");
				int resultCount = pstmt.executeUpdate();
				System.out.println(resultCount);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
